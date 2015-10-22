package semaphore;

public class Task extends Thread {
    private Runnable task;
    private boolean finished = false;
    private boolean shutdown = false;

    public Task(Runnable task) {
        this.task = task;
        this.finished = true;
        this.shutdown = false;
        this.start();
    }

    public Task() {
        this(null);
    }

    public Runnable getTask() {
        return task;
    }

    public synchronized boolean setTask(Runnable task) {
        if (isFinished()) {
            this.task = task;
            this.finished = false;
            return true;
        }
        return false;
    }

    public boolean isShutdown() {
        return shutdown;
    }

    public void shutdown() {
        this.shutdown = true;
        this.finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public void run() {
        System.out.println("runnig");
        while (!shutdown) {
            if(!finished && task != null) {
                task.run();
                finished = true;
                SemaphoreSinleton.getInstance().getSemaphore().release();
            }
        }
    }
}
