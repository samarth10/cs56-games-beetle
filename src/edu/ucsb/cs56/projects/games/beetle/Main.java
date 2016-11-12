package edu.ucsb.cs56.projects.games;
import edu.ucsb.cs56.projects.games.beetle.player.*;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dennis
 * @author Kevin Jih
 * @author Justin Nguyen
 * @author Alex Kang
 * @author Yuanqi Li
 * @author Samarth Goyal
 */
public class Main {

    public static void main(String[] args) {
        new Main(0, 0).run();
    }

    private Player player1, player2;
    private int player1Score = 0, player2Score = 0;
    private String player1Name = "Player1", player2Name = "Computer";
    private int gameType = 0;
    private int numPlayer = 1;


    public void setGameType(int num) {
        this.gameType = num;
    }

    public Main(int player1Score, int player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    public void run() {

        JFrame frame = new JFrame("Dice Rolling Game");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        JButton ant = new JButton("Ant");
        JButton beetle = new JButton("Beetle");
        JButton ladybug = new JButton("Ladybug");
        JButton person = new JButton("Person");
        JButton exit = new JButton("Exit");

        ant.addActionListener(e -> { gameType = 0; choosePlayers(frame); });
        beetle.addActionListener(e -> { gameType = 1; choosePlayers(frame); });
        ladybug.addActionListener(e -> { gameType = 2; choosePlayers(frame); });
        person.addActionListener(e -> { gameType = 3; choosePlayers(frame); });
        exit.addActionListener(e -> System.exit(0));

        gc.gridy = 0; panel.add(new JLabel("Welcome to Dice Rolling Game!"), gc);
        gc.gridy = 1; panel.add(ant, gc);
        gc.gridy = 2; panel.add(beetle, gc);
        gc.gridy = 3; panel.add(person, gc);
        gc.gridy = 4; panel.add(ladybug, gc);
        gc.gridy = 5; panel.add(exit, gc);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setBackground(new Color(0,155,100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Beetle Game");
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void choosePlayers(JFrame frame) {

        Object[] options = {"Single Player", "Two Players"};
        numPlayer = JOptionPane.showOptionDialog(
                frame, "Make your decision!", "Make your decision!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
        ) + 1;

        player1Name = (String)JOptionPane.showInputDialog(
                frame, "Enter Player 1's name", "Player 1",
                JOptionPane.PLAIN_MESSAGE, null, null, "Player 1"
        );

        if (numPlayer == 2)
            player2Name = (String)JOptionPane.showInputDialog(
                    frame, "Enter Player 2's name", "Player 2",
                    JOptionPane.PLAIN_MESSAGE, null, null, "Player 2"
            );

        frame.setVisible(false);
        mainFrame();
    }

    private void mainFrame() {

        JFrame frame = new JFrame();
        ImageIcon picture;
        JLabel picLabel = new JLabel();

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridwidth = 2;

        switch (gameType) {
            case 0: player1 = new Ant(player1Name); player2 = new Ant(player2Name);
                    picture = new ImageIcon(new ImageIcon("pictures/ant.jpg").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
                    picLabel.setIcon(picture); break;
            case 1: player1 = new Beetle(player1Name); player2 = new Beetle(player2Name);
                    picture = new ImageIcon(new ImageIcon("pictures/beetle.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
                    picLabel.setIcon(picture); break;
            case 2: player1 = new Ladybug(player1Name); player2 = new Ladybug(player2Name);
                    picture = new ImageIcon(new ImageIcon("pictures/ladybug.jpg").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
                    picLabel.setIcon(picture); break;
            case 3: player1 = new Person(player1Name); player2 = new Person(player2Name);
                    picture = new ImageIcon(new ImageIcon("pictures/human.png").getImage().getScaledInstance(200,150, Image.SCALE_DEFAULT));
                    picLabel.setIcon(picture); break;
        }

        // Set player 1 score boards
        JPanel player1Panel = new JPanel(new GridBagLayout());
        player1Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel p1Score[] = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            gc.gridy = i + 1; gc.gridx = 0;
            player1Panel.add(new JLabel(player1.getPartName(i)), gc);
            p1Score[i] = new JLabel(Integer.toString(player1.getPartNeed(i)));
            gc.gridx = 6;
            player1Panel.add(p1Score[i], gc);
        }

        JPanel p1Board = new JPanel();
        p1Board.setLayout(new BoxLayout(p1Board, BoxLayout.Y_AXIS));
        p1Board.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel p1NameLable = new JLabel(player1.getName() + " score: " + player1Score);
        p1NameLable.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1Board.add(p1NameLable);
        p1Board.add(player1Panel);


        // Set player 2 score boards
        JPanel player2Panel = new JPanel(new GridBagLayout());
        player2Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel p2Score[] = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            gc.gridy = i + 1; gc.gridx = 3;
            player2Panel.add(new JLabel(player2.getPartName(i)), gc);
            p2Score[i] = new JLabel(Integer.toString(player2.getPartNeed(i)));
            gc.gridx = 0;
            player2Panel.add(p2Score[i], gc);
        }

        JPanel p2Board = new JPanel();
        p2Board.setLayout(new BoxLayout(p2Board, BoxLayout.Y_AXIS));
        p2Board.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel p2NameLable = new JLabel(player2.getName() + " score: " + player2Score);
        p2NameLable.setAlignmentX(Component.CENTER_ALIGNMENT);
        p2Board.add(p2NameLable);
        p2Board.add(player2Panel);

        // Set game info board
        JPanel display = new JPanel();
        JTextArea text = new JTextArea(20, 26);
        JScrollPane scroll = new JScrollPane(text);
        text.setEditable(false);
        display.add(scroll);

        // Add control buttons
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton roll = new JButton("Roll");
        JButton exit = new JButton("Exit");
        JLabel info = new JLabel();

        roll.addActionListener(e -> {
            text.append(player1.addPart());
            text.append(player2.addPart());

            for (int i = 0; i < 6; i++) {
                p1Score[i].setText(Integer.toString(player1.getPartNeed(i)));
                p2Score[i].setText(Integer.toString(player2.getPartNeed(i)));
            }

            if (player1.isWin() && !player2.isWin()) {
                player1Score++;
                chooseContinue(frame, player1.getName() + " won!");
            } else if (player2.isWin() && !player1.isWin()) {
                player2Score++;
                chooseContinue(frame, player2.getName() + " won!");
            } else if (player2.isWin() && player1.isWin()) {
                player1Score++;
                player2Score++;
                chooseContinue(frame, "Breaking the deadlock and try again!");
            }
        });
        exit.addActionListener(e -> System.exit(0));

        roll.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String infoStr = "";
        for (int i = 0; i < 6; i++)
            infoStr += Integer.toString(i + 1) + "[" + player1.getPartName(i) + "] ";
        info.setText(infoStr);

        controlPanel.add(roll);
        controlPanel.add(exit);
        controlPanel.add(info);
        controlPanel.add(picLabel);

        // Create the main window
        frame.getContentPane().add(p1Board, BorderLayout.WEST);
        frame.getContentPane().add(p2Board, BorderLayout.EAST);
        frame.getContentPane().add(controlPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(display, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Beetle Game");
        frame.setSize(750, 480);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void chooseContinue(JFrame frame, String msg) {

        Object[] options = {"Continue", "Exit"};
        int isContinue = JOptionPane.showOptionDialog(
                frame, msg, "Do you want to continue?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]
        );

        frame.setVisible(false);

        if (isContinue == 1) {
           System.exit(0);
        } else {
            Object[] choices = {"Ant", "Beetle", "Ladybug", "Person"};
            int option = JOptionPane.showOptionDialog(frame, "Enter a new game mode.", "Enter a new game mode", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
            setGameType(option);
            mainFrame();

        }
    }
}

//class playerScoreBoard extends JPanel {
//
//    playerScoreBoard(Player player) {
//
//
//        JPanel panel = new JPanel(new GridBagLayout());
//        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        GridBagConstraints gc = new GridBagConstraints();
//        gc.gridwidth = 2;
//
//        JLabel parts[] = new JLabel[6];
//        for (int i = 0; i < 6; i++) {
//            gc.gridy = i + 1; gc.gridx = 0;
//            panel.add(new JLabel(player.getPartName(i)), gc);
//            parts[i] = new JLabel(Integer.toString(player.getPartNeed(i)));
//            gc.gridx = 6;
//            panel.add(parts[i], gc);
//        }
//
//        JPanel p1Board = new JPanel();
//        p1Board.setLayout(new BoxLayout(p1Board, BoxLayout.Y_AXIS));
//        p1Board.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        JLabel p1NameLable = new JLabel(player.getName());
//        p1NameLable.setAlignmentX(Component.CENTER_ALIGNMENT);
//        p1Board.add(p1NameLable);
//        p1Board.add(panel);
//    }
//}
