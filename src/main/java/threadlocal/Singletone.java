package threadlocal;

public class Singletone {
    private static final Singletone ourInstance = new Singletone();
    private ThreadLocal<Element> element = new ThreadLocal<Element>();
    private String value;

    public static Singletone getInstance() {
        return ourInstance;
    }

    private Singletone() {
    }

    public String[] getElement() {
        return element.get().getValues();
    }

    public void setElement(String element) {
        this.element.set(new Element(element));
    }


}
