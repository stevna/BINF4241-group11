public class MicrowaveStartBakingCommand {
    Microwave microwave;

    public MicrowaveStartBakingCommand(Microwave microwave) {
        this.microwave = microwave;

    }
    public void execute(){
        microwave.startBaking();

    }
}
