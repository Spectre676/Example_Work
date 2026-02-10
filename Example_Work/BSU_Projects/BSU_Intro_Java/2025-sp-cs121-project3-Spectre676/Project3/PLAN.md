# PLAN.md P3 TicTacToe

# Part 1: To be done before you start your project

## Program Overview

1. In your own words, explain the purpose of this program in at most
   three sentences.  (What does it do? What input will it need? What
   output does it produce?)

   The purpose of this program is to create a playable game of Tic Tac Toe and keep track of how many games have been won, losed, or tied. It will need player inputs in the form of button presses to select what square you fill, if you want to check the scoreboard, or if you want to quit the application. And the output that it produces is filled in square, scoreboard, or closing the program.


2. List each source file (.java) in the project and explain its
   purpose.  You don't have to use complete sentences.

   TicTacToe.java - is the base for TicTacToeGame.java

   TicTacToeGame.java - the program that actually runs everything (is the game logic)

   TicTacToeGUI.java - the program that sets everything up (is the visual & utility elemnts)

   TicTacToeTester.java - makes sure the program works as intended



# Concept References

Identify the slides (module and slide numbers) that introduce and
demonstrate each of the following concepts:

* Defining ActionListeners: Module 8, Slides 14-16 & 34
* Attaching ActionListeners: Module 8, Slides 14-16 & 34
* Interfaces: Module 6, Slides 83-88
* Creating an array: Module 7, Slides 3-23
* Creating a 2D array: Module 7, Slides 24-39
* Modifying and accessing an array: Module 7, Slides 14-16 & Slides 19-20
* Modifying and accessing a 2D array: Module 7, Slides 29-35
* GUI Layouts: Module 8, Slides 26-41
* Encapsulation: Module 6, Slides 28-30
* Instance Variables: Module 6, Slides 13-17
* Purpose of constructor: Module 6, Slides 18-21
* Subpanels: Module 8, Slide 32
* JButton: Module 8, Slides 14 & 20
* JLabel: Module 8, Slide 13
* JOptionPane: Module 8, Slide 35
* GUI Best Practices: Module 8, Slides 42-45



# Activity Connections

This project is similar to the LiteBrite activity.  Both require you
to create a GUI, align elements, and react to button presses.

Reflecting on the LiteBrite activity, answer the following questions:

* How did you register an ActionListener on your LiteBrite buttons?
  How will you register an ActionListener on your TicTacToe gameboard
  and what will it need to do?

   Each LitePegButton registers its own ActionListener inside its constructor, which means every button is responsible for handling its own clicks. I'll probably use the same code but add a part that registers whether it is player 1 or player 2 that clicked the button that way it doesn't acidentally fill in a square for the opposite player.

* How did you know which button was clicked in your ActionListener?

   Since each LitePegButton adds a listener that belongs to itself, it knows it was the one clicked. The listener doesn't need to figure out which button was clicked -- it's already scoped to that specific button instance.

* How did you set the text of the Reset button? How will you update
  the text parts of the TicTacToe GUI?

   I set the text of the Reset button using the constructor of the JButton class: JButton resetButton = new JButton("Reset"); The string "Reset" passed into the constructor sets the text label that appears on the button. Depends on which buttons specifically, for the Reset and Scoreboard I'll probably use what was written above and change the text as needed. For like the Xs and Os for the game aspect I'll probably include changing the font, color, and size of the text.

* What did you need to do to reset the LiteBrite board?  What will you
  need to do to reset the TicTacToe board?

   Each button has a reset() method that sets its color back to black. And what the ResetButtonListener does is that it loops thorugh the entire grid of buttons and activates this method which effectively resets the entire board. Most likely the exact same thing but instead of color I'll set the text back to nothing.

# Testing Plan

How will you test this program during development to ensure it meets
all requirements? How will you know your program has met all
requirements?

   Run the TicTacToeTester.java & play it myself


# Compile and Run Instructions

* From the directory containing all source code (.java) files, what is the command-line command that compiles the program?

   javac TicTacToeGUI.java


* From the directory containing the compiled class (.class) files, what is the command-line command that runs the program?

   java TicTacToeGUI

* Provide any additional instructions the user needs beyond the run command to run the program.

   Might also need to do javac for TicTacToeGame.java and TicTacToe.java

   If using TicTacToeTester.java you will also need to do javac & java for it.



# Part 2: To be done after your program is done

## Sources

List all outside sources (with specific links) you used to help you on
this project.  You do not need to list slides, the book, or other
class assignments.

   None, other than slides, the book, and class assignments.



## Reflection

1. Discuss one bug you encountered while programming.  How did you
   find the bug?  What process did you use to fix the bug?  What did
   you learn from this bug that might help you in the future?

   While programming one bug that I encountered was that the Tic Tac Toe board wasn't properly loading. I found this bug when I ran the program myself and the buttons for each of the grid spaces weren't there. My process to fix the bug started with making sure that each part that loads in the grid and buttons was properly done, then making sure the TicTacToeGUI method was written properly. It turns out I just put the resetGame(); aspect of it in the wrong spot and it started working just fine. I learned that you need to make sure that everything is in the right spot for the code to run properly.



2. Provide a two to three paragraph reflection on this project.
   Discuss things like the challenges you had, resources you used,
   strategies you found helpful or not helpful, etc.

   The majority of the resources I used for this project were the class slides, assignments, and the textbook. These materials helped ensure that I was completing the project correctly and understanding the necessary concepts. I did not need to use any outside sources for this project.

   The biggest challenge I encountered was the bug I discussed in the first question. Aside from that, another difficulty was ensuring that the different Java files worked together properly. Overall, the project went quite well and served as a good test of what I’ve learned.



