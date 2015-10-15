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
        Thread.currentThread().sleep(1000);
        return new Integer(i);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new LinkedList<Future<Integer>>();
        for(int i = 0; i < 10; i++) {
            results.add(executorService.submit(new CallableTest(i)));
        }
        Future<Integer> res = results.get(results.size()-1);
        while(res.isDone() == false) {
            System.out.println(res.get(1000000, TimeUnit.MICROSECONDS));
        }
    }
}
