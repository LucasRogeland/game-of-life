package com.game.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemplateTest {

	@Test
	void createsGridFromTemplateString() {
		final CellGrid grid = Template.build("""
				--X--
				--X--
				-X---
				""");
		assertEquals(false, grid.getCell(0, 0).getIsAlive());
		assertEquals(false, grid.getCell(1, 0).getIsAlive());
		assertEquals(true, grid.getCell(2, 0).getIsAlive());
		assertEquals(false, grid.getCell(3, 0).getIsAlive());
		assertEquals(false, grid.getCell(4, 0).getIsAlive());
		assertEquals(false, grid.getCell(0, 1).getIsAlive());
		assertEquals(false, grid.getCell(1, 1).getIsAlive());
		assertEquals(true, grid.getCell(2, 1).getIsAlive());
		assertEquals(false, grid.getCell(3, 1).getIsAlive());
		assertEquals(false, grid.getCell(4, 1).getIsAlive());
		assertEquals(false, grid.getCell(0, 2).getIsAlive());
		assertEquals(true, grid.getCell(1, 2).getIsAlive());
		assertEquals(false, grid.getCell(2, 2).getIsAlive());
		assertEquals(false, grid.getCell(3, 2).getIsAlive());
		assertEquals(false, grid.getCell(4, 2).getIsAlive());
	}

}
