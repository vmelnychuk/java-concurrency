package volatile_example;

import java.util.Scanner;

class Processor extends Thread {
    private volatile boolean running = true; // prevents thread from caching variable value
    @Override
    public void run() {
        while (running) {
            System.out.print(".");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class Main {
    public static void main(String[] args) {
        Processor p1 = new Processor();
        p1.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        p1.shutdown();
        System.out.println("END");
    }
}
