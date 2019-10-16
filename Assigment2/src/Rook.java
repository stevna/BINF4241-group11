public class Rook extends ChessPiece{
    private int[] possibleMoves = {1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0,
                                    -1, 0, -2, 0, -3, 0, -4, 0, -5, 0, -6, 0, -7, 0,
                                    0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7,
                                    0, -1, 0, -2, 0, -3, 0, -4, 0, -5, 0, -6, 0, -7};

    public Rook(Enum col, int x, int y) {
        super();
        color = col.toString();
        xcord = x;
        ycord = y;

        if (color == "white") {
            shortName = "WT";
        }
        else {
            shortName = "BT";
        }
    }

    @Override
    public boolean moveValidation(Board board, int xDest, int yDest) {
        /*for (int i = 0; i < possibleMoves.length; i = i + 2) {
            if (xDest == xcord + possibleMoves[i] && yDest == ycord + possibleMoves[i + 1]) {
                return true;
            }
        }
        return false;*/

        if(xcord==xDest) {
            if(ycord<yDest) {
                for(int i=ycord+1;i<yDest;i++) {
                    if(board.isOccupied(xDest,i)) {
                        return false;
                    }
                }
            }
            else {
                for(int i=ycord;i>yDest;i--) {
                    if(board.isOccupied(xDest,i)) {
                        return false;
                    }
                }
            }
        }
        else if (ycord==yDest) {
            if(xcord<xDest) {
                for(int i=xcord+1;i<xDest;i++) {
                    if(board.isOccupied(i,yDest)) {
                        return false;
                    }
                }
            }
            else {
                for(int i=xcord-1;i>xDest;i--) {
                    if(board.isOccupied(i,yDest)) {
                        return false;
                    }
                }
            }
        }
        else{
            return false;
        }
        return true;
    }

}
