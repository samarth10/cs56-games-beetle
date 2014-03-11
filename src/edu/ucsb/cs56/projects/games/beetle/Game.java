package edu.ucsb.cs56.projects.games.beetle;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Game{
	private int[] score = {0,0};
	public Game(){}
    /**
        increaseScore takes an index i
        and adds 1 the array score.
        i = 0 -> player score
        i = 1 -> computer score
    */
	public void increaseScore(int i){
        this.score[i]++;
    }
    public int getScore(int i){
		return score[i];
}
}
