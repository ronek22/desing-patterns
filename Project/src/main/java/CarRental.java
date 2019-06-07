import Enums.Brand;
import Enums.ServiceType;

import java.util.ArrayList;
import java.util.List;

public class CarRental implements Subject, Publisher {
    private volatile static CarRental instance;
    private List<Car> carList;
    private List<Observer> carSubscribers;
    private static final String publishMessage = "Added new vehicle for renting: %s";


    private CarRental() {
        carList = new ArrayList<>();
        carSubscribers = new ArrayList<>();
    }

    public static CarRental getInstance() {
        if(instance == null){
            synchronized (CarRental.class){
                if(instance == null) {
                    instance = new CarRental();
                }
            }
        }
        return instance;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public Car findCar(String model) {
        return carList.stream()
                .filter(car -> car.getModel().equals(model))
                .findFirst().orElse(null);
    }


    public Car getCar() {
        return carList.get(carList.size() - 1);
    }


    public void serviceCar(Customer customer, Car car, ServiceType type){
        switch(type){
            case RENTING:
                    customer.renting(car);
                    car.renting(true);
                break;
            case RETURNING:
                    car.renting(false);
                    customer.returning();
            }
    }


    @Override
    public void registerObserver(Observer observer) {
        carSubscribers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        carSubscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        carSubscribers.forEach(Observer::update);
    }

    @Override
    public void publish(Car car) {
        carList.add(car);
        System.out.println(String.format(publishMessage, car));
        notifyObservers();
    }

    public void clear() {
        carList = new ArrayList<>();
        carSubscribers = new ArrayList<>();
    }
}
