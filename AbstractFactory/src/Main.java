public class Main {
    public static void main(String[] args) {
        testAbstractFactory();
    }

    public static void testAbstractFactory() {
        Computer pc = ComputerFactory.getComputer(new PCFactory( "4", "4.5", "2000 GB"));
        Computer server = ComputerFactory.getComputer(new PCFactory( "64", "24.5", "45000 GB"));

        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
    }
}
