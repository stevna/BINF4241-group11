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
            int selectedDevice;
            int selectedCommand;

            for (Device d : devices) {
                System.out.println("device name: ("+ d.getIdentifier() + ") " + d.getName());
            }

            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println(("Please type in the number of the device: "));
                input = scanner.nextLine();
                int tmp = 0;

                if (input.equals("exit")) {
                    break;
                }

                try {
                    tmp = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    tmp = 0;
                }
                selectedDevice = 0;

                for (Device d : devices) {

                    if (tmp == d.getIdentifier()) {
                        selectedDevice = d.getIdentifier();

                        System.out.println("Following information about your device:");
                        d.getInformation();
                        System.out.println("You see the functions of that device:");
                        d.printFunc();
                    }
                }

                if (tmp == 0 || selectedDevice == 0) {
                    System.err.println("Wrong input! Please try again.");
                    break;
                }

                do {
                    System.out.println("Choose the function you want to execute:");
                    input = scanner.nextLine();

                    try {
                        selectedCommand = Integer.parseInt(input);
                    }catch (NumberFormatException e) {
                        System.err.println("Wrong input! Please try again.");
                        selectedCommand = 0;
                    }

                    if (selectedCommand == -1) {
                        break;
                    }

                    Thread thread;

                    if (selectedDevice == 1 && selectedCommand != 0) {
                        System.out.println("Cleaningrobot");

                        if (selectedCommand == 1) {
                            CleaningrobotBackToChargeCommand c1 = new CleaningrobotBackToChargeCommand(cleaningrobot);
                            thread = new Thread(c1);
                            thread.start();

                        }
                        else if (selectedCommand == 2) {

                        }
                        else if (selectedCommand == 3) {
                            CleaningrobotBatteryStatusCommand c3 = new CleaningrobotBatteryStatusCommand(cleaningrobot);
                            thread = new Thread(c3);
                            thread.start();
                        }
                        else if (selectedCommand == 4) {

                        }
                        else if (selectedCommand == 5) {

                        }
                        else if (selectedCommand == 6) {

                        }
                        else if (selectedCommand == 7) {

                        }


                    }

                    else if (selectedDevice == 2 && selectedCommand != 0) {
                        System.out.println("Microwave");

                    }

                    else if (selectedDevice == 3 && selectedCommand != 0) {
                        System.out.println("Oven");

                    }

                    else if (selectedDevice == 4 && selectedCommand != 0) {
                        System.out.println("Washingmachine");

                    }

                } while (selectedCommand == 0);
            } while (selectedDevice == 0);


        } while (!input.equals("exit"));

        System.out.println("Shutdown Smartphone...");
        System.exit(0);
    }

    public static void main(String[] args) {
        Smartphone s = new Smartphone();
        s.use();
    }

}
