public class ServerFactory implements ComputerAbstractFactory{
    private String RAM;
    private String CPU;
    private String HDD;

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
