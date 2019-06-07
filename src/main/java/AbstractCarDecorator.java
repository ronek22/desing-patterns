public abstract class AbstractCarDecorator extends AbstractCar {
    protected AbstractCar car;

    public AbstractCarDecorator(AbstractCar car){
        this.car = car;
    }
}
