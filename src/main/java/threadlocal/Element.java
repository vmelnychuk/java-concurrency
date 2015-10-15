package threadlocal;

public class Element {
    private String value;
    private SubElement subElement;
    private int localVar;

    public Element(String value) {
        this.value = value;
        subElement = ElementSingleton.getInstance().getValue();
        subElement.setName(value);

    }

    public String[] getValues() {
        return new String[]{value, subElement.getName()};
    }

    public void setValue(String value) {
        this.value = value;
        subElement.setName(value);
    }
}
