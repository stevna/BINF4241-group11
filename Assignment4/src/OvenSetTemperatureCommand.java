public class OvenSetTemperatureCommand implements Command {

    Oven oven;
    int temp;

    public OvenSetTemperatureCommand(Oven oven, int newt) {
        this.oven = oven;
        temp = newt;
    }

    public void execute(){
        oven.setTemp(temp);

    }

}
