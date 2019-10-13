public class Queen extends ChessPiece {

    public Queen(Enum col) {
        super();
        color = col.toString();
        pieceName = "Queen";

        if (color == "white"){
            initialposition.add(fields.D);
            initialposition.add(1);
            shortName = "WQ";

        }
        else if(color == "black"){
            initialposition.add(fields.D);
            initialposition.add(8);
            shortName = "BQ";

        }

        movements.add(initialposition);

    }
}
