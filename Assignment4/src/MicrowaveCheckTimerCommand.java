public class MicrowaveCheckTimerCommand {
    Microwave microwave;

    public MicrowaveCheckTimerCommand(Microwave microwave) {
        this.microwave = microwave;

    }
    public void execute(){
        microwave.checkTimer();

    }
}
