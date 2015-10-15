package threadlocal;

public class Singletone {
    private static final Singletone ourInstance = new Singletone();
    private ThreadLocal<String> element = new ThreadLocal<String>();

    public static Singletone getInstance() {
        return ourInstance;
    }

    private Singletone() {
    }

    public String getElement() {
        return element.get();
    }

    public void setElement(String element) {
            this.element.set(element);
    }
}
