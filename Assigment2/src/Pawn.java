import java.util.ArrayList;

public class Pawn extends ChessPiece {
    private int[] possibleMoves = {0, 1, -1, 1, 1, -1};
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

    @Override
    public boolean moveValidation(int xDest, int yDest) {
        for (int i = 0; i < possibleMoves.length; i = i + 2) {
            if (xDest == xcord + possibleMoves[i] && yDest == ycord + possibleMoves[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
