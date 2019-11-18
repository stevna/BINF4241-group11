import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Cleaningrobot extends Device {
    private final int identifier = 1;


    public Cleaningrobot(){
        func.add("(1) Back to charge");
        func.add("(2) Battery Charging Status");
        func.add("(3) Battery Status");
        func.add("(4) Check cleaning percentage");
        func.add("(5) Complete cleaning");
        func.add("(6) End cleaning");
        func.add("(7) Set timer");
        func.add("(8) Start vacuum cleaner");
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



    public void backToCharge(){
        if(status == eStatus.on) {
            System.out.println("Time expired, Robot goes back to charging station");
            loading = eloading.yes;
        }
        else {
            System.out.println("You have to start the Cleaining Robot first");
        }
    }

    public void checkBatteryChargingStatus(){
        System.out.println("Battery Charging Status is" + BatteryStatus + "%");

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
        System.out.println("Percentage of cleaning completion is " + cleaningCompletion);

    }

    public void completeCleaning(){
        System.out.println("Outstanding cleaning completed");
        status = eStatus.off;
    }

    public void endCleaning(){
        System.out.println("Cleaning finished and going back to station");
        status = eStatus.off;
        loading = eloading.yes;
    }

    public void setTimer(){

        //mit sleep funktionierts anschinend nid, bruched de timer
        Scanner scanner = new Scanner(System.in);
        System.out.println(("Please type how many seconds the timer should be"));
        String timerstr = scanner.nextLine();
        int timerint = Integer.parseInt(timerstr);
        timer = timerint;

        System.out.println("You set your timer to: " + timerint);
        System.out.println("Timer started");

        timerclass.schedule(new hello(),timerint*1000);


    }

    class hello extends TimerTask{
        public void run(){
            System.out.format("Timer Task Finished..!%n");
            timerclass.cancel(); // Terminate the timer thread
        }
    }


    public void startVacuumCleaner(){
        if(inBase && BatteryStatus == 100 ){
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
