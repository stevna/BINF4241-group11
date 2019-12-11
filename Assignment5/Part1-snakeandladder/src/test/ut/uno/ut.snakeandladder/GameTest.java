
package test.ut.uno.ut.snakeandladder;

import main.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;


/**
 * Class for Testing the game, including different tests for the board, the leaders, the snakes and the move function.
 */
public class GameTest {
    private static Game game;
    private static ArrayList<Square> squares;

    /**
     * Method sets up needed things for testing. A game is created, also a list of squares are extracted and saved from that game.
     */
    @BeforeClass
    public static void setUp() {
        String[] names = {"Blossom", "Bubbles", "Buttercup"};
        game = new Game(100, names);
        squares = new ArrayList<Square>();
        squares = game.getSquares();
    }

    /**
     * This is the testboard size method. We assert, that the size is equal to 100, which is by instantiating the game in the setUp.
     * @author Group 11
     */
    @Test
    public void testBoardSize(){
        int cnt = squares.size();
        Assert.assertEquals("Wrong number of squares.",cnt,100);
    }

    /**
     * Method asserts, that the first square of a game is not allowed to be a leader and the last square of a game is not allowed to be a snake.
     */
    @Test
    public void testFirstLast(){
        Square s1 = squares.get(0);
        Assert.assertFalse("First square is a leader.", s1 instanceof Leader);

        Square s2 = game.getSquares().get(99);
        Assert.assertFalse("Last square is a snake.", s2 instanceof Snake);
    }

    /**
     * Method asserts, that every ladder's endpoint is behind the ladder's startpoint and that a snake's startpoin is behind the snake's endpoint. Thus it is checked that the leadders and snakes are of the correct subclasses.
     */
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

    /**
     * Method asserts, that the end of a leader must not be another ladder or snake. Thus chaining is not possible.
     */
    @Test
    public void testSequenceOfLadders(){
        for(Square square: squares) {
            if(square instanceof Leader) {
                Assert.assertFalse("End of ladder is ladder.",squares.get(((Leader) square).getEnd()) instanceof Leader);
                Assert.assertFalse("End of ladder is snake",squares.get(((Leader) square).getEnd()) instanceof Snake);
            }
        }
    }

    /**
     * Method asserts, that the end of a snake must not be a snake or ladder. Thus chaining is not possible. Only snakes which do not point to -1 are included, since some of the snakes endpoints are set to -1 during the game.
     */
    @Test
    public void testSequenceOfSnakes(){
        for(Square square: squares) {
            if(square instanceof Snake && ((Snake) square).getEnd()!=-1) {
                Assert.assertFalse("End of snake is snake.",squares.get(((Snake) square).getEnd()) instanceof Snake);
                Assert.assertFalse("End of snake is ladder.",squares.get(((Snake) square).getEnd()) instanceof Leader);
            }
        }
    }

    /**
     *Method asserts, that fieds are occupied, after they are set so
     */
    @Test
    public void testSetOccupied(){
        squares.get(game.getSquares().size() - 1).setoccupied();
        Assert.assertTrue("Field is not occupied", squares.get(game.getSquares().size() - 1).checkoccupied());

    }

    /**
     *Method asserts, that fieds are unoccupied, after they are set so
     */
    @Test
    public void testUnSetOccupied(){
        squares.get(game.getSquares().size() - 1).setunoccupied();
        Assert.assertFalse("Field is not unoccupied", squares.get(game.getSquares().size() - 1).checkoccupied());

    }

    /**
     * Assert, that the method getEndOfLeader returns the correct end
     */
    @Test
    public void testGetEnfOfLeader(){
        Leader leader = new Leader(102);
        leader.end = 110;
        Assert.assertTrue("leader get end does not work",leader.getEnd() == 110);

    }

    /**
     * Assert, that the method getLengthofLadder returns the correct length
     */
    @Test
    public void testLengthfOfLeader(){
        Leader leader = new Leader(102);
        leader.end = 110;
        System.out.println(leader.getEnd());
        System.out.println(leader.getId());
        Assert.assertEquals("Length of leader does not work",8,leader.getLength());

    }

    /**
     * Assert, that the method getLengthofSnake returns the correct length
     */
    @Test
    public void testLengthOfSnake(){
        Snake snake= new Snake();
        snake.setEnd(50);
        Assert.assertEquals("Length of snake does not work",50,snake.getLength());

    }

    /**
     * Method asserts, that the move method works correctly. Different cases had to be checked, a very important one was, that if the player threw the dice and he had a larger
     * number than remaining fields of the board, the user went to the last field and then back again. Thus he had to throw the correct amount of dice dots to finish.
     * If that is not the case, three test cases were investigated. Once if the move including a ladder works, one if the move including the snake works and one for the normal move.
     * The test runs through the whole game with the 100 squares for being significant and much more random.
     */
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
