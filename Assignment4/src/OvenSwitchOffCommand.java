public class OvenSwitchOffCommand implements Command{

    Oven oven;

    public OvenSwitchOffCommand(Oven oven) {
        this.oven = oven;

    }
    public void execute(){
        oven.switchOff();

    }
}
