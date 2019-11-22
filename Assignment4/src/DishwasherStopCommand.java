public class DishwasherStopCommand implements Command {

    private Dishwasher dishwasher;

    public DishwasherStopCommand(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;

    }
    public void execute(){
        dishwasher.stop();

    }
}
