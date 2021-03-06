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

    @Override
    public boolean captureValidation(Board board, int xDest, int yDest) {

        // white pawns
        if (color.equals("white")) {
            // Checks if the field diagonal on the right side or on the left side is occupied
            //if (board.isOccupied(xDest,yDest)) {
                if((xDest - xcord == 1 && yDest - ycord == 1) || (xcord - xDest == 1 && yDest - ycord == 1))
                return true;
            //}
        }

        // black pawns
        else if (color.equals("black")) {
            // Checks if the field diagonal on the right side or on the left side is occupied
            //if (board.isOccupied(xDest,yDest)) {
                if((xcord - xDest == 1 && ycord - yDest == 1) || (xDest - xcord == 1 && ycord - yDest == 1))
                return true;
            //}
        }
        // if the pawn can't reach the enemy
        return false;
    }

    @Override
    public boolean moveValidation(Board board, int xDest, int yDest) {

        //  move validation for white pawns
        if (color.equals("white")) {
            // checks if the pawn can move two fields forward
            if (xDest - xcord == 0 && yDest - ycord == 2 && isFirst_move()
                    && !board.isOccupied(xDest,yDest) && !board.isOccupied(xDest,yDest-1)) {
                return true;
            }

            // checks if the pawn can move one field forward
            else if (xDest - xcord == 0 && yDest - ycord == 1 && !board.isOccupied(xDest, yDest)) {
                return true;
            }
        }

        // move validations for black pawns
        else if (color.equals("black")){
            // checks if the pawn can move two fields forward
            if (xcord - xDest == 0 && ycord - yDest == 2 && isFirst_move()
                    && !board.isOccupied(xDest,yDest) && !board.isOccupied(xDest,yDest+1)) {
                return true;
            }

            // checks if the pawn can move one field forward
            else if (xcord - xDest == 0 && ycord - yDest == 1 && !board.isOccupied(xDest, yDest)) {
                return true;
            }
        }
        // if the pawn can't reach the field
        return false;
    }
}
