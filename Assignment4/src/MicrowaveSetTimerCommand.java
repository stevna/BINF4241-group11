public class MicrowaveSetTimerCommand implements Command {
    Microwave microwave;

    public MicrowaveSetTimerCommand(Microwave microwave) {
        this.microwave = microwave;

    }
    public void execute(){
        microwave.setTimer();

    }
}
