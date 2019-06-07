package abstractFactory;

import classicBuilder.House;

public class HouseStore {
    private Factory factory;

    public HouseStore(Factory factory) { this.factory = factory; }

    public House BuildHouse() {
        return factory.createHouse();
    }
}
