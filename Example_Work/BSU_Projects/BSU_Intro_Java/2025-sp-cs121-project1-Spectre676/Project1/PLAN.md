# PLAN.md P1 MusicHero

# Part 1 : To be done before you start your project

## Program Overview

1. In your own words, explain the purpose of this program in at most
   three sentences.  (What does it do? What input will it need? What
   output does it produce?)

   The purpose of the program is to "download," a collection of songs and be able to search throught the list for specific titles, analyze how large the collection is, find the closest song to specific playtimes. Inputs that will be needed are strings & integers. It should output all the songs in the catalog, number of songs, number of artists, playtime, and other things specified by the function.


2. List each source file (.java) in the project and explain its
   purpose. You don't have to use complete sentences.

   MusicHero.java - Uses Track.java to output all the information listed above in question 1.
   Track.java - Gets all the information on the different music tracks.



# Concept References

Identify the slides (module and slide numbers) that introduce and demonstrate each of the following concepts:
 * sentinel values for loops: Module 4, slides 74-94
 * switch statements: Module 4, slides 44-46
 * correcting text input for case - multiple cases or using String case methods
 * ArrayLists: Module 5, slides 6-21
 * using a class (like Track) - calling the constructor, methods: Module 3, slides 14-25
 * using a Scanner to read keyboard input: Module 2, slides 55-59
 * using a Scanner to read lines from files: Module 5, slides 49-53
 * using a Scanner to break a String into tokens: Module 5, slides 57-61
 * looping through lists - accessing current object: Module 5, slides 23-39


# Activity Connections

* Consider the AdGenerator activity. You had to read in various data
  types, including mixing String and numeric data.  How did you read
  in numeric input without compromising the next input?

   By splicing the data.



* Loops are needed throughout this project for the menu, loading
  playlists, searching for keyterms, and analyizing a playlist. What
  kinds of loops were used in the GameBoard activity? Can the type of
  loop you used in GradeBook be used for all purposes in this project,
  or will you need other types of loops as well?

   "While" & "For" loops will be needed for this project.



* There is a great deal of overlap between this project and the
  GradeBook activity.  The GradeBook activity demonstrated reading a
  file, tokenizing the data, creating objects from the data, and
  populating an ArrayList.  Write a pseudo-code algorithm (e.g. use
  English, not code) that outlines the steps to read a file and
  tokenize the data. (Use your GradeBook activity to help you).

   1. Define the File Path
   2. Initialize a File Reader
   3. Initialize a Tokenize (e.g., Scanner)
   4. Read Data from the File
   5. Process Each Line (Optional)
   6. Tokenize the Line/Content
   7. Store or Process Tokens
   8. Handle Exceptions
   9. Close Resources
 





# Testing Plan

How will you test this program during development to ensure it meets
all requirements? How will you know your program has met all
requirements?

   I created a checklist to go through everything and make sure it is correct.



# Compile and Run Instructions

* From the directory containing all source code (.java) files, what is the command-line command that compiles the program?

javac MusicHero.java


* From the directory containing the compiled class (.class) files, what is the command-line command that runs the program?

java MusicHero


* Provide any additional instructions the user needs beyond the run command to run the program.

In VScode if you do javac MusicHero.java it should do both MusicHero.java and Track.java, in the case that it doesn't also do javac Track.java



# Part 2: To be done after your program is done

## Sources

List all outside sources (with specific links) you used to help you on
this project. You do not need to list slides, the book, or other
class assignments.

N/A



## Reflection

1. Discuss one bug you encountered while programming.  How did you
   find the bug?  What process did you use to fix the bug?  What did
   you learn from this bug that might help you in the future?

   One of the bugs that I encountered was that I accidentally setup the loadCatalog incorrectly, so the .csv files were being read as album, title, artist instead of artist, album, title. I found this out because when running the searchCatalog it wouldn't work and eventually I found that the catalogs were being loaded incorrectly. So I set them to what they should have been and everything was working fine.



2. Provide a two to three paragraph reflection on this project.
   Discuss things like the challenges you had, resources you used,
   strategies you found helpful or not helpful, etc.

      The most difficult part of this project was making sure that each of the individual functions work properly. But I managed to figure everything out so it ran smoothly with no issues. Some of the main issues were making sure that the loadCatalog & the searchCatalog worked properly. And then also the findClosest was also quite annoying to figure out, but it all worked out in the end.
      
      When it came to resources used in order to figure out everything I just used the slides & the textbook to figure it out. It took some adjusting to actually apply everything in the slides and textbook but it wasn't too difficult. Overall it was a fun project to work on and it helped a lot with processing everything we have been going over. 