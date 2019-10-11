public class Queen extends ChessPiece {

    public Queen(Enum col) {
        super();
        color = col.toString();
        pieceName = "Queen";

        if (color == "white"){
            initialposition.add(fields.D);
            initialposition.add(0);

        }
        else if(color == "black"){
            initialposition.add(fields.D);
            initialposition.add(7);

        }

        movements.add(initialposition);



    }
}
