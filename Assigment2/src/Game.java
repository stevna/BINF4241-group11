import java.lang.reflect.Field;
import java.util.ArrayList;

public class Game {

    ArrayList<ChessPiece> pieces = new ArrayList<>();
    //different enums for initialization to know where to initialise which piece
    enum Color {
        black, white
    }

    enum Fields {A, B, C, D, E, F, G, H};

    public Game() {
        placeInitial();
        getState();

        System.out.println(Fields.valueOf("C").ordinal());
    }

    public void getState() {
        for (int y = 7; y >= 0; y--) {
            for (int x=0;x<8;x++) {
                System.out.print("[");
                for (ChessPiece p : pieces) {
                    if (p.getXcord() == x && p.getYcord() == y) {
                        System.out.print(p.getShortName());
                    }
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }

    private void placeInitial() {

        //for both color, black and white, do the following
        for (Color color : Color.values()) {
            King king = new King(color);
            pieces.add(king);
            Queen queen = new Queen(color);
            pieces.add(queen);

            //for every enum in FieldPawns create the corresponding Pawns
            for (int i=0;i<8;i++) {
                Pawn pawn = new Pawn(color, i);
                pieces.add(pawn);
            }
        }
        Rook rook1 = new Rook(Color.white, 0,0);
        pieces.add(rook1);
        Rook rook2 = new Rook(Color.white, 7,0);
        pieces.add(rook2);
        Rook rook3 = new Rook(Color.black, 0,7);
        pieces.add(rook3);
        Rook rook4 = new Rook(Color.black, 7,7);
        pieces.add(rook4);

        Knight knight1 = new Knight(Color.white, 1,0);
        pieces.add(knight1);
        Knight knight2 = new Knight(Color.white, 6,0);
        pieces.add(knight2);
        Knight knight3 = new Knight(Color.black, 1,7);
        pieces.add(knight3);
        Knight knight4 = new Knight(Color.black, 6,7);
        pieces.add(knight4);

        Bishop bishop1 = new Bishop(Color.white, 2,0);
        pieces.add(bishop1);
        Bishop bishop2 = new Bishop(Color.white, 5,0);
        pieces.add(bishop2);
        Bishop bishop3 = new Bishop(Color.black, 2,7);
        pieces.add(bishop3);
        Bishop bishop4 = new Bishop(Color.black, 5,7);
        pieces.add(bishop4);
    }
}


