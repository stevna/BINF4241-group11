package test.ut.uno;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SkipTest {
    enum Color{black,yellow,red,blue,green}
    private Skip skip;
    private Game game;
    String[] players = {"Bubbles", "Thomas", "Spongebob", "Thanos" };

    @BeforeClass
    public void setUp() {
        game = new Game(players);
        skip = new Skip();
    }

    /**
     * Checks the functionality of the Skip card
     */
    @Test
    public void testSkip() {
        skip.performExecute();
        Assert.assertTrue("Failed to skip player 2", game.getCurrentPlayer().getID() == 2);

    }
}
