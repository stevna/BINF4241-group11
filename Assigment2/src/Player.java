import java.util.ArrayList;

public class Player {
    private String name;
    private int id;
    private String color;
    private static int numberOfPlayers = 0;
    private ArrayList<ChessPiece> eatenPieces = new ArrayList<>();

    // set the players name, id and color
    // first player gets black and second white
    public Player(String inputName) {
        name = inputName;
        id = numberOfPlayers;
        numberOfPlayers++;
        if(id == 0) {
            color = "white";
        }
        else {
            color = "black";
        }
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    public void addEatenPieces(ChessPiece p) {
        eatenPieces.add(p);
    }
}
