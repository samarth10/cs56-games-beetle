package edu.ucsb.cs56.projects.games;
import edu.ucsb.cs56.projects.games.beetle.player.*;

public class BeetleGame {

    Player p1, p2;
    String p1Name = "Player1", p2Name = "Computer";
    int p1Score = 0, p2Score = 0;
    int type = 0;
    int numPlayer = 1;

    BeetleGame(int p1Score, int p2Score) {
        this.p1Score = p1Score;
        this.p2Score = p2Score;
    }

    void setGameType(int num) {
        this.type = num;
    }

    public static void main(String[] args) {

        BeetleGame game = new BeetleGame(0, 0);

        if (args.length > 0 && args[0].equals("-t"))
            new TextBased(game).run();
        else
            new GuiBased(game).run();
    }
}
