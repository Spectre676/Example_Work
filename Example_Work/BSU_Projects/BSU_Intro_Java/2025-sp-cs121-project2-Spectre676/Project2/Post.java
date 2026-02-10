import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.stream.FileCacheImageInputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;


/**
 * The Post class represents a social media-style post with text, author, timestamp,
 * and a list of comments. Each post is stored in a uniquely named file and supports
 * loading from and saving to that file.
 * 
 * This class implements the PostInterface interface.
 * 
 * @author Spectre H.
 */
public class Post implements PostInterface
{
    private String author;
    private String text;
    private Instant timestamp;
    private int postID;
    private ArrayList <String> commentsList;


    /**
     * Constructor for creating a new post with specified post ID, author, and text.
     * Automatically sets the current timestamp and saves the post to a file.
     * 
     * @param postID The unique identifier for the post
     * @param author The author of the post
     * @param text The content of the post
     */
    public Post(int postID, String author, String text)
    {
        this.postID = postID;
        this.author = author;
        this.text = text;
        this.timestamp = Instant.now(); // Set timestamp to current time
        this.commentsList = new ArrayList<String>();

        try
        {
            DecimalFormat df = new DecimalFormat("00000");
            PrintWriter writer = new PrintWriter(new File(getFilename()));
            writer.println(df.format(postID) + " " + timestamp.toString() + " " + author + " " + text);
            writer.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: File not found");
        }
    }

    /**
     * Constructor for loading a post from a file based on its post ID.
     * Reads post content and comments from the corresponding file.
     * 
     * @param postID The ID of the post to load
     */
    public Post(int postID)
    {
        this.postID = postID;
        this.commentsList = new ArrayList<>();

        try
        {
            Scanner scnr = new Scanner(new File(getFilename()));

            if (scnr.hasNextLine())
            {
                String[] firstLine = scnr.nextLine().split(" ", 4);
                this.postID = Integer.parseInt(firstLine[0]);
                this.timestamp = Instant.parse(firstLine[1]);
                this.author = firstLine[2];
                this.text = firstLine[3];
            }

            while(scnr.hasNextLine())
            {
                commentsList.add(scnr.nextLine());
            }
            scnr.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: File not found");
        }
    }

    /**
     * Adds a comment to the post, including timestamp and author info.
     * Updates the post file with the new comment.
     * 
     * @param author The author of the comment
     * @param text The text of the comment
     */
    public void addComment(String author, String text)
    {
        String timestampComment = Instant.now().toString();
        String comment = timestampComment + " " + author + " " + text;
        commentsList.add(comment);

        try
        {
            PrintWriter writer = new PrintWriter(new File(getFilename()));
            writer.println(toStringPostOnly());
            
            for(String com : commentsList)
            {
                writer.println(com);
            }
            writer.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: File not found");
        }
    }

    /**
     * Generates the filename for storing this post based on post ID.
     * 
     * @return The filename associated with this post
     */
    public String getFilename()
    {
        DecimalFormat df = new DecimalFormat("00000");
        return "Post-" + df.format(postID) + ".txt";
    }

    /**
     * Returns a string representation of the post without comments.
     * 
     * @return A string containing post ID, timestamp, author, and text
     */
    public String toStringPostOnly()
    {
        DecimalFormat df = new DecimalFormat("00000");
        return df.format(postID) + " " + timestamp.toString() + " " + author + " " + text;
    }

    /**
     * Returns a string representation of the full post, including comments.
     * 
     * @return A formatted string showing the post and its comments
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Post: \n" + toStringPostOnly());
        sb.append("\nComments:");

        for(String coms : commentsList)
        {
            sb.append("\n").append(coms);
        }
        return sb.toString();
    }

    /**
     * Gets the unique identifier for the post.
     * 
     * @return The post ID
     */
    public int getPostID()
    {
        return postID;
    }

     /**
     * Gets the text content of the post.
     * 
     * @return The post's text
     */
    public String getText()
    {
        return text;
    }

    /**
     * Gets the timestamp of when the post was created.
     * 
     * @return The timestamp of the post
     */
    public Instant getTimestamp()
    {
        return timestamp;
    }

    /**
     * Gets the author of the post.
     * 
     * @return The post's author
     */
    public String getAuthor()
    {
        return author;
    }
}
