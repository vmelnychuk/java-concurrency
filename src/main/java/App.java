import task1.ContinuousPrinter;
import task1.RunnableContinuousPrinter;
import task1.RunnableTest;
import task1.ThreadTest;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static final int LEANTH = 100;
    public static void main(String[] args) throws InterruptedException {
//        List<ThreadTest> threadList = new ArrayList<>();
//        List<RunnableTest> runnableList = new ArrayList<>();
//        for(int i = 0; i < LEANTH; i++) {
//            threadList.add(new ThreadTest(i));
//            runnableList.add(new RunnableTest(i));
//        }
//
//        System.out.println("\nThreads:");
//        for(ThreadTest thread : threadList) {
//            thread.start();
//        }
//
//        Thread.sleep(3000);
//        System.out.println("\nRunnables:");
//        for(RunnableTest runnable : runnableList) {
//            (new Thread(runnable)).start();
//        }
        RunnableContinuousPrinter continuousPrinter1 = new RunnableContinuousPrinter();
        RunnableContinuousPrinter continuousPrinter2 = new RunnableContinuousPrinter();
        RunnableContinuousPrinter continuousPrinter3 = new RunnableContinuousPrinter();
        new Thread(continuousPrinter1).start();
        new Thread(continuousPrinter2).start();
        new Thread(continuousPrinter3).start();

    }
}