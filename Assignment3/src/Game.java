import java.util.ArrayList;
import java.util.Scanner;

public class Game implements Subject, IteratorCreator {

    private ArrayList<ChessPiece> pieces = new ArrayList<>();
    private Player[] players = new Player[2];
    private boolean gameOver = false;
    private Board board;
    private ArrayList<Observer> observers = new ArrayList<>();
    private Scoreboard scoreboard;

    enum Color {black, white}
    enum letters {A, B, C, D, E, F, G, H}

    private Iterator pieceIterator;
    private Iterator playerIterator;

    public Game(String[] names) {
        placeInitial();
        initializePlayers(names);

        System.out.println("\nInitial State:");
        scoreboard = Scoreboard.getInstance();
        registerObserver(scoreboard);

        getState();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int observerIndex = observers.indexOf(observer);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver(int pos, int score) {
        for(Observer observer : observers) {
            observer.update(pos, score);
        }
    }


    // shows the actual state of the game
    public void getState() {
        for (int y = 7; y >= 0; y--) {
            System.out.print((y+1)+" ");
            for (int x=0;x<8;x++) {
                System.out.print("[");
                boolean printed = false;
                // ------------------------------- ITERATOR -------------------------------
                pieceIterator = createPieceIterator();
                while (pieceIterator.hasNext()) {
                    ChessPiece piece = (ChessPiece) pieceIterator.next();
                    if (piece.getXcord() == x && piece.getYcord() == y) {
                        System.out.print(piece.getShortName());
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
        System.out.print("  ");
        for(Enum e: letters.values()) {
            System.out.print(" "+e+"  ");
        }
        System.out.println();
    }

    // This method creates for each color the chess pieces with it's initial coordinates
    private void placeInitial() {

        board = Board.getInstance();

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
        players[0] = player1;
        Player player2 = new Player(names[1]);
        players[1] = player2;
    }

    // This method starts the game and is used to get the inputs of the users
    public void play(){

        // While the King is not dead
        while(!gameOver) {

            // ------------------------------- ITERATOR -------------------------------
            // For each player
            playerIterator = createPlayerIterator();
            while (playerIterator.hasNext()) {
                Player p = (Player)playerIterator.next();
                boolean successfulMove = false;
                System.out.println("\nPlayer: "+p.getName() + ", score:" + scoreboard.getScore(p.getId()));

                //Verify if the King is in Check
                check(p);

                // While the player hasn't move any piece
                while(!successfulMove) {
                    int cnt = 0;
                    Scanner userinput = new Scanner(System.in);  // Create a Scanner object
                    System.out.print("Enter " +p.getColor()+" move: ");
                    String inp = userinput.nextLine();

                    String[] input = inp.split("");
                    ChessPiece selectedPiece = null;
                    String destination = null;

                    if(inp.equals("quit")) {
                        System.exit(0);
                    }
                    else if(inp.toLowerCase().equals("o-o")) {
                        ChessPiece rook;
                        if(p.getColor().equals("white")) {
                            selectedPiece = whoIsThere(4,0);
                            rook = whoIsThere(7,0);
                            if(selectedPiece.getShortName().equals("WK") && rook.getShortName().equals("WT")) {
                                if(selectedPiece.isFirst_move() && rook.isFirst_move()) {
                                    selectedPiece.setCord(7, 0);
                                    rook.setCord(4, 0);
                                    successfulMove = true;
                                }
                            }
                        }
                        else if (p.getColor().equals("black")) {
                            selectedPiece = whoIsThere(4,7);
                            rook = whoIsThere(7,7);
                            if(selectedPiece.getShortName().equals("BK") && rook.getShortName().equals("BT")) {
                                if(selectedPiece.isFirst_move() && rook.isFirst_move()) {
                                    selectedPiece.setCord(7, 7);
                                    rook.setCord(4, 7);
                                    successfulMove = true;
                                }
                            }
                        }
                    }

                    else if(inp.toString().toLowerCase().equals("o-o-o")) {
                        ChessPiece rook;
                        if(p.getColor().equals("white")) {
                            selectedPiece = whoIsThere(4,0);
                            rook = whoIsThere(0,0);
                            if(selectedPiece.getShortName().equals("WK") && rook.getShortName().equals("WT")) {
                                if(selectedPiece.isFirst_move() && rook.isFirst_move()) {
                                    selectedPiece.setCord(0, 0);
                                    rook.setCord(4, 0);
                                    successfulMove = true;
                                }
                            }
                        }
                        else if (p.getColor().equals("black")) {
                            selectedPiece = whoIsThere(4,7);
                            rook = whoIsThere(0,7);
                            if(selectedPiece.getShortName().equals("BK") && rook.getShortName().equals("BT")) {
                                if(selectedPiece.isFirst_move() && rook.isFirst_move()) {
                                    selectedPiece.setCord(0, 7);
                                    rook.setCord(4, 7);
                                    successfulMove = true;
                                }
                            }
                        }
                    }

                    else if(input.length==2 && checkInput(input[0],input[1])) {
                        // ------------------------------- ITERATOR -------------------------------
                        pieceIterator = createPieceIterator();
                        // Move a pawn (example A3)
                        while (pieceIterator.hasNext()){
                            ChessPiece piece = (ChessPiece)pieceIterator.next();
                            if(piece instanceof Pawn && piece.getColor().equals(p.getColor()) && piece.moveValidation(board, letterToInteger(input[0]),Integer.parseInt(input[1])-1)) {
                                selectedPiece = piece;
                            }
                        }
                        destination = input[0]+input[1];
                        if(selectedPiece!=null && move(p, selectedPiece, destination)) {
                            successfulMove = true;
                        }
                    }
                    else if (input.length==3) {
                        //Capture a piece with a pawn (example dxe)
                        if(input[1].equals("x") && checkInputP(input[0],input[2])) {
                            int y;
                            // ------------------------------- ITERATOR -------------------------------
                            pieceIterator = createPieceIterator();
                            while (pieceIterator.hasNext()){
                                ChessPiece piece = (ChessPiece)pieceIterator.next();
                                if (p.getColor().equals("white")) {
                                    y = piece.getYcord()+1;
                                }
                                else {
                                    y = piece.getYcord()-1;
                                }
                                if(piece instanceof Pawn && piece.getColor()==p.getColor()
                                        && piece.captureValidation(board, letterToInteger(input[2]),y)
                                        && letterToInteger(input[0]) == piece.getXcord()) {
                                    if(board.isOccupied(letterToInteger(input[2]),y)){
                                        selectedPiece = piece;
                                        destination = input[2]+(y+1);
                                        break;
                                    }
                                }
                            }
                            if(selectedPiece!=null && capture(p, selectedPiece, destination)) {
                                successfulMove = true;
                            }
                        }

                        // Move a piece (example Na3)
                        else if(checkInput(input[1],input[2])) {
                            // ------------------------------- ITERATOR -------------------------------
                            pieceIterator = createPieceIterator();
                            while (pieceIterator.hasNext()){
                                ChessPiece piece = (ChessPiece)pieceIterator.next();
                                if(piece.getShortName().split("")[1].equals(input[0].toUpperCase()) && piece.getColor().equals(p.getColor())
                                        && piece.moveValidation(board, letterToInteger(input[1]),Integer.parseInt(input[2])-1)) {
                                    selectedPiece = piece;
                                    cnt++;
                                }
                            }
                            destination = input[1]+input[2];
                            if(cnt==1 && selectedPiece!=null && move(p, selectedPiece, destination)) {
                                successfulMove = true;
                            }
                        }
                    }
                    else if (input.length==4 && checkInput(input[2],input[3])) {
                        //Capture a piece with another piece (example Txa3)
                        if(input[1].equals("x")) {
                            // ------------------------------- ITERATOR -------------------------------
                            pieceIterator = createPieceIterator();
                            while (pieceIterator.hasNext()){
                                ChessPiece piece = (ChessPiece)pieceIterator.next();
                                if(piece.getShortName().split("")[1].equals(input[0].toUpperCase()) && piece.getColor().equals(p.getColor())
                                        && piece.moveValidation(board, letterToInteger(input[2]),Integer.parseInt(input[3])-1)) {
                                    selectedPiece = piece;
                                    cnt++;
                                }
                            }
                            destination = input[2]+input[3];
                            if(cnt==1 && selectedPiece!=null && capture(p, selectedPiece, destination)) {
                                successfulMove = true;
                            }
                        }
                        else if(input[2].equals("=") && checkInput(input[0],input[1])){
                            destination = input[0]+input[1];
                            if(input[1].equals("1")||input[1].equals("8")) {
                                // ------------------------------- ITERATOR -------------------------------
                                pieceIterator = createPieceIterator();
                                while (pieceIterator.hasNext()){
                                    ChessPiece piece = (ChessPiece)pieceIterator.next();
                                    selectedPiece = piece;
                                    if (piece instanceof Pawn && piece.getColor().equals(p.getColor()) && piece.moveValidation(board, letterToInteger(input[0]), Integer.parseInt(input[1]) - 1)) {
                                        if (move(p, selectedPiece, destination)) {
                                            successfulMove = true;
                                            promotion(p, selectedPiece, input[3]);
                                        }
                                    }
                                    else if (piece instanceof Pawn && piece.getColor().equals(p.getColor()) && piece.captureValidation(board, letterToInteger(input[0]), Integer.parseInt(input[1]) - 1)) {
                                        if (capture(p, selectedPiece, destination)) {
                                            successfulMove = true;
                                            System.out.println("Promotion capture");
                                            promotion(p, selectedPiece, input[3]);
                                        }
                                    }

                                }
                            }
                        }
                    } //---------------------------------------------------------------------------------------------------------------------------------------------
                    else if(input.length==5 && checkInput(input[1],input[2]) && checkInput(input[3],input[4])) {
                        ChessPiece piece = whoIsThere(letterToInteger(input[1]),Integer.parseInt(input[2])-1);
                        if(!(piece instanceof Pawn) && input[0].toUpperCase().equals(piece.getShortName().split("")[1]) && piece.getColor().equals(p.getColor())
                            && piece.moveValidation(board, letterToInteger(input[3]),Integer.parseInt(input[4])-1)) {
                            selectedPiece = piece;
                            destination = input[3]+input[4];
                        }
                        if(selectedPiece!=null && move(p, selectedPiece, destination)) {
                            successfulMove = true;
                        }

                    }
                    else if(input.length==6 && input[1].equals("x") && checkInput(input[2],input[3]) && checkInput(input[4],input[5])) {
                        ChessPiece piece = whoIsThere(letterToInteger(input[2]),Integer.parseInt(input[3])-1);
                        if(!(piece instanceof Pawn) && input[0].toUpperCase().equals(piece.getShortName().split("")[1]) && piece.getColor().equals(p.getColor())
                                && piece.moveValidation(board, letterToInteger(input[4]),Integer.parseInt(input[5])-1)) {
                            selectedPiece = piece;
                            destination = input[4]+input[5];
                        }
                        if(selectedPiece!=null && capture(p, selectedPiece, destination)) {
                            successfulMove = true;
                        }
                    }





                    // if the piece couldn't have been moved
                    if(selectedPiece==null || !successfulMove) {
                        System.out.println("\nInvalid move! Please try again.\n");
                    }
                    if(cnt>1) {
                        System.out.println("Multiple pieces of this type can reach this position.\n");
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
    public boolean move(Player p, ChessPiece src, String dest){
        boolean didMove = false;

        /*if(!checkField(dest)){
            return didMove;
        }*/
        if(src instanceof King && kingSuicide(p,src,dest)) {
            return didMove;
        }

        String[] d = dest.split("");
        int xDest = letterToInteger(d[0].toUpperCase());
        int yDest = Integer.parseInt(d[1])-1;

        ChessPiece pieceOnDestination = whoIsThere(xDest,yDest);

        // if the destination is not occupied
        if(pieceOnDestination==null) {
            // Update the board
            board.leave(src.getXcord(), src.getYcord());
            board.enter(xDest, yDest);

            // Move the piece to the new position
            src.setCord(xDest, yDest);
            didMove = true;

            // if first move then set first move to false
            if(src.isFirst_move()) {
                src.setFirstMoveToFalse();
            }
        }

        // Return if the piece has been moved (true) or not (false)
        return didMove;
    }

    public boolean capture(Player p, ChessPiece src, String dest){
        boolean didMove = false;

        /*if(!checkField(dest)){
            return didMove;
        }*/

        if(src instanceof King && kingSuicide(p,src,dest)) {
            return didMove;
        }

        String[] d = dest.split("");
        int xDest = letterToInteger(d[0].toUpperCase());
        int yDest = Integer.parseInt(d[1])-1;

        ChessPiece pieceOnDestination = whoIsThere(xDest,yDest);

        // if the destination is occupied
        if(pieceOnDestination != null) {

            // if the piece on the destination has not the same colour
            if (!(pieceOnDestination.getColor().equals(p.getColor()))) {

                // Add the piece to eatenPieces
                p.eatPiece(pieceOnDestination);

                // Remove the piece of the enemy
                pieces.remove(pieceOnDestination);

                // Update the board
                board.leave(src.getXcord(), src.getYcord());
                board.enter(xDest, yDest);

                if (pieceOnDestination instanceof Queen) {
                    notifyObserver(p.getId(), 5);
                }
                else {
                    notifyObserver(p.getId(), 1);
                }

                // Move the piece to the new position
                src.setCord(xDest, yDest);
                didMove = true;

                // if first move then set first move to false
                if(src.isFirst_move()) {
                    src.setFirstMoveToFalse();
                }

                // -------------will be removed later--------------
                // If the King of one player dies, the other player wins
                if (pieceOnDestination instanceof King) {
                    gameOver = true;
                    System.out.println("Player: " + p.getName() + " wins!");
                }
            }
        }

        // Return if the piece has been moved (true) or not (false)
        return  didMove;
    }

    // Returns the instance of ChessPiece which is on the field XY
    public ChessPiece whoIsThere(int x, int y) {
        // ------------------------------- ITERATOR -------------------------------
        pieceIterator = createPieceIterator();
        while (pieceIterator.hasNext()) {
            ChessPiece piece = (ChessPiece)pieceIterator.next();
            if(piece.getXcord() == x && piece.getYcord() == y) {
                return piece;
            }
        }
        return null;
    }

    // Converts a letter (A to H) into an integer (0 to 7)
    public int letterToInteger(String l) {
        return letters.valueOf(l.toUpperCase()).ordinal();
    }

    public boolean kingSuicide(Player p, ChessPiece src, String dest) {
        String[] d = dest.split("");
        int xDest = letterToInteger(d[0].toUpperCase());
        int yDest = Integer.parseInt(d[1])-1;
        // ------------------------------- ITERATOR -------------------------------
        pieceIterator = createPieceIterator();
        while (pieceIterator.hasNext()){
            ChessPiece piece = (ChessPiece)pieceIterator.next();
            if(piece instanceof Pawn) {
                if (!piece.getColor().equals(p.getColor()) && piece.captureValidation(board,xDest,yDest)) {
                    return true;
                }
            }
            else {
                if (!piece.getColor().equals(p.getColor()) && piece.moveValidation(board, xDest, yDest)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void check(Player p){
        int indexWhite = 0;
        int indexBlack = 0;
        int index = 0;
        // ------------------------------- ITERATOR -------------------------------
        pieceIterator = createPieceIterator();
        while (pieceIterator.hasNext()){
            ChessPiece piece = (ChessPiece)pieceIterator.next();
            if(piece.getShortName() == "WK"){
                indexWhite = index;
            }
            else if(piece.getShortName() == "BK"){
                indexBlack = index;
            }
            index += 1;

        }

        // ------------------------------- ITERATOR -------------------------------
        pieceIterator = createPieceIterator();
        while (pieceIterator.hasNext()){
            ChessPiece piece = (ChessPiece)pieceIterator.next();

            if(piece instanceof Pawn) {
                if (piece.getColor() == "black"&&!piece.getColor().equals(p.getColor()) && piece.captureValidation(board,pieces.get(indexWhite).getXcord(),pieces.get(indexWhite).getYcord())) {
                    System.out.println("White King is in check!");
                }
                else if(piece.getColor() == "white"&&!piece.getColor().equals(p.getColor()) && piece.captureValidation(board,pieces.get(indexBlack).getXcord(),pieces.get(indexBlack).getYcord())) {
                    System.out.println("Black King is in check!");
                }
            }
            else {
                if (piece.getColor() == "black" && !piece.getColor().equals(p.getColor()) && piece.moveValidation(board,pieces.get(indexWhite).getXcord(),pieces.get(indexWhite).getYcord())) {
                    System.out.println("White King is in check!");
                }
                else if(piece.getColor() == "white" && !piece.getColor().equals(p.getColor()) && piece.moveValidation(board,pieces.get(indexBlack).getXcord(),pieces.get(indexBlack).getYcord())) {
                    System.out.println("Black King is in check!");
                }
            }
        }

    }






    public void promotion(Player p, ChessPiece pawn, String x) {
        int index = pieces.indexOf(pawn);
        if(p.getColor().equals("white")) {
            if(x.toUpperCase().equals("Q")) {
                System.out.println("1");
                Queen q = new Queen(Color.white);
                System.out.println("2");
                q.setCord(pawn.getXcord(),pawn.getYcord());
                System.out.println("3");
                pieces.set(index,q);
                System.out.println("4");
            }
            else if(x.toUpperCase().equals("T")) {
                Rook r = new Rook(Color.white,pawn.getXcord(),pawn.getYcord());
                pieces.set(index,r);
            }
            else if(x.toUpperCase().equals("B")) {
                Bishop b = new Bishop(Color.white,pawn.getXcord(),pawn.getYcord());
                pieces.set(index,b);
            }
            else if(x.toUpperCase().equals("N")) {
                Knight k = new Knight(Color.white,pawn.getXcord(),pawn.getYcord());
                pieces.set(index,k);
            }
        }
        else if(p.getColor().equals("black")) {
            if(x.toUpperCase().equals("Q")) {
                Queen q = new Queen(Color.black);
                q.setCord(pawn.getXcord(),pawn.getYcord());
                pieces.set(index,q);
            }
            else if(x.toUpperCase().equals("T")) {
                Rook r = new Rook(Color.black,pawn.getXcord(),pawn.getYcord());
                pieces.set(index,r);
            }
            else if(x.toUpperCase().equals("B")) {
                Bishop b = new Bishop(Color.black,pawn.getXcord(),pawn.getYcord());
                pieces.set(index,b);
            }
            else if(x.toUpperCase().equals("N")) {
                Knight k = new Knight(Color.black,pawn.getXcord(),pawn.getYcord());
                pieces.set(index,k);
            }
        }
    }

    public boolean checkInput(String xinput, String yinput) {
        try {
            Integer i = Integer.parseInt(yinput);
            letterToInteger(xinput);
        }
        catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    //Check input of the letters when a pawn captures another piece
    public boolean checkInputP(String xinput, String yinput) {
        try {
            letterToInteger(yinput);
            letterToInteger(xinput);
        }
        catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public PieceIterator createPieceIterator() {
        return new PieceIterator(pieces);
    }

    public PlayerIterator createPlayerIterator() {
        return new PlayerIterator(players);
    }

}
