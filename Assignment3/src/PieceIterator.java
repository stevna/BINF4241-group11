import java.util.ArrayList;

public class PieceIterator implements Iterator{
    ArrayList<ChessPiece> pieces;
    int position;

    public PieceIterator(ArrayList pieces) {
        this.pieces = pieces;
    }

    @Override
    public boolean hasNext() {
        if (position >= pieces.size() || pieces.get(position) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public ChessPiece next() {
        ChessPiece piece = pieces.get(position);
        position++;
        return piece;
    }
}
