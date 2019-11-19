public class WashingmachineSwitchOffCommand implements Command, Runnable{
    private Washingmachine washingmachine;

    public WashingmachineSwitchOffCommand(Washingmachine wm){
        washingmachine = wm;
    }

    @Override
    public void execute() {
        washingmachine.switchOff();
    }

    @Override
    public void run() {
        execute();
    }
}
