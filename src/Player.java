public class Player {
    public String name;
    private int id;
    private int position;
    private static int countPlayers = 0;

    public Player(String playerName) {
        name = playerName;
        setId();
        setPosition(0);
    }

    public String getName() {
        return name;
    }

    public void setId() {
        id = countPlayers;
        countPlayers++;
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

    // chunt zimmli sicher ih d'Game Klass, da die als einzigi über all squares und players bscheid weiss
    public int move(int dicenumber){
        position = position + dicenumber;
        return position;
    }
}
