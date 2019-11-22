public class DishWasherStartCommand implements Command,Runnable{
    private Dishwasher dishwasher;

    public DishWasherStartCommand(Dishwasher dw){
        dishwasher = dw;
    }

    @Override
    public void execute() {
        dishwasher.start();
    }

    @Override
    public void run() {
        execute();
    }
}

