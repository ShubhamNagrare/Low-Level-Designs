package com.lld.SnakesAndLadder.Models;


public class Player {
	
	private String name;
	private int position;
	private boolean won;
	
	public Player(String name) {
		this.name = name;
		position =  0;
		won = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getWon() {
		return this.won;
	}
	
	public void setWon(boolean val) {
		won = val;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	

}
