import Enums.Brand;
import Enums.ServiceType;

// Facade
public class Client {

    public boolean rentOrReturn(Customer customer, Car car, ServiceType type){
        switch (type){
            case RENTING:
                if(isRentPossible(customer, car)) {
                    CarRental.getInstance().serviceCar(customer, car, type);
                    return true;
                }
                return false;
            case RETURNING:
                CarRental.getInstance().serviceCar(customer, car, type);
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
