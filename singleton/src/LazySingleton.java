public class LazySingleton {
    private static LazySingleton instance;
    private static int val = 0;

    private LazySingleton () {};

    public static LazySingleton getInstance() {
        if(instance == null) {
            System.out.println("Lazy instance is got created");
            instance = new LazySingleton();
        }
        System.out.println("printing static value: " + val);
        val ++;
        return instance;
    }
}
