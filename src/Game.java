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
        squares.get(0).setoccupied();
        getState();
        play();
    }

    //wird nachher wieder gelöscht
    public static void main(String[] args) {
        String[] names = new String[2];
        names[0] = "XXX";
        names[1] = "YYY";
        Game mygame = new Game(16, names);

    }

    private void createPlayers(String[] names){
        for(String element: names){
            Player player = new Player(element);
            players.add(player);
        }

        //Output
        for(Player e: players) {
            System.out.println("Player: "+" " +e.name);
        }
        System.out.println(players.get(0).name);

    }

    private void createSquares(int size){
        numberOfSquares = size;
        for(int i = 0; i<numberOfSquares;i++){

            double doublekindof = Math.random();
            doublekindof = doublekindof *12 + 1;
            int kindof = (int) doublekindof;

            if(kindof == 1){
                Leader leader= new Leader(i,numberOfSquares);
                squares.add(leader);
            }
            /*!!!SNAKE!!!
            if(kindof == 2){
                Snake snake = new Snake(i,numberOfSquares);
                squares.add(snake);
            }*/
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
        boolean win = true; //false
        while(!win) {
            for(Player player: players) {
                player.move(Dice.calculate());
                System.out.print(player.name+": ");
                getState();
                if(squares.get(numberOfSquares-1).checkoccupied()) {
                    win = true;
                    System.out.println(player.name+" wins!");
                    break;
                }
            }
        }
    }

    public void getState(){
        for(Square e: squares) {
            int nr = e.getId()+1;
            if(e.checkoccupied()) {
                System.out.print("["+nr);
                for(Player player : players) {
                    if(player.getPosition() == e.getId()) {
                        System.out.print("<"+player.name+">");
                    }
                }
                System.out.print("]");
            }
            /*else if(e.isleader) {
                System.out.print("["+nr+"->"+e.end+"]");
            }
            else if(e.issnake){
                System.out.print("["+nr+"<-"+e.end+"]");
            }*/
            else if(e.isFirstSquare()) {
                System.out.print("["+nr+"]");
            }
            else {
                System.out.print("["+nr+"]");
            }
        }
    }
}
