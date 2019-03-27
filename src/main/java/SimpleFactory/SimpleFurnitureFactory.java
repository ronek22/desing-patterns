package SimpleFactory;

import Products.Chair;
import Products.Chairs.AntiqueChair;
import Products.Chairs.ArtDecoChair;
import Products.Chairs.ModernChair;
import Products.Sofa;
import Products.Sofas.AntiqueSofa;
import Products.Sofas.ArtDecoSofa;
import Products.Sofas.ModernSofa;
import Products.Table;
import Products.Tables.AntiqueTable;
import Products.Tables.ArtDecoTable;
import Products.Tables.ModernTable;

public class SimpleFurnitureFactory {
    private static SimpleFurnitureFactory instance;

    private SimpleFurnitureFactory() {}

    public static SimpleFurnitureFactory getInstance() {
        if (instance == null)
            instance = new SimpleFurnitureFactory();
        return instance;
    }

    //

    public Chair CreateChair(String type) {
        type = type.toLowerCase();
        Chair chair = null;

        if(type.equals("antique")) {
            chair = new AntiqueChair();
        } else if(type.equals("artdeco")){
            chair = new ArtDecoChair();
        } else if(type.equals("modern")){
            chair = new ModernChair();
        }

        return chair;
    }

    public Sofa CreateSofa(String type){
        type = type.toLowerCase();
        Sofa sofa = null;

        if(type.equals("antique")) {
            sofa = new AntiqueSofa();
        } else if(type.equals("artdeco")){
            sofa = new ArtDecoSofa();
        } else if(type.equals("modern")){
            sofa = new ModernSofa();
        }

        return sofa;
    }

    public Table CreateTable(String type) {
        type = type.toLowerCase();
        Table table = null;

        if(type.equals("antique")) {
            table = new AntiqueTable();
        } else if(type.equals("artdeco")){
            table = new ArtDecoTable();
        } else if(type.equals("modern")){
            table = new ModernTable();
        }

        return table;
    }
}
