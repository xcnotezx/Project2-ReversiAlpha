# Project2-ReversiAlpha
Team: ...And his name is John Sinna!!!

🎺🎺🎺


Partners:

John Carolin 810641630 jvcarolin@uga.edu

Sinna Uy 810385861 suy@uga.edu


Instructions using Reversi


To compile, ensure that all of the project class files are in a single directory.
In the bash command prompt, type "$ javac Project2-ReversiAlpha/*.java" Do not use
quotation marks. Also, be sure to replace "Project2-ReversiAlpha" with the name of
whatever directory all of your class files are located in.


To run the program, ensure that you are currently in the directory containing the project
and type the following: "$ java Reversi player1 player2." Replace player1 and player2 with
the types of players you want to play as each player. Your options are "Human", which is
controlled by a human using a keyboard, "RandomComputerPlayer", which is a computer
player that makes random, legal moves, and "IntelligentComputerPlayer", which is a computer
player that makes (somewhat) intelligent moves in the game. These arguments are not case
sensitive. Any improper formatting of input will result in the game presenting an 
error message and exiting.


To play the game as a computer player, follow the instructions on the screen. 


Known errors:



Extra credit:


We have implemented an "Intelligent Computer Player" class. This class determines which
moves to make by assigning values to each location on the board and moving to whatever
legal move has the highest value. In the event of a tie of highest value, the program
randomly determines which of those locations to pick. The values are placed on the grid
as follows:

5	4	4	4	4	4	4	5

4	3	3	3	3	3	3	4

4	3	2	2	2	2	3	4

4	3	2	1	1	2	3	4

4	3	2	1	1	2	3	4

4	3	2	2	2	2	3	4

4	3	3	3	3	3	3	4

5	4	4	4	4	4	4	5
