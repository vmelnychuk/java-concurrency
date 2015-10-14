package task1;

import model.Printer;

public class RunnableContinuousPrinter implements Runnable {
    public static final int TIMES = 10;
    private Printer printer;

    public RunnableContinuousPrinter() {
        printer = new Printer();
    }
    @Override
    public void run() {
        printer.printText(Thread.currentThread().getName(), TIMES);
    }
}
