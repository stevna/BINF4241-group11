public class WashingmachineTurnOffCommand implements Command {
    private Washingmachine washingmachine;

    public WashingmachineTurnOffCommand(Washingmachine wm){
        washingmachine = wm;
    }

    public void execute() {
        washingmachine.turnOff();
    }

}
