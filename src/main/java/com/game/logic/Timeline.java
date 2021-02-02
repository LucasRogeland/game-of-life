package com.game.logic;

public class Timeline {

	private int generation;
	private CellGrid grid;
	
	public Timeline() {
		this(new CellGrid());
	}
	
	public Timeline(CellGrid grid)  {
		generation = 0;
		this.grid = grid;
	}
	
	public void next() {
		generation++;
		final CellGrid nextGrid = new CellGrid(grid.getColumns(), grid.getRows());
		for (int row = 0; row < grid.getRows(); row++) {
			for (int column = 0; column < grid.getColumns(); column++) {
				final Cell cell = grid.getCell(column, row);
				final Cell nextCell = nextGrid.getCell(column, row);
				final int livingNeighbors = grid.getLivingNeighborsCount(column, row);
				if (livingNeighbors == 3 || (livingNeighbors == 2 && cell.getIsAlive())) nextCell.setIsAlive(true);
			}
		}
		grid = nextGrid;
	}
	
	public int getGeneration() {
		return generation;
	}
	
	public CellGrid getGrid() {
		return grid;
	}
}
