package threadlocal;

public class ElementSingleton {
    private static volatile ElementSingleton ourInstance = new ElementSingleton();
    private volatile SubElement value = new SubElement("check");

    public SubElement getValue() {
        return value;
    }

    public void setValue(SubElement value) {
        this.value = value;
    }

    public static ElementSingleton getInstance() {
        return ourInstance;
    }

    private ElementSingleton() {
    }
}
