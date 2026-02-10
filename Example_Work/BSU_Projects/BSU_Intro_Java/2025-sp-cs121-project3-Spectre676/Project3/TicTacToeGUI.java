import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class implements a GUI for playing Tic Tac Toe using Swing.
 * It handles user input, updates the display, and interacts with the game logic.
 * 
 * @author Spectre H.
 */
public class TicTacToeGUI extends JFrame
{
    private TicTacToeGame game;
    private JButton[][] gridButtons;
    private JTextArea moveHistoryArea;
    private JLabel statusLabel;
    private JButton newGameButton;
    private JComboBox<String> firstPlayerSelector;

    private static final int SIZE = 3;

    /**
     * Constructs the Tic Tac Toe GUI, initializing all components and layout.
     */
    public TicTacToeGUI()
    {
        super("Tic Tac Toe");
        game = new TicTacToeGame();

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setResizable(false);

        // Top panel: Control
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setBackground(new Color(173, 3, 102));
        
        firstPlayerSelector = new JComboBox<>(new String[]{"X", "O"});
        JLabel firstPlayerLabel = new JLabel("First Player:");
        firstPlayerLabel.setForeground(Color.BLACK);
        controlPanel.add(firstPlayerLabel);
        controlPanel.add(firstPlayerSelector);

        newGameButton = new JButton("New Game");
        controlPanel.add(newGameButton);

        statusLabel = new JLabel("Current Turn: X");
        statusLabel.setForeground(Color.BLACK);
        controlPanel.add(statusLabel);

        add(controlPanel, BorderLayout.NORTH);

        // Center panel: Game grid
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(SIZE, SIZE));
        boardPanel.setBorder(BorderFactory.createTitledBorder("Tic Tac Toe Board"));
        gridButtons = new JButton[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++)
        {
            for (int col = 0; col < SIZE; col++)
            {
                JButton button = new JButton(" ");
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 48));
                button.setBackground(Color.BLACK);
                button.setOpaque(true);
                button.setBorderPainted(true);
                final int r = row;
                final int c = col;

                button.addActionListener(e -> {handleMove(r, c);});
                gridButtons[r][c] = button;
                boardPanel.add(button);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        // Bottom panel: Move history
        moveHistoryArea = new JTextArea(6, 30);
        moveHistoryArea.setEditable(false);
        moveHistoryArea.setLineWrap(true);
        moveHistoryArea.setBackground(new Color(173, 3, 102));
        moveHistoryArea.setForeground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(moveHistoryArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Move History"));

        add(scrollPane, BorderLayout.SOUTH);

        // Set up listeners
        newGameButton.addActionListener(e -> resetGame());

        setVisible(true);
        resetGame();
    }

    /**
     * Handles a move at the given grid position.
     *
     * @param row the row index of the move
     * @param col the column index of the move
     */
    private void handleMove(int row, int col)
    {   
        if (game.gameOver()) return;
        
        TicTacToe.BoardChoice currentPlayer = (game.getMoves().length % 2 == 0) 
            ? getSelectedStartingPlayer() 
            : (getSelectedStartingPlayer() == TicTacToe.BoardChoice.X ? TicTacToe.BoardChoice.O : TicTacToe.BoardChoice.X);

        Color currentColor = (currentPlayer == TicTacToe.BoardChoice.X) ? Color.BLUE : Color.RED;

        String moveString = String.format("Player %s moved at (%d, %d)\n",
            currentPlayer == TicTacToe.BoardChoice.X ? "X" : "O", row, col);
        
        moveHistoryArea.append(moveString);

        if (!game.choose(currentPlayer, row, col)) return;
        
        gridButtons[row][col].setForeground(currentColor);
        gridButtons[row][col].setText(currentPlayer.toString());
        updateStatus();
        firstPlayerSelector.setEnabled(false);

        if (game.gameOver())
        {
            showGameOver();
        }
    }

    /** 
     * Returns the player selected as the starter in the drop-down menu.
     *
     * @return the selected starting player
     */
    private TicTacToe.BoardChoice getSelectedStartingPlayer()
    {
        return firstPlayerSelector.getSelectedItem().equals("X") ? TicTacToe.BoardChoice.X : TicTacToe.BoardChoice.O;
    }

    /**
     * Updates the status label to reflect the next player’s turn.
     */
    private void updateStatus()
    {
        if (game.gameOver())
        {
            return;
        }
        else
        {
            TicTacToe.BoardChoice nextPlayer = (game.getMoves().length % 2 == 0)
                ? getSelectedStartingPlayer()
                : (getSelectedStartingPlayer() == TicTacToe.BoardChoice.X ? TicTacToe.BoardChoice.O : TicTacToe.BoardChoice.X);

            statusLabel.setText("Current Turn: " + nextPlayer);
        }
    }

    /**
     * Displays the game result and appends the move history to the text area.
     */
    private void showGameOver()
    {
        TicTacToe.GameState state = game.getGameState();
        String message;
        switch (state)
        {
            case X_WON:
                message = "X Wins!";
                break;
            case O_WON:
                message = "O Wins!";
                break;
            case TIE:
                message = "It's a tie!";
                break;
            default:
                message = "Game In Progress.";
        }
        
        statusLabel.setText("Game Over: " + message);
        moveHistoryArea.setText("Game Over: " + message + "\n\nMoves:\n");

        Point[] moves = game.getMoves();
        for (int i = 0; i < moves.length; i++) {
            String player = (i % 2 == 0) ? "X" : "O";
            moveHistoryArea.append(String.format("Player %s moved at (%d, %d)\n", player, moves[i].x, moves[i].y));
        }
        moveHistoryArea.setCaretPosition(moveHistoryArea.getDocument().getLength());

        TicTacToe.BoardChoice[] movePlayers = new TicTacToe.BoardChoice[game.getMoves().length];
        TicTacToe.BoardChoice starter = getSelectedStartingPlayer();
        for (int i = 0; i < movePlayers.length; i++)
        {
            movePlayers[i] = (i % 2 == 0) ? starter : (starter == TicTacToe.BoardChoice.X ? TicTacToe.BoardChoice.O : TicTacToe.BoardChoice.X);
        }

        firstPlayerSelector.setEnabled(true); // allow switching for next game
    }

    /**
     * Resets the game board and UI to start a new game.
     */
    private void resetGame()
    {
        game.newGame();

        for (int r = 0; r < SIZE; r++)
        {
            for (int c = 0; c < SIZE; c++)
            {
                gridButtons[r][c].setText(" ");
                gridButtons[r][c].setEnabled(true);
            }
        }

        moveHistoryArea.setText(" ");
        statusLabel.setText("Current Turn: " + getSelectedStartingPlayer());
        firstPlayerSelector.setEnabled(true);
    }

    /**
     * Main method to launch the Tic Tac Toe GUI.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new TicTacToeGUI());
    }
}
