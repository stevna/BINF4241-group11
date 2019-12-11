package test.ut.uno;

import org.junit.BeforeClass;
import org.junit.Test;

public class DeckTest {
    private static Deck d;

    @BeforeClass
    public static void setUp() {
        d = new Deck();

    }

    @Test
    public void testDrawCard() {
        Card card = new Card(Color.Blue, 7);
        d.addCardToDeck(card);
        d.drawCard();


    }

    @Test
    public void testGetDeck() {

    }

    @Test
    public void testShuffle() {

    }

    @Test
    public void testAddCardToDeck() {

    }

    @Test
    public void testRemoveCardOfDeck() {

    }


}
