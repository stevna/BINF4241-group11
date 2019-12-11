package test.ut.uno;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
    private static Player player1;
    private static Player player2;

    @BeforeClass
    public static void setUp() {
        player1 = new Player();
        player2 = new Player();
    }

    @Test
    public void testNames() {
        Assert.assertEquals("Wrong Name of player1", player1.getName(), "Ted");
        Assert.assertEquals("Wrong Name of player2", player2.getName(), "Fred");
    }

    @Test
    public void testIds() {
        Assert.assertEquals(player1.getID, 0);
        Assert.assertEquals(player2.getID, 1);
    }

    @Test
    public void testPrintHandCards() {

    }

    @Test
    public void test
}
