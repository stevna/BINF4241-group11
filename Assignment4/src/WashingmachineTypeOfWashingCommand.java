public class WashingmachineTypeOfWashingCommand implements Command  {
    private Washingmachine washingmachine;
    private String typeOfWashing;

    public WashingmachineTypeOfWashingCommand(Washingmachine wm, String type){
        washingmachine = wm;
        typeOfWashing = type;
    }

    public void execute() {
        washingmachine.setTypeOfWashing(typeOfWashing);
    }

}
