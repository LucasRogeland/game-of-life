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
		if (columns < 1) columns = DEFAULT_COLUMNS;
		if (rows < 1) rows = DEFAULT_ROWS;
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
		guardPosition(column, row);
		return cells.get(column + (row * columns));
	}
	
	public void addRows(int addition) {
		if (addition < 0) return;
		for(int rowsAdded = 0; rowsAdded < addition; rowsAdded++) {
			for (int column = 0; column < columns; column ++) {
				cells.add(new Cell());				
			}
		}
		rows += addition;
	}
	
	public void addColumns(int addition) {
		if (addition < 0) return;
		for (int row = 0; row < rows; row++) {
			for (int columnsAdded = 0; columnsAdded < addition; columnsAdded++) {
				cells.add(columns + row * columns + columnsAdded, new Cell());
			}
		}
		columns += addition;
	}
	
	public int getLivingNeighbors(int column, int row) {
		return (int) getNeighboringCells(column, row)
				.stream()
				.filter(neighbor -> neighbor.getIsAlive())
				.count();
	}
	
	public List<Cell> getNeighboringCells(int column, int row) {
		guardPosition(column, row);
		final List<Cell> neighbors = new ArrayList<Cell>();
		
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
	
	private void guardPosition(int column, int row) {
		if (column < 0 || row < 0 || columns > columns || row > rows) throw new IndexOutOfBoundsException();
	}
	
	private void fillDefault() {
		final int size = columns * rows;
		cells = new ArrayList<Cell>(size);
		for (int i = 0; i < size; i++) {
			cells.add(new Cell());
		}
	}
	
}
