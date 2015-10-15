package threadlocal;

public class SingletoneThread extends Thread {
    public static final int LEANGTH = 100;
    private String id;

    public SingletoneThread(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        Singletone.getInstance().setElement(id);
        String[] elements = Singletone.getInstance().getElement();
        if (!elements[0].equals(elements[1])) {
            System.out.println("id: " + elements[0] + " element: " + elements[1]);
        }
    }

    public static void main(String[] args) {
        SingletoneThread[] array = new SingletoneThread[LEANGTH];
         for(int i = 0; i < LEANGTH; i++) {
            array[i] = new SingletoneThread(Integer.toString(i));
        }

        for(int i = 0; i < LEANGTH; i++) {
            array[i].start();
        }
    }
}
