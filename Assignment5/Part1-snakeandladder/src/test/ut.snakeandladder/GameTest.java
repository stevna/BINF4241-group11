package test.ut.snakeandladder;

import main.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;

public class GameTest {
    private static Game game;
    private static ArrayList<Square> squares;


    @BeforeClass
    public static void setUp() {
        String[] names = {"Blossom", "Bubbles", "Buttercup"};
        game = new Game(100, names);
        squares = new ArrayList<Square>();
        squares = game.getSquares();
    }


    @Test
    public void testBoardSize(){
        int cnt = squares.size();
        Assert.assertEquals("Wrong number of squares.",cnt,100);
    }

    @Test
    public void testFirstLast(){
        Square s1 = squares.get(0);
        Assert.assertFalse("First square is a leader.", s1 instanceof Leader);

        Square s2 = game.getSquares().get(99);
        Assert.assertFalse("Last square is a snake.", s2 instanceof Snake);
    }

    @Test
    public void testLadderDirection() {
        for(Square square: squares) {
            if(square instanceof Leader) {
                Assert.assertTrue("Ladder is a snake.",square.getId()<((Leader) square).getEnd());
            }
            else if (square instanceof Snake) {
                Assert.assertTrue("Snake is a ladder.",square.getId()>((Snake) square).getEnd());
            }
        }
    }

    @Test
    public void testSequenceOfLadders(){
        for(Square square: squares) {
            if(square instanceof Leader) {
                Assert.assertFalse("End of ladder is ladder.",squares.get(((Leader) square).getEnd()) instanceof Leader);
                Assert.assertFalse("End of ladder is snake",squares.get(((Leader) square).getEnd()) instanceof Snake);
            }
        }
    }

    @Test
    public void testSequenceOfSnakes(){
        for(Square square: squares) {
            if(square instanceof Snake && ((Snake) square).getEnd()!=-1) {
                Assert.assertFalse("End of snake is snake.",squares.get(((Snake) square).getEnd()) instanceof Snake);
                Assert.assertFalse("End of snake is ladder.",squares.get(((Snake) square).getEnd()) instanceof Leader);
            }
        }
    }

    @Test
    public void testMove() {
        boolean win = false; //false
        while (!win) {
            for (Player player : game.getPlayers()) {
                int pPosition = player.getPosition();
                game.move(player);
                int position;
                if (pPosition + game.getLastDice() > 99) {
                    position = 99 - (pPosition + game.getLastDice() - 99);
                } else {
                    position = pPosition + game.getLastDice();
                }
                int dice = game.getLastDice();
                if (game.findSquare(position) instanceof Leader && player.getPosition() != 0) {
                    Assert.assertEquals("Wrong leader move.", player.getPosition(), position + ((Leader) game.findSquare(position)).getLength());
                } else if (game.findSquare(position) instanceof Snake && ((Snake) game.findSquare(position)).getEnd() != -1 && player.getPosition() != 0) {
                    Assert.assertEquals("Wrong snake move.", player.getPosition(), position - ((Snake) game.findSquare(position)).getLength());
                } else if (player.getPosition() != 0) {
                    Assert.assertEquals("Wrong square move.", player.getPosition(), position);
                }
                if (squares.get(game.getSquares().size() - 1).checkoccupied()) {
                    win = true;
                }
            }
        }
    }
}
