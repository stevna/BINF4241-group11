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

    }

    //shows the actual state of the game
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
            //Create the King
            King king = new King(color);
            pieces.add(king);
            //Create the Queen
            Queen queen = new Queen(color);
            pieces.add(queen);

            //Create the Pawns
            for (int i=0;i<8;i++) {
                Pawn pawn = new Pawn(color, i);
                pieces.add(pawn);
            }
        }
        //Create the Rooks
        Rook rook1 = new Rook(Color.white, 0,0);
        pieces.add(rook1);
        Rook rook2 = new Rook(Color.white, 7,0);
        pieces.add(rook2);
        Rook rook3 = new Rook(Color.black, 0,7);
        pieces.add(rook3);
        Rook rook4 = new Rook(Color.black, 7,7);
        pieces.add(rook4);

        //Create the Knights
        Knight knight1 = new Knight(Color.white, 1,0);
        pieces.add(knight1);
        Knight knight2 = new Knight(Color.white, 6,0);
        pieces.add(knight2);
        Knight knight3 = new Knight(Color.black, 1,7);
        pieces.add(knight3);
        Knight knight4 = new Knight(Color.black, 6,7);
        pieces.add(knight4);

        //Create the Bishops
        Bishop bishop1 = new Bishop(Color.white, 2,0);
        pieces.add(bishop1);
        Bishop bishop2 = new Bishop(Color.white, 5,0);
        pieces.add(bishop2);
        Bishop bishop3 = new Bishop(Color.black, 2,7);
        pieces.add(bishop3);
        Bishop bishop4 = new Bishop(Color.black, 5,7);
        pieces.add(bishop4);
    }

    //Create the two players
    public void initializePlayers(String[] names) {
        Player player1 = new Player(names[0]);
        players.add(player1);
        Player player2 = new Player(names[1]);
        players.add(player2);
    }

    public void play(){
        while(!gameOver) {
            for (Player p : players) {
                boolean successfulMove = false;
                System.out.println("Player: "+p.getName());
                while(!successfulMove) {
                    Scanner piece = new Scanner(System.in);  // Create a Scanner object
                    System.out.print("Enter the field of the piece which you wanna move: ");
                    String selectedPiece = piece.nextLine();
                    Scanner field = new Scanner(System.in);  // Create a Scanner object
                    System.out.print("Enter the destination: ");
                    String destination = field.nextLine();
                    if(move(p,selectedPiece, destination)) {
                        successfulMove = true;
                    }
                    else {
                        System.out.println("\nInvalid move! Please try again.\n");
                    }
                }
                if(gameOver) {
                    break;
                }
                getState();

            }
        }
    }

    public boolean move(Player p,String source, String destination){
        boolean didMove = false;
        //System.out.println("Move "+source+" to "+destination);
        String[] s = source.split("");
        int xSource = letterToInteger(s[0]);
        int ySource = Integer.parseInt(s[1])-1;
        ChessPiece piece = whoIsThere(xSource,ySource);

        String[] d = destination.split("");
        int xDest = letterToInteger(d[0]);
        int yDest = Integer.parseInt(d[1])-1;


        //move, if moveValidation is True and the piece has the same colour as the player
        if(piece.moveValidation(xDest,yDest) && piece.getColor().equals(p.getColor())) {
            ChessPiece pieceOnDestination = whoIsThere(xDest,yDest);
            if(pieceOnDestination != null) {
                if(!(pieceOnDestination.getColor() == p.getColor())) {
                    Player enemy;
                    if(players.get(0) == p) {
                        enemy = players.get(1);
                    }
                    else {
                        enemy = players.get(0);
                    }
                    enemy.eatPiece(pieceOnDestination);
                    pieces.remove(pieceOnDestination);
                    piece.setCord(xDest,yDest);
                    didMove = true;

                    //-------------will be removed later--------------
                    if(pieceOnDestination instanceof King) {
                        gameOver = true;
                        System.out.println("Player: " + p.getName() + " wins!");
                    }
                }
            }
            else {
                piece.setCord(xDest,yDest);
                didMove = true;
            }
        }
        return didMove;
    }

    //Returns the instance of ChessPiece which is on the field XY
    public ChessPiece whoIsThere(int x, int y) {
        for(ChessPiece piece: pieces) {
            if(piece.getXcord() == x && piece.getYcord() == y) {
                return piece;
            }
        }
        return null;
    }

    //Converts a letter (A to H) into an integer (0 to 7)
    public int letterToInteger(String l) {
        return Fields.valueOf(l).ordinal();
    }

    public void removePiece(ChessPiece p) {
        /*for(int i=0;i<pieces.size();i++) {
            pieces.remove(p);
        }*/
        pieces.remove(p);
    }
    public void addPiece(ChessPiece p) {
        pieces.add(p);
    }
}


