public class WashingmachineSwitchOnCommand implements Command, Runnable{
    private Washingmachine washingmachine;

    public WashingmachineSwitchOnCommand(Washingmachine wm){
        washingmachine = wm;
    }

    @Override
    public void run() {
        execute();
    }

    @Override
    public void execute() {
        washingmachine.switchOn();
    }
}
