public class DishwasherSwitchOnCommand implements Command {

    private Dishwasher dishwasher;

    public DishwasherSwitchOnCommand(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;

    }
    public void execute(){
        dishwasher.switchOn();

    }
}
