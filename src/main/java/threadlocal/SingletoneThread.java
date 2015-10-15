package threadlocal;

public class SingletoneThread extends Thread {
    public static final int LEANGTH = 10000;
    private String id;

    public SingletoneThread(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        Singletone.getInstance().setElement(id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String element = Singletone.getInstance().getElement();
        if (!id.equals(element)) {
            System.out.println("id: " + id + " element: " + element);
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
