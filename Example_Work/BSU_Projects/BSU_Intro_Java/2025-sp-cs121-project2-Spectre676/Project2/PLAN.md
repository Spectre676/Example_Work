# PLAN.md P2 TextBook

# Part 1 : To be done before you start your project

## Program Overview

1. In your own words, explain the purpose of this program in at most
   three sentences.  (What does it do? What input will it need? What
   output does it produce?)


2. List each source file (.java) in the project and explain its
   purpose.  You don't have to use complete sentences.



# Concept References

Identify the slides (module and slide numbers) that introduce and
demonstrate each of the following concepts:

* Encapsulation
* Instance Variables
* Getters/Setters
* ArrayLists
* Interfaces
* Reading files
* Writing files
* Writing vs. appending to files
* Purpose of constructor
* Exception handling
* Aggregation
* Tokenizing Strings/Handling CSV data




# Activity Connections

This project requires writing different classes for specific jobs in
the project and getting them all to interact correctly.  You will also
need to frequently read and write files.

Reflecting on the Task activity and ToDoList activities, answer the following questions:

* Why did you need getters and setters in your classes?  What access
  modifier should be used for instance variables?  What access
  modifier should be used for methods that other classes need to call?



* What is the relationship between Task and ToDoList (using the class
  relationships defined in part 5 of module 6 slides)?



* How did you find specific Tasks in the ToDoList?  How can you find
  specific Posts in the Textbook?



* How were Interfaces used in the activities?  What is the purpose of
  the Interfaces provided in this project?



* In ToDoList, one constructor took a File object. How is this
  constructor similar to the TextBook constructor?  How can the file
  be used to populate the Textbook (think how it was used to populate
  the ToDoList)?



# Testing Plan

How will you test this program during development to ensure it meets
all requirements? How will you know your program has met all
requirements?

Make sure it passes all the tests in PostUnitTester.java and TextBookUnitTester.java



# Compile and Run Instructions

* From the directory containing all source code (.java) files, what is the command-line command that compiles the program?

javac TextBookDriver.java

* From the directory containing the compiled class (.class) files, what is the command-line command that runs the program?

java TextBookDriver


* Provide any additional instructions the user needs beyond the run command to run the program.

If this doesn't compile everything also do javac for Post.java, PostInterface.java, TextBook.java, and TextBookInterface.java



# Part 2: To be done after your program is done

## Sources

List all outside sources (with specific links) you used to help you on
this project.  You do not need to list slides, the book, or other
class assignments.

None



## Reflection

1. Discuss one bug you encountered while programming.  How did you
   find the bug?  What process did you use to fix the bug?  What did
   you learn from this bug that might help you in the future?

   While coding one of the main issues I ran into was that it wasn't properly creating or deleting files. I found this out by running the PostUnitTester & TextBookUnitTester and seeing which tests it had passed and failed. My process to fix the bug was reading through what they log said on those tests and looking through previous class assignments to figure out how to fix it exactly. This bug taught me that it is always goood to check your work as your working on it instead of waiting until you're done coding.



2. Provide a two to three paragraph reflection on this project.
   Discuss things like the challenges you had, resources you used,
   strategies you found helpful or not helpful, etc.
   
   Overall, I found this to be a valuable learning experience and a solid test of the knowledge I’ve gained throughout the course. Most of the resources I relied on were the class slides and previous assignments, which provided a helpful foundation for understanding the material and tackling the tasks. I occasionally referred back to the textbook for clarification or to reinforce concepts that I was unsure about. It was interesting to see how much I’ve learned and retained, and putting it all into practice was both challenging and rewarding.
   
   The most difficult parts were usually when my code didn’t pass the initial set of tests. That’s where I ran into the biggest learning moments—trying to figure out what went wrong, adjusting my code, and then re-running the tests to see if it worked. It took patience and persistence, but that trial-and-error process really helped me understand things more deeply. One key strategy that kept me going through all of it was listening to music, which helped me stay focused. I also made a point not to stop or sleep until I had finished what I started—probably not the healthiest approach, but it definitely kept me motivated and determined to finish strong.

