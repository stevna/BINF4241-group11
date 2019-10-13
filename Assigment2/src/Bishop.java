import java.util.ArrayList;

public class Bishop extends ChessPiece {
    public Bishop(Enum col, Enum field) {
        super();
        color = col.toString();
        pieceName = "Bishop";

        if (color == "white" && field.toString() == "C"){
            initialposition.add(fields.C);
            initialposition.add(1);
            shortName = "WB";

        }

        else if (color == "white" && field.toString() == "F"){
            initialposition.add(fields.F);
            initialposition.add(1);
            shortName = "WB";

        }

        else if(color == "black" && field.toString() == "C"){
            initialposition.add(fields.C);
            initialposition.add(8);
            shortName = "BB";

        }

        else{
            initialposition.add(fields.F);
            initialposition.add(8);
            shortName = "BB";
        }

        movements.add(initialposition);

    }
}
