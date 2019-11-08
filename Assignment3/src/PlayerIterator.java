public class PlayerIterator implements Iterator{
    Player[] players;
    int position;

    public PlayerIterator(Player[] players) {
        this.players = players;
    }

    @Override
    public boolean hasNext() {
        if (position >= players.length || players[position] == null) {
            return false;
        }
        return true;
    }

    @Override
    public Player next() {
        Player player = players[position];
        position++;
        return player;
    }
}
