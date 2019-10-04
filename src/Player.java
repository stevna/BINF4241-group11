public class Player {
    public String name;
    private int id = 0;
    private int position = 0;
    private static int numberOfPlayeres = 0;

    public Player(String playerName){
        name = playerName;
        id = numberOfPlayeres++;
    }


    public void setName(String given_name){
        name = given_name;

    }

    public String getName(){
        return name;
    }


    public void setId(){

    }

    public int getId(){
        return id;


    }


    public int getPosition(){
        return position;
    }


    public int move(int dicenumber){
        position = position + dicenumber;
        return position;

    }


    public static void main(String[] args){




    }
}
