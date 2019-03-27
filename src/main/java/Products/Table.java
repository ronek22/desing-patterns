package Products;

public abstract class Table extends Furniture {

    public void build() {
        System.out.println("Building | " + material + " Table: " + name);
    }

    public void deliver() {
        System.out.println("Delivering | " + material + " Table: " + name);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Table: " + name;
    }

}
