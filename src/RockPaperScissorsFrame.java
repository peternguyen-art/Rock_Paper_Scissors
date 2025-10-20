import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import static java.lang.System.exit;

/**
 * The RockPaperScissorsFrame class implements a GUI-based Rock-Paper-Scissors game.
 * It provides multiple computer strategies (Least Used, Most Used, Last Used, Random, Cheat)
 * and displays live game statistics such as player wins, computer wins, and ties.
 *
 * The game determines the computer's move based on a random probability distribution:
 * <ul>
 *     <li>1–10% → Cheat</li>
 *     <li>11–30% → Least Used</li>
 *     <li>31–50% → Most Used</li>
 *     <li>51–70% → Last Used</li>
 *     <li>71–100% → Random</li>
 * </ul>
 *
 * Each button press triggers an action event that records the player's move
 * and determines the computer’s move accordingly.
 *
 * Author: Peter Nguyễn
 * Version: 1.0
 * Date: October 2025
 */

public class RockPaperScissorsFrame extends JFrame {
    // Panels
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel centerPnl;
    JPanel statPnl;
    JPanel resultPnl;
    JPanel buttonPnl;

    // Buttons
    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    // ImageIcon
    ImageIcon rockImg;
    ImageIcon paperImg;
    ImageIcon scissorsImg;
    ImageIcon quitImg;

    // Labels
    JLabel titleLbl;
    JLabel playerWinLb;
    JLabel computerWinLb;
    JLabel tiesLabel;

    // Text fields
    JTextField playerWinTxt;
    JTextField computerWinTxt;
    JTextField tiesTxt;

    // Text Area
    JTextArea resultTxt;
    JScrollPane resultScroll;

    // Other game stats
    int playerWinCnt = 0;
    int computerWinCnt = 0;
    int tiesCnt = 0;

    int rockCnt = 0;
    int paperCnt = 0;
    int scissorsCnt = 0;

    Random rand = new Random();

    ArrayList<String> usedBtn = new ArrayList<>();

    String playerMove = "";
    String compMove = "";

    /**
     * Constructs the main RockPaperScissorsFrame and initializes the GUI components.
     */
    public RockPaperScissorsFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTitlePnl();
        mainPnl.add(titlePnl,BorderLayout.NORTH);

        createCenterPnl();
        mainPnl.add(centerPnl,BorderLayout.CENTER);

        createButtonPnl();
        mainPnl.add(buttonPnl,BorderLayout.SOUTH);

        add(mainPnl);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Creates the title panel with the main game label.
     */
    private void createTitlePnl(){
        titlePnl = new JPanel();
        titleLbl = new JLabel("Rock Paper Scissors Game!");
        titleLbl.setFont(new Font("Arial", Font.BOLD, 25));

        titlePnl.add(titleLbl);
    }

    /**
     * Creates the center panel containing the stats and results sections.
     */
    private void createCenterPnl(){
        centerPnl = new JPanel();
        centerPnl.setLayout(new BorderLayout());

        createStatPnl();
        centerPnl.add(statPnl,BorderLayout.NORTH);

        createResultPnl();
        centerPnl.add(resultPnl,BorderLayout.CENTER);

    }

    /**
     * Creates the statistics panel displaying player wins, computer wins, and ties.
     */
    private void createStatPnl(){
        statPnl = new JPanel();
        statPnl.setLayout(new GridLayout(4,1));

        statPnl.setBorder(new EmptyBorder(30,30,50,50));
        playerWinLb = new JLabel("Player Wins: ");
        playerWinLb.setFont(new Font("Arial", Font.BOLD, 14));
        computerWinLb = new JLabel("Computer Wins: ");
        computerWinLb.setFont(new Font("Arial", Font.BOLD, 14));
        tiesLabel = new JLabel("Ties: ");
        tiesLabel.setFont(new Font("Arial", Font.BOLD, 14));

        playerWinTxt = new JTextField(String.valueOf(playerWinCnt));
        playerWinTxt.setHorizontalAlignment(JTextField.CENTER);
        computerWinTxt = new JTextField(String.valueOf(computerWinCnt));
        computerWinTxt.setHorizontalAlignment(JTextField.CENTER);
        tiesTxt = new JTextField(String.valueOf(tiesCnt));
        tiesTxt.setHorizontalAlignment(JTextField.CENTER);

        playerWinTxt.setEditable(false);
        computerWinTxt.setEditable(false);
        tiesTxt.setEditable(false);

        statPnl.add(playerWinLb);
        statPnl.add(playerWinTxt);
        statPnl.add(computerWinLb);
        statPnl.add(computerWinTxt);
        statPnl.add(tiesLabel);
        statPnl.add(tiesTxt);
    }

    /**
     * Creates the result panel containing the game log.
     */
    private void createResultPnl(){
        resultPnl = new JPanel();
        resultTxt = new JTextArea(10,25);
        resultTxt.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        resultTxt.setEditable(false);

        resultScroll = new JScrollPane(resultTxt);

        resultTxt.setEditable(false);

        resultPnl.add(resultScroll);
    }

