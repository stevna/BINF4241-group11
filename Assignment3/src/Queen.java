public class Queen extends ChessPiece {

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
    public boolean moveValidation(Board board, int xDest, int yDest) {

        //this validation is a mix of the rook and the bishop validation
        if(Math.abs(xcord-xDest)==Math.abs(ycord-yDest)){
            int xOffset, yOffset;

            if(xcord < xDest){
                xOffset = 1;
            }
            else{
                xOffset = -1;
            }

            if(ycord < yDest){
                yOffset = 1;
            }
            else{
                yOffset = -1;
            }

            int y = ycord + yOffset;
            for(int x = xcord + xOffset; x != xDest; x += xOffset){
                if(board.isOccupied(x,y)){
                    return false;
                }
                y += yOffset;
            }
        }
        else if(xcord==xDest) {
            if(ycord<yDest) {
                for(int i=ycord+1;i<yDest;i++) {
                    if(board.isOccupied(xDest,i)) {
                        return false;
                    }
                }
            }
            else {
                for(int i=ycord-1;i>yDest;i--) {
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
        else {
            return false;
        }
        return true;
    }
}
