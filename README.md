# COMP2042_CW_hfyww1
# JAVA Frogger Arcade Game
A template of the original arcade game Frogger was given with the assignment of refactoring and modifying the original code. Given the freedom to edit the visual representation of the game, and adding boundless features, the following code has adjustments to the aesthetics and include game levels and functioning buttons.

## Requirements
Needs JavaFX installed and a compiler, for this project Eclipse was used.

## Packages
There are 

## Modifications
### Visuals
Some of the .png files given did not colour coordinate with the background image .png, to combat this, manual editing of the images were made on paint to create a more aesthetically pleasing game.

### Levels
There are a total of 5 levels in the game, player begins at level 1 and moves up a level when the player has reached an end slot. These levels were created under the main.java. In each of the levels the following adaptations are made:
1. This level remains as is.
2. There is a new fast car added, and one of the bottom logs are removed.
3. Fast cars are made faster, a snake enters the middle row.
4. Another fast car is added , total of 3 fast cars. A turtle is removed from the bottom row.
5. 2 snakes enter the scene

### High score
A .txt file is created when the player plays the game and stores the highest score from previous gameplays in it. This high score is displaye din the top left of the game for the player to now beat.

### Duration of round
The top of the game displays a clock and shows the time in seconds that it took the previous level to complete.

### Refactors
There were some redundant or unnecessary codes and functions in the original given code, for efficiency these areas were removed. The code was cleaned up by organizing the display and ordering the contents of methods. In some long codes, switch case statements were made for simplicity.

## Screenshots of Game
