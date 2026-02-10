import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The TextBook class manages a collection of Post objects. It allows users to
 * add, remove, and comment on posts, as well as save and load post data from
 * files.
 * 
 * This class implements the TextBookInterface interface.
 * 
 * Each post is stored in a separate file, and the list of post IDs is tracked
 * in a shared file defined by POST_LIST_FILENAME.
 * 
 * @author Spectre H.
 */
public class TextBook implements TextBookInterface
{
    private ArrayList <Post> postList;
    private int lastID;

    /**
     * Constructs a new TextBook by loading existing post IDs from a file
     * and initializing post objects from those IDs.
     */
    public TextBook() // Constructor
    {
        postList = new ArrayList<>();
        lastID = 0;

        try
        {
            Scanner scnr = new Scanner(new File(POST_LIST_FILENAME));

            while(scnr.hasNextInt())
            {
                int postID = scnr.nextInt();
                postList.add(new Post(postID));

                if(postID > lastID)
                {
                    lastID = postID;
                }
            }
            scnr.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: File not found");
        }
    }

    /**
     * Gets the ID of the most recently added post.
     * 
     * @return The last post ID
     */
    public int getLastID()
    {
        return lastID;
    }

    /**
     * Gets the number of posts currently stored.
     * 
     * @return The number of posts
     */
    public int getPostCount()
    {
        return postList.size();
    }

     /**
     * Returns the full string representation of a post at a given index.
     * 
     * @param index The index of the post
     * @return The string representation of the post
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public String getPostString(int index)
    {
        if(index >= 0 && index < postList.size())
        {
            return postList.get(index).toString();
        }
        else
        {
            throw new IndexOutOfBoundsException("Index not valid");
        }
    }

    /**
     * Adds a new post with the given author and text.
     * Increments the lastID and saves the post to a file.
     * 
     * @param author The author of the post
     * @param text The content of the post
     */
    public void addPost(String author, String text)
    {
        lastID++;
        Post newPost = new Post(lastID, author, text);
        
        postList.add(newPost);

        try
        {
            PrintWriter writer = new PrintWriter(new File(POST_LIST_FILENAME));

            for(Post post : postList)
            {
                writer.println(post.getPostID());
            }
            writer.close();

            PrintWriter fileCreator = new PrintWriter(new File(newPost.getFilename()));
            fileCreator.println(newPost.toStringPostOnly());
            fileCreator.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: File not found");
        }
    }

    /**
     * Removes a post at the specified index and deletes its corresponding file.
     * 
     * @param index The index of the post to remove
     * @return The removed Post object
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public Post removePost(int index)
    {
        if (index >= 0 && index < postList.size())
        {
            Post postDeleted = postList.remove(index);

            File postFile = new File(postDeleted.getFilename());
            if (postFile.exists())
            {
                postFile.delete();
            }

            updatePostListFile();

            return postDeleted;
        }
        else
        {
            throw new IndexOutOfBoundsException("Index not valid");
        }
    }

    /**
     * Adds a comment to a post at the specified index.
     * 
     * @param postIndex The index of the post
     * @param author The author of the comment
     * @param text The content of the comment
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public void addComment(int postIndex, String author, String text)
    {
        if(postIndex >= 0 && postIndex < postList.size())
        {
            Post post = postList.get(postIndex);
            post.addComment(author, text);
        }
        else
        {
            throw new IndexOutOfBoundsException("Post does not exist");
        }
    }

    /**
     * Returns a summary string of all posts in the TextBook.
     * 
     * @return A summary of the TextBook contents
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("TextBook contains ").append(postList.size()).append(" posts\n");

        for(int i = 0; i < postList.size(); i++)
        {
            sb.append(i).append(" - ").append(postList.get(i).toStringPostOnly()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns a copy of the list of all posts.
     * 
     * @return An ArrayList of Post objects
     */
    public ArrayList<Post> getPosts()
    {
        return new ArrayList<>(postList);
    }

    /**
     * Updates the post list file with the current list of post IDs.
     * Used after adding or removing posts.
     */
    private void updatePostListFile()
    {
        try (PrintWriter writer = new PrintWriter(new File(POST_LIST_FILENAME)))
        {
            for (Post post : postList)
            {
                writer.println(post.getPostID());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error writing to the post list file.");
        }
    }
}
