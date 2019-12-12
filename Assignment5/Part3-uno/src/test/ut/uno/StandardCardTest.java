package test.ut.uno;

import org.junit.Assert;
import org.junit.Test;

public class StandardCardTest {
    enum Color{black,yellow,red,blue}
    private int cardValue = 5;
    private Card card = new Card(Color.yellow,cardValue);


    /**
     * The method checks the functionality of the color attribute of the StandardCard class
     */
    @Test
    public void testGetColor(){
        Assert.assertSame("get Color method is wrong", "yellow ", card.getColor.toString );
    }

    /**
     * The method checks the functionality of the value attribute of the StandardCard class
     */
    @Test
    public void testGetValue(){
        Assert.assertSame("get Value method is wrong",5,card.getValue() );


    }
}

