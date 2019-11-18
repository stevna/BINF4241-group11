import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Cleaningrobot extends Device {

    private String name = "Cleaningrobot";

    private Timer timerclass = new Timer();

    private int BatteryStatus = 100;
    private int  cleaningCompletion = 5;
    private boolean inBase = true;
    enum eStatus{on, off}
    private eStatus status = eStatus.off;

    enum eloading{yes,no};
    private eloading loading = eloading.yes;



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
        String timer = scanner.nextLine();
        int timerint = Integer.parseInt(timer);

        System.out.println("You set your timer to: " + timerint);
        System.out.println("Timer started");
        /*try{
            Thread.sleep(timerint* 1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }*/

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

    public String getName(){
        return name;
    }



}
