package abstractFactory;

import classicBuilder.House;
import classicBuilder.Material;

public class SummerHouse extends House {
    public SummerHouse() {
        this.setDoors(3);
        this.setFloors(1);
        this.setWindows(5);
        this.setMaterial(Material.WOOD);
        this.setHasGarage(false);
        this.setHasGarden(true);
    }
}
