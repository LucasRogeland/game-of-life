package com.game.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CellTest {

	@Test
	void createDefaultDead() {
		final Cell cell = new Cell();
		assertEquals(false, cell.getIsAlive());
	}
	
	@Test
	void createAlive() {
		final Cell cell = new Cell(true);
		assertEquals(true, cell.getIsAlive());
	}
	
	@Test
	void createDead() {
		final Cell cell = new Cell(false);
		assertEquals(false, cell.getIsAlive());
	}
	
	@Test 
	void setAliveToDead() {
		final Cell cell = new Cell(true);
		cell.setIsAlive(false);
		assertEquals(false, cell.getIsAlive());
	}
	
	@Test 
	void setDeadToAlive() {
		final Cell cell = new Cell(false);
		cell.setIsAlive(true);
		assertEquals(true, cell.getIsAlive());
	}

}
