package com.game.logic;

import java.util.ArrayList;
import java.util.List;

public class CellGrid {

	public static final int DEFAULT_COLUMNS = 15;
	public static final int DEFAULT_ROWS = 15;
	
	private int columns, rows;
	private List<Cell> cells;
	
	public CellGrid() {
		this(DEFAULT_COLUMNS, DEFAULT_ROWS);
	}
	
	public CellGrid(int columns, int rows) {
		if (columns < 0 || rows < 0) throw new IllegalArgumentException("Columns and rows must be positive");
		this.columns  = columns;
		this.rows = rows;
		fillDefault();
	}
	
	public int getColumns() {
		return columns;
	}
	
	public int getRows() {
		return rows;
	}
	
	public List<Cell> getCells() {
		return cells;
	}
	
	public Cell getCell(int column, int row) {
		return cells.get(column + (row * columns));
	}
	
	public void addRows(int addition) {
		if (addition < 0) throw new IllegalArgumentException("Must be positive");
		for(int rowsAdded = 0; rowsAdded < addition; rowsAdded++) {
			for (int column = 0; column < columns; column ++) {
				cells.add(new Cell());				
			}
		}
		rows += addition;
	}
	
	public void addColumns(int addition) {
		if (addition < 0) throw new IllegalArgumentException("Must be positive");
		for (int row = 0; row < rows; row++) {
			for (int columnsAdded = 0; columnsAdded < addition; columnsAdded++) {
				cells.add(columns * row + columnsAdded, new Cell());
			}
		}
		columns += addition;
	}
	
	public int getLivingNeighbors(Cell cell) {
		return (int) getNeighboringCells(cell)
				.stream()
				.filter(neighbor -> neighbor.getIsAlive())
				.count();
	}
	
	public List<Cell> getNeighboringCells(Cell cell) {
		if (cell == null) throw new NullPointerException("cell was null");
		final int index = cells.indexOf(cell);
		if (index == -1) throw new IllegalArgumentException("cell index not found");
		
		final List<Cell> neighbors = new ArrayList<Cell>();
		final int column = index % columns;
		final int row = index / columns;
		
		final boolean isFirstRow = row == 0;
		final boolean isLastRow = row == rows - 1;
		final boolean isFirstColumn = column == 0;
		final boolean isLastColumn = column == columns - 1;
		
		if (!isFirstRow) neighbors.add(getCell(column, row - 1));
		if (!isLastRow) neighbors.add(getCell(column, row + 1));
		if (!isFirstColumn) neighbors.add(getCell(column - 1, row));
		if (!isLastColumn) neighbors.add(getCell(column + 1, row));
		if (!isFirstRow && !isFirstColumn) neighbors.add(getCell(column - 1, row - 1));
		if (!isLastRow && !isFirstColumn) neighbors.add(getCell(column - 1, row + 1));
		if (!isFirstRow && !isLastColumn) neighbors.add(getCell(column + 1, row - 1));
		if (!isLastRow && !isLastColumn) neighbors.add(getCell(column + 1, row + 1));

		return neighbors;
	}
	
	private void fillDefault() {
		final int size = columns * rows;
		cells = new ArrayList<Cell>(size);
		for (int i = 0; i < size; i++) {
			cells.add(new Cell());
		}
	}
	
}
