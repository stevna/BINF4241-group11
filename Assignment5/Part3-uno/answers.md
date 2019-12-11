# Assignment 5
## Part 1 - SnakeandLadder

## Part 2 - TicTacToe
### GameboardTest
As we first ran the GameBoardTest file four tests failed (“markOnBoard()”, “markTwice()”, “getOpenPositions” and “getOpenPositionsAll”).
* “markOnBoard” and “markTwice”:

    The method “mark” returned true if the position was already marked and false if it was empty. But the correct solution is exactly the other way around. To solve the problem, we changed both return statements with each other.
* “getOpenPositions” and “getOpenPositionsAll”:

    To get these to tests passed, we had to make a change on the “getOpenPostions” method. Since the second for loop started with 1 instead of 0 the first column was never considered. To resolve this, we changed the initial value of the integer “col” to 0.
### TicTacToeGameStateTest
After all tests of the GameBoardTest were working, we ran the TicTacToeGameStateTest and seven tests failed (“hasWinColl”, “hasWinRow”, “isOverWin”, “hasWinDiagonal”, “startingPlayerIsX”, “getAvailableStatesLastOne” and “switchPlayer”).
* “hasWinColl”, “hasWinRow” and “isOverWin”:
 
    The method “hasWin” returned false if the player completed a row or a column. That violates the rules of tictactoe, because completing a row or a column is the goal of the game. We just needed to rewrite the return statement to true.
* “hasWinDiagonal”:

    The method “completesDiagonal” had an error in the last return statement. Instead of returning true if one of two possible diagonals was completed, it method return true if you achieved a diagonal looking like a front slash or a formation like a equal to or greater symbol. The second comparison in the first part of the return statement had to be changed (TicTacToeGameState, line 158). Therefore, the row attribute passed to the getMark method changed from 0 to 2.
* “startingPlayerIsX”, “getAvailableStatesLastOne” and “switchPlayer”:

    To pass these tests, we had to make changes in the method “getCurrentPlayer”, because all three tests use this method. Instead of returning the current player, a new player, called randomPlayer, was created and returned. To fix the problem, we deleted the randomPlayer.

## Part 3 - UNO
