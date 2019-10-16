import java.util.ArrayList;

public class Bishop extends ChessPiece {
    private int[] possibleMoves = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7,
                                    -1, 1, -2, 2, -3, 3, -4, 4, -5, 5, -6, 6, -7, 7,
                                    1, -1, 2, -2, 3, -3, 4, -4, 5, -5, 6, -6, 7, -7,
                                    -1, -1, -2, -2, -3, -3, -4, -4, -5, -5, -6, -6, -7, -7};

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
        /*for (int i = 0; i < possibleMoves.length; i = i + 2) {
            if (xDest == xcord + possibleMoves[i] && yDest == ycord + possibleMoves[i + 1]) {
                return true;
            }
        }
        return false;*/
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
