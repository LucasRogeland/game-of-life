package com.game.logic;

public class Template {

	public static final String START = """
			------------------------------
			------------------------------
			------------------------------
			------------------------------
			------------------------------
			------------------------------
			------------------------------
			--------X---------------------
			----------X-------------------
			-------XX--XXX----------------
			------------------------------
			------------------------------
			------------------------------
			""";
	
	public static CellGrid build(String template) {
		final String[] rows = template.split("\n");
		final CellGrid grid =  new CellGrid(rows[0].length(), rows.length);
		for (int row = 0; row < rows.length; row++) {
			for(int column = 0; column < grid.getColumns(); column++) {
				if (rows[row].charAt(column) == 'X') grid.getCell(column, row).setIsAlive(true);
			}
		}
		return grid;
	}
	
}
