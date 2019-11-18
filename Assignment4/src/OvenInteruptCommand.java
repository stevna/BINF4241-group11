public class OvenInteruptCommand implements Command {

    Oven oven;

    public OvenInteruptCommand(Oven oven) {
        this.oven = oven;

    }
    public void execute(){
        oven.interrupt();

    }
}
