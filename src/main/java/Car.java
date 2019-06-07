import Enums.Brand;
import Enums.Engine;

public class Car extends AbstractCar implements PrototypeCapable {
    private Engine typeOfEngine;
    private int horsePower;
    private boolean inRepair;
    private boolean isRented;
    private double pricePerMinute;

    //region Getters
    public Brand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Engine getTypeOfEngine() {
        return typeOfEngine;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    public boolean isInRepair() {
        return inRepair;
    }

    public boolean isRented() {
        return isRented;
    }

    public boolean isAvailable() {
        return !inRepair && !isRented;
    }

    public void renting(boolean value) {
        this.isRented = value;
    }
    //endregion

    public Car clone() throws CloneNotSupportedException {
        Car car = (Car) super.clone();
        return car;
    }

    public static class Builder {
        private Brand brand;
        private String model;
        private Engine typeOfEngine;
        private int horsePower;
        private int productionYear;
        private boolean inRepair = false;
        private boolean isRented = false;
        private double pricePerMinute;

        public Builder brand(Brand brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model){
            this.model = model;
            return this;
        }

        public Builder engine(Engine engine){
            this.typeOfEngine = engine;
            return this;
        }

        public Builder productionYear(int productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder horsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        public Builder inRepair(boolean inRepair){
            this.inRepair = inRepair;
            return this;
        }

        public Builder isRented(boolean isRented){
            this.isRented = isRented;
            return this;
        }

        public Builder pricePerMinute(double pricePerMinute){
            this.pricePerMinute = pricePerMinute;
            return this;
        }

        public Car build() {
            Car car = new Car();
            car.brand = this.brand;
            car.model = this.model;
            car.typeOfEngine = this.typeOfEngine;
            car.productionYear = this.productionYear;
            car.horsePower = this.horsePower;
            car.isRented = this.isRented;
            car.inRepair = this.inRepair;
            car.pricePerMinute = this.pricePerMinute;

            return car;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand=" + brand +
                ", model='" + model + '\'' +
                ", typeOfEngine=" + typeOfEngine +
                ", productionYear=" + productionYear +
                ", inRepair=" + inRepair +
                ", isRented=" + isRented +
                ", pricePerMinute=" + pricePerMinute +
                '}';
    }
}
