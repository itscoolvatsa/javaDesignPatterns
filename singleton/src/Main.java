public class Main {
    public static void main(String[] args) {
        EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton.getInstance();

        StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.getInstance();

        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton = LazySingleton.getInstance();

        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();

        System.out.println("done");
    }
}
