package task2;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class CallableTest implements Callable<Integer> {
    private int i;
    public CallableTest(int i) {
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        return new Integer(i);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new LinkedList<Future<Integer>>();
        for(int i = 0; i < 10; i++) {
            results.add(executorService.submit(new CallableTest(i)));
        }
        for(Future<Integer> element : results) {
            try {
                System.out.println(element.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}
