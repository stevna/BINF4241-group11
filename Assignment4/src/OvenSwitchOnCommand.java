public class OvenSwitchOnCommand implements Command {

    Oven oven;

    public OvenSwitchOnCommand(Oven oven) {
        this.oven = oven;

    }
    public void execute(){
        oven.switchOn();

    }
}
