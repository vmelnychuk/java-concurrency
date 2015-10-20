package semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class CustomExecutionService {
    private int size;
    private List<CustomRunnable> threads;
    private Semaphore semaphore;

    public CustomExecutionService(int size) {
        this.size = size;
        this.threads = new ArrayList<CustomRunnable>(size);
        this.semaphore = new Semaphore(size);
        SemaphoreSinleton.getInstance().setSemaphore(semaphore);
    }

    public void submit(CustomRunnable thread) {
        threads.add(thread);
        try {
            semaphore.acquire();
            System.out.println(thread.getId() + " starting...");
            new Thread(thread).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void shutdown() {
        for(CustomRunnable thread : threads) {
            thread.shutdown();
        }
    }

    public void randomShutdown() {
        CustomRunnable thread = threads.get(ThreadLocalRandom.current().nextInt(threads.size()));
        thread.shutdown();
    }
}
