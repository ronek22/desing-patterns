package SimpleFactory;

import Products.Chair;

public class SimpleStoreUseCase {

    public static void main(String[] args) {
        FurnitureStore store = new FurnitureStore();

        System.out.println("Try to order antique chair");
        Chair chair = store.OrderChair("antique");
        System.out.println(chair);
    }

}
