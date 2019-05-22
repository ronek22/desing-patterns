import classicBuilder.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClassicBuilderTest {

    private HouseBuilder builder;
    private HouseShop shop = new HouseShop();

    @Test
    public void shouldReturnFamilyHouse() {
        builder = new FamilyHouseBuilder();
        shop.constructHouse(builder);
        House house = builder.getHouse();

        assertAll(
                () -> assertEquals(house.getMaterial(), Material.STONE),
                () -> assertEquals(house.getDoors(), 10),
                () -> assertEquals(house.getFloors(), 2),
                () -> assertEquals(house.getWindows(), 15),
                () -> assertTrue(house.isHasGarage()),
                () -> assertFalse(house.isHasGarden())
            );
    }

    @Test
    public void shouldReturnSummerHouse() {
        builder = new SummerHouseBuilder();
        shop.constructHouse(builder);
        House house = builder.getHouse();

        assertAll(
                () -> assertEquals(house.getMaterial(), Material.WOOD),
                () -> assertEquals(house.getDoors(), 3),
                () -> assertEquals(house.getFloors(), 1),
                () -> assertEquals(house.getWindows(), 5),
                () -> assertFalse(house.isHasGarage()),
                () -> assertTrue(house.isHasGarden())
        );
    }

    @Test
    public void createMultipleSummerHouseShouldNotReturnTheSameObject() {
        builder = new SummerHouseBuilder();

        shop.constructHouse(builder);
        House house1 = builder.getHouse();

        shop.constructHouse(builder);
        House house2 = builder.getHouse();


        assertAll(
                () -> assertEquals(house1.toString(), house2.toString()),
                () -> assertNotSame(house1, house2)
        );
    }

}
