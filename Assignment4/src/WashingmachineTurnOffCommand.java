public class WashingmachineTurnOffCommand implements Command, Runnable{
    private Washingmachine washingmachine;

    public WashingmachineTurnOffCommand(Washingmachine wm){
        washingmachine = wm;
    }

    @Override
    public void execute() {
        washingmachine.turnOff();
    }

    @Override
    public void run() {
        execute();
    }
}
