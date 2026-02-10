![CS121 Banner](images/CS121-BANNER.svg)

**NOTE: Before beginning the project, please remember to [open the workspace](images/open-lab-workspace.png) after cloning this repository in VSCode.**
# Project 1: MusicHero

## Purpose & Concepts: 
In this project you will demonstrate the concepts presented up to and including module 5. In particular you will demonstrate your understanding of loops, ArrayLists, File I/O, and using objects.


## Problem Description
Novel Entertainment Systems (NES) is entering a new arena for their entertainment products... Music. NES has been contracted to build a music analytics tool called MusicHero. The customer will provide a music catalog in the form of a plain text file. Each row in the file represents a single song with the following comma separated values (csv): Artist, Album, Title, Duration (in seconds). 

The MusicHero tool will allow the user to open a music catalog file, print stats about the catalog, search for songs in the catalog, find the song closest to a particular play time, and display the entire catalog. 

## Requirements
You will write a driver class (class with a main() method) called MusicHero.java that will use Track.java. The output of your program should exactly match the examples'.  


MusicHero.java will have the following functionality:


### **Selection Menu Loop**
The selection menu loop is the main user interface for the MusicHero project. Each of the successive parts will build out the functionality of the MusicHero tool. When the program starts, it should first display a menu and then enter a while loop to display command prompt like the following:
   ```
   ********************************
   ***       Program Menu       ***
   ********************************
   (L)oad catalog
   (S)earch catalog
   (A)nalyze catalog
   (F)ind song closest to playtime
   (P)rint catalog
   (Q)uit

   Please enter a command (press (M) for Menu): 
   ```

If a user enters an invalid command, simply display an invalid selection message in the console and display the command prompt again:
   ```
   Invalid selection!
   Please enter a command (press M for Menu): 
   ```

The menu should initially be displayed before the program enters the while loop. Only when the user presses 'M' or 'm' should the menu be printed to the console again. When the user presses 'Q' or 'q' the selection loop exits and a goodbye message is displayed before the program quits.
   
   **NOTE: All menu commands should be case insensitive (e.g. 'S' and 's' should both search catalog)**

### **Load Catalog**
Prompt the user for the name of the file containing the catalog to be loaded. Read in the file,  create a Track object for each song listed in the file, and add it to an ArrayList of Track objects called `trackList`. You may assume there are no errors in the catalog files and that each line will contain four comma-separated values (in this order: Artist, Album, Title, Duration).

Each time a new catalog is loaded, it should *replace* (not append to) the trackList. Before loading tracks from the catalog file into the trackList, use the trackList's `clear()` method to remove the current songs from the ArrayList.
   

The program should cleanly handle the situation where a user specifies a filename that does not exist by displaying a message to the user and displaying the selection menu prompt again without modifying the trackList.  If you can't open the file, you should tell the user, like this:

   ```
   Please enter a command (press M for Menu): l
   Load Catalog...
   Please enter filename: wrongFilename.csv
   Unable to open file: wrongFilename.csv
   Please enter a command (press M for Menu): 
   ```

   When the catalog has been successfully loaded, print a message giving how many songs have been successfully loaded. Your output should look like this:
   
   ```
   Please enter a command (press M for Menu): l
   Load Catalog...
   Please enter the filename: collection-jb.csv
   Successfully loaded 23 songs!
   ```

### **Search Catalog**
 The search function will search the **track titles** to see if it contains the search term. The search should be **case insensitive** meaning a search for "cheese" will match tracks that contain "Cheese" such as "Cheeseburger in Paradise" or "Chili Cheese Fries". 
   
   Print the total number of songs that matched the search term and then print every track that matched. The following is an example:

   ```
   Please enter a command (press 'm' for Menu): S
   Search Catalog... 
   Please enter the search query: cheese
   Found 1 matches
   ---------------------------------
   Cheeseburger in Paradise       Jimmy Buffett        Songs You Know by Heart          172

   ```

