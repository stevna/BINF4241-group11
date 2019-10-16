import java.util.ArrayList;

public class King extends ChessPiece {
    //ArrayList<Object> initialposition = new ArrayList<>();

    //array list ide array list, es innere sind positione, es üssere isch di ganz move gschicht
    //denn übergit meh die liste und zeigt eifach immer es letschte element ah

    public King(Enum col) {
        super();
        color = col.toString();
        xcord = 4;
        if (color.equals("white")){
            ycord = 0;
            shortName = "WK";
        }
        else if(color.equals("black")){
            ycord = 7;
            shortName = "BK";

        }
    }
}
