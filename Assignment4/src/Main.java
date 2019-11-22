import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        Smartphone s = new Smartphone();
        try {
            s.use();
        } catch (InterruptedException e) {
            System.err.println("An error occurred!!!");
        }


        /*

        //every object get instantiated

        //class isch normal konstruiert
        Cleaningrobot cleaningrobot = new Cleaningrobot();


        //second thread, microwave class isch selber als thread konstruiert
        Microwave microwave= new Microwave();
        Thread object1 = new Thread(new Microwave());
        object1.start();

        Oven oven = new Oven();






        ArrayList<Device> devices= new ArrayList<>();
        devices.add(cleaningrobot);
        devices.add(microwave);
        devices.add(oven);

        String input = "";

         */





        /*

        OvenSwitchOnCommand switchon = new OvenSwitchOnCommand(oven);
        remote.setCommand(switchon);
        remote.pressButton();

        */


        /*

        while(!input.equals("exit") ){
            for (Device p : devices) {
                System.out.println("device name: " + p.getName());

            }

            Scanner scanner = new Scanner(System.in);
            System.out.println(("Please type in the device name"));
            input = scanner.nextLine();


            for (Device p : devices) {
                if(input.equals(p.getName())) {

                    System.out.println("Following information about your device:");
                    p.getInformation();
                    System.out.println("You see the functions of that device:");
                    p.printFunc();

                    System.out.println("Choose the function you want to execute:");
                    input = scanner.nextLine();

                    //wie chan ich dur en user input eh function ufrüefe
                }

            }

            System.out.println(("Please type in exit or another device name"));
            input = scanner.nextLine();

        }

        */


        //isch zum teste gsie
        /*CleaningrobotStartVacuumCleanerCommand start = new CleaningrobotStartVacuumCleanerCommand(cleaningrobot);

        CleaningrobotBackToChargeCommand backtocharge = new CleaningrobotBackToChargeCommand(cleaningrobot);
        CleaningrobotSetTimerCommand settimer = new CleaningrobotSetTimerCommand(cleaningrobot);


        remote.setCommand(start);
        remote.pressButton();

        remote.setCommand(settimer);
        remote.pressButton();

        remote.setCommand(backtocharge);
        remote.pressButton();

        */





        /*OvenSwitchOnCommand switchon = new OvenSwitchOnCommand(oven);
        remote.setCommand(switchon);
        remote.pressButton();


        OvenSetTemperatureCommand setTempt= new OvenSetTemperatureCommand(oven);
        remote.setCommand(setTempt);
        remote.pressButton();

        OvenSetTimerCommand setTimer = new OvenSetTimerCommand(oven);
        remote.setCommand(setTimer);
        remote.pressButton();

        OvenStartCookingCommand startCooking = new OvenStartCookingCommand(oven);
        remote.setCommand(startCooking);
        remote.pressButton();

        OvenSwitchOffCommand switchOff = new OvenSwitchOffCommand(oven);
        remote.setCommand(switchOff);
        remote.pressButton();


        OvenCheckTimerCommand checkTimer = new OvenCheckTimerCommand(oven);
        remote.setCommand(checkTimer);
        remote.pressButton();












        /*MicrowaveSwitchOnCommand switchon = new MicrowaveSwitchOnCommand(microwave);
        remote.setCommand(switchon);
        remote.pressButton();*/

        /*MicrowaveSetTimerCommand setTimerMicro = new MicrowaveSetTimerCommand(microwave);
        remote.setCommand(setTimerMicro);
        remote.pressButton();




    }
    */




}}
