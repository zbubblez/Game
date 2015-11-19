package ui;

import javax.swing.JPanel;

import core.Game;

public class BufferPanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Game game = null;

	public BufferPanel(Game game) {
		this.game = game;
	}

	@Override
	public void run() {
		
	}

}
