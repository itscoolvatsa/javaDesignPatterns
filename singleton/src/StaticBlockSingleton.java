public class StaticBlockSingleton {
    private static final StaticBlockSingleton instance;

    private StaticBlockSingleton() {}

    static {
        try{
            instance = new StaticBlockSingleton();
            System.out.println("Static Block Singleton has been intialized");
        }catch (Exception e){
            throw new RuntimeException("Error while initializing Static Block Singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
