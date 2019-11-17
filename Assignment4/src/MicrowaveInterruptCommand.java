public class MicrowaveInterruptCommand {
    Microwave microwave;

    public MicrowaveInterruptCommand(Microwave microwave) {
        this.microwave = microwave;

    }
    public void execute(){
        microwave.interrupt();

    }
}
