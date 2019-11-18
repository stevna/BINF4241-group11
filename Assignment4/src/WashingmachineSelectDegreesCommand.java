import java.util.Scanner;
public class WashingmachineSelectDegreesCommand implements Runnable {
    private Washingmachine washingmachine;

    public WashingmachineSelectDegreesCommand(Washingmachine wm){
        washingmachine = wm;
    }

    @Override
    public void run() {
        System.out.print("Select degrees: ");
        Scanner scanner = new Scanner(System.in);
        String deg = scanner.nextLine();
        washingmachine.selectDegrees(Integer.parseInt(deg));
    }
}
