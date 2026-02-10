import java.util.Scanner;

/**
 * The TextBookDriver class provides a command-line interface for interacting with the
 * TextBook application. Users can view, add, delete, comment on, and read posts.
 * 
 * This driver demonstrates the core functionality of the TextBook class by
 * presenting a menu and accepting user input to manipulate and view posts.
 * 
 * @author Spectre H.
 */
public class TextBookDriver {

     /**
     * The main method starts the TextBook application. It prompts the user for input
     * and provides options to view posts, add posts, comment, delete, and more.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        TextBook textBook = new TextBook();

        System.out.print("Enter your name to enter the TextBook: ");
        String author = scnr.nextLine();
        System.out.println(author + " Welcome to TextBook, the best text-social media site!");
        boolean quit = false;
        displayerMenu();

        while (!quit) {
            System.out.print("--------------------\nSelect an option or M for menu: ");
            String userInput = scnr.nextLine().toLowerCase();

            switch (userInput) {
                case "m":
                    displayerMenu();
                    break;

                case "p":
                    if (textBook.getPostCount() > 0)
                    {
                        System.out.println(textBook.toString());
                    }
                    else
                    {
                        System.out.println("No posts available.");
                    }
                    break;

                case "a":
                    System.out.print("Enter text for your new post: ");
                    String text = scnr.nextLine();
                    textBook.addPost(author, text);
                    break;

                case "d":
                    int indexDelete = -1;
                    while (indexDelete < 0 || indexDelete >= textBook.getPostCount())
                    {
                        System.out.print("Enter index to delete: ");
                        if (!scnr.hasNextInt())
                        {
                            System.out.println("Error: Invalid input. Please enter a valid index.");
                            scnr.nextLine();
                            continue;
                        }
                        indexDelete = scnr.nextInt();
                        scnr.nextLine();
                        if (indexDelete < 0 || indexDelete >= textBook.getPostCount())
                        {
                            System.out.println("Error: Invalid index. Please enter a valid index.");
                        }
                    }
                    try
                    {
                        textBook.removePost(indexDelete);
                        System.out.println("Post deleted");
                    } 
                    catch (IndexOutOfBoundsException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "c":
                    try {
                        System.out.print("Enter index of the post on which to comment: ");
                        if (!scnr.hasNextInt()) {
                            System.out.print("Error: Invalid input. Please enter a valid index: ");
                            scnr.nextInt();
                        }
                        int indexComment = scnr.nextInt();
                        scnr.nextLine();
                        System.out.print("Introduce comment: ");
                        String comment = scnr.nextLine();
                        textBook.addComment(indexComment, author, comment);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "r":
                    System.out.print("Enter the index of the post to read: ");
                    int indexRead = scnr.nextInt();
                    scnr.nextLine();
                    System.out.println(textBook.getPostString(indexRead));
                    break;

                case "q":
                    System.out.println("Goodbye " + author + "!");
                    quit = true;
                    scnr.close();
                    break;

                default:
                    System.out.println("Invalid option ");
                    break;
            }
        }
    }

    /**
     * Displays the main menu options for interacting with the TextBook application.
     */
    private static void displayerMenu() {
        System.out.println("--------------------");
        System.out.println("TextBook site menu");
        System.out.println("--------------------");
        System.out.println("(P)rint TextBooks posts");
        System.out.println("(A)dd a new post");
        System.out.println("(D)elete a post");
        System.out.println("(C)omment on a post");
        System.out.println("(R)ead a post and its comments");
        System.out.println("(Q)uit");
    }
}