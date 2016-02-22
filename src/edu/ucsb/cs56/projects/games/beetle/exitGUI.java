package edu.ucsb.cs56.projects.games.beetle;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Dimension;
import java.io.*;
import javax.swing.*;

public class exitGUI extends JFrame{

	private JButton playAgain;
	private JButton exit;
	private JPanel panel = new JPanel();
	int playerScore = 0;
	int computerScore = 0;
	public exitGUI(int playerScore, int computerScore){

		super("Exit Menu");
		this.playerScore = playerScore;
		this.computerScore = computerScore;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playAgain = new JButton("Play Again");
		exit = new JButton("Close Game");
		exit.addActionListener(new ExitListener());
		playAgain.addActionListener(new playAgainListener());
		panel.add(playAgain);
		panel.add(exit);
		add(panel);
		setSize(150,150);
		setResizable(false);
	} 

	class playAgainListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			startGUI gui = new startGUI(playerScore, computerScore);
        	gui.setUpHomeScreen();
		}
	}
	
	class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}


}