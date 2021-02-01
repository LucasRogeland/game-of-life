package com.game.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimelineTest {

	@Test
	void initializeWithDefaultGrid() {
		final Timeline timeline = new Timeline();
		assertNotNull(timeline.getGrid());
		assertNotEquals(0, timeline.getGrid().getRows());
		assertNotEquals(0, timeline.getGrid().getColumns());
	}
	
	@Test
	void initializePreDefinedGrid() {
		CellGrid grid = Template.build("""
				-XX-
				---X
				""");
		final Timeline timeline = new Timeline(grid);
		assertNotNull(timeline.getGrid());
		assertEquals(2, timeline.getGrid().getRows());
		assertEquals(4, timeline.getGrid().getColumns());
		
		assertEquals(false, timeline.getGrid().getCell(0, 0).getIsAlive());
		assertEquals(true, timeline.getGrid().getCell(1, 0).getIsAlive());
		assertEquals(true, timeline.getGrid().getCell(2, 0).getIsAlive());
		assertEquals(false, timeline.getGrid().getCell(3, 0).getIsAlive());
		
		assertEquals(false, timeline.getGrid().getCell(0, 1).getIsAlive());
		assertEquals(false, timeline.getGrid().getCell(1, 1).getIsAlive());
		assertEquals(false, timeline.getGrid().getCell(2, 1).getIsAlive());
		assertEquals(true, timeline.getGrid().getCell(3, 1).getIsAlive());
	}
	
	@Test 
	void nextUpdatesGridWithNewGeneration() {
		CellGrid grid = Template.build("""
				-XXX
				----
				""");
		final Timeline timeline = new Timeline(grid);
		timeline.next();
		assertEquals(false, timeline.getGrid().getCell(0, 0).getIsAlive());
		assertEquals(false, timeline.getGrid().getCell(1, 0).getIsAlive());
		assertEquals(true, timeline.getGrid().getCell(2, 0).getIsAlive());
		assertEquals(false, timeline.getGrid().getCell(3, 0).getIsAlive());
		
		assertEquals(false, timeline.getGrid().getCell(0, 1).getIsAlive());
		assertEquals(false, timeline.getGrid().getCell(1, 1).getIsAlive());
		assertEquals(true, timeline.getGrid().getCell(2, 1).getIsAlive());
		assertEquals(false, timeline.getGrid().getCell(3, 1).getIsAlive());
	}

}
