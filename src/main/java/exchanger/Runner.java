package exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static final int LENGTH = 10; // should be even
    private Exchanger<Integer> exchanger;
    private List<Part> parts;

    public Runner() {
        exchanger = new Exchanger<Integer>();
        parts = new ArrayList<Part>();
        for(int i = 0; i < LENGTH; i++) {
            Part part = new Part(i, exchanger);
            parts.add(part);
        }
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.runner(3);
    }

    public void runner(int times) {
        for(int i = 0; i < times; i++) {
            System.out.printf("Run #%d ============================%n", i);
            ExecutorService executorService = Executors.newFixedThreadPool(LENGTH);
            for(Part part : parts) {
                executorService.submit(part);
            }
            executorService.shutdown();

            while (!executorService.isTerminated()) {}
            for(Part part : parts) {
                System.out.println("id: " + part.getId() + " with pair " + part.getPaidId());
            }
        }
    }
}
