import java.util.Scanner;

public class Washingmachine extends Device {
    private final int identifier = 4;
    String name = "Washingmachine";
    enum eStatus{on, off}
    enum typesOfWashing{DoubleRinse, Intense, Quick, Spin};
    private eStatus status = eStatus.off;
    private int degrees = 0;
    private int timer = 0;
    private String typeOfWashing = null;
    private boolean isRunning = false;
    Thread runningProgram;

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
            System.out.println("You have to switch on the  washing machine first.");
        }
        else {
            degrees = deg;
            System.out.println("Selected degrees: " + deg);
        }
    }

    public void setTimer(String type) {
        int t = 1000;
        if(type.equals(typesOfWashing.DoubleRinse.toString())){
            timer = 20*t;
        }
        if(type.equals(typesOfWashing.Intense.toString())){
            timer = 30*t;
        }
        if(type.equals(typesOfWashing.Quick.toString())) {
            timer = 10*t;
        }
        else { //Spin
            timer = 7*t;
        }
        System.out.println("Set timer to "+timer/t+" seconds.");
    }

    public void setTypeOfWashing(String type){
        if(status.equals(eStatus.off)){
            System.out.println("You have to switch on the  washing machine first.");
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
            runningProgram = null;
        }
    }

    public void startProgram(){
        if(status.equals(eStatus.off)){
            System.out.println("You have to switch on the  washing machine first.");
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
                System.out.println("Started washing program ("+typeOfWashing+", "+degrees+"°C)");
                isRunning = true;
                Thread.sleep(timer);
                isRunning = false;
                System.out.println("Finished washing program");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Washingmachine wm = new Washingmachine();
        Thread mt;
        System.out.println("\nWhat do you want to do? (washing machine)");
        System.out.println("1. Switch on");
        System.out.println("2. Select degrees");
        System.out.println("3. Select program");
        System.out.println("4. Start program");
        System.out.println("5. Turn off");
        System.out.println("6. Switch off");
        String command ="";
        do {
            System.out.println("Input: ");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();

            if (command.equals("1")) {
                WashingmachineSwitchOnCommand wmOn = new WashingmachineSwitchOnCommand(wm);
                mt = new Thread(wmOn);
                mt.start();
            }
            else if (command.equals("2")) {
                System.out.print("Select degrees: ");
                Scanner scan = new Scanner(System.in);
                String deg = scan.nextLine();
                WashingmachineSelectDegreesCommand wmsd = new WashingmachineSelectDegreesCommand(wm, Integer.parseInt(deg));
                mt = new Thread(wmsd);
                mt.start();
            }
            else if (command.equals("3")){
                System.out.print("Select Program: ");
                Scanner scans = new Scanner(System.in);
                String type = scans.nextLine();
                WashingmachineTypeOfWashingCommand wmtow = new WashingmachineTypeOfWashingCommand(wm, type);
                mt = new Thread(wmtow);
                mt.start();
            }
            else if (command.equals("4")) {
                WashingmachineStartProgramCommand wmsp = new WashingmachineStartProgramCommand(wm);
                mt = new Thread(wmsp);
                mt.start();
            }
            else if(command.equals("5")) {
                WashingmachineTurnOffCommand wmto = new WashingmachineTurnOffCommand(wm);
                mt = new Thread(wmto);
                mt.start();
            }
            else if(command.equals("6")) {
                WashingmachineSwitchOffCommand wmso = new WashingmachineSwitchOffCommand(wm);
                mt = new Thread(wmso);
                mt.start();
            }
        }while(command!="exit");

    }

    public String getName(){
        return name;
    }

    public int getIdentifier() {
        return identifier;
    }
}
