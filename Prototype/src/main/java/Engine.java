public class Engine implements Cloneable {
    private Type type;
    private float displacement;
    private int horsePower;

    public Engine(Type type){
        this.type = type;
    }

    public Engine displacement(float capacity){
        this.displacement = capacity;
        return this;
    }

    public Engine horsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public Type getType() {
        return type;
    }

    public float getDisplacement() {
        return displacement;
    }

    public void setType(Type type){
        this.type = type;
    }

    public void setDisplacement(float displacement){
        this.displacement = displacement;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    protected Engine clone() throws CloneNotSupportedException {
        Engine engine = (Engine) super.clone();
        engine.type = type.clone();
        return engine;
    }

    @Override
    public String toString() {
        return "{ \'" + type + '\'' +
                ", " + displacement + " cc" +
                ", " + horsePower + "hp }";
    }
}
