package test.ut.uno;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    enum Color{black,yellow,red,blue}
    int cardValue = 5;
    Card card = new Card(Color.yellow,cardValue);



    @Test
    public void TestGetColor(){
        Assert.assertSame("get Color method is wrong", "yellow ", card.getColor.toString );
    }

    @Test
    public void TestGetValue(){
        Assert.assertSame("get Value method is wrong",5,card.getValue() );


    }
}

