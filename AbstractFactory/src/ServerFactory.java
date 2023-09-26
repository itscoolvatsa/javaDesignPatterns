public class ServerFactory implements ComputerAbstractFactory{
    private final String RAM;
    private final String CPU;
    private final String HDD;

    private ServerFactory(String RAM, String CPU, String HDD) {
        this.RAM = RAM;
        this.CPU = CPU;
        this.HDD = HDD;
    }

    @Override
    public Computer createComputer() {
        return new Server(RAM, CPU, HDD);
    }
}
