public class WashingmachineAutomaticTimerCommand implements Command, Runnable{
    private Washingmachine washingmachine;
    //private type;

    public WashingmachineAutomaticTimerCommand(Washingmachine wm, String t){
        washingmachine = wm;
       // type = t;
    }

    @Override
    public void execute() {
        //washingmachine.setTimer(type);
    }

    @Override
    public void run() {
        execute();
    }
}