### **Analyze Catalog**
Display the number of songs, number of unique artists, number of unique albums, and the total playtime of the catalog. The following is an example of the output:
   
   ```
   Please enter a command (press 'm' for Menu): a
   Catalog Analysis...
      Number of Artists: 1
      Number of Albums: 2
      Number of Songs: 23
      Catalog Playtime: 4542
   ```

### **Find the Track Closest to a Playtime**
   Prompt the user for a playtime (in seconds) and display the song or songs with a playtime closest to that time.  For example:
   ```
   Please enter a command (press 'm' for Menu): f
   Closest Track...
   Enter the desired playtime in seconds: 204
   Finding track(s) closest to 204 seconds...
   Found 2 songs
   ---------------------------------
   Fins                           Jimmy Buffett        Songs You Know By Heart          205
   Son of a Son of a Sailor       Jimmy Buffett        Songs You Know By Heart          205
   
   ```

### **Print Catalog**
Print all tracks that are currently loaded in the catalog to the console.  Display the number of tracks in trackList followed by a divider, like this:

```
   Please enter a command (press 'm' for Menu): p
   Print Catalog...
   Song list contains 23 songs...
   ---------------------------------
   Woman Goin' Crazy On Caroli... Jimmy Buffett        Havana Daydreamin'               250
   My Head Hurts My Feet Stink... Jimmy Buffett        Havana Daydreamin'               155
   The Captain and the Kid        Jimmy Buffett        Havana Daydreamin'               198
   Big Rig                        Jimmy Buffett        Havana Daydreamin'               211
   Defying Gravity                Jimmy Buffett        Havana Daydreamin'               163
      ...
   ```

### **Quit**

Print a pleasant goodbye message and exit cleanly! Do not use `System.exit()` to quit the program. When the user chooses "Quit", that should trigger your while loop's exit condition.  **Do not `break` from the while loop and do not use System.exit()**

## Program Structure

### Program Flow
Think about the flow of this program.  When the program starts, it should display the menu (once).  Then it needs to wait for user input.  When the user enters something, it should perform the desired task (or tell the user their input was invalid) and then wait for more input. When the user chooses "Quit", that should trigger your while loop's exit condition.  **Do not `break` from the while loop and do not use System.exit()**

This means that you will need to use a while loop to continually ask the user for input and perform the tasks.  You should use a switch statement to determine what task should be performed based on the user's input.  So what needs to go inside of the loop? What should go in each section of the switch statements?  Where should you define your variables? 

### Variables
Speaking of variables, what variables will you need? You need to ask the user for input, so you'll need a Scanner.  You'll need to read a file, so you'll need a different Scanner for the file.  You'll need to store the Tracks, so you'll need an ArrayList in which to store the Tracks.  You need to store the user's input in several locations, so you'll need variables in which to store the user's reponses. You will likely need other variables as well, but this should get you started thinking.

