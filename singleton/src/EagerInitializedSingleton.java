public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {}

    public static EagerInitializedSingleton getInstance() {
        System.out.println("printing inside from the EagerInitializedSingleton");
        return instance;
    }
}
