import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String args[])
    {

        //every object get instantiated

        //class isch normal konstruiert
        Cleaningrobot cleaningrobot = new Cleaningrobot();


        //second thread, microwave class isch selber als thread konstruiert
        Microwave microwave= new Microwave();
        Thread object1 = new Thread(new Microwave());
        object1.start();



        Remote remote = new Remote();


        ArrayList<Device> devices= new ArrayList<>();
        devices.add(cleaningrobot);
        devices.add(microwave);

        String input = "";





        while(!input.equals("exit") ){
            for (Device p : devices) {
                System.out.println("device name: " + p.getName());

            }

            Scanner scanner = new Scanner(System.in);
            System.out.println(("Please type in the device name"));
            input = scanner.nextLine();



        }



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









        /*MicrowaveSwitchOnCommand switchon = new MicrowaveSwitchOnCommand(microwave);
        remote.setCommand(switchon);
        remote.pressButton();*/

        /*MicrowaveSetTimerCommand setTimerMicro = new MicrowaveSetTimerCommand(microwave);
        remote.setCommand(setTimerMicro);
        remote.pressButton();

        */



    }

}
