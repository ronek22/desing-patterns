import abstractFactory.HouseStore;
import abstractFactory.SummerHouseFactory;
import classicBuilder.House;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {
    private HouseStore abstractFactory = new HouseStore(SummerHouseFactory.getInstance());

    @Test
    public void createMultipleSummerHouseShouldNotReturnTheSameObject(){
        House house1 = abstractFactory.BuildHouse();
        House house2 = abstractFactory.BuildHouse();

        assertAll(
                () -> assertEquals(house1.toString(), house2.toString()),
                () -> assertNotSame(house1, house2)
        );
    }
}
