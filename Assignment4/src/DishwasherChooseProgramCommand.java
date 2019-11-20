public class DishwasherChooseProgramCommand implements Command {
    private String typeOfWashing;
    private Dishwasher dishwasher;

    public DishwasherChooseProgramCommand(Dishwasher dishwasher, String typeOfWashing) {
        this.dishwasher = dishwasher;
        this.typeOfWashing = typeOfWashing;

    }
    public void execute(){
        dishwasher.chooseProgram(typeOfWashing);

    }
}
