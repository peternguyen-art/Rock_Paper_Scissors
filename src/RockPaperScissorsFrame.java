import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.exit;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel centerPnl;
    JPanel statPnl;
    JPanel resultPnl;
    JPanel buttonPnl;

    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    ImageIcon rockImg;
    ImageIcon paperImg;
    ImageIcon scissorsImg;
    ImageIcon quitImg;

    JLabel titleLbl;
    JLabel playerWinLb;
    JLabel computerWinLb;
    JLabel tiesLabel;

    //text fields
    JTextField playerWinTxt;
    JTextField computerWinTxt;
    JTextField tiesTxt;

    JTextArea resultTxt;
    JScrollPane resultScroll;

    int playerWinCnt = 0;
    int computerWinCnt = 0;
    int tiesCnt = 0;

    int rockCnt = 0;
    int paperCnt = 0;
    int scissorsCnt = 0;

    Random rand = new Random();

    ArrayList<String> usedBtn = new ArrayList<>();

    String playerMove = "";

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

    private void createTitlePnl(){
        titlePnl = new JPanel();
        titleLbl = new JLabel("Rock Paper Scissors Game!");
        titleLbl.setFont(new Font("Arial", Font.BOLD, 25));

        titlePnl.add(titleLbl);
    }

    private void createCenterPnl(){
        centerPnl = new JPanel();
        centerPnl.setLayout(new BorderLayout());

        createStatPnl();
        centerPnl.add(statPnl,BorderLayout.NORTH);

        createResultPnl();
        centerPnl.add(resultPnl,BorderLayout.CENTER);

    }

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

    private void createResultPnl(){
        resultPnl = new JPanel();
        resultTxt = new JTextArea(10,25);
        resultTxt.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        resultScroll = new JScrollPane(resultTxt);

        resultTxt.setEditable(false);

        resultPnl.add(resultScroll);
    }

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

        ActionListener moveListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String playerMove
            }
        }

        rockBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                rockCnt++;
                usedBtn.add("R");
                playerMove = "R";
            }
        });

        paperBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                paperCnt++;
                usedBtn.add("P");
                playerMove = "P";
            }
        });

        scissorsBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                scissorsCnt++;
                usedBtn.add("S");
                playerMove = "S";
            }
        });

        quitBtn.addActionListener((ActionEvent e)-> exit(0));

        buttonPnl.add(rockBtn);
        buttonPnl.add(paperBtn);
        buttonPnl.add(scissorsBtn);
        buttonPnl.add(quitBtn);
    }

    public class leastUsed implements Strategy{
        String compMove;

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

    public class mostUsed implements Strategy{
        String compMove;

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

    public class lastUsed implements Strategy{
        String compMove;

        @Override
        public String getMove(String playerMove) {
            String lastMove = usedBtn.get(usedBtn.size() - 2);
            switch (lastMove) {
                case  "R":
                    compMove = "P";
                    break;
                case  "P":
                    compMove = "S";
                    break;
                case  "S":
                    compMove = "R";
                    break;
            }
            return compMove;
        }
    }
}
