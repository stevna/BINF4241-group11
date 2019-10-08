import java.util.ArrayList;

public class Game {
    int numberOfSquares;
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Square> squares = new ArrayList<Square>();

    public Game (int size, String[] names){
        createPlayers(names);
        createSquares(size);
        for(Player player : players) {
            player.setPosition(0);
        }
        System.out.print("Initial state: ");
        getState();
        play();
    }

    private void createPlayers(String[] names){
        for(String element: names){
            Player player = new Player(element);
            players.add(player);
        }
    }

    private void createSquares(int size) {
        numberOfSquares = size;
        ArrayList<Integer> endOfLeader = new ArrayList<Integer>();

        for (int i = 0; i < numberOfSquares; i++) {

            // every square  can be a snake or a leader by chance, we chose 1/6 here
            double doublekindof = Math.random();
            doublekindof = doublekindof * 6 + 1;
            int kindof = (int) doublekindof;


            if (kindof == 1 && i != 0 && i != numberOfSquares - 1 &&!endOfLeader.contains(i)){
                Leader leader = new Leader(numberOfSquares);
                squares.add(leader);
                endOfLeader.add(leader.getEnd());
            }

            else if (kindof == 2 && i != 0 && i != numberOfSquares - 1 && !endOfLeader.contains(i) ) {
                Snake snake = new Snake();
                System.out.println("id" + (snake.getId()+1));
                System.out.println("end" + (snake.getEnd()+1));

                //the end of a snake must not be leader, if this is the case, the snake is going to be a normal square with the appropriate id
                if (squares.get(snake.getEnd()) instanceof Leader || squares.get(snake.getEnd()) instanceof Snake) {
                    /*snake = null;
                    Square square = new Square();
                    squares.add((square));*/
                    snake.setEnd(-1);
                    squares.add(snake);
                }

                else {
                    squares.add(snake);
                }
            }

            else {
                // if it is not a leader and not a snake, it is a normal square
                Square square = new Square();
                squares.add(square);
            }
        }


/*
// following loops were needed to check that no leader begins at the end of the snake and vice verca
        for (Square squareL : squares) {
            if (squareL instanceof Leader) {
                if(endOfSnake.contains(squareL.getId())) {

                    System.out.println("There is a leader at the end of a snake on square " + (squareL.getId()+1));
                }


                //break;
            }}

        for (Square squareS : squares) {
            if (squareS instanceof Snake) {
                if(endOfLeader.contains(squareS.getId())) {

                    System.out.println("There is a snake on the end of a leader on square " + (squareS.getId()+1));

                }
               }
            }

*/


    }



    public Square findSquare(int id){
        return squares.get(id);
    }
    public void play(){
        boolean win = false; //false
        while(!win) {
            for(Player player: players) {
                move(player);
                if(squares.get(numberOfSquares-1).checkoccupied()) {
                    win = true;
                    System.out.printf("%-15s", "Final State: ");
                    getState();
                    System.out.println(player.name+" wins!");
                    break;
                }
            }
        }
    }

    public void move(Player player){
        int dice = Dice.calculate();
        String action = new String(player.name+" rolls "+dice+": ");
        System.out.printf("%-15s", action);
        getState();

        Square actualPosition = findSquare(player.getPosition());

        int destinationNr = actualPosition.getId()+dice;
        if (destinationNr > numberOfSquares-1){
            int dif = numberOfSquares-1-actualPosition.getId();
            destinationNr = numberOfSquares-1-(dice-dif);
        }

        Square destination = findSquare(destinationNr);

        player.removeFromSquare(actualPosition);


        //only move there if unoccupied and check if the square is a leader or a snake. if so, enter the new end
        if(!destination.checkoccupied()) {
            if(destination instanceof Leader) {
                if(!(findSquare(((Leader) destination).getEnd())).checkoccupied()) {
                    player.enterSquare(findSquare(((Leader) destination).getEnd()));
                }
                else{
                    player.enterSquare(findSquare(0));
                }
            }
            else if (destination instanceof Snake && ((Snake) destination).getEnd() !=-1){
                if(!(findSquare(((Snake) destination).getEnd()).checkoccupied())) {
                    player.enterSquare(findSquare(((Snake) destination).getEnd()));
                }
                else{
                    player.enterSquare(findSquare(0));
                }
            }
            else {
                player.enterSquare(destination);
            }
        }
        else {
            player.enterSquare(findSquare(0));
        }

    }


    public void getState(){
        for(Square e: squares) {
            int nr = e.getId()+1;
            if(e.checkoccupied() || e.getId()==0) {
                System.out.print("["+nr);
                for(Player player : players) {
                    if(player.getPosition() == e.getId()) {
                        System.out.print("<"+player.name+">");
                    }
                }
                System.out.print("]");
            }
            else if(e instanceof Leader) {
                System.out.print("[" + nr + "->" + (((Leader) e).getEnd()+1) + "]");
            }
            else if(e instanceof Snake && ((Snake) e).getEnd() != -1) {
                System.out.print("[" + (((Snake) e).getEnd()+1) + "<-" + nr + "]");
            }
            else if(e.isFirstSquare()) {
                System.out.print("["+nr+"]");
            }
            else {
                System.out.print("["+nr+"]");
            }
        }
        System.out.println();
    }
}
