package classicBuilder;

// Director
public class HouseShop {
    public void constructHouse(HouseBuilder builder){
        builder.buildWalls();
        builder.buildGarage();
        builder.buildGarden();
        builder.buildWindows();
        builder.buildDoors();
    }
}
