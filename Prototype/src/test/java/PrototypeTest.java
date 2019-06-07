import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrototypeTest {

    private MotorcycleManager manager = new MotorcycleManager();

    @Test
    public void deepCopyTest() {
        Motorcycle motor1 = manager.getMotorPrototype("sport");
        Motorcycle motor2 = manager.getMotorPrototype("sport");

        System.out.println("DEEP COPY");
        System.out.println("===============");
        System.out.println("First motor:  " + motor1);
        System.out.println("Second motor: " + motor2);
        System.out.println("===============");

        assertAll(
                () -> assertEquals(motor1.toString(), motor2.toString()),
                () -> assertNotSame(motor1, motor2),
                () -> assertNotSame(motor1.getEngine(), motor2.getEngine()),
                () -> assertNotSame(motor1.getEngine().getType(), motor2.getEngine().getType())
        );
    }

    @Test
    public void shallowCopyTest() {
        Motorcycle motor1 = manager.getMotorShallowCopy("cruiser");
        Motorcycle motor2 = manager.getMotorShallowCopy("cruiser");

        System.out.println("SHALLOW COPY");
        System.out.println("===============");
        System.out.println("First motor:  " + motor1);
        System.out.println("Second motor: " + motor2);
        System.out.println("===============");

        assertAll(
                () -> assertEquals(motor1.toString(), motor2.toString()),
                () -> assertNotSame(motor1, motor2),
                () -> assertSame(motor1.getEngine(), motor2.getEngine()),
                () -> assertSame(motor1.getEngine().getType(), motor2.getEngine().getType())
        );

    }

}
