import java.awt.Point;

/**
 * This class implements the logic of a Tic Tac Toe game.
 * It supports move tracking, game state evaluation, and enforcing turn rules.
 * 
 * @author Spectre H.
 */
public class TicTacToeGame implements TicTacToe
{
    private BoardChoice[][] grid;
    private Point[] moves;
    private int moveCount;
    private BoardChoice lastPlayer;
    private GameState gameState;

    private static final int SIZE = 3;
    private static final int MAX_MOVES = SIZE * SIZE;

    /**
     * Constructs a new TicTacToeGame and initializes the game board.
     */
    public TicTacToeGame()
    {
        grid = new BoardChoice[SIZE][SIZE];
        moves = new Point[MAX_MOVES];
        newGame();
    }

    @Override
    public void newGame()
    {
        for (int r = 0; r < SIZE; r++)
        {
            for (int c = 0; c < SIZE; c++)
            {
                grid[r][c] = BoardChoice.OPEN;
            }
        }

        moves = new Point[MAX_MOVES];
        moveCount = 0;
        lastPlayer = null;
        gameState = GameState.IN_PROGRESS;
    }

    @Override
    public boolean choose(BoardChoice player, int row, int col)
    {
        if (player == null || gameOver() || !inBounds(row, col)) return false;
        if (grid[row][col] != BoardChoice.OPEN || player == lastPlayer) return false;

        grid[row][col] = player;
        moves[moveCount++] = new Point(row, col);
        lastPlayer = player;

        updateGameState(player, row, col);
        return true;
    }

    /**
     * Checks if the given row and column are within the game board bounds.
     *
     * @param row the row index
     * @param col the column index
     * @return true if the coordinates are within bounds, false otherwise
     */
    private boolean inBounds(int row, int col)
    {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    /**
     * Updates the game state based on the latest move.
     *
     * @param player the player who made the move
     * @param row    the row of the move
     * @param col    the column of the move
     */
    private void updateGameState(BoardChoice player, int row, int col)
    {
        if (hasThreeInARow(player))
        {

            gameState = (player == BoardChoice.X) ? GameState.X_WON : GameState.O_WON;
        }
        else if (moveCount == MAX_MOVES)
        {
            gameState = GameState.TIE;
        }
        else
        {
            gameState = GameState.IN_PROGRESS;
        }
    }

    /**
     * Checks if the specified player has three in a row.
     *
     * @param player the player to check
     * @return true if the player has won, false otherwise
     */
    private boolean hasThreeInARow(BoardChoice player)
    {
        for (int i = 0; i < SIZE; i++)
        {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) return true; //row
            if (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player) return true; //col
        }
        if(grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) return true;
        if(grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) return true;

        return false;
    }

    @Override
    public boolean gameOver()
    {
        return gameState != GameState.IN_PROGRESS;
    }

    @Override
    public GameState getGameState()
    {
        return gameState;
    }

    @Override
    public BoardChoice[][] getGameGrid()
    {
        BoardChoice[][] copy = new BoardChoice[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++)
        {
            for (int c = 0; c < SIZE; c++)
            {
                copy[r][c] = grid[r][c];
            }
        }
        return copy;
    }

    @Override
    public Point[] getMoves()
    {
        Point[] result = new Point[moveCount];
        System.arraycopy(moves, 0, result, 0, moveCount);
        return result;
    }
}
