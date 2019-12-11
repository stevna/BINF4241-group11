package test.ut.uno;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class DeckTest {
    private static Deck d;

    enum Color{Blue, Yellow, Green, Red, Black}

    @BeforeClass
    public static void setUp() {
        d = new Deck();

    }

    @Test
    public void testDrawCard() {
        StandardCard card = new StandardCard(Color.Blue, 7);
        d.addCardToDeck(card);
        d.drawCard();
        Assert.assertEquals("Could not draw a card.", d.getDeck().length(), 0);
    }

    @Test
    public void testGetDeck() {
        StandardCard card = new StandardCard(Color.Blue, 7);
        d.addCardToDeck(card);
        Assert.assertEquals("Failed to return the deck.", d.getDeck().get(0), card);
    }

    @Test
    public void testShuffle() {
        StandardCard card = new StandardCard(Color.Blue, 7);
        Wild wild = new Wild();
        Deck d1 = new Deck();
        Deck d2 = new Deck();
        d1.addCardToDeck(card);
        d1.addCardToDeck(wild);
        d2.addCardToDeck(card);
        d2.addCardToDeck(wild);
        d1.shuffle();
        Assert.assertNotEquals(d1.getDeck().get(0), d2.getDeck.get(0));

        }
    }

    @Test
    public void testAddCardToDeck() {

    }

    @Test
    public void testRemoveCardOfDeck() {

    }


}
