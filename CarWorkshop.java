import java.util.ArrayList;
import java.util.List;

public class CarWorkshop<T extends Vehicle> implements Loadable<T>{ // T - generic type parameter.
    // Indikerar på att det endast kan ta emot objekt av en viss typ.
    private final FifoStorage<T> storageInWorkshop;

    public CarWorkshop(int maxCapacity) {
        storageInWorkshop = new FifoStorage<>(maxCapacity);
    }
    @Override
    public void load(T car) {
        storageInWorkshop.load(car);
        }
        @Override
    public T unload() {
            return storageInWorkshop.unload();
    }

}
