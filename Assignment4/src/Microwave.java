import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Microwave extends Device {
    private final int identifier = 2;
    private Instant end;
    private Instant start;



    public Microwave(){
        func.add("(1) Check timer");
        func.add("(2) Interrupt");
        func.add("(3) Set temperature");
        func.add("(4) Set timer");
        func.add("(5) Start baking");
        func.add("(6) Switch off");
        func.add("(7) Switch on");
    }


    private Timer timerclass = new Timer();
    private String name = "Microwave";

    enum eStatus{on, off}
    private eStatus status = eStatus.off;
    enum eBaking{on,off}
    private eBaking baking = eBaking.off;

    private int temp = 0;
    ArrayList<Integer> timerlist= new ArrayList<>();


    public void checkTimer(){

        //give back last element of the timerlist

        try {

            if(status == eStatus.off){
                System.out.println("You have to turn on the microwave first");
            }

            else if(baking == eBaking.off && !timerlist.isEmpty()) {
                System.out.println("the last timer set was: " + timerlist.get(timerlist.size() - 1));
            }
            else if(baking == eBaking.on && !timerlist.isEmpty()){
                end = Instant.now();
                Duration timeElapsed = Duration.between(start,end);
                long timeelapsedinMilis = timeElapsed.toMillis()/1000;
                int timer = timerlist.get(timerlist.size() - 1)/1000;
                System.out.println(timeElapsed.toMillis()/1000);
                long timerend = timer-timeelapsedinMilis;
                System.out.println("current timer of the microwave: " + timerend) ;

            }

            else{
                System.out.println("You never put a timer, please do that first");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("You never put a timer, please do that first");
        }
        }





    public void interrupt(){
        if(baking == eBaking.on){
            baking = eBaking.off;
            System.out.println("Baking was interrupted");
        }
        else{
            System.out.println("There is no baking to interrupt");
        }
    }

    public void setTemp(){
        if(status == eStatus.on){
            Scanner scanner = new Scanner(System.in);
            System.out.println(("Please type in the tempearture you want"));
            String tempstr = scanner.nextLine();
            int tempint = Integer.parseInt(tempstr);
            temp = tempint;
            System.out.println("Your temperature was set to: " + temp );

        }
        else {
            System.out.println("The microwave has be turned on first");
        }
    }

    public void setTimer(int t) {

        System.out.println("Timer of the microwave started");
        timerlist.add(t);
        try {
            start = Instant.now();
            TimeUnit.SECONDS.sleep(t);

        } catch (InterruptedException e) {
            System.out.println("An error occurred!");
        }

        System.out.format("Timer of the microwave finished");

    }


    public void startBaking(){

        if(status == eStatus.on && temp>0 && timerlist.size()>0 && timerlist.get(timerlist.size() - 1)>0){
            baking = eBaking.on;
            System.out.println("Baking started");
        }
        else{
            System.out.println("Microwave has to be on and a temperature has to be set");
        }
    }

    public void switchOff(){

        if(status == eStatus.on){
            status = eStatus.off;
            System.out.println("Microwave was switched off");
        }
        else {
            System.out.println("You cannot switch off the microwave if you did not start it");
        }

    }

    public void switchOn(){

        if(status == eStatus.off){
            status = eStatus.on;
            System.out.println("Microwave was switched on");
        }
        else {
            System.out.println("You cannot switch on the microwave if it is running");
        }

    }

    public String getName(){
        return name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void getInformation() {
        System.out.println("Microwave is currently " + status.toString());

        if (baking == eBaking.on) {
            System.out.println("Baking...");
        }

    }
}
