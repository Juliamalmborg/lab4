package model;
import java.util.ArrayList;
import java.util.List;

public abstract class Storage<T> implements Loadable<T> {
    private final double maxCapacity;
    protected List<T> loaded;


    public Storage(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.loaded = new ArrayList<>();
    }
    @Override
    public void load(T car){
        if(getsize() >= getMaxCapacity()) {
            throw new IllegalArgumentException("The storage is full");
        }
        loaded.addLast(car);
    }
    @Override
    public T unload(){
        if (getsize() == 0) {
            throw new IllegalArgumentException("The storage is empty");
        }
        return unloadimplementation();
    }

    public  int getsize(){
        return loaded.size();
    }

    public double getMaxCapacity() {
        return this.maxCapacity;
    }
    public abstract T unloadimplementation();
}

