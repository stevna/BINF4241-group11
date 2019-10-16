public class Pawn extends ChessPiece {
    //private int[] possibleMovesWhite = {0, 1, -1, 1, 1, -1};
    //private int[] possibleMovesBlack = {0, -1, 1, -1, -1, 1};
    //private int[] possibleFirstMovesWhite = {0, 1, -1, 1, 1, -1, 0, 2};
    //private int[] possibleFirstMovesBlack = {0, -1, 1, -1, -1, 1, 0, -2};
    private boolean first_move = true;


    public Pawn(Enum col, int x) {
        super();
        color = col.toString();
        xcord = x;

        if (color.equals("white")) {
            ycord = 1;
            shortName = "WP";
        }
        else if (color.equals("black")) {
            ycord = 6;
            shortName = "BP";
        }
    }

    private void setFirst_moveToFalse() {
        first_move = false;
    }

    private  boolean isFirst_move() {
        return first_move;
    }

    @Override
    public boolean moveValidation(Board board, int xDest, int yDest) {
        if (color.equals("white")) {
            if (xDest - xcord == 0 && yDest - ycord == 2 && isFirst_move()
                    && !board.isOccupied(xDest,yDest) && !board.isOccupied(xDest,yDest-1)) {
                setFirst_moveToFalse();
                return true;
            }
            else if (xDest - xcord == 0 && yDest - ycord == 1 && !board.isOccupied(xDest, yDest)) {
                return true;
            }
            else if (xDest - xcord == 1 && yDest - ycord == 1 && board.isOccupied(xDest,yDest)) {
                return true;
            }
            else if (xcord - xDest == 1 && yDest - ycord == 1 && board.isOccupied(xDest,yDest)) {
                return true;
            }
        }

        else if (color.equals("black")){
            if (xcord - xDest == 0 && ycord - yDest == 2 && isFirst_move()
                    && !board.isOccupied(xDest,yDest) && !board.isOccupied(xDest,yDest+1)) {
                setFirst_moveToFalse();
                return true;
            }
            else if (xcord - xDest == 0 && ycord - yDest == 1 && !board.isOccupied(xDest, yDest)) {
                return true;
            }
            else if (xcord - xDest == 0 && ycord - yDest == 1 && board.isOccupied(xDest,yDest)) {
                return true;
            }
            else if (xDest - xcord == 1 && ycord - yDest == 1 && board.isOccupied(xDest,yDest)) {
                return true;
            }
        }
        return false;

        /*int[] possibleMoves;
        if(color.equals("white")) {
            if (isFirst_move()) {
                possibleMoves = possibleFirstMovesWhite;
                setFirst_moveToFalse();
            }
            else {
                possibleMoves = possibleMovesWhite;
            }
        }
        else {
            if (isFirst_move()) {
                possibleMoves = possibleFirstMovesBlack;
                setFirst_moveToFalse();
            }
            else {
                possibleMoves = possibleMovesBlack;
            }
        }
        for (int i = 0; i < possibleMoves.length; i = i + 2) {
            if (xDest == xcord + possibleMoves[i] && yDest == ycord + possibleMoves[i + 1]) {
                return true;
            }
        }
        return false;*/
    }
}
