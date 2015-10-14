package task3;

import task1.RunnableContinuousPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new RunnableContinuousPrinter());
        executor.submit(new RunnableContinuousPrinter());
        executor.submit(new RunnableContinuousPrinter());
        executor.submit(new RunnableContinuousPrinter());
        executor.submit(new RunnableContinuousPrinter());
        executor.submit(new RunnableContinuousPrinter());
        executor.shutdown();

    }
}
