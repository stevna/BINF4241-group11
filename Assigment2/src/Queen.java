public class Queen extends ChessPiece {
    private int[] possibleMoves = {1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0,                // movements rook
                                    -1, 0, -2, 0, -3, 0, -4, 0, -5, 0, -6, 0, -7, 0,        // movements rook
                                    0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7,               // movements rook
                                    0, -1, 0, -2, 0, -3, 0, -4, 0, -5, 0, -6, 0, -7,        // movements rook
                                    1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7,               // movements bishop
                                    -1, 1, -2, 2, -3, 3, -4, 4, -5, 5, -6, 6, -7, 7,        // movements bishop
                                    1, -1, 2, -2, 3, -3, 4, -4, 5, -5, 6, -6, 7, -7,        // movements bishop
                                    -1, -1, -2, -2, -3, -3, -4, -4, -5, -5, -6, -6, -7, -7};// movements bishop

    public Queen(Enum col) {
        super();
        color = col.toString();
        xcord = 3;

        if (color == "white"){
            ycord = 0;
            shortName = "WQ";
        }
        else if(color == "black"){
            ycord = 7;
            shortName = "BQ";
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
