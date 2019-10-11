import java.util.ArrayList;

public class Bishop extends ChessPiece {
    public Bishop(Enum col, Enum field) {
        super();
        color = col.toString();
        pieceName = "Bishop";

        if (color == "white" && field.toString() == "C"){
            initialposition.add(fields.C);
            initialposition.add(0);

        }

        else if (color == "white" && field.toString() == "F"){
            initialposition.add(fields.F);
            initialposition.add(0);

        }

        else if(color == "black" && field.toString() == "C"){
            initialposition.add(fields.C);
            initialposition.add(7);

        }

        else{
            initialposition.add(fields.F);
            initialposition.add(7);

        }

        movements.add(initialposition);



    }
}
