public class WashingmachineSelectDegreesCommand implements Command {
    private Washingmachine washingmachine;
    private int degree;

    public WashingmachineSelectDegreesCommand(Washingmachine wm, int deg){
        washingmachine = wm;
        degree = deg;
    }

    public void execute() {
        washingmachine.selectDegrees(degree);
    }
}
