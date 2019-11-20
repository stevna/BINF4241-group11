public class WashingmachineStartProgramCommand implements Command,Runnable{
    private Washingmachine washingmachine;

    public WashingmachineStartProgramCommand(Washingmachine wm){
        washingmachine = wm;
    }

    @Override
    public void execute() {
        washingmachine.startProgram();
    }

    @Override
    public void run() {
        execute();
    }
}
