package classicBuilder;

public class SummerHouseBuilder extends HouseBuilder {
    public SummerHouseBuilder(){
        this.house = new House();
    }

    @Override
    public void buildWalls() {
        this.house.setMaterial(Material.WOOD);
        this.house.setFloors(1);
    }

    @Override
    public void buildDoors() {
        this.house.setDoors(3);
    }

    @Override
    public void buildWindows() {
        this.house.setWindows(5);
    }

    @Override
    public void buildGarage() {
        this.house.setHasGarage(false);
    }

    @Override
    public void buildGarden() {
        this.house.setHasGarden(true);
    }


}
