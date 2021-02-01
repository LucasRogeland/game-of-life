package com.game.logic;

public class Cell {

	private boolean isAlive;
	
	public Cell() {
		this(false);
	}
	
	public Cell(boolean isAlive) {
		setIsAlive(isAlive);
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}
	
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
}
