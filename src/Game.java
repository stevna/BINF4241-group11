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

    private void createSquares(int size){
        numberOfSquares = size;
        for(int i = 0; i<numberOfSquares;i++){

            double doublekindof = Math.random();
            doublekindof = doublekindof *12 + 1;
            int kindof = (int) doublekindof;

            if(kindof == 1 && i != 0 && i != numberOfSquares-1){
                Leader leader= new Leader(numberOfSquares);
                squares.add(leader);
            }
            else if(kindof == 2 && i != 0 && i != numberOfSquares-1){
                Snake snake= new Snake();
                squares.add(snake);
            }
            else{
                Square square = new Square();
                squares.add(square);
            }
        }
    }
    public Square findSquare(int id){
        return squares.get(id);
    }
    public void play(){
        boolean win = false; //false
        while(!win) {
            for(Player player: players) {
                move(player);
                getState();
                if(squares.get(numberOfSquares-1).checkoccupied()) {
                    win = true;
                    System.out.println(player.name+" wins!");
                    break;
                }
            }
        }
    }

    public void move(Player player){
        int dice = Dice.calculate();
        System.out.print(player.name+" roll "+dice+": ");

        Square actualPosition = findSquare(player.getPosition());

        int destinationNr = actualPosition.getId()+dice;
        if (destinationNr > numberOfSquares-1){
            int dif = numberOfSquares-1-actualPosition.getId();
            destinationNr = numberOfSquares-1-(dice-dif);
        }

        Square destination = findSquare(destinationNr);

        player.removeFromSquare(actualPosition);

        if(!destination.checkoccupied()) {
            if(destination instanceof Leader) {
                //player.setPosition(((Leader) destination).getEnd());
                player.enterSquare(findSquare(((Leader) destination).getEnd()));
            }
            else if (destination instanceof Snake){
                //player.setPosition(((Snake) destination).getEnd());
                player.enterSquare(findSquare(((Snake) destination).getEnd()));
            }
            else {
                //player.setPosition(destination.getId());
                player.enterSquare(destination);
            }
        }
        else {
            //player.setPosition(0);
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
            else if(e instanceof Snake) {
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
