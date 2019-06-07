import classicBuilder.*;
import fluentBuilder.House;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FluentBuilderTest {
    @Test
    public void shouldReturnSummerHouse() {
        fluentBuilder.House house = House.builder()
                .material(Material.WOOD)
                .doors(3)
                .floors(1)
                .windows(5)
                .hasGarage(false)
                .hasGarden(true)
                .build();

        assertAll(
                () -> assertEquals(house.getMaterial(), Material.WOOD),
                () -> assertEquals(house.getDoors(), 3),
                () -> assertEquals(house.getFloors(), 1),
                () -> assertEquals(house.getWindows(), 5),
                () -> assertFalse(house.isHasGarage()),
                () -> assertTrue(house.isHasGarden())
        );

        System.out.println(house);
    }

    @Test
    public void shouldReturnFamilyHouse() {
        fluentBuilder.House house = House.builder()
                .material(Material.STONE)
                .doors(10)
                .floors(2)
                .windows(15)
                .hasGarage(true)
                .hasGarden(false)
                .build();

        assertAll(
                () -> assertEquals(house.getMaterial(), Material.STONE),
                () -> assertEquals(house.getDoors(), 10),
                () -> assertEquals(house.getFloors(), 2),
                () -> assertEquals(house.getWindows(), 15),
                () -> assertTrue(house.isHasGarage()),
                () -> assertFalse(house.isHasGarden())
        );

        System.out.println(house);
    }

    @Test
    public void createMultipleSummerHouseShouldNotReturnTheSameObject() {
        fluentBuilder.House house1 = House.builder()
                .material(Material.STONE)
                .doors(10)
                .floors(2)
                .windows(15)
                .hasGarage(true)
                .hasGarden(false)
                .build();

        fluentBuilder.House house2 = House.builder()
                .material(Material.STONE)
                .doors(10)
                .floors(2)
                .windows(15)
                .hasGarage(true)
                .hasGarden(false)
                .build();


        assertAll(
                () -> assertEquals(house1.toString(), house2.toString()),
                () -> assertNotSame(house1, house2)
        );
    }
}
