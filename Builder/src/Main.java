public class Main {

    public static void main(String []args) {
        Computer computer = new Computer.ComputerBuilder("5.7",
                "64 GB", "2000 GB").setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true).build();

        System.out.println(computer.toString());
    }
}
