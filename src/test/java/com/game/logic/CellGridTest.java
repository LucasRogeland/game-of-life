package com.game.logic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CellGridTest {

	final int DEFAULT_COLUMNS  = 15;
	final int DEFAULT_ROWS = 15;
	final int DEFAULT_SIZE   = DEFAULT_COLUMNS * DEFAULT_ROWS;

	@Test
	void createDefaultgrid() {
		final CellGrid grid = new CellGrid();
		final List<Cell> cells = grid.getCells();
		assertNotNull(cells);
		assertEquals(DEFAULT_SIZE, cells.size());
	}
	
	@Test
	void createCustomSizedgrid() {
		final int width  = 28;
		final int height = 12;
		CellGrid grid = new CellGrid(width, height);
		List<Cell> cells = grid.getCells();
		assertNotNull(cells);
		assertEquals(width * height, cells.size());
	}

	@Test
	void addRowsInsertsNewRowsOfCells() {
		final int columns  = 10;
		final int rows = 5;
		CellGrid grid = new CellGrid(columns, rows);
		grid.addRows(2);
		assertEquals(70, grid.getCells().size());
		grid.addRows(5);
		assertEquals(120, grid.getCells().size());
	}
	
	@Test
	void addRowsUpdatesMemberRows() {
		final int columns  = 10;
		final int rows = 5;
		final CellGrid grid = new CellGrid(columns, rows);
		grid.addRows(2);
		assertEquals(7, grid.getRows());
		grid.addRows(5);
		assertEquals(12, grid.getRows());
	}
	
	@Test
	void addColumnsInsertsNewCellsAtTheEndOfEachRow() {
		CellGrid grid = new CellGrid(10, 5);
		grid.getCell(0, 3).setIsAlive(true);
		grid.addColumns(2);
		assertEquals(true, grid.getCell(0, 3).getIsAlive());
		assertEquals(60, grid.getCells().size());
		grid.addColumns(5);
		assertEquals(85, grid.getCells().size());
	}
	
	@Test
	void addColumnsUpdatesMemberColumns() {
		final CellGrid grid = new CellGrid(10, 5);
		grid.addColumns(2);
		assertEquals(12, grid.getColumns());
		grid.addColumns(5);
		assertEquals(17, grid.getColumns());
	}
	
	@Test
	void neighboringCellsBoundsCheck() {
		final CellGrid grid = new CellGrid();
		final List<Cell> neighborsEnd = grid.getNeighboringCells(DEFAULT_COLUMNS - 1, DEFAULT_ROWS - 1);
		final List<Cell> neighborsStart = grid.getNeighboringCells(DEFAULT_COLUMNS - 1, DEFAULT_ROWS - 1);
		assertEquals(3, neighborsEnd.size());
		assertEquals(3, neighborsStart.size());
	}
	
	@Test 
	void getCellNegativeInputThrowsIndexOutOfBounds() {
		final CellGrid grid = new CellGrid();
		assertThrows(IndexOutOfBoundsException.class, () -> grid.getCell(-1, -1));
	}
	
}
 