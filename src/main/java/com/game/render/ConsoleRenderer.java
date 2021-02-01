package com.game.render;

import com.game.logic.CellGrid;
import com.game.logic.Cell;

public class ConsoleRenderer implements Renderer{

	private static final String NEW_ROW = "\n\s\s";
	private static final char CELL_ALIVE = 'X';
	private static final char CELL_DEAD = '-';
	private static final int CLEAR_SIZE = 50;
	
	public void render(CellGrid grid) {
		clearConsole();
		final StringBuilder render = new StringBuilder();
		
		for (int row = 0; row < grid.getRows(); row++) {
			render.append(NEW_ROW);
			for (int column = 0; column < grid.getColumns(); column++) {
				render.append(cellGraphics(grid.getCell(column, row)));
			}
		}
		
		System.out.print(render);
	}
	
	private void clearConsole() {
		System.out.println(System.lineSeparator().repeat(CLEAR_SIZE));
	}
	
	private char cellGraphics(Cell cell) {
		return cell.getIsAlive() ? CELL_ALIVE : CELL_DEAD;
	}
	
}
