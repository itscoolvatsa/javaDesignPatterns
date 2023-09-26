public class Computer {
    private final String CPU;
    private final String RAM;
    private final String HDD;

    private final boolean isGraphicsCardEnabled;
    private final boolean isBluetoothEnabled;

    private Computer (ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.HDD = builder.HDD;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public static class ComputerBuilder {
//        required
        private final String CPU;
        private final String RAM;
        private final String HDD;

//        optional
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String CPU, String RAM, String HDD) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.HDD = HDD;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
