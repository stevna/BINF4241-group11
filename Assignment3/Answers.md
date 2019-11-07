
# Assignment 3
If the images are not viewable we also uploaded a pdf file (Answers.pdf).
## Part 1
### Singleton

1. We implemented the Singleton-Pattern in the “Board” class and the “Scoreboard” class (which we implemented in Part 3), 
because it should have only one instance of each of them during the running program. 
Furthermore, the implementation of this pattern provides a global point of access the instance of both classes. 
Therefore, we don’t have to give the instance of the board to the pieces.

2. Class diagrams:
![Board](./img/singleton_classdiagram_board.JPG)
![Scoreboard](./img/singleton_classdiagram_scoreboard.JPG)

3. Sequence diagrams:
![Board](./img/singleton_sequencediagram_board.JPG)
![Scoreboard](./img/singleton_sequencediagram_scoreboard.JPG)

### Iterator

1. We implemented the Iterator-Pattern in the “Game” class to iterate over the chess pieces and the players.
Both are store in a lists with a different underlying presentation. The chess pieces are stored in an arraylist and the players are stored in an array.
The implementation of this pattern allows us consistent access to the elements of both lists.

2. Class diagram:
![Iterator](./img/iterator_classdiagram.JPG)

3. Sequence diagram:
The following sequence diagram shows the procedure where the program iterates through each player and iterates for each player through each piece to find the right piece to move.
![Iterator](./img/iterator_sequencediagram.JPG)

## Part 2
### Make a move
We consolidated all pieces in ChessPiece to get a clear overview. In our sequence diagrams we only considered the classes which interact with the board class.
After the actor has entered his move the Game class calls the validation of the specific piece which can reach the entered position. During the validation the piece checks the occupation of the board. Afterwards when the piece is being moved the occupation of the board is being updated.
![Iterator](./img/sequencediagram_makeamove.JPG)

### Castling
After the actor has entered the castling command the Game class calls the validation of the specific rook which can reach the position of the king. During the validation the rook checks the occupation of the board. When the castling is executed the occupation of the board is being updated.
![Iterator](./img/sequencediagram_castling.JPG)

## Part 3
### Observer: Scorecard
The following class diagram shows how we implemented the Scorecard with the Obeserver-Pattern.
![Iterator](./img/observer_classdiagram_scoreboard.JPG)








