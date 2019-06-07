public class Type implements Cloneable {
    private String name;

    public Type(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Type clone() throws CloneNotSupportedException {
        return (Type) super.clone();
    }

    @Override
    public String toString() {
        return name;
    }
}
