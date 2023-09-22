public class ComputerFactory {
    public static Computer getComputer(String type, String RAM, String CPU, String HDD) {
        if("PC".equalsIgnoreCase(type)) {
            return new PC(RAM, CPU, HDD);
        }
        if("Server".equalsIgnoreCase(type)) {
            return new Server(RAM, CPU, HDD);
        }
        return null;
    }
}
