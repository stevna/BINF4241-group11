public class Knight extends ChessPiece {
    private int[] possibleMoves = { -1, 2, -1, -2, 1, 2, 1, -2, -2, 1, -2, -1, 2, 1, 2, -1 };


    public Knight(Enum col, int x, int y) {
        super();
        color = col.toString();
        xcord = x;
        ycord = y;

        if (color.equals("white")){
            shortName = "WN";
        }
        else if(color.equals("black")){
            shortName = "BN";
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
