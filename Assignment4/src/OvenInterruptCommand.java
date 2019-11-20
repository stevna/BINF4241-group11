public class OvenInterruptCommand implements Command {

    Oven oven;

    public OvenInterruptCommand(Oven oven) {
        this.oven = oven;

    }
    public void execute(){
        oven.interrupt();

    }
}
