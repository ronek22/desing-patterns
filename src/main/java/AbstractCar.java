import Enums.Brand;

public abstract class AbstractCar {
    Brand brand;
    String model;
    int productionYear;

    public abstract double getPricePerMinute();

}
