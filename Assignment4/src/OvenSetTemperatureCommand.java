public class OvenSetTemperatureCommand implements Command {

    Oven oven;

    public OvenSetTemperatureCommand(Oven oven) {
        this.oven = oven;

    }
    public void execute(){
        oven.setTemp();

    }

}
