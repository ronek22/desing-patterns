package classicBuilder;

public class House {
    private int windows;
    private int doors;
    private int floors;
    private boolean hasGarage;
    private boolean hasGarden;
    private Material material;


    //region Getters and Setters
    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public boolean isHasGarage() {
        return hasGarage;
    }

    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    public boolean isHasGarden() {
        return hasGarden;
    }

    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    //endregion

    @Override
    public String toString(){
        return "builder.House{"+
                "windows=" + windows +
                ", doors=" + doors +
                ", floors=" + floors +
                ", has garage=" + hasGarage +
                ", has garden=" + hasGarden +
                ", material=" + material +
                "}";

    }
}
