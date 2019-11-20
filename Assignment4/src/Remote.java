public class Remote {
    Command slot;
    public Remote(){}

    public void setCommand(Command c){
        slot = c;
    }

    public void pressButton(){
        slot.execute();
    }
}
