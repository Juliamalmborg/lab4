package model;
public class FifoStorage<T> extends Storage<T> { //ej stack add remocce

    public FifoStorage(int maxCapacity) {
        super(maxCapacity);
    }

    @Override
    public T unloadimplementation(){
        return loaded.removeFirst();
    }

}
