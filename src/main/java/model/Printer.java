package model;

public class Printer {
    private String text;

    public Printer() {
    }

    public void printText(String textToPrint, int times) {
        text = textToPrint;
        for(int i = 0; i < times; i++) {
            System.out.println("Printer: " + text + " " + i);
        }
    }
}
