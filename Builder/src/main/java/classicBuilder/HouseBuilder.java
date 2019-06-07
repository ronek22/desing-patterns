package classicBuilder;

public abstract class HouseBuilder {
    House house;

    public abstract void buildWalls();
    public abstract void buildDoors();
    public abstract void buildWindows();
    public abstract void buildGarage();
    public abstract void buildGarden();

    public House getHouse(){
        House result = this.house;
        this.house = new House();
        return result;
    }
}
