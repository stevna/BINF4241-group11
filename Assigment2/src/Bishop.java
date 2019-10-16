import java.util.ArrayList;

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
}
