public class LifoStorage<T> extends Storage<T> {


    public LifoStorage(int maxCapacity) {
        super(maxCapacity);
    }
    @Override
    public T unloadimplementation(){
        return loaded.removeLast();
    }

}
