public class OvenStartCookingCommand implements Command{

    Oven oven;

    public OvenStartCookingCommand(Oven oven) {
        this.oven = oven;

    }
    public void execute(){
        oven.startCooking();
    }
}
