public class OvenSetTimerCommand implements Command {

    Oven oven;

    public OvenSetTimerCommand(Oven oven) {
        this.oven = oven;

    }
    public void execute(){
        oven.setTimer();

    }
}
