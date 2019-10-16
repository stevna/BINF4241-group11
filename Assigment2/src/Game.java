import java.lang.constant.DynamicConstantDesc;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    ArrayList<ChessPiece> pieces = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    private boolean gameOver = false;
    //different enums for initialization to know where to initialise which piece
    enum Color {black, white}
    enum letters {A, B, C, D, E, F, G, H};
    enum fields {
        A1, A2, A3, A4, A5, A6, A7, A8,
        B1, B2, B3, B4, B5, B6, B7, B8,
        C1, C2, C3, C4, C5, C6, C7, C8,
        D1, D2, D3, D4, D5, D6, D7, D8,
        E1, E2, E3, E4, E5, E6, E7, E8,
        F1, F2, F3, F4, F5, F6, F7, F8,
        G1, G2, G3, G4, G5, G6, G7, G8,
        H1, H2, H3, H4, H5, H6, H7, H8,
    }

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
                boolean printed = false;
                for (ChessPiece p : pieces) {
                    if (p.getXcord() == x && p.getYcord() == y) {
                        System.out.print(p.getShortName());
                        printed = true;
                    }
                }
                if(!printed) {
                    System.out.print("  ");
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
                System.out.println("\nPlayer: "+p.getName());
                while(!successfulMove) {
                    Scanner piece = new Scanner(System.in);  // Create a Scanner object
                    System.out.print("Enter the position of the piece which you wanna move: ");
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

    public boolean move(Player p, String src, String dest){
        boolean didMove = false;

        //System.out.println("Move "+source+" to "+destination);
        String[] s = src.split("");
        int xSource = letterToInteger(s[0]);
        int ySource = Integer.parseInt(s[1])-1;
        ChessPiece piece = whoIsThere(xSource,ySource);

        String[] d = dest.split("");
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
        return letters.valueOf(l).ordinal();
    }
    public boolean isSomethingBetween(ChessPiece p, int xDest, int yDest) {
        if(p instanceof Rook){
            if(p.getXcord()==xDest) {
                if(p.getYcord()<yDest) {
                    for(int i=p.getYcord()+1;p.getYcord()+1<=yDest;i++) {
                        if(whoIsThere(xDest,i)!=null) {
                            return true;
                        }
                    }
                }
                else {
                    for(int i=p.getYcord()-1;p.getYcord()-1>=yDest;i--) {
                        if(whoIsThere(xDest,i)!=null) {
                            return true;
                        }
                    }
                }
            }
            else if (p.getYcord()==yDest) {

            }
        }
        return false;
    }

}


