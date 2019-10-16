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

}
