Assignment 2 - Chess Game

Specifications:
- Our implementation allows you to move and capture according to the chess rules.
- The king can't kill himself by moving to another position.
- Pawns can move two fields in their first move.
- The user gets informed when he is in check.
- It doesn't matter if you insert uppercase or lowercase letters.
- Invalid inputs cause in an error message and the user is forced to enter another valid input.
- At any time in the game you can use "quit" to end the game.

Our implementation of the chess game allows you do to de following tasks:
- Pawn
  - Move: e.g. a3 means to move a pawn to position A3
  - Capture: e.g. axb means to capture a piece located in column b with a pawn in located in column a
- Other Piece
  - Move: e.g. Ta3 means to move a specifif tower to postion A3
          in case two identical pieces can reach the same position you can us Ta1a3 to move the tower located on position A1 to position A3
  - Capture: e.g. Txa5 means to capture an enemy piece located on position A5
          in case two identical pieces can reach the same position you can us Ta1aa to capture with the tower located on position A1 a piece located on position A3
- Castling:
  - o-o for kingside castling
  - o-o-o for queenside castling
- Promotion: e.g. Using B8=Q means to retrieve a Queen at position B8 (only possible if a pawn can reach the postion B8)
