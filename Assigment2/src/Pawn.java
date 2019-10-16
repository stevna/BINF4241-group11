import java.util.ArrayList;

public class Pawn extends ChessPiece {
    //ArrayList<Object> initialposition = new ArrayList<>();
    public Pawn(Enum col, int x) {
        super();
        color = col.toString();
        xcord = x;

        if (color == "white") {
            ycord = 1;
            shortName = "WP";
        }
        else if (color == "black") {
            ycord = 6;
            shortName = "BP";
        }
    }
}
