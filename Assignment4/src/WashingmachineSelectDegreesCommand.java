import java.util.Scanner;
public class WashingmachineSelectDegreesCommand implements Command, Runnable {
    private Washingmachine washingmachine;
    private int degree;

    public WashingmachineSelectDegreesCommand(Washingmachine wm, int deg){
        washingmachine = wm;
        degree = deg;
    }

    @Override
    public void run() {
        execute();
    }

    @Override
    public void execute() {
        washingmachine.selectDegrees(degree);
    }
}
