package semaphore;

import java.util.concurrent.*;

//TODO: create provider-consumer pattern for submitting tasks
public class CustomExecutionService {
    private int size;
    private LinkedBlockingQueue<CustomRunnable> tasks;
    private Thread executor;
    private boolean shutdown = false;

    public CustomExecutionService(int size) {
        this.size = size;
        this.tasks = new LinkedBlockingQueue<CustomRunnable>();
        Semaphore semaphore = new Semaphore(size);
        SemaphoreSinleton.getInstance().setSemaphore(semaphore);
        this.executor = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (!shutdown) {
                    try {
                        SemaphoreSinleton.getInstance().getSemaphore().acquire();
                        CustomRunnable thread = tasks.take();
                        System.out.println(thread.getId() + " starting...");
                        new Thread(thread).start();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void submit(CustomRunnable thread) {
        tasks.add(thread);
        executor.start();
    }

    public void shutdown() {
        shutdown = true;
        for(CustomRunnable thread : tasks) {
            thread.shutdown();
        }
    }
}
