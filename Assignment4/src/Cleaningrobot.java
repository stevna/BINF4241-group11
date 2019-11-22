import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Cleaningrobot extends Device {
    private final int identifier = 1;


    public Cleaningrobot(){
        func.add("(1) Battery Charging Status");
        func.add("(2) Battery Status");
        func.add("(3) Check cleaning percentage");
        func.add("(4) Complete cleaning");
        func.add("(5) End cleaning");
        func.add("(6) Set timer");
        func.add("(7) Start vacuum cleaner");
    }


    private String name = "Cleaningrobot";
    private Timer timerclass = new Timer();

    private int BatteryStatus = 100;
    private int  cleaningCompletion = 5;
    private boolean inBase = true;
    enum eStatus{on, off}
    private eStatus status = eStatus.off;

    enum eloading{yes,no};
    private eloading loading = eloading.yes;
    int timer = 0;



    public void checkBatteryChargingStatus(){
        if(loading == eloading.yes) {
            System.out.println("Battery Charging Status is " + BatteryStatus + " %");
        }
        else {
            System.out.println("Robot is not charging at the moment");
        }

    }

    public void checkBatteryStatus(){
        if(BatteryStatus == 0) {
            System.out.println("Battery is empty, going back to the stations");
            loading = eloading.yes;
        }
            else{
                System.out.println("Battery Status is " + BatteryStatus + " %");
        }
    }

    public void getCleaningPercentage(){
        if(loading == eloading.no && status == eStatus.on) {
            System.out.println("Percentage of cleaning completion is " + cleaningCompletion);
        }
        else{
            System.out.println("Robot is not cleaning at the moment");
        }



    }

    public void completeCleaning(){
        if(status == eStatus.on) {
            System.out.println("Outstanding cleaning completed, robot goes back to chargin station");
            status = eStatus.off;
            loading = eloading.yes;
        }
        else{
            System.out.println("You have to start the robot first");
        }

    }

    public void endCleaning(){
        if(status == eStatus.on) {
            System.out.println("Cleaning finished and going back to station");
            status = eStatus.off;
            loading = eloading.yes;
        }
        else{
            System.out.println("You have to start the robot first");
        }
    }

    public void setTimer(int t) {

        if(status == eStatus.on) {

            System.out.println("Timer started");
            try {
                TimeUnit.SECONDS.sleep(t);
            } catch (InterruptedException e) {
                System.out.println("An error occurred!");
            }

            System.out.format("Robot Timer Finished, Robot goes back to charging station");
            status = eStatus.off;
            loading = eloading.yes;
        }
        else{
            System.out.println("You have to start the robot first");}

        // timerclass.schedule(new hello(),timerint*1000);


    }


    public void startVacuumCleaner(){
        if(loading == eloading.yes && BatteryStatus == 100 && status == eStatus.off ){
            System.out.println("Vacuum cleaner is started");
            status = eStatus.on;
            loading = eloading.no;
        }
        else{
            System.out.println("Vacuum cleaner has to be in his station and batterystatus needs to be 100 %");
        }
    }


    public void getInformation(){
        System.out.println("Cleanigrobot is currently " + status.toString());

    }

    public String getName(){
        return name;
    }

    public int getIdentifier() {
        return identifier;
    }
}
