import java.util.ArrayList;

public class King extends ChessPiece {
    private int[] possibleMoves = {0, 1, 1, 1, 1, 0, 1, -1, 0, -1, -1, -1, -1, 0, -1, 1};

    public King(Enum col) {
        super();
        color = col.toString();
        xcord = 4;
        if (color.equals("white")){
            ycord = 0;
            shortName = "WK";
        }
        else if(color.equals("black")){
            ycord = 7;
            shortName = "BK";

        }
    }

    @Override
    public boolean moveValidation(Board board, int xDest, int yDest) {
        for (int i = 0; i < possibleMoves.length; i = i + 2) {
            if (xDest == xcord + possibleMoves[i] && yDest == ycord + possibleMoves[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
