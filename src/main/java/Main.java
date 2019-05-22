import abstractFactory.HouseStore;
import abstractFactory.SummerHouseFactory;
import classicBuilder.HouseBuilder;
import classicBuilder.HouseShop;
import classicBuilder.Material;
import classicBuilder.SummerHouseBuilder;
import classicBuilder.House;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) throws Exception {
        Instant start;
        Instant finish;
        long elapsed;
        int n = 100_000_000;
        House house;
        fluentBuilder.House fluentHouse;

        // Builder Set-Up
        HouseShop shop = new HouseShop();
        HouseBuilder builder = new SummerHouseBuilder();

        // Abstract Factory Set-Up
        HouseStore abstractFactory = new HouseStore(SummerHouseFactory.getInstance());

        // ABSTRACT FACTORY EXECUTION ===================================
        start = Instant.now();
        for(int i = 0; i < n; i++){
            house = abstractFactory.BuildHouse();
        }
        finish = Instant.now();
        elapsed = Duration.between(start,finish).toMillis();
        System.out.println("AF TIME ELAPSED: " + elapsed);


        // SIMPLE BUILDER EXECUTION ===================================
        start = Instant.now();
        for(int i = 0; i < n; i++){
            shop.constructHouse(builder);
            house = builder.getHouse();
        }
        finish = Instant.now();
        elapsed = Duration.between(start,finish).toMillis();
        System.out.println("BUILDER TIME ELAPSED: " + elapsed);



        // FLUENT BUILDER EXECUTION ===================================
        start = Instant.now();
        for(int i = 0; i < n; i++){
            fluentHouse = fluentBuilder.House.builder()
                    .doors(3)
                    .floors(1)
                    .windows(5)
                    .hasGarage(false)
                    .hasGarden(true)
                    .material(Material.WOOD)
                    .build();
        }
        finish = Instant.now();
        elapsed = Duration.between(start,finish).toMillis();
        System.out.println("FLUENT BUILDER TIME ELAPSED: " + elapsed);

    }
}
