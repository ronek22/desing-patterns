public class Customer implements Observer {
    private String firstName;
    private String lastName;
    private boolean isRenting;
    private CarRental carPublisher;
    private Car lastCar;

    private static final String message = "Hi %s, added: %s for rent";

    public Customer(String firstName, String lastName, CarRental carPublisher){
        this.firstName = firstName;
        this.lastName = lastName;
        this.carPublisher = carPublisher;
    }

    public Customer(String firstName, String lastName, boolean isRenting){
        this.firstName = firstName;
        this.lastName = lastName;
        this.isRenting = isRenting;
    }

    public boolean checkIsRenting() {
        return isRenting;
    }

    public void renting(Car car){
        this.lastCar = car;
        this.isRenting = true;
    }

    public void returning(){
        this.isRenting = false;
    }

    public Car getLastCar() {
        return lastCar;
    }

    @Override
    public void update() {
        lastCar = carPublisher.getCar();
        System.out.println(String.format(message, firstName+" "+lastName, lastCar));
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isRenting=" + isRenting +
                ", lastCar=" + lastCar +
                '}';
    }
}
