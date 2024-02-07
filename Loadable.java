public interface Loadable<T>  {

    void load(T object);

    T unload();
}
