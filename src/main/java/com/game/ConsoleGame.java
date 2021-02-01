package com.game;

import java.util.concurrent.TimeUnit;

import com.game.logic.CellGrid;
import com.game.logic.Template;
import com.game.logic.Timeline;
import com.game.render.ConsoleRenderer;
import com.game.render.Renderer;

public class ConsoleGame implements Game {
	
	private static final int WAIT_TIME = 250;
	
	private Renderer renderer;
	private Timeline timeline;
	
	public ConsoleGame() {
		CellGrid startingGrid = Template.build(Template.START);
		timeline = new Timeline(startingGrid);
		renderer = new ConsoleRenderer();
	}
	
	public void start() throws InterruptedException {
		while(true) {
			renderer.render(timeline.getGrid());
			timeline.next();
			TimeUnit.MILLISECONDS.sleep(WAIT_TIME);
		}
	}
	
}
