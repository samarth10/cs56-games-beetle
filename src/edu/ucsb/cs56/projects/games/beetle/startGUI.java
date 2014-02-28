/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Dennis
 * @author Kevin Jih
 */
public class startleGUI {
    JFrame frame = new JFrame("Dice Rolling Game");
    JPanel thePanel = new JPanel(new GridBagLayout());
    JLabel title = new JLabel("Welcome to Dice Rolling Game!");
   
    JButton beetle = new JButton("Beetle");
    JButton exit = new JButton("Exit");
       
    public void setUpHomeScreen(){
        text.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridwidth=2;
        gc.gridx=2;
        gc.gridy=0;
        frame.add(title, gc);
        

        
        gc.gridx=2;
        gc.gridy=2;

	beetle.addActionListener(new BeetleListener());
	frame.add(beetle, gc);

	gc.gridy=3;
        exit.addActionListener(new ExitListener());
        frame.add(exit, gc);



        //frame.getContentPane().add(thePanel);
        frame.pack();
        frame.setSize(800,800);
        frame.setVisible(true);
        
        
    }
    
    class BeetleListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    beetleGUI bgui = new beetleGUI();
	    bgui.setUpHomeScreen();
	}
    }//end BeetleListener

    class ExitListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		System.exit(0);

	}
    }//end ExitListener
}
