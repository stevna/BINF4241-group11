import java.util.ArrayList;

public class King extends ChessPiece {
    //ArrayList<Object> initialposition = new ArrayList<>();

    //array list ide array list, es innere sind positione, es üssere isch di ganz move gschicht
    //denn übergit meh die liste und zeigt eifach immer es letschte element ah

    public King(Enum col) {
        super();

        color = col.toString();
        pieceName = "King";

        if (color == "white"){
            initialposition.add(fields.E);
            initialposition.add(1);
            shortName = "WK";

        }
        else if(color == "black"){
            initialposition.add(fields.E);
            initialposition.add(8);
            shortName = "BK";

        }
        movements.add(initialposition);
    }
}
