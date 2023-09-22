public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {};

    public static synchronized ThreadSafeSingleton getInstance() {
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        System.out.println("printing from thread safe singleton");
        return instance;
    };
}
