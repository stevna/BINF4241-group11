import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    ArrayList<ChessPiece> pieces = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();
    private boolean gameOver = false;
    Board board;
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

    // shows the actual state of the game
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

    // This method creates for each color the chess pieces with it's initial coordinates
    private void placeInitial() {

        board = new Board();

        // for both color, black and white, do the following
        for (Color color : Color.values()) {
            // Create the King
            King king = new King(color);
            pieces.add(king);
            // Create the Queen
            Queen queen = new Queen(color);
            pieces.add(queen);

            // Create the Pawns
            for (int i=0;i<8;i++) {
                Pawn pawn = new Pawn(color, i);
                pieces.add(pawn);
            }
        }
        // Create the Rooks
        Rook rook1 = new Rook(Color.white, 0,0);
        pieces.add(rook1);
        Rook rook2 = new Rook(Color.white, 7,0);
        pieces.add(rook2);
        Rook rook3 = new Rook(Color.black, 0,7);
        pieces.add(rook3);
        Rook rook4 = new Rook(Color.black, 7,7);
        pieces.add(rook4);

        // Create the Knights
        Knight knight1 = new Knight(Color.white, 1,0);
        pieces.add(knight1);
        Knight knight2 = new Knight(Color.white, 6,0);
        pieces.add(knight2);
        Knight knight3 = new Knight(Color.black, 1,7);
        pieces.add(knight3);
        Knight knight4 = new Knight(Color.black, 6,7);
        pieces.add(knight4);

        // Create the Bishops
        Bishop bishop1 = new Bishop(Color.white, 2,0);
        pieces.add(bishop1);
        Bishop bishop2 = new Bishop(Color.white, 5,0);
        pieces.add(bishop2);
        Bishop bishop3 = new Bishop(Color.black, 2,7);
        pieces.add(bishop3);
        Bishop bishop4 = new Bishop(Color.black, 5,7);
        pieces.add(bishop4);
    }

    // Create an Player class object for each player
    public void initializePlayers(String[] names) {
        Player player1 = new Player(names[0]);
        players.add(player1);
        Player player2 = new Player(names[1]);
        players.add(player2);
    }

    // This method starts the game and is used to get the inputs of the users
    public void play(){

        // While the King is not dead
        while(!gameOver) {

            // For each player
            for (Player p : players) {
                boolean successfulMove = false;
                System.out.println("\nPlayer: "+p.getName());

                // While the player hasn't move any piece
                while(!successfulMove) {

                    // Asks for input of the source and destination of one particular piece
                    Scanner piece = new Scanner(System.in);  // Create a Scanner object
                    System.out.print("Enter the position of the piece which you wanna move: ");
                    String selectedPiece = piece.nextLine();
                    Scanner field = new Scanner(System.in);  // Create a Scanner object
                    System.out.print("Enter the destination: ");
                    String destination = field.nextLine();

                    // Moves the piece if possible
                    if(move(p,selectedPiece, destination)) {
                        successfulMove = true;
                    }

                    // if the piece couldn't have been moved
                    else {
                        System.out.println("\nInvalid move! Please try again.\n");
                    }
                }

                // if one king is dead
                if(gameOver) {
                    break;
                }

                // Print the actual state of the board
                getState();

            }
        }
    }

    // This method is used to move a figure to another position if the games rule allow it
    public boolean move(Player p, String src, String dest){
        boolean didMove = false;
        if(src.length()!=2 || dest.length()!=2) {
            return didMove;
        }
        if(!checkField(src) || !checkField(dest)){
            return didMove;
        }

        // split both inputs
        String[] s = src.split("");
        int xSource = letterToInteger(s[0].toUpperCase());
        int ySource = Integer.parseInt(s[1])-1;
        ChessPiece piece = whoIsThere(xSource,ySource);

        String[] d = dest.split("");
        int xDest = letterToInteger(d[0].toUpperCase());
        int yDest = Integer.parseInt(d[1])-1;

        // move, if source is occupied, moveValidation is True and the piece has the same colour as the player
        if(board.isOccupied(xSource,ySource) && piece.moveValidation(board,xDest,yDest) && piece.getColor().equals(p.getColor())) {
            ChessPiece pieceOnDestination = whoIsThere(xDest,yDest);

            // if the destination is occupied
            if(pieceOnDestination != null) {

                // if the piece on the destination has not the same colour
                if(!(pieceOnDestination.getColor().equals(p.getColor()))) {

                    // Get the instance of the enemy player
                    Player enemy;
                    if(players.get(0) == p) {
                        enemy = players.get(1);
                    }
                    else {
                        enemy = players.get(0);
                    }

                    // Add the piece to eatenPieces of the enemy
                    enemy.eatPiece(pieceOnDestination);

                    // Remove the piece of the enemy
                    pieces.remove(pieceOnDestination);

                    // Move the piece to the new position
                    piece.setCord(xDest,yDest);
                    didMove = true;

                    // Update the board
                    board.leave(xSource,ySource);
                    board.enter(xDest,yDest);


                    // -------------will be removed later--------------
                    // If the King of one player dies, the other player wins
                    if(pieceOnDestination instanceof King) {
                        gameOver = true;
                        System.out.println("Player: " + p.getName() + " wins!");
                    }
                }
            }

            // if the destination is not occupied
            else {
                // Move the piece to the new position
                piece.setCord(xDest,yDest);
                didMove = true;

                // Update the board
                board.leave(xSource,ySource);
                board.enter(xDest,yDest);
            }
        }

        // Return if the piece has been moved (true) or not (false)
        return didMove;
    }

    // Returns the instance of ChessPiece which is on the field XY
    public ChessPiece whoIsThere(int x, int y) {
        for(ChessPiece piece: pieces) {
            if(piece.getXcord() == x && piece.getYcord() == y) {
                return piece;
            }
        }
        return null;
    }

    // Converts a letter (A to H) into an integer (0 to 7)
    public int letterToInteger(String l) {
        return letters.valueOf(l).ordinal();
    }

    // Checks if the input of the user is a valid field
    public boolean checkField(String field){
        for(fields f: fields.values()){
            if(f.toString().equals(field)) {
                return true;
            }
        }
        return false;
    }

}
