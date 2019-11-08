public class Scoreboard implements Observer {
    private int[] score;
    private static Scoreboard scoreboard;

    private Scoreboard() {
        score = new int[2];
    }

    public static Scoreboard getInstance() {
        if (scoreboard == null) {
            scoreboard = new Scoreboard();
        }
        return scoreboard;
    }

    @Override
    public void update(int pos, int s) {
        score[pos] += s;
    }

    public int getScore(int pos) {
        return score[pos];
    }
}
