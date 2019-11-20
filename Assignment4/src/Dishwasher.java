import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;


public class Dishwasher extends Device{

    String name = "Dishwasher";
    enum eStatus{on, off}
    enum typesOfProgram{glasses, plates, pans, mixed, none};
    private eStatus status = eStatus.off;
    private int timer = 0;
    private String typeOfProgram = null;
    private boolean isRunning = false;
    private final int identifier = 5;
    private Instant end;
    private Instant start;
    Thread runningProgram;


    public Dishwasher(){
        func.add("(1) Switch ON");
        func.add("(2) Start dishwasher");
        func.add("(3) Choose program");
        func.add("(4) Check timer");
        func.add("(5) Stop dishwasher");
        func.add("(6) Switch off");
    }


    public void automaticTimer(String type) {
        int t = 1000;
        if(type.toLowerCase().equals(typesOfProgram.glasses.toString())){
            timer = 40*t;
        }
        else if(type.toLowerCase().equals(typesOfProgram.mixed.toString())){
            timer = 60*t;
        }
        else if(type.toLowerCase().equals(typesOfProgram.pans.toString())) {
            timer = 20*t;
        }
        else if(type.toLowerCase().equals(typesOfProgram.plates.toString())) {
            timer = 13*t;
        }
        System.out.println("Timer is "+timer/t+" seconds.");
    }

    public void checkTimer(){

        if(isRunning){
            end = Instant.now();
            Duration timeElapsed = Duration.between(start,end);
            System.out.println("Remaining time of the program is " + timeElapsed);
        }

        else if(!isRunning && typeOfProgram != null){
            automaticTimer(typeOfProgram);


        }

        else{
            System.out.println("You have to turn Dishwasher on first");
        }

        }



    public void chooseProgram(String type){
        if(status.equals(eStatus.off)){
            System.out.println("You have to switch on the washing machine first.");
        }
        else {
            for (typesOfProgram t : typesOfProgram.values()) {
                if (type.equals(t.toString())) {
                    typeOfProgram = t.toString();
                    System.out.println("Set type of washing to " + typeOfProgram + ".");
                    start = Instant.now();
                    automaticTimer(typeOfProgram);
                }
            }
        }

    }

    public void start(){
        if(status == eStatus.on && typeOfProgram != null){
            try {
                runningProgram = Thread.currentThread();
                System.out.println("Started washing program");
                isRunning = true;
                Thread.sleep(timer);
                isRunning = false;
                System.out.println("Finished washing program");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        else if(status == eStatus.off){
            System.out.println("You have to turn on the dishwasher first");
        }

        else if(status == eStatus.on && typeOfProgram == null){
            System.out.println("Please choose a program first");
        }
    }

    public void stop(){
        if(status.equals(eStatus.off)){
            System.out.println("You have to switch on the dishwasher first.");
           }
        else {
            timer = 0;
            typeOfProgram = null;
            isRunning = false;
            System.out.println("Dishwasher was stopped");
            }
        }


    public void switchOn(){
        if(status == eStatus.on) {
            System.out.println("The dishwasher is already switched on.");
        }
        else {
            status = eStatus.on;
            System.out.println("Switched on the dishwasher.");
        }
    }

    public void switchOff(){

        if(status == eStatus.off) {
            System.out.println("The dishwasher is already switched off.");
        }
        else {
            status = eStatus.on;
            System.out.println("Switched off the dishwasher.");
        }

    }
    public String getName(){
        return name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void getInformation(){
        System.out.println("Dishwasher is currently " + status.toString());

        if (isRunning) {
            System.out.println("Running...");
        }

        if (typeOfProgram != null) {
            System.out.println("-> Type of washing: " + typeOfProgram);
        }
    }
}
