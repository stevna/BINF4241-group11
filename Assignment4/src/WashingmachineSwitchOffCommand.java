public class WashingmachineSwitchOffCommand implements Command {
    private Washingmachine washingmachine;

    public WashingmachineSwitchOffCommand(Washingmachine wm){
        washingmachine = wm;
    }

    public void execute() {
        washingmachine.switchOff();
    }

}
