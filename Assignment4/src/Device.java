import java.util.ArrayList;

public abstract class Device {
    private int identifier;
    private String name;
    ArrayList<String> func= new ArrayList<>();

    public String getName(){
        return name;
    }

    public ArrayList getFunc(){return func;}

    public void printFunc(){
        for(String s:func){
            System.out.println(s);
        }
        System.out.println("(-1) go back");
    }

    public void getInformation(){

    }

    public abstract int getIdentifier();

  }
