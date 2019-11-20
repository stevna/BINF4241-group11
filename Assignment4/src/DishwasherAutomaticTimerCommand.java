public class DishwasherAutomaticTimerCommand implements Command {

    private Dishwasher dishwasher;
    //private type;

    public DishwasherAutomaticTimerCommand(Dishwasher dw){
        dishwasher = dw;
        // type = t;
    }

    @Override
    public void execute() {
        //dishwasher.setTimer(type);
    }


}
