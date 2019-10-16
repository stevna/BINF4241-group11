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
}