Coming back to where to define your variables, that depends on how long you'll need to use it (remember this is the variable's scope).  Your variables do need to be defined somewhere inside a method, however.  `MusicHero` is a purely functional driver class.  This means that it should not have any instance variables (even if they're final or static. No instance variables whatsoever). It also should not have any other public methods.  You may use private utility methods if that makes sense to you and you understand how to pass the parameters correctly, but you do not have to (and shouldn't if you don't understand how to properly).

There are two variables that the entire main method will need access to.  You should define these variables at the top of main and outside of your while loop.  The first is an ArrayList to store the Track object. Use the following line of code to create a new trackList of Track objects: `ArrayList<Track> trackList = new ArrayList<Track>();`  The second is the Scanner that gets input from the user.  You should have **exactly one Scanner that is opened on the keyboard**. Opening more than one Scanner on the keyboard causes problems.  Use the same Scanner to get input from the user every time you ask for input from the user.  Remember to close the Scanner after the while loop (if you close it in the while loop, then it'll be closed on the next iteration and will throw an exception).

### Iterating Through the ArrayList
There are several timees throughout this program where you will need to iterate through the ArrayList (Search Catalog, Analyze Catalog, Print Catalog).  The easiest way to iterate through an ArrayList is to use a for loop.  You know exactly how many times you need to go through the list (the size of the ArrayList), which is exactly the use case for a for loop.  Remember that you have a few options for what kind of for loop to use.  Refer back to the slides and choose a for loop appropriately.  (Note: sometimes it doesn't matter which one you use; in those cases, pick your favorite for loop).

## Hints

### Remember Case Insensitive
The menu options and search term used in Search Catalog should be case insensitive. For example, the user should be able to enter "a" OR "A" to choose Analyze Catalog.  In Search Catalog, if the user entered "SkY", it should match titles containing "sky", "SKY", "skY", etc.  Check out the String Javadocs (or the slides) to look for methods that may be useful.

### Use contains()
Both String objects and ArrayLists have a `contains()` method that is extrememly handy for checking whether one string is contained within another.  In Search Catalog, this will be more useful than the equals() method because contains() will find "cheese" in "cheeseburger" while equals() will not.  

In Analyze Catalog, the ArrayList `contains()` is extremely handy for checking whether the ArrayList contains an object that is equal to the specified object. The contains() method walks through the ArrayList and calls the equals() method on each item in the list and checks it against the specified object. It returns true if it finds a match.

### Use toString()
The `Track` class has a `toString` method that you should use whenever you print a `Track` object to ths console.  Don't make more work for yourself by creating your own Strings using the getters; just call `toString`. 

### Track has Getters
If you need to know something about a track object, ask it.  Call the appropriate getter to get the information that you need.

### Hints to Read the File
In Load Catalog, you will need to read each line of the csv file, section out the data from each line, create a Track object, and add the object to the ArrayList that stores all of the Tracks.  Here is an algorithm to help you out.  

```
// Ask the user for a filename
// Check if the file exists
// If it doesn't exist, tell the user and stop trying to read the file
// Otherwise, create a new Scanner (not your input Scanner)open on the file
// Clear the ArrayList
// while the file has data
   // Read a line from the file
   // Use a new Scanner (not your input Scanner) on the line you just read
   // Call useDelimiter on the line Scanner so that it separates on commas instead of spaces
         // e.g `myStringScanner.useDelimiter(",");`
   // Call getNext() to read each piece of data from the line 
         // Artist, Album, Title, Duration (in seconds).
   // Use the information to create a Track object
   // Add the Track object to the ArrayList
// Close the file Scanner
```

Now, you know that reading files requires a try/catch block that is not included in the algorithm above. Remember to enclose your File Scanner and any code that depends on it in a try/catch block.  Refer back to your book and the slides for examples.

In addition, you should consider creating similar algorithms to help you remember what to do for the other parts of the program, too. 
     
### Hints for Searching the Catalog
As stated above, `contains()` will be useful and the search should be case insensitive. Furthermore, since you need to know how many songs match AND print out all matching songs (using `toString`, of course), you need to store the matching songs.

Use a for loop to walk through each track in the Track ArrayList and check to see if the track is a match for the term. If it matches, add the track to an ArrayList of Track objects called `searchResults`. 

Try creating an algorithm like the one above that walks through how you would search the catalog.  

## Before You Begin: Computational Thinking & Planning
1. Read all requirements carefully and familiarize yourself with the [Track documentation](https://boisestate.github.io/CS121-Public/Track/Track.html). 
2. Fill in PLAN.md. Pay special attention to the testing plan for this project. How can you test the functionality of each piece of the project one at a time as you go? 


## Reflect
1. Write a two to three paragraph reflection describing your experience with this project. Talk about what worked well and what didn't work so well in planning, coding, and testing.  Did you run into an issue that took some time to figure out?  Tell us about it. Write the reflection in PLAN.md


## Finally
1. Commit the changes to your local repository with a message stating that Project 0 is complete.
2. Push the changes from your local repository to the GitHub classroom repository.
