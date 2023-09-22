public class EagerInitializedSingleton {
    private static EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {};

    public static EagerInitializedSingleton getInstance() {
        System.out.println("printing inside from the EagerInitializedSingleton");
        return instance;
    }
}
