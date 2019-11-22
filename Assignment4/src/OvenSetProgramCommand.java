public class OvenSetProgramCommand implements Command {

    Oven oven;

    public OvenSetProgramCommand(Oven oven) {
        this.oven = oven;

    }
    public void execute(){
        oven.setProgram();

    }
}
