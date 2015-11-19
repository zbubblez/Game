package ui;

import java.awt.Image;

import javax.swing.JPanel;

import core.Game;
import utilities.Tools;

public class BufferPanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Game game = null;
	private Image buffer = null;

	public BufferPanel(Game game) {
		this.game = game;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			buffer = this.createImage(this.getWidth(), this.getHeight());
			if (buffer != null && buffer.getGraphics() != null) {
				game.paint(buffer.getGraphics());
				this.getGraphics().drawImage(buffer, 0, 0, null);
			}
			Tools.sleep(5);
		}
	}

}
