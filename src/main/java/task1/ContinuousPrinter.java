package task1;

import model.Printer;

public class ContinuousPrinter extends Thread {
    private Printer printer;
    public static final int TIMES = 10;

    public ContinuousPrinter() {
        this.printer = new Printer();
    }

    @Override
    public void run() {
        printer.printText(Thread.currentThread().getName(), TIMES);
    }
}
