import java.util.ArrayList;

public class Pawn extends ChessPiece {
    //ArrayList<Object> initialposition = new ArrayList<>();
    public Pawn(Enum col, Enum field) {
        super();
        color = col.toString();
        pieceName = "Pawn";

        if (color == "white") {
            initialposition.add(field);
            initialposition.add(2);
            shortName = "WP";


        } else if (color == "black") {
            initialposition.add(field);
            initialposition.add(7);
            shortName = "BP";
        }

        movements.add(initialposition);

    }


}
