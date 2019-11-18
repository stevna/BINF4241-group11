import java.util.ArrayList;
import java.util.Scanner;

public class Smartphone {
    private Cleaningrobot cleaningrobot;
    private Microwave microwave;
    private Oven oven;
    private Washingmachine washingmachine;
    // private Dishwasher dishwasher;
    ArrayList<Device> devices= new ArrayList<>();

    public Smartphone() {
        cleaningrobot = new Cleaningrobot();
        microwave = new Microwave();
        oven = new Oven();
        washingmachine = new Washingmachine();
        devices.add(cleaningrobot);
        devices.add(microwave);
        devices.add(oven);
        devices.add(washingmachine);
    }

    public void use() {
        String input = "";

        do {
            for (Device d : devices) {
                System.out.println("device name: ("+ d.getIdentifier() + ") " + d.getName());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println(("Please type in the device the number of the device: "));
            input = scanner.nextLine();


            for (Device d : devices) {
                if (Integer.parseInt(input) == d.getIdentifier()) {

                    System.out.println("Following information about your device:");
                    d.getInformation();
                    System.out.println("You see the functions of that device:");
                    d.printFunc();

                    System.out.println("Choose the function you want to execute:");
                    input = scanner.nextLine();
                    
                }
            }


        } while (!input.equals("exit"));
    }

    public static void main(String[] args) {
        Smartphone s = new Smartphone();
        s.use();
    }

}
