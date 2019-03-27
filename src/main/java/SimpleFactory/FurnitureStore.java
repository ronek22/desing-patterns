package SimpleFactory;

import Products.Chair;
import Products.Sofa;
import Products.Table;

public class FurnitureStore {
    private SimpleFurnitureFactory _factory;

    public FurnitureStore() {
        this._factory = SimpleFurnitureFactory.getInstance();
    }

    public Chair OrderChair(String type){
        Chair chair = _factory.CreateChair(type);
        if(chair == null)
            return null;

        chair.build();
        chair.deliver();

        return chair;
    }

    public Sofa OrderSofa(String type) {
        Sofa sofa = _factory.CreateSofa(type);
        if(sofa == null)
            return null;

        sofa.build();
        sofa.deliver();
        return sofa;
    }

    public Table OrderTable(String type) {
        Table table = _factory.CreateTable(type);
        if(table == null)
            return null;

        table.build();
        table.deliver();
        return table;
    }
}
