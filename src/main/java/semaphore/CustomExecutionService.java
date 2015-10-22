package semaphore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class CustomExecutionService {
    private int size;
    private Queue<Runnable> tasksToRun;
    private ConcurrentLinkedQueue<Task> pool;
    private Thread executor;
    private boolean shutdown = false;

    public CustomExecutionService(int size) {
        this.size = size;
        this.tasksToRun = new ConcurrentLinkedQueue<>();
        Semaphore semaphore = new Semaphore(size);
        SemaphoreSinleton.getInstance().setSemaphore(semaphore);

        System.out.println("creating pool");
        this.pool = new ConcurrentLinkedQueue<Task>();
        for(int i = 0; i < size; i++) {
                pool.add(new Task());
        }

        executor = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SemaphoreSinleton.getInstance().getSemaphore().acquire();
                    if (tasksToRun.isEmpty()) {
                        SemaphoreSinleton.getInstance().getSemaphore().release();
                    } else {
                        Runnable taskToRun = tasksToRun.remove();
                        for(Task task : pool) {
                            if (task.isFinished()) {
                                if( task.setTask(taskToRun)) {
                                    break;
                                }
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executor.start();
    }

    public void submit(Runnable taskToRun) {
        tasksToRun.add(taskToRun);
    }

    public void shutdown() {
        shutdown = true;
        for(Task task : pool) {
            task.shutdown();
        }
        tasksToRun = null;
    }
}
