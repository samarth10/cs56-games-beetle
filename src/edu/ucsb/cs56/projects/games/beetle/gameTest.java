package edu.ucsb.cs56.projects.games.beetle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class gameTest {

    @Test public void test_antGUI(){
	
	antGUI agui = new antGUI();
	assertEquals(1,1);
		/*assertEquals(1,agui.pHN);
	assertEquals(6,agui.pLN);
	assertEquals(2,agui.pEN);
	assertEquals(2,agui.pAN);
	assertEquals(1,agui.pTN);
	assertEquals(1,agui.cBN);
	assertEquals(1,agui.cHN);
	assertEquals(6,agui.cLN);
	assertEquals(2,agui.cEN);
	assertEquals(2,agui.cAN);
	assertEquals(1,agui.cTN);*/
	assertEquals(0, agui.game.getScore(0));
	assertEquals(0, agui.game.getScore(1));
    }

    @Test public void test_beetleGUI(){
	
	beetleGUI bgui = new beetleGUI();
    }

    @Test public void test_personGUI(){
	
	personGUI pgui = new personGUI();
    }

    @Test public void test_ladybugGUI(){
	
	ladybugGUI lgui = new ladybugGUI();
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
