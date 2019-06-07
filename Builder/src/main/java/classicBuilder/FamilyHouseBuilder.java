package classicBuilder;

public class FamilyHouseBuilder extends HouseBuilder {
    public FamilyHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildWalls() {
        this.house.setMaterial(Material.STONE);
        this.house.setFloors(2);
    }

    @Override
    public void buildDoors() {
        this.house.setDoors(10);
    }

    @Override
    public void buildWindows() {
        this.house.setWindows(15);
    }

    @Override
    public void buildGarage() {
        this.house.setHasGarage(true);
    }

    @Override
    public void buildGarden() {
        this.house.setHasGarden(false);
    }

}
