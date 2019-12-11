package test.ut.uno;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest {
    private static Player player1;
    private static Player player2;

    @BeforeClass
    public static void setUp() {
        player1 = new Player("Ted");
        player2 = new Player("Fred");
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
    public void testEmptyHandCards() {
        Assert.assertEquals(player1.handCards, null);
        Assert.assertEquals(player2.handCards, null);
    }

    @Test
    public void testGetHandCards() {
        StandardCard standardCard = new StandardCard(Color.Red, 7);
        Wild wild = new Wild();
        player1.handCards.add(standardCard);
        player1.handCards.add(wild);
        ArrayList cards = new Arraylist<Card>();
        cards.add(standardCard);
        cards.add(wild);
        Assert.assertEquals(player1.getHandCards, cards);

    }
}
