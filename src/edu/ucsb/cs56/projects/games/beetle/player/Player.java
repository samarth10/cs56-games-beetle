package edu.ucsb.cs56.projects.games.beetle.player;

import java.util.Random;

public abstract class Player {

    String name;
    int roll;
    int partNeed[];
    int partPre[];
    String partName[];

    private Random randGen = new Random();

    /**
     * Add a partHas to player based on the last roll.
     * @return A message indicating how's going.
     */
    public String addPart() {

        String message = "";
        this.roll = randGen.nextInt(6);
        message += name + " rolled: " + Integer.toString(roll + 1) + "\n";

        if (partPre[roll] != -1 && partNeed[partPre[roll]] != 0)
            return message + name + " needs enough " + partName[partPre[roll]] + " first\n\n";
        if (partNeed[roll] == 0)
            return message + name + " already has enough " + partName[roll] + "\n\n";

        partNeed[roll]--;
        return message + " adds a new " + partName[roll] + "\n\n";
    }

    /**
     * Check whether the player has all of the necessary partHas to win.
     * Should be called at the end of each turn.
     * @return True if the player win, false if not.
     */
    public boolean isWin() {
        for (int i = 0; i < 6; i++)
            if (partNeed[i] != 0)
                return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public int getPartNeed(int i) {
        return partNeed[i];
    }

    public String getPartName(int i) {
        return partName[i];
    }
}
