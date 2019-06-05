import enums.Brand;
import enums.Engine;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {
    private volatile static CarFactory instance;
    private static Map<String, Car> cars = new HashMap<>();

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        if (instance == null) {
            synchronized (CarFactory.class) {
                if (instance == null) {
                    instance = new CarFactory();
                    prepareFactory();
                }
            }
        }
        return instance;
    }

    private static void prepareFactory() {
        cars.put("cheap",
                new Car.Builder()
                        .brand(Brand.KIA)
                        .model("Ceed")
                        .engine(Engine.DIESEL)
                        .horsePower(114)
                        .productionYear(2009)
                        .pricePerMinute(10)
                        .build());

        cars.put("normal",
                new Car.Builder()
                        .brand(Brand.TOYOTA)
                        .model("C-HR")
                        .engine(Engine.HYBRID)
                        .horsePower(122)
                        .productionYear(2016)
                        .pricePerMinute(20)
                        .build());

        cars.put("expensive",
                new Car.Builder()
                        .brand(Brand.TESLA)
                        .model("Model 3")
                        .engine(Engine.ELECTRIC)
                        .horsePower(255)
                        .productionYear(2017)
                        .pricePerMinute(45)
                        .build());

        cars.put("damaged",
                new Car.Builder()
                        .brand(Brand.NISSAN)
                        .model("GT-R")
                        .engine(Engine.PETROL)
                        .horsePower(500)
                        .productionYear(2015)
                        .pricePerMinute(60)
                        .inRepair(true)
                        .build());

        cars.put("rented",
                new Car.Builder()
                        .brand(Brand.FIAT)
                        .model("Punto")
                        .engine(Engine.PETROL)
                        .horsePower(93)
                        .productionYear(2008)
                        .pricePerMinute(10)
                        .isRented(true)
                        .build());
    }

    public Car put(String key, Car car) {
        cars.put(key, car);
        return car;
    }

    public Car get(String key) throws CloneNotSupportedException {
        return cars.get(key).clone();
    }

}
