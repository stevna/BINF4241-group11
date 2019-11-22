public class WashingmachineSwitchOnCommand implements Command {
    private Washingmachine washingmachine;

    public WashingmachineSwitchOnCommand(Washingmachine wm){
        washingmachine = wm;
    }

    public void execute() {
        washingmachine.switchOn();
    }
}
