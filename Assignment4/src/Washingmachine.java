import java.util.Scanner;
public class Washingmachine extends Device {
    enum eStatus{on, off}
    private eStatus status = eStatus.off;
    int degrees;

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
        degrees = deg;
        System.out.println("Selected degrees: "+deg);
    }

    public static void main(String[] args) {
        Washingmachine wm = new Washingmachine();
        Thread mt;
        while(true) {
            System.out.println("\nWhat do you want to do? (washing machine)");
            System.out.println("1. Switch on");
            System.out.println("2. Select degrees");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    WashingmachineSwitchOnCommand wmOn = new WashingmachineSwitchOnCommand(wm);
                    mt = new Thread(wmOn);
                    mt.start();

                case "2":
                    WashingmachineSelectDegreesCommand wmsd = new WashingmachineSelectDegreesCommand(wm,30);
                    mt = new Thread(wmsd);
                    mt.start();
            }
        }

    }
}
