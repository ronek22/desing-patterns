import Enums.Brand;
import Enums.ServiceType;

// Facade
public class Client {

    private CarRental carRental;

    public Client() {
        carRental = CarRental.getInstance();
    }

    public void addDefaultCars(){
        CarFactory factory = CarFactory.getInstance();
        carRental.addCar(factory.get("expensive"));
        carRental.addCar(factory.get("cheap"));
        carRental.addCar(factory.get("normal"));
        carRental.addCar(factory.get("damaged"));
        carRental.addCar(factory.get("rented"));
    }

    public boolean rentOrReturn(Customer customer, String model, ServiceType type){
        Car car = carRental.findCar(model);
        if(car == null)
            return false;
        switch (type){
            case RENTING:
                if(isRentPossible(customer, car)) {
                    carRental.serviceCar(customer, car, type);
                    return true;
                }
                return false;
            case RETURNING:
                carRental.serviceCar(customer, car, type);
                return true;
        }
    return false;
    }

    public boolean isRentPossible(Customer customer, Car car) {
        if (customer.checkIsRenting()) {
            return false;
        } else if (car.isInRepair()) {
            return false;
        } else if (car.isRented()) {
            return false;
        }

        return true;
    }
}
