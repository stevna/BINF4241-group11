import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    ArrayList<ChessPiece> pieces = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    private boolean gameOver = false;
    //different enums for initialization to know where to initialise which piece
    enum Color {
        black, white
    }

    enum Fields {A, B, C, D, E, F, G, H};

    public Game(String[] names) {
        placeInitial();
        getState();
        initializePlayers(names);
        while(!gameOver) {
            for (Player p : players) {
                System.out.println(p.getName());

                Scanner piece = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Enter Piece: ");
                String selectedPiece = piece.nextLine();
                Scanner field = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Enter Destination: ");
                String destination = field.nextLine();
                move(selectedPiece, destination);

                getState();

            }
        }

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
    public void initializePlayers(String[] names) {
        Player player1 = new Player(names[0]);
        players.add(player1);
        Player player2 = new Player(names[1]);
        players.add(player2);
    }

    public void move(String source, String destination){
        System.out.println("Move "+source+" to "+destination);
        String[] s = source.split("");
        int xSource = letterToInteger(s[0]);
        int ySource = Integer.parseInt(s[1])-1;
        ChessPiece piece = whoIsThere(xSource,ySource);

        //Check if peace belongs to the right player

        String[] d = destination.split("");
        int xDest = letterToInteger(d[0]);
        int yDest = Integer.parseInt(d[1])-1;

        if(piece.movevalidation()) {
            piece.setCord(xDest,yDest);
        }

    }
    public ChessPiece whoIsThere(int x, int y) {
        for(ChessPiece piece: pieces) {
            if(piece.getXcord() == x && piece.getYcord() == y) {
                return piece;
            }
        }
        return null;
    }
    public int letterToInteger(String l) {
        return Fields.valueOf(l).ordinal();
    }
}


