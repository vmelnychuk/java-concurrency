package semaphore;

import java.util.concurrent.Semaphore;

public class App {
    public static final int SIZE = 5;
    public static final int THREADS_NUMBER = 20;
    public static void main(String[] args) throws InterruptedException {
        CustomExecutionService executionService = new CustomExecutionService(SIZE);
        for(int i = 0; i < THREADS_NUMBER; i++) {
            executionService.submit(new CustomRunnable(i, SemaphoreSinleton.getInstance().getSemaphore()));
        }

        Thread.sleep(1000);
        executionService.shutdown();
    }
}
