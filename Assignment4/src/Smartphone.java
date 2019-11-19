import java.util.ArrayList;
import java.util.Scanner;

public class Smartphone {
    private Cleaningrobot cleaningrobot;
    private Microwave microwave;
    private Oven oven;
    private Washingmachine washingmachine;
    // private Dishwasher dishwasher;
    private ArrayList<Device> devices= new ArrayList<>();

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

    public void use() throws InterruptedException {
        String input = "";

        do {
            int selectedDevice;
            int selectedCommand;

            for (Device d : devices) {
                System.out.println("("+ d.getIdentifier() + ") " + d.getName());
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
                        System.out.println(d.getName());
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
                    selectedCommand = 0;
                    boolean commandSuccessful = false;
                    boolean commandError = false;

                    try {
                        selectedCommand = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        commandError = true;
                    }

                    if (selectedCommand == -1) {
                        break;
                    }

                    // THREAD
                    Thread thread;

                    if (selectedDevice == 1 && selectedCommand != 0) {
                        // System.out.println("Cleaningrobot");

                        if (selectedCommand == 1) {
                            CleaningrobotBackToChargeCommand c1 = new CleaningrobotBackToChargeCommand(cleaningrobot);
                            thread = new Thread(c1);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 2) {
                            CleaningrobotBatteryChargingStatusCommand c2 = new CleaningrobotBatteryChargingStatusCommand(cleaningrobot);
                            thread = new Thread(c2);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 3) {
                            CleaningrobotBatteryStatusCommand c3 = new CleaningrobotBatteryStatusCommand(cleaningrobot);
                            thread = new Thread(c3);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 4) {
                            CleaningrobotCheckCleaningPercentageCommand c4 = new CleaningrobotCheckCleaningPercentageCommand(cleaningrobot);
                            thread = new Thread(c4);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 5) {
                            CleaningrobotCompleteCleaningCommand c5 = new CleaningrobotCompleteCleaningCommand(cleaningrobot);
                            thread = new Thread(c5);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 6) {
                            CleaningrobotEndCleaningCommand c6 = new CleaningrobotEndCleaningCommand(cleaningrobot);
                            thread = new Thread(c6);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 7) {
                            Scanner scan = new Scanner(System.in);
                            System.out.println(("Please type how many seconds the timer should be"));
                            String timerStr = scan.nextLine();
                            int timerInt = Integer.parseInt(timerStr);
                            CleaningrobotSetTimerCommand c7 = new CleaningrobotSetTimerCommand(cleaningrobot, timerInt);
                            thread = new Thread(c7);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 8) {
                            CleaningrobotStartVacuumCleanerCommand c8 = new CleaningrobotStartVacuumCleanerCommand(cleaningrobot);
                            thread = new Thread(c8);
                            thread.start();
                            commandSuccessful = true;
                        }


                    }

                    else if (selectedDevice == 2 && selectedCommand != 0) {
                        // System.out.println("Microwave");

                        if (selectedCommand == 1) {

                        }

                        else if (selectedCommand == 2) {

                        }

                        else if (selectedCommand == 3) {

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

                    else if (selectedDevice == 3 && selectedCommand != 0) {
                        // System.out.println("Oven");

                        if (selectedCommand == 1) {

                        }

                        else if (selectedCommand == 2) {

                        }

                        else if (selectedCommand == 3) {

                        }

                        else if (selectedCommand == 4) {

                        }

                        else if (selectedCommand == 5) {

                        }

                        else if (selectedCommand == 6) {

                        }

                        else if (selectedCommand == 7) {

                        }

                        else if (selectedCommand == 8) {

                        }

                    }

                    else if (selectedDevice == 4 && selectedCommand != 0) {
                        // System.out.println("Washingmachine");

                        if (selectedCommand == 1) {
                            WashingmachineSwitchOnCommand wmOn = new WashingmachineSwitchOnCommand(washingmachine);
                            thread = new Thread(wmOn);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else
                            if (selectedCommand == 2) {
                            System.out.print("Select degrees: ");
                            Scanner scan = new Scanner(System.in);
                            String deg = scan.nextLine();
                            WashingmachineSelectDegreesCommand wmsd = new WashingmachineSelectDegreesCommand(washingmachine, Integer.parseInt(deg));
                            thread = new Thread(wmsd);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 3){
                            System.out.print("Select Program: ");
                            Scanner scans = new Scanner(System.in);
                            String type = scans.nextLine();
                            WashingmachineTypeOfWashingCommand wmtow = new WashingmachineTypeOfWashingCommand(washingmachine, type);
                            thread = new Thread(wmtow);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 4) {
                            WashingmachineStartProgramCommand wmsp = new WashingmachineStartProgramCommand(washingmachine);
                            thread = new Thread(wmsp);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if(selectedCommand == 5) {
                            WashingmachineTurnOffCommand wmto = new WashingmachineTurnOffCommand(washingmachine);
                            thread = new Thread(wmto);
                            thread.start();
                            commandSuccessful = true;
                        }

                        else if(selectedCommand == 6) {
                            WashingmachineSwitchOffCommand wmso = new WashingmachineSwitchOffCommand(washingmachine);
                            thread = new Thread(wmso);
                            thread.start();
                            commandSuccessful = true;
                        }
                    }
                    if (!commandSuccessful || commandError) {
                        System.err.println("Wrong input! Please try again.");
                    }

                    Thread.sleep(300);

                } while (true);

            } while (selectedDevice == 0);


        } while (!input.equals("exit"));

        System.out.println("Shutdown Smartphone...");
        // System.exit(0);
    }

    /*
    public static void main(String[] args) {
        Smartphone s = new Smartphone();
        try {
            s.use();
        } catch (InterruptedException e) {
            System.err.println("An error occurred!!!");
        }
    }

    */

}
