import Enums.Brand;
import Enums.Engine;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarRentalTest {
    CarFactory factory = CarFactory.getInstance();
    Client client = new Client();
    CarRental carRental = new CarRental();

    Car expensive = factory.get("expensive");
    Car damaged = factory.get("damaged");
    Car rented = factory.get("rented");

    @Test
    public void builderTest() {
        Car newCar = Car.builder()
                .brand(Brand.NISSAN)
                .model("350-z")
                .horsePower(300)
                .engine(Engine.PETROL)
                .productionYear(2007)
                .pricePerMinute(100)
                .inRepair(false)
                .isRented(true)
                .build();

        assertAll(
                () -> assertEquals(Brand.NISSAN, newCar.getBrand()),
                () -> assertEquals("350-z", newCar.getModel()),
                () -> assertEquals(300, newCar.getHorsePower()),
                () -> assertEquals(Engine.PETROL, newCar.getTypeOfEngine()),
                () -> assertEquals(2007, newCar.getProductionYear()),
                () -> assertEquals(100, newCar.getPricePerMinute()),
                () -> assertFalse(newCar.isInRepair()),
                () -> assertTrue(newCar.isRented())
        );
    }

    @Test
    public void prototypeTest() {
        Car rented_2 = factory.get("rented");

        assertAll(
                () ->  assertNotSame(rented_2, rented),
                () ->  assertEquals(rented_2.toString(), rented.toString())
        );


    }

    @Test
    public void observerTest() {
        System.out.println("Observer Test");
        System.out.println("=============================");
        Customer first = new Customer("Jan", "Kowalski", carRental);
        Customer second = new Customer("Maciej", "Konieczny", carRental);

        carRental.registerObserver(first);
        carRental.registerObserver(second);

        carRental.publish(expensive);

        carRental.unregisterObserver(first);
        carRental.publish(damaged);
    }

    @Test
    public void facadeTest() {
        Customer first = new Customer("Krzysztof", "Pora", false);
        Customer second = new Customer("Jacek", "Nowak", true);

        assertAll(
                () -> assertFalse(expensive.isInRepair()),
                () -> assertFalse(expensive.isRented()),
                () -> assertTrue(damaged.isInRepair()),
                () -> assertFalse(damaged.isRented()),
                () -> assertTrue(rented.isRented()),
                () -> assertFalse(rented.isInRepair()),

                () -> assertTrue(client.isRentPossible(first, expensive)),
                () -> assertFalse(client.isRentPossible(first, rented)),
                () -> assertFalse(client.isRentPossible(first, damaged)),
                () -> assertFalse(client.isRentPossible(second, expensive))
        );

    }
}
