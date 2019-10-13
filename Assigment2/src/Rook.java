public class Rook extends ChessPiece{

    public Rook(Enum col, Enum field) {
        super();
        color = col.toString();
        pieceName = "Rook";

        if (color == "white" && field.toString() == "A"){
            initialposition.add(fields.A);
            initialposition.add(1);
            shortName = "WT";

        }

        else if (color == "white" && field.toString() == "H"){
            initialposition.add(fields.H);
            initialposition.add(1);
            shortName = "WT";

        }

        else if(color == "black" && field.toString() == "A"){
            initialposition.add(fields.A);
            initialposition.add(8);
            shortName = "BT";

        }

        else{
            initialposition.add(fields.H);
            initialposition.add(8);
            shortName = "BT";
        }

        movements.add(initialposition);

    }

}
