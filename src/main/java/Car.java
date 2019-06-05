import enums.Brand;
import enums.Engine;

public class Car implements PrototypeCapable {
    private Brand brand;
    private String model;
    private Engine typeOfEngine;
    private int horsePower;
    private int productionYear;
    private boolean inRepair;
    private boolean isRented;
    private double pricePerMinute;


    public Car clone() throws CloneNotSupportedException {
        Car car = (Car) super.clone();
        car.inRepair = false;
        car.isRented = false;
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
