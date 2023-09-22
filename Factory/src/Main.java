public class Main {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC", "4", "4.5", "2000 GB");
        Computer server = ComputerFactory.getComputer("Server", "64", "64", "20000 GB");

        System.out.println("Factory PC Config ::"+pc);
        System.out.println("Factory Server Config ::"+server);

        
    }
}
