import java.util.ArrayList;
import java.util.List;

public class CarRental implements Subject, Publisher {
    private List<Observer> carSubscribers;
    private Car car;
    private static final String publishMessage = "Added new vehicle for renting: %s";

    public CarRental() {
        carSubscribers = new ArrayList<>();
    }

    public Car getCar() {
        return car;
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
        this.car = car;
        System.out.println(String.format(publishMessage, car));
        notifyObservers();
    }
}
