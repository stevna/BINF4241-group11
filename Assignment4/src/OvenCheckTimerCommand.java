public class OvenCheckTimerCommand implements Command {

    Oven oven;

    public OvenCheckTimerCommand(Oven oven) {
        this.oven = oven;

    }
    public void execute(){
        oven.checkTimer();

    }

}
