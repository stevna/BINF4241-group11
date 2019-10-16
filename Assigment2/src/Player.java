import java.util.ArrayList;

public class Player {
    private String name;
    private int id;
    private String color;
    enum Color{black, white};
    private static int numberOfPlayers = 0;
    private ArrayList<ChessPiece> eatenPieces = new ArrayList<>();
    private ArrayList<ChessPiece> ownedpieces = new ArrayList<>();

    // set the players name, id and color
    // first player gets black and second white
    public Player(String inputName) {
        name = inputName;
        id = numberOfPlayers;
        numberOfPlayers++;
        if(id == 0) {
            color = Color.white.toString();
        }
        else {
            color = Color.black.toString();
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

    public void eatPiece(ChessPiece p) {
        eatenPieces.add(p);
    }

    // retrieves the players eaten queen if a one of the player's pawn touches the adversary's edge of the board
    public ChessPiece retrieveQueen() {
        for(ChessPiece piece : eatenPieces) {
            if (piece instanceof Queen) {
                eatenPieces.remove(piece);
                return piece;
            }
        }
        return null;
    }
}
