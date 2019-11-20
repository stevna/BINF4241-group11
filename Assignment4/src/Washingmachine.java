import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Washingmachine extends Device {
    private final int identifier = 4;
    private String name = "Washingmachine";
    private enum eStatus{on, off}
    private enum typesOfWashing{doublerinse, intense, quick, spin};
    private eStatus status = eStatus.off;
    private int degrees = 0;
    private int timer = 0;
    private String typeOfWashing = null;
    private boolean isRunning = false;
    private Thread runningProgram;

    public Washingmachine(){
        func.add("(1) Switch on");
        func.add("(2) Select degrees");
        func.add("(3) Select program");
        func.add("(4) Start program");
        func.add("(5) Turn off");
        func.add("(6) Switch off");
    }


    public void switchOn(){
        if(status == eStatus.on) {
            System.out.println("The washing machine is already switched on.");
        }
        else {
            status = eStatus.on;
            System.out.println("Switched on the washing machine.");
        }
    }

    public void selectDegrees(int deg){
        if(status.equals(eStatus.off)){
            System.out.println("You have to switch on the washing machine first.");
        }
        else {
            degrees = deg;
            //System.out.println("Selected degrees: " + deg);
        }
    }

    public void setTimer(String type) {
        int t = 1000;
        if(type.toLowerCase().equals(typesOfWashing.doublerinse.toString())){
            timer = 40*t;
        }
        else if(type.toLowerCase().equals(typesOfWashing.intense.toString())){
            timer = 60*t;
        }
        else if(type.toLowerCase().equals(typesOfWashing.quick.toString())) {
            timer = 20*t;
        }
        else { //Spin
            timer = 13*t;
        }
        System.out.println("Set timer to "+timer/t+" seconds.");
    }

    public void setTypeOfWashing(String type){
        if(status.equals(eStatus.off)){
            System.out.println("You have to switch on the washing machine first.");
        }
        else {
            for (typesOfWashing t : typesOfWashing.values()) {
                if (type.equals(t.toString())) {
                    typeOfWashing = t.toString();
                    System.out.println("Set type of washing to " + typeOfWashing + ".");
                    setTimer(typeOfWashing);
                }
            }
        }

    }

    public void switchOff() {
        if(status==eStatus.off) {
            System.out.println("The washing machine is already switched off.");
        }
        else if(isRunning) {
            System.out.println("The washing machine is currently running. You can't switch it off.");
        }
        else {
            System.out.println("Switched off the washing machine.");
            status = eStatus.off;
            degrees = 0;
            typeOfWashing = null;
            timer = 0;
        }
    }

    public void turnOff() {
        if(status.equals(eStatus.off)){
            System.out.println("You have to switch on the washing machine first.");
        }
        else {
            degrees = 0;
            timer = 0;
            typeOfWashing = null;
            isRunning = false;
            runningProgram.interrupt();
            runningProgram = null;
         }
    }

    public void startProgram(){
        if(status.equals(eStatus.off)){
            System.out.println("You have to switch on the washing machine first.");
        }
        else if(isRunning) {
            System.out.println("The washing program "+ typeOfWashing +" is already running");
        }
        else if(typeOfWashing==null || degrees==0){
            System.out.println("You have to define the degrees and the washing program first.");
        }
        else {
            try {
                runningProgram = Thread.currentThread();
                System.out.println("Started washing program ("+typeOfWashing+", "+degrees+"°C).");
                isRunning = true;
                Thread.sleep(timer);
                isRunning = false;
                System.out.println("Finished washing program ("+typeOfWashing+", "+degrees+"°C).");
                degrees = 0;
                timer = 0;
                typeOfWashing = null;
                isRunning = false;
            } catch (InterruptedException e) {
                System.err.println("The program has been stopped.");
            }

        }

    }

    public String getName(){
        return name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void getInformation(){
        System.out.println("Washingmachine is currently " + status.toString());

        if (typeOfWashing != null) {
            System.out.println("-> Type of washing: " + typeOfWashing + " (" + timer/1000+" seconds)");
        }

        if (degrees != 0) {
            System.out.println("-> Degrees: " + degrees);
        }

        if (isRunning) {
            System.out.println("Running...");
        }

    }

}
