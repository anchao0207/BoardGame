# BoardGame
  BOARD CLASS
In the Board class, we have add method that will add a horse (of a player) into the spawning position of that player. 
And also check if that position is freed to add or not. If that position is taken by the same player's horse. Adding horse will failed.
If it is taken by other player horse, we will replace that other horse with player horse
We have 3 move method.
move(horse) is a helper method that simply just move a horse by 1 step.
moveInStack is a special case to move the horse which already in the safe stack
move(horse, int) is simply just move with more step. But we will check if they got blocked by other horse or they are able to kick other horse or not.
We also have a checkWin method which check for winner if all of there horse is in the final position, and toString method to create a String visual of the game.
  HORSE CLASS
This class simply represent the player and also horses of that player (by color)
it has getColor, getCol, getRow, and setCoordinate method in order to keep track of whose horse is this (by color) and also their current position
  JeuDesPetitsChevaux CLASS
This is the class that we create to make the game become automatic. 
We also adding a pop up option panel to let the player able to choose the horse that they want to move or number of dice
We also keep track of the turn in this class and rolling the dice method
Moreover, this is a class where we draw the graphic for the game.

