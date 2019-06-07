public class DiscountDecorator extends AbstractCarDecorator {
    private int discountPercent;
    
    public DiscountDecorator(int discountPercent, AbstractCar car){
        super(car);
        this.discountPercent = discountPercent;
    }

    @Override
    public double getPricePerMinute() {
        return car.getPricePerMinute() * (100 - discountPercent) / 100.0;
    }
}
