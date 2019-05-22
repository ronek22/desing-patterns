package abstractFactory;

import classicBuilder.House;

public class SummerHouseFactory implements Factory {
    private static SummerHouseFactory instance;

    private SummerHouseFactory() {}

    public static SummerHouseFactory getInstance() {
        if(instance==null)
            instance = new SummerHouseFactory();
        return instance;
    }

    @Override
    public House createHouse() {
        return new SummerHouse();
    }
}
