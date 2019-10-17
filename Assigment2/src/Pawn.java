public class Pawn extends ChessPiece {
    private boolean firstMove = true; // to make sure that the pawns can go 2 fields forward in their first move

    // set the variables for the pawn
    public Pawn(Enum col, int x) {
        super();
        color = col.toString();
        xcord = x;

        // set initial xcord and shortName if it is a white pawn
        if (color.equals("white")) {
            ycord = 1;
            shortName = "WP";
        }

        // set initial xcord and shortName if it is a black pawn
        else if (color.equals("black")) {
            ycord = 6;
            shortName = "BP";
        }
    }

    private void setFirstMoveToFalse() {
        firstMove = false;
    }

    private  boolean isFirst_move() {
        return firstMove;
    }

    @Override
    public boolean moveValidation(Board board, int xDest, int yDest) {
        //  move validation for white pawns
        if (color.equals("white")) {
            // checks if the pawn can move two fields forward
            if (xDest - xcord == 0 && yDest - ycord == 2 && isFirst_move()
                    && !board.isOccupied(xDest,yDest) && !board.isOccupied(xDest,yDest-1)) {
                setFirstMoveToFalse(); // firstMove gets false
                return true;
            }

            // checks if the pawn can move one field forward
            else if (xDest - xcord == 0 && yDest - ycord == 1 && !board.isOccupied(xDest, yDest)) {
                return true;
            }

            // Checks if the field diagonal on the right side is occupied
            else if (xDest - xcord == 1 && yDest - ycord == 1 && board.isOccupied(xDest,yDest)) {
                return true;
            }

            // Checks if the field diagonal on the left side is occupied
            else if (xcord - xDest == 1 && yDest - ycord == 1 && board.isOccupied(xDest,yDest)) {
                return true;
            }
        }

        // move validations for black pawns
        else if (color.equals("black")){
            // checks if the pawn can move two fields forward
            if (xcord - xDest == 0 && ycord - yDest == 2 && isFirst_move()
                    && !board.isOccupied(xDest,yDest) && !board.isOccupied(xDest,yDest+1)) {
                setFirstMoveToFalse(); // firstMove gets false
                return true;
            }

            // checks if the pawn can move one field forward
            else if (xcord - xDest == 0 && ycord - yDest == 1 && !board.isOccupied(xDest, yDest)) {
                return true;
            }

            // Checks if the field diagonal on the left side is occupied
            else if (xcord - xDest == 1 && ycord - yDest == 1 && board.isOccupied(xDest,yDest)) {
                return true;
            }

            // Checks if the field diagonal on the right side is occupied
            else if (xDest - xcord == 1 && ycord - yDest == 1 && board.isOccupied(xDest,yDest)) {
                return true;
            }
        }
        return false;
    }
}
