package compilers_cs_example;

public class Simple {
    private int a = 1;
    private int b = 2;

    public void to() {
        a = 3;
        b = 4;
    }

    public void fro() {
        System.out.println("a=" + a + ", b=" + b);
    }
}
