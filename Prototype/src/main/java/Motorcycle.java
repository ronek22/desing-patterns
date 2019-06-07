public class Motorcycle implements Cloneable {
    private String brand;
    private String model;
    private Engine engine;
    private int yearOfProduction;

    public Motorcycle(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    public Motorcycle engine(Engine engine){
        this.engine = engine;
        return this;
    }

    public Motorcycle yearOfProduction(int yearOfProduction){
        this.yearOfProduction = yearOfProduction;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setBrand(String brand) { this.brand = brand;}

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    protected Motorcycle clone() {
        try{
            Motorcycle motor = (Motorcycle) super.clone();
            motor.engine = engine.clone();
            return motor;
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }

    }

    public Motorcycle shallowCopy() {
        try {
            return (Motorcycle) super.clone();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Motorcycle {" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", year of production: " + yearOfProduction +
                "}";
    }




}