    /**
     * Creates the panel for user input buttons (Rock, Paper, Scissors, Quit)
     * and sets up listeners for user actions and computer strategy selection.
     */
    private void  createButtonPnl(){
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1,4));

        rockBtn = new JButton("Rock");
        paperBtn = new JButton("Paper");
        scissorsBtn = new JButton("Scissors");
        quitBtn = new JButton("Quit");

        rockImg = new ImageIcon("src/assets/rock.png");
        paperImg = new ImageIcon("src/assets/paper.png");
        scissorsImg = new ImageIcon("src/assets/scissors.png");
        quitImg = new ImageIcon("src/assets/quit.png");

        Image rock = rockImg.getImage();
        Image paper = paperImg.getImage();
        Image scissors = scissorsImg.getImage();
        Image quit = quitImg.getImage();

        Image resizedRock = rock.getScaledInstance(25,25,Image.SCALE_SMOOTH);
        Image resizedPaper = paper.getScaledInstance(25,25,Image.SCALE_SMOOTH);
        Image resizedScissors = scissors.getScaledInstance(25,25,Image.SCALE_SMOOTH);
        Image resizedQuit = quit.getScaledInstance(25,25,Image.SCALE_SMOOTH);

        rockImg = new ImageIcon(resizedRock);
        paperImg = new ImageIcon(resizedPaper);
        scissorsImg = new ImageIcon(resizedScissors);
        quitImg = new ImageIcon(resizedQuit);

        rockBtn.setIcon(rockImg);
        paperBtn.setIcon(paperImg);
        scissorsBtn.setIcon(scissorsImg);
        quitBtn.setIcon(quitImg);

        rockBtn.setActionCommand("R");
        paperBtn.setActionCommand("P");
        scissorsBtn.setActionCommand("S");

        ActionListener moveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                playerMove = ae.getActionCommand();
                usedBtn.add(playerMove);

                switch (playerMove) {
                    case "R" -> rockCnt++;
                    case "P" -> paperCnt++;
                    case "S" -> scissorsCnt++;
                }

                // Instantiate strategy objects with updated data
                LeastUsed leastUsed = new LeastUsed();
                MostUsed mostUsed = new MostUsed();
                LastUsed lastUsed = new LastUsed();
                RpsRandom random = new RpsRandom();
                RpsCheat cheat = new RpsCheat();

                // Determine computer strategy
                int cheatIndicator = rand.nextInt(100) + 1;

                if (cheatIndicator <= 10) {
                    compMove = cheat.getMove(playerMove);
                } else if (cheatIndicator <= 30) {
                    compMove = leastUsed.getMove(playerMove);
                } else if (cheatIndicator <= 50) {
                    compMove = mostUsed.getMove(playerMove);
                } else if (cheatIndicator <= 70) {
                    compMove = lastUsed.getMove(playerMove);
                } else {
                    compMove = random.getMove(playerMove);
                }

                // Determine winner & update UI
                String result;
                if (playerMove.equals(compMove)) {
                    tiesCnt++;
                    result = "It's a tie!";
                } else if (
                        (playerMove.equals("R") && compMove.equals("S")) ||
                                (playerMove.equals("P") && compMove.equals("R")) ||
                                (playerMove.equals("S") && compMove.equals("P"))
                ) {
                    playerWinCnt++;
                    result = "You win!";
                } else {
                    computerWinCnt++;
                    result = "Computer wins!";
                }

                playerWinTxt.setText(String.valueOf(playerWinCnt));
                computerWinTxt.setText(String.valueOf(computerWinCnt));
                tiesTxt.setText(String.valueOf(tiesCnt));

                resultTxt.append("You: " + playerMove + " | Computer: " + compMove + " → " + result + "\n");
            }
        };

        rockBtn.addActionListener(moveListener);
        paperBtn.addActionListener(moveListener);
        scissorsBtn.addActionListener(moveListener);
        quitBtn.addActionListener((ActionEvent e) -> exit(0));

        buttonPnl.add(rockBtn);
        buttonPnl.add(paperBtn);
        buttonPnl.add(scissorsBtn);
        buttonPnl.add(quitBtn);
    }

    /**
     * Strategy that selects the move least used by the player so far.
     */
    public class LeastUsed implements Strategy{

        @Override
        public String getMove(String playerMove) {
            if (rockCnt < paperCnt && rockCnt < scissorsCnt) {
                compMove = "P";
            } else if(paperCnt < rockCnt && paperCnt < scissorsCnt) {
                compMove = "S";
            } else if (scissorsCnt < rockCnt && scissorsCnt < paperCnt) {
                compMove = "R";
            } else {
                String[] moves = {"R", "P", "S"};
                compMove = moves[rand.nextInt(3)];
            }
            return compMove;
        }
    }

    /**
     * Strategy that selects the move most used by the player so far.
     */
    public class MostUsed implements Strategy{

        @Override
        public String getMove(String playerMove) {
            if (rockCnt > paperCnt && rockCnt > scissorsCnt) {
                compMove = "P";
            } else if(paperCnt > rockCnt && paperCnt > scissorsCnt) {
                compMove = "S";
            } else if (scissorsCnt > rockCnt && scissorsCnt > paperCnt) {
                compMove = "R";
            } else {
                String[] moves = {"R", "P", "S"};
                compMove = moves[rand.nextInt(3)];
            }
            return compMove;
        }
    }

    /**
     * Strategy that counters the player's previous move.
     */
    public class LastUsed implements Strategy{

        @Override
        public String getMove(String playerMove) {
            if (usedBtn.size() < 2) {
                String[] moves = {"R", "P", "S"};
                compMove = moves[rand.nextInt(3)];
            } else {
                String lastMove = usedBtn.get(usedBtn.size() - 2);
                switch (lastMove) {
                    case "R" -> compMove = "P";
                    case "P" -> compMove = "S";
                    case "S" -> compMove = "R";
                }
            }
            return compMove;
        }
    }
}
