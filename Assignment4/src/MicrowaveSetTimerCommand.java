public class MicrowaveSetTimerCommand implements Command, Runnable {
    Microwave microwave;
    int time;

    public MicrowaveSetTimerCommand(Microwave microwave, int newT) {
        this.microwave = microwave;
        time = newT;

    }
    public void execute(){
        microwave.setTimer(time);

    }

    @Override
    public void run() {
        execute();
    }
}
