public class Player {
    public String name;
    private int id;
    private int position;
    private static int countPlayers = 0;

    public Player(String playerName) {
        name = playerName;
        id = countPlayers;
        setPosition(0);
        countPlayers++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setPosition(int newPos) {
        position = newPos;
    }

    public int getPosition() {
        return position;
    }

    public void removeFromSquare(Square square) {
        if (!square.isFirstSquare()) {
            square.setunoccupied();
        }
    }

    public void enterSquare(Square square) {
        if (!square.isFirstSquare()) {
            square.setoccupied();
        }
        setPosition(square.getId());
    }

    // chunt möglicherwis ih d'Game Klass, da die als einzigi über all squares und players bscheid weiss
    public int move(int dicenumber){
        position = position + dicenumber;
        return position;
    }
}
