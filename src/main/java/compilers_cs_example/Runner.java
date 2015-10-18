package compilers_cs_example;

public class Runner {

    public static void main(String[] args) {
        Simple simple = new Simple();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                simple.to();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                simple.fro();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t1.start();
    }
}
