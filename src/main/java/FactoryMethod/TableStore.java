package FactoryMethod;

import Products.Furniture;
import Products.Tables.AntiqueTable;
import Products.Tables.ArtDecoTable;
import Products.Tables.ModernTable;

public class TableStore extends FurnitureStore {
    private static TableStore instance;

    private TableStore() {}

    public static TableStore getInstance() {
        if(instance == null)
            instance = new TableStore();
        return instance;
    }
    @Override
    Furniture createFurniture(String item) {
        item = item.toLowerCase();
        if(item.equals("antique")) {
            return new AntiqueTable();
        } else if(item.equals("artdeco")) {
            return new ArtDecoTable();
        } else if(item.equals("modern")) {
            return new ModernTable();
        } else return null;
    }
}
