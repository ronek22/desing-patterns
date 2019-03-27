package FactoryMethod;

import Products.Furniture;
import Products.Sofas.AntiqueSofa;
import Products.Sofas.ArtDecoSofa;

public class SofaStore extends FurnitureStore {
    private static SofaStore instance;

    private SofaStore() {}

    public static SofaStore getInstance() {
        if(instance == null)
            instance = new SofaStore();
        return instance;
    }

    @Override
    Furniture createFurniture(String item) {
        item = item.toLowerCase();
        if(item.equals("antique")) {
            return new AntiqueSofa();
        } else if(item.equals("artdeco")) {
            return new ArtDecoSofa();
        } else if(item.equals("modern")) {
            return new ArtDecoSofa();
        } else return null;
    }
}
