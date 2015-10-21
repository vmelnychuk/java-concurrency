package semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class CustomRunnable implements Runnable {
    private int id;
    private boolean shutdown;

    public CustomRunnable(int id) {
        this.id = id;
        this.shutdown = false;
    }

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(shutdown) {
                System.out.println("Shutdown of " + id);
                break;
            }
        }
        SemaphoreSinleton.getInstance().getSemaphore().release();
        System.out.println(id + " is finished");
    }

    public void shutdown() {
        shutdown = true;
    }

    public int getId() {
        return id;
    }

}
