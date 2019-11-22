public class DishwasherSwitchOffCommand implements Command {
    private Dishwasher dishwasher;

    public DishwasherSwitchOffCommand(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;

    }
    public void execute(){
        dishwasher.switchOff();

    }

}
