public class MicrowaveSwitchOffCommand implements Command {

    Microwave microwave;

    public MicrowaveSwitchOffCommand(Microwave microwave) {
        this.microwave = microwave;

    }
    public void execute(){
        microwave.switchOff();

    }
}
