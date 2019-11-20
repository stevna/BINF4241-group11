public class MicrowaveSwitchOffCommand {

    Microwave microwave;

    public MicrowaveSwitchOffCommand(Microwave microwave) {
        this.microwave = microwave;

    }
    public void execute(){
        microwave.switchOff();

    }
}
