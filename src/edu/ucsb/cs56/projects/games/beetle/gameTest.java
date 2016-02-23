package edu.ucsb.cs56.projects.games.beetle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class gameTest {

    @Test public void test_antGUI(){
	
	antGUI agui = new antGUI();
	assertEquals(1,1);
	assertEquals(0, agui.game.getScore(0));
	assertEquals(0, agui.game.getScore(1));
    }

    @Test public void test_beetleGUI(){
	
	beetleGUI bgui = new beetleGUI();
	assertEquals(1,1);
	assertEquals(0, bgui.game.getScore(0));
	assertEquals(0, bgui.game.getScore(1));
    }

    @Test public void test_personGUI(){
	
	personGUI pgui = new personGUI();
	assertEquals(1,1);
	assertEquals(0, pgui.game.getScore(0));
	assertEquals(0, pgui.game.getScore(1));
    }

    @Test public void test_ladybugGUI(){
	
	ladybugGUI lgui = new ladybugGUI();
	assertEquals(1,1);
	assertEquals(0, lgui.game.getScore(0));
	assertEquals(0, lgui.game.getScore(1));
    }

    //Open the start game window
    @Test public void test_startGUI(){
	startGUI sgui = new startGUI();
	sgui.setUpHomeScreen();
    }
    
    //Open the end game window
    @Test public void test_exitGUI(){
	exitGUI egui = new exitGUI();
	egui.setVisible(true);
    }
}
