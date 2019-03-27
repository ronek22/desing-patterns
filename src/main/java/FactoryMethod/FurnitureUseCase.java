package FactoryMethod;

public class FurnitureUseCase {
    public static void main(String[] args) {
        ChairStore chairStore = ChairStore.getInstance();
        chairStore.Build("antique");

        TableStore tableStore = TableStore.getInstance();
        tableStore.Build("modern");
    }
}
