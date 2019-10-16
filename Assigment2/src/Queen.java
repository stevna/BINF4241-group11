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
    public boolean moveValidation(Board board, int xDest, int yDest) {
        /*for (int i = 0; i < possibleMoves.length; i = i + 2) {
            if (xDest == xcord + possibleMoves[i] && yDest == ycord + possibleMoves[i + 1]) {
                return true;
            }
        }
        return false;*/
        if(Math.abs(xcord-xDest)==Math.abs(ycord-yDest)){
            int xOffset, yOffset;

            if(xcord < xDest){
                xOffset = 1;
            }else{
                xOffset = -1;
            }

            if(ycord < yDest){
                yOffset = 1;
            }else{
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
        else {
            return false;
        }
        return true;
    }
}
