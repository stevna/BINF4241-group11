public class MicrowaveSetTemperatureCommand {

    Microwave microwave;
    int temp;

    public MicrowaveSetTemperatureCommand(Microwave microwave, int newt) {
        this.microwave = microwave;
        temp = newt;

    }
    public void execute(){
        microwave.setTemp(temp);

    }
}
