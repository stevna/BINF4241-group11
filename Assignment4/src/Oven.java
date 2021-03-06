import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Oven extends Device {
    private final int identifier = 3;

    public Oven(){
        func.add("(1) Check timer");
        func.add("(2) Interrupt");
        func.add("(3) Set program");
        func.add("(4) Set temperature");
        func.add("(5) Set timer");
        func.add("(6) Start cooking");
        func.add("(7) Switch off");
        func.add("(8) Switch on");
    }
    private String name = "Oven";

    private Instant end;
    private Instant start;
    private int lastTimer;
    private int currentTimer;

    enum eStatus{on, off}
    private eStatus status = eStatus.off;
    enum eCooking{on,off}
    private eCooking cooking = eCooking.off;

    enum eProgram{ventilated, grill, none}
    private eProgram program = eProgram.none;

    private int temp = 0;

    ArrayList<Integer> timerlist= new ArrayList<>();






    public void checkTimer(){

        //give back last element of the timerlist

        if(status == eStatus.off){
            System.out.println("You have to turn on the oven first");
        }
        else if(cooking == eCooking.off) {
            System.out.println("The last timer set was: " + lastTimer);
        }
        else if(cooking == eCooking.on){
            /*
            end = Instant.now();
            Duration timeElapsed = Duration.between(start,end);
            long timeelapsedinMilis = timeElapsed.toMillis()/1000;
            int timer = timerlist.get(timerlist.size() - 1)/1000;
            System.out.println(timeElapsed.toMillis()/1000);
            long timerend = timer-timeelapsedinMilis;
            */
            System.out.println("Current timer of the oven: " + currentTimer) ;

        }
    }

    public void interrupt(){
        if(cooking == eCooking.on){
            cooking = eCooking.off;
            System.out.println("Cooking was interrupted");
        }
        else{
            System.out.println("There is no Cooking to interrupt");
        }
    }


    public void setProgram(){
        if(status == eStatus.on){
            Scanner scanner = new Scanner(System.in);
            System.out.println(("Please type in the Program you want"));
            String programing = scanner.nextLine();

            if(programing.equals("ventilated") ){
                program = eProgram.ventilated;
            }
            else if (programing.equals("grill")){
                program = eProgram.grill;
            }

            else{
                program = eProgram.none;
            }
        }

        else{
            System.out.println("Oven has to be turned on first");
        }

    }


    public void setTemp(int tempint){
        if(status == eStatus.on){
            temp = tempint;
            System.out.println("Your Oven temperature was set to: " + temp );
        }

        else {
            System.out.println("The Oven has be turned on first");
        }
    }

    public void setTimer(int t) {
        lastTimer = t;

        System.out.println("Timer of oven started");
        for (int i = lastTimer; i > 0; i--) {
            currentTimer = i;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("The program has been stopped.");
            }
        }

        System.out.format("Timer of oven is finished");


    }

    public void startCooking(){

        if(status == eStatus.on && temp>0 && timerlist.size()>0 && timerlist.get(timerlist.size() - 1)>0 && program != eProgram.none){
            cooking = eCooking.on;
            System.out.println("Cooking started");
        }
        else{
            System.out.println("Oven has to be on and a temperature and the timer has to be set");
        }
    }



    public void switchOff(){

        if(status == eStatus.on){
            status = eStatus.off;
            System.out.println("Oven was switched off");
        }
        else {
            System.out.println("You cannot switch off the Oven if you did not start it");
        }

    }

    public void switchOn(){

        if(status == eStatus.off){
            status = eStatus.on;
            System.out.println("Oven was switched on");
        }
        else {
            System.out.println("You cannot switch on the Oven if it is running");
        }

    }

    public void getInformation(){
        System.out.println("Device is currently turned " + status.toString());
        if(cooking == eCooking.on){
            System.out.println("Temperature is set to " + temp + " and the programm " + program.toString() + " is chosen");

        }
    }

    public String getName(){
        return name;
    }

    public int getIdentifier() {
        return identifier;
    }
}
