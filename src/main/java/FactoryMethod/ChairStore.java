package FactoryMethod;

import Products.Chairs.AntiqueChair;
import Products.Chairs.ArtDecoChair;
import Products.Chairs.ModernChair;
import Products.Furniture;

public class ChairStore extends FurnitureStore {
    private static ChairStore instance;

    private ChairStore() {}

    public static ChairStore getInstance() {
        if(instance == null)
            instance = new ChairStore();
        return instance;
    }


    @Override
    Furniture createFurniture(String item) {
        item = item.toLowerCase();
        if(item.equals("antique")) {
            return new AntiqueChair();
        } else if(item.equals("artdeco")) {
            return new ArtDecoChair();
        } else if(item.equals("modern")) {
            return new ModernChair();
        } else return null;
    }
}
