
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

        if(Math.abs(xcord-xDest)!=Math.abs(ycord-yDest)){
            return false;
        }

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
        return true;
    }
}
