public class PC extends Computer{
    private final String RAM;
    private final String CPU;
    private final String HDD;

    public PC(String RAM, String CPU, String HDD) {
        this.RAM = RAM;
        this.CPU = CPU;
        this.HDD = HDD;
    }

    @Override
    public String getRAM() {
        return this.RAM;
    }

    @Override
    public String getCPU() {
        return this.CPU;
    }

    @Override
    public String getHDD() {
        return this.HDD;
    }
}
