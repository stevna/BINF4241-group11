public class Knight extends ChessPiece {

    public Knight(Enum col, int x, int y) {
        super();
        color = col.toString();
        xcord = x;
        ycord = y;
        if (color.equals("white")){
            shortName = "WN";
        }
        else if(color.equals("black")){
            shortName = "BN";
        }

    }

}
