public class Knight extends ChessPiece {

    public Knight(Enum col, Enum field) {
        super();
        color = col.toString();
        pieceName = "Knight";

        if (color == "white" && field.toString() == "B"){
            initialposition.add(fields.B);
            initialposition.add(0);

        }

        else if (color == "white" && field.toString() == "G"){
            initialposition.add(fields.G);
            initialposition.add(0);

        }

        else if(color == "black" && field.toString() == "B"){
            initialposition.add(fields.B);
            initialposition.add(7);

        }

        else{
            initialposition.add(fields.G);
            initialposition.add(7);

        }


        movements.add(initialposition);



    }

}
