import java.util.Scanner;

public class Microwave extends Device implements Runnable {


    private String name = "Microwave";



    enum eStatus{on, off}
    private eStatus status = eStatus.off;
    enum eBaking{on,off}
    private eBaking baking = eBaking.off;

    private int timer = 0;
    private int temp = 0;


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
        System.out.println("the timer is: " + timer);
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

        Scanner scanner = new Scanner(System.in);
        System.out.println(("Please type how many seconds the timer should be"));
        String timer = scanner.nextLine();
        int timerint = Integer.parseInt(timer);

        System.out.println("You set your microwace timer to: " + timerint);
        System.out.println("Timer started");

    }

    public void startBaking(){

        if(status == eStatus.on && temp>0){
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


}
