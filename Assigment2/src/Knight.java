public class Knight extends ChessPiece {

    public Knight(Enum col, Enum field) {
        super();
        color = col.toString();
        pieceName = "Knight";

        if (color == "white" && field.toString() == "B"){
            initialposition.add(fields.B);
            initialposition.add(1);
            shortName = "WN";

        }

        else if (color == "white" && field.toString() == "G"){
            initialposition.add(fields.G);
            initialposition.add(1);
            shortName = "WN";

        }

        else if(color == "black" && field.toString() == "B"){
            initialposition.add(fields.B);
            initialposition.add(8);
            shortName = "BN";

        }

        else{
            initialposition.add(fields.G);
            initialposition.add(8);
            shortName = "BN";

        }


        movements.add(initialposition);



    }

}
