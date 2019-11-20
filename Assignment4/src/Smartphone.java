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
                        System.out.println("##### " + d.getName() + " #####");
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

                    // Cleaningrobot
                    if (selectedDevice == 1 && selectedCommand != 0) {

                        if (selectedCommand == 1) {
                            CleaningrobotBackToChargeCommand c1 = new CleaningrobotBackToChargeCommand(cleaningrobot);
                            c1.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 2) {
                            CleaningrobotBatteryChargingStatusCommand c2 = new CleaningrobotBatteryChargingStatusCommand(cleaningrobot);
                            c2.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 3) {
                            CleaningrobotBatteryStatusCommand c3 = new CleaningrobotBatteryStatusCommand(cleaningrobot);
                            c3.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 4) {
                            CleaningrobotCheckCleaningPercentageCommand c4 = new CleaningrobotCheckCleaningPercentageCommand(cleaningrobot);
                            c4.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 5) {
                            CleaningrobotCompleteCleaningCommand c5 = new CleaningrobotCompleteCleaningCommand(cleaningrobot);
                            c5.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 6) {
                            CleaningrobotEndCleaningCommand c6 = new CleaningrobotEndCleaningCommand(cleaningrobot);
                            c6.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 7) {
                            Scanner scanC = new Scanner(System.in);
                            System.out.println(("Please type how many seconds the timer should be"));
                            String timerStr = scanC.nextLine();
                            int timerInt = Integer.parseInt(timerStr);
                            CleaningrobotSetTimerCommand c7 = new CleaningrobotSetTimerCommand(cleaningrobot, timerInt);
                            thread = new Thread(c7);
                            thread.start();
                            commandSuccessful = true;
                            Thread.sleep(200);
                        }

                        else if (selectedCommand == 8) {
                            CleaningrobotStartVacuumCleanerCommand c8 = new CleaningrobotStartVacuumCleanerCommand(cleaningrobot);
                            c8.execute();
                            commandSuccessful = true;
                        }


                    }

                    // Microwave
                    else if (selectedDevice == 2 && selectedCommand != 0) {

                        if (selectedCommand == 1) {
                            MicrowaveCheckTimerCommand mw = new MicrowaveCheckTimerCommand(microwave);
                            mw.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 2) {
                            MicrowaveInterruptCommand mw = new MicrowaveInterruptCommand(microwave);
                            mw.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 3) {
                            MicrowaveSetTempeartureCommand mw = new MicrowaveSetTempeartureCommand(microwave);
                            mw.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 4) {
                            Scanner scanMw = new Scanner(System.in);
                            System.out.println(("Please type how many seconds the timer should be"));
                            String timerStr = scanMw.nextLine();
                            int timerInt = Integer.parseInt(timerStr);
                            MicrowaveSetTimerCommand mw = new MicrowaveSetTimerCommand(microwave, timerInt);
                            thread = new Thread(mw);
                            thread.start();
                            commandSuccessful = true;
                            Thread.sleep(200);
                        }

                        else if (selectedCommand == 5) {
                            MicrowaveStartBakingCommand mw = new MicrowaveStartBakingCommand(microwave);
                            mw.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 6) {
                            MicrowaveSwitchOffCommand mw = new MicrowaveSwitchOffCommand(microwave);
                            mw.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 7) {
                            MicrowaveSwitchOnCommand mw = new MicrowaveSwitchOnCommand(microwave);
                            mw.execute();
                            commandSuccessful = true;
                        }

                    }

                    // Oven
                    else if (selectedDevice == 3 && selectedCommand != 0) {

                        if (selectedCommand == 1) {
                            OvenCheckTimerCommand o = new OvenCheckTimerCommand(oven);
                            o.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 2) {
                            OvenInteruptCommand o = new OvenInteruptCommand(oven);
                            o.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 3) {
                            OvenSetProgramCommand o = new OvenSetProgramCommand(oven);
                            o.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 4) {
                            OvenSetTemperatureCommand o = new OvenSetTemperatureCommand(oven);
                            o.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 5) {
                            Scanner scanO = new Scanner(System.in);
                            System.out.println(("Please type how many seconds the timer should be"));
                            String timerStr = scanO.nextLine();
                            int timerInt = Integer.parseInt(timerStr);
                            OvenSetTimerCommand o = new OvenSetTimerCommand(oven, timerInt);
                            thread = new Thread(o);
                            thread.start();
                            commandSuccessful = true;
                            Thread.sleep(200);
                        }

                        else if (selectedCommand == 6) {
                            OvenStartCookingCommand o = new OvenStartCookingCommand(oven);
                            o.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 7) {
                            OvenSwitchOffCommand o = new OvenSwitchOffCommand(oven);
                            o.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 8) {
                            OvenSwitchOnCommand o = new OvenSwitchOnCommand(oven);
                            o.execute();
                            commandSuccessful = true;
                        }

                    }

                    // Washingmachine
                    else if (selectedDevice == 4 && selectedCommand != 0) {

                        if (selectedCommand == 1) {
                            WashingmachineSwitchOnCommand wmOn = new WashingmachineSwitchOnCommand(washingmachine);
                            wmOn.execute();
                            commandSuccessful = true;
                        }

                        else
                            if (selectedCommand == 2) {
                            System.out.print("Select degrees: ");
                            Scanner scan = new Scanner(System.in);
                            String deg = scan.nextLine();
                            WashingmachineSelectDegreesCommand wmsd = new WashingmachineSelectDegreesCommand(washingmachine, Integer.parseInt(deg));
                            wmsd.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 3){
                            System.out.print("Select Program: ");
                            Scanner scans = new Scanner(System.in);
                            String type = scans.nextLine();
                            WashingmachineTypeOfWashingCommand wmtow = new WashingmachineTypeOfWashingCommand(washingmachine, type);
                            wmtow.execute();
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 4) {
                            WashingmachineStartProgramCommand wmsp = new WashingmachineStartProgramCommand(washingmachine);
                            thread = new Thread(wmsp);
                            thread.start();
                            commandSuccessful = true;
                            Thread.sleep(200);
                        }

                        else if(selectedCommand == 5) {
                            WashingmachineTurnOffCommand wmto = new WashingmachineTurnOffCommand(washingmachine);
                            wmto.execute();
                            commandSuccessful = true;
                        }

                        else if(selectedCommand == 6) {
                            WashingmachineSwitchOffCommand wmso = new WashingmachineSwitchOffCommand(washingmachine);
                            wmso.execute();
                            commandSuccessful = true;
                        }
                    }

                    // Dishwasher
                    else if (selectedDevice == 5 && selectedCommand != 0) {

                        if (selectedCommand == 1) {
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 2) {
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 3){
                            commandSuccessful = true;
                        }

                        else if (selectedCommand == 4) {
                            commandSuccessful = true;
                        }

                        else if(selectedCommand == 5) {
                            commandSuccessful = true;
                        }

                        else if(selectedCommand == 6) {
                            commandSuccessful = true;
                        }
                    }

                    if (!commandSuccessful || commandError) {
                        System.err.println("Wrong input! Please try again.");
                    }

                    // Thread.sleep(300);

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
