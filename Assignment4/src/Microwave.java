import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Microwave extends Device implements Runnable {
    private final int identifier = 2;

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


    public void run(){
        try
        {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running");

        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }






    public void checkTimer(){

        //give back last element of the timerlist
        if(baking == eBaking.off) {
            System.out.println("the last timer set was: " + timerlist.get(timerlist.size() - 1));
        }
        else{
            System.out.println("the last timer set was: " + timerlist.get(timerlist.size() - 1));

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
        //aso wenn sie lauft, denn chame tempeartur ihstelle
        if(status == eStatus.on){
            Scanner scanner = new Scanner(System.in);
            System.out.println(("Please type in the tempearture you want"));
            String tempstr = scanner.nextLine();
            int tempint = Integer.parseInt(tempstr);
            temp = tempint;
            System.out.println("Your temperature was set to: " + temp );

        }
        else {
            System.out.println("The microvate has be turned on first");
        }
    }

    public void setTimer() {

        //mit sleep funktionierts anschinend nid, bruched de timer
        Scanner scanner = new Scanner(System.in);
        System.out.println(("Please type how many seconds the timer should be"));
        String timer = scanner.nextLine();
        int timerint = Integer.parseInt(timer);
        timerlist.add(timerint);

        System.out.println("You set your timer to: " + timerint);
        System.out.println("Timer started");

        timerclass.schedule(new hello(),timerint*1000);


    }

    class hello extends TimerTask {
        public void run(){
            System.out.format("Timer Task Finished..!%n");
            timerclass.cancel(); // Terminate the timer thread
        }
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
}
