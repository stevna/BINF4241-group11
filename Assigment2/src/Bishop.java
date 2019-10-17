
public class Bishop extends ChessPiece {

    public Bishop(Enum col, int x, int y) {
        super();
        color = col.toString();
        xcord = x;
        ycord = y;

        if (color == "white"){
            shortName = "WB";
        }
        else{
            shortName = "BB";
        }

    }

    @Override
    public boolean moveValidation(Board board, int xDest, int yDest) {

        // if the bishop can't reach the field
        if(Math.abs(xcord-xDest)!=Math.abs(ycord-yDest)){
            return false;
        }

        int xOffset, yOffset;

        // Find direction to x coordinate of destination
        if(xcord < xDest){
            xOffset = 1;
        }
        else{
            xOffset = -1;
        }

        // Find direction to y coordinate of destination
        if(ycord < yDest){
            yOffset = 1;
        }
        else{
            yOffset = -1;
        }

        int y = ycord + yOffset;

        // Move diagonal
        for(int x = xcord + xOffset; x != xDest; x += xOffset){
            if(board.isOccupied(x,y)){
                return false;
            }
            y += yOffset;
        }
        return true;
    }
}
