public class Rook extends ChessPiece{

    public Rook(Enum col, Enum field) {
        super();
        color = col.toString();
        pieceName = "Rook";

        if (color == "white" && field.toString() == "A"){
            initialposition.add(fields.A);
            initialposition.add(0);

        }

        else if (color == "white" && field.toString() == "H"){
            initialposition.add(fields.H);
            initialposition.add(0);

        }

        else if(color == "black" && field.toString() == "A"){
            initialposition.add(fields.A);
            initialposition.add(7);

        }

        else{
            initialposition.add(fields.H);
            initialposition.add(7);

        }


        movements.add(initialposition);



    }

}
