package Products;

public abstract class Sofa extends Furniture{
    protected int seats;

    public void build() {
        System.out.println("Building | Sofa: " + name + " with " + seats + " seats...");
    }

    public void deliver() {
        System.out.println("Delivering | Sofa: " + name + " with " + seats + " seats...");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Sofa: " + name;
    }
}
