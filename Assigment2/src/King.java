
public class King extends ChessPiece {
    // list with tuples of all possible lengths of the movements of the king
    // first number of a tuple represents the x coordinate and the second the y coordinate
    // example: {0, 1} means move zero fields in the x direction and one field in the y direction
    private int[][] possibleMoves = { {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1} };

    // set the variables for the king
    public King(Enum col) {
        super();
        color = col.toString();
        xcord = 4;

        // white king
        if (color.equals("white")){
            ycord = 0;
            shortName = "WK";
        }

        // black king
        else if(color.equals("black")){
            ycord = 7;
            shortName = "BK";

        }
    }

    // validates if the desired destination is reachable with the possible movements form the list "possibleMoves"
    @Override
    public boolean moveValidation(Board board, int xDest, int yDest) {
        for (int i = 0; i < possibleMoves.length; i++) {
            if (xDest == xcord + possibleMoves[i][0] && yDest == ycord + possibleMoves[i][1]) {
                return true;
            }
        }
        return false;
    }

}
