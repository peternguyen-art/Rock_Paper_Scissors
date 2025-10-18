import javax.swing.*;
import java.awt.*;

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

    public RockPaperScissorsFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTitlePnl();
        mainPnl.add(titlePnl,BorderLayout.NORTH);

        createCenterPnl();
        mainPnl.add(centerPnl,BorderLayout.CENTER);

//        mainPnl.add(buttonPnl,BorderLayout.SOUTH);

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
        statPnl.setLayout(new GridLayout(3,1));

        playerWinLb = new JLabel("Player Wins: ");
        playerWinLb.setFont(new Font("Arial", Font.BOLD, 14));
        computerWinLb = new JLabel("Computer Wins: ");
        computerWinLb.setFont(new Font("Arial", Font.BOLD, 14));
        tiesLabel = new JLabel("Ties: ");
        tiesLabel.setFont(new Font("Arial", Font.BOLD, 14));

        playerWinTxt = new JTextField(String.valueOf(playerWinCnt));
        computerWinTxt = new JTextField(String.valueOf(computerWinCnt));
        tiesTxt = new JTextField(String.valueOf(tiesCnt));

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
}
