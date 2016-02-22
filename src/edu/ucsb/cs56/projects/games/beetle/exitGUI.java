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
	private JButton newLevel;
	private JPanel panel = new JPanel();

	public exitGUI(){
		super("Exit Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playAgain = new JButton("Play Again");
		exit = new JButton("Close Game");
		newLevel = new JButton("Choose new level");
		panel.add(playAgain);
		panel.add(exit);
		panel.add(newLevel);
		add(panel);
		setSize(150,150);
	} 


}