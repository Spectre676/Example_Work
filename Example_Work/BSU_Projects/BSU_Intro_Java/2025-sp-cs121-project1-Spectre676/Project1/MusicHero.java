import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MusicHero 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Track> trackList = new ArrayList<>();
        boolean quit = false;
        printMenu();

        while (!quit)
        {
            
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "l":
                    loadCatalog(scanner, trackList);
                    System.out.println("Please enter a command (press (M) for Menu): ");
                    break;
                case "s":
                    searchCatalog(scanner, trackList);
                    System.out.println("Please enter a command (press (M) for Menu): ");
                    break;
                case "a":
                    analyzeCatalog(trackList);
                    System.out.println("Please enter a command (press (M) for Menu): ");
                    break;
                case "f":
                    findClosestTrack(scanner, trackList);
                    System.out.println("Please enter a command (press (M) for Menu): ");
                    break;
                case "p":
                    printCatalog(trackList);
                    System.out.println("Please enter a command (press (M) for Menu): ");
                    break;
                case "q":
                    quit = true;
                    System.out.println("Goodbye!");
                    break;
                case "m":
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid selection!");
                    System.out.println("Please enter a command (press (M) for Menu): ");
                    break;
            }
        }

        scanner.close();
    }

    private static void printMenu()
    {
        System.out.println("********************************");
        System.out.println("***       Program Menu       ***");
        System.out.println("********************************");
        System.out.println("(L)oad catalog");
        System.out.println("(S)earch catalog");
        System.out.println("(A)nalyze catalog");
        System.out.println("(F)ind song closest to playtime");
        System.out.println("(P)rint catalog");
        System.out.println("(Q)uit");
        System.out.println("Please enter a command (press (M) for Menu): ");
    }

    private static void loadCatalog(Scanner scanner, ArrayList<Track> trackList)
    {
        System.out.println("Load Catalog...");
        System.out.print("Please enter filename: ");
        String filename = scanner.nextLine().trim();

        File file = new File(filename);
        if (!file.exists())
        {
            System.out.println("Unable to open file: " + filename);
            return;
        }

        trackList.clear();
        try (Scanner fileScanner = new Scanner(file))
        {
            while (fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4)
                {
                    String artist = parts[0].trim();
                    String album = parts[1].trim();
                    String title = parts[2].trim();
                    int playTime = Integer.parseInt(parts[3].trim());
                    trackList.add(new Track(title, artist, album, playTime));
                }
            }
            System.out.println("Successfully loaded " + trackList.size() + " songs!");
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("Unable to open file: " + filename);
        }
    }

    private static void searchCatalog(Scanner scanner, ArrayList<Track> trackList)
    {
        System.out.println("Search Catalog...");
        System.out.print("Please enter the search query: ");
        String query = scanner.nextLine().trim().toLowerCase();

        ArrayList<Track> results = new ArrayList<>();
        for (Track track: trackList)
        {
            if (track.getTitle().toLowerCase().contains(query))
            {
                results.add(track);
            }
        }

        System.out.println("Found " + results.size() + " matches");
        System.out.println("---------------------------------");
        for (Track track : results)
        {
            System.out.println(track);
        }
    }

    private static void analyzeCatalog(ArrayList<Track> trackList)
    {
        int numArtists = 0;
        int numAlbums = 0;
        int totalPlaytime = 0;

        ArrayList<String> artists = new ArrayList<>();
        ArrayList<String> albums = new ArrayList<>();

        for (Track track : trackList)
        {
            if (!artists.contains(track.getArtist()))
            {
                artists.add(track.getArtist());
                numArtists++;
            }   
            if (!albums.contains(track.getAlbum()))
            {
                albums.add(track.getAlbum());
                numAlbums++;
            }
            totalPlaytime += track.getPlayTime();
        }

        System.out.println("Catalog Analysis...");
        System.out.println("  Number of Artists: " + numArtists);
        System.out.println("  Number of Albums: " + numAlbums);
        System.out.println("  Number of Songs: " + trackList.size());
        System.out.println("  Catalog Playtime: " + totalPlaytime);
    }

    private static void findClosestTrack(Scanner scanner, ArrayList<Track> trackList)
    {
        System.out.println("Closest Track...");
        System.out.print("Enter the desired playtime in seconds: ");
        int playtime = Integer.parseInt(scanner.nextLine().trim());

        int minDifference = Integer.MAX_VALUE;
        ArrayList<Track> closestTracks = new ArrayList<>();

        for (Track track : trackList)
        {
            int difference = Math.abs(track.getPlayTime() - playtime);
            if (difference < minDifference)
            {
                minDifference = difference;
                closestTracks.clear();
                closestTracks.add(track);
            }
            else if (difference == minDifference)
            {
                closestTracks.add(track);
            }
        }        

        System.out.println("Finding track(s) closest to " + playtime + " seconds...");
        System.out.println("Found " + closestTracks.size() + " songs");
        System.out.println("---------------------------------");
        for (Track track : closestTracks)
        {
            System.out.println(track);
        }
    }

    private static void printCatalog(ArrayList<Track> trackList)
    {
        System.out.println("Print Catalog...");
        System.out.println("Song list contains " + trackList.size() + " songs...");
        System.out.println("---------------------------------");
        for (Track track : trackList)
        {
            System.out.println(track);
        }
    }
}