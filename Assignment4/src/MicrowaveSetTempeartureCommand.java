public class MicrowaveSetTempeartureCommand {

    Microwave microwave;

    public MicrowaveSetTempeartureCommand(Microwave microwave) {
        this.microwave = microwave;

    }
    public void execute(){
        microwave.setTemp();

    }
}
