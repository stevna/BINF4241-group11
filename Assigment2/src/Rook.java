public class Rook extends ChessPiece{

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
