public class OvenSetTimerCommand implements Command, Runnable {

    Oven oven;
    int time;

    public OvenSetTimerCommand(Oven oven, int newt) {
        this.oven = oven;
        time = newt;
    }

    public void execute(){
        oven.setTimer(time);
    }

    @Override
    public void run() {
        execute();
    }
}
