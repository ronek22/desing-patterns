// Facade
public class Client {

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
