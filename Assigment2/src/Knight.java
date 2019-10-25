public class Knight extends ChessPiece {
    // list with tuples of all possible lengths of the movements of the knight
    // first number of a tuple represents the x coordinate and the second the y coordinate
    // example: {1, 2} means move one field in the x direction and two fields in the y direction
    private int[][] possibleMoves = { {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {2, 1}, {2, -1} };

    // set the variables for the knight
    public Knight(Enum col, int x, int y) {
        super();
        color = col.toString();
        xcord = x;
        ycord = y;

        // white knight
        if (color.equals("white")){
            shortName = "WN";
        }

        // black knight
        else if(color.equals("black")){
            shortName = "BN";
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
