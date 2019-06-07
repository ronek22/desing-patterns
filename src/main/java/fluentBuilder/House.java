package fluentBuilder;

import classicBuilder.Material;

//Inner Static Fluent Builder
public class House {
    private int windows;
    private int doors;
    private int floors;
    private boolean hasGarage;
    private boolean hasGarden;
    private Material material;

    //region Getters
    public int getWindows() {
        return windows;
    }

    public int getDoors() {
        return doors;
    }

    public int getFloors() {
        return floors;
    }

    public boolean isHasGarage() {
        return hasGarage;
    }

    public boolean isHasGarden() {
        return hasGarden;
    }

    public Material getMaterial() {
        return material;
    }
    //endregion

    public static final class Builder {
        private int windows;
        private int doors;
        private int floors;
        private boolean hasGarage;
        private boolean hasGarden;
        private Material material;

        public House build(){
            House house = new House();
            house.windows = this.windows;
            house.doors = this.doors;
            house.floors = this.floors;
            house.hasGarage = this.hasGarage;
            house.hasGarden = this.hasGarden;
            house.material = this.material;
            return house;
        }

        public Builder windows(int windows) {
            this.windows = windows;
            return this;
        }

        public Builder doors(int doors) {
            this.doors = doors;
            return this;
        }

        public Builder floors(int floors) {
            this.floors = floors;
            return this;
        }

        public Builder hasGarden(boolean garden){
            this.hasGarden = garden;
            return this;
        }

        public Builder hasGarage(boolean garage){
            this.hasGarage = garage;
            return this;
        }

        public Builder material(Material material){
            this.material = material;
            return this;
        }

    }

    public static Builder builder() {
        return new Builder();
    }


    @Override
    public String toString(){
        return "fluentBuilder.House{"+
                "windows=" + windows +
                ", doors=" + doors +
                ", floors=" + floors +
                ", has garage=" + hasGarage +
                ", has garden=" + hasGarden +
                ", material=" + material +
                "}";

    }
}
