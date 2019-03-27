package FactoryMethod;

import Products.Furniture;

public abstract class FurnitureStore {
    abstract Furniture createFurniture(String item);

    public Furniture Build(String name) {
        Furniture furniture = createFurniture(name);
        if(furniture == null)
            return null;

        System.out.println(furniture);
        furniture.build();
        furniture.deliver();

        return furniture;
    }
}
