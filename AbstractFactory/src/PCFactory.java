public class PCFactory implements ComputerAbstractFactory{
    private final String RAM;
    private final String CPU;
    private final String HDD;

    public PCFactory(String RAM, String CPU, String HDD) {
        this.RAM = RAM;
        this.CPU = CPU;
        this.HDD = HDD;
    }

    @Override
    public Computer createComputer() {
        return new PC(RAM, CPU, HDD);
    }
}
