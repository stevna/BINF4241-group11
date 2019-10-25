public class Player {
    public String name;
    private int id;
    private int position;
    private static int countPlayers = 0;

    public Player(String playerName) {
        name = playerName;
        id = countPlayers;
        setPosition(0);
        countPlayers++; //increase id for each created player
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
}
