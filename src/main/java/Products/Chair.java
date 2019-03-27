package Products;

public abstract class Chair extends Furniture {
    public void build() {
        System.out.println("Building | " + material + " Chair: " + name);
    }

    public void deliver() {
        System.out.println("Delivering | " + material + " Chair: " + name);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Chair: " + name;
    }

}
