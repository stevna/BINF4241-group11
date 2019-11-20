public class WashingmachineTypeOfWashingCommand implements Command,Runnable {
    private Washingmachine washingmachine;
    private String typeOfWashing;

    public WashingmachineTypeOfWashingCommand(Washingmachine wm, String type){
        washingmachine = wm;
        typeOfWashing = type;
    }


    @Override
    public void execute() {
        washingmachine.setTypeOfWashing(typeOfWashing);
    }

    @Override
    public void run() {
        execute();
    }
}
