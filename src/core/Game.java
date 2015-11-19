package core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import ui.BufferPanel;
import utilities.Tools;

public class Game {

	private BufferPanel panel = null;
	private JFrame gameFrame = new JFrame(Constants.name + "   -- " + Constants.version);

	public Game() {
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(500, 500);
		panel = new BufferPanel(this);
		gameFrame.add(panel, BorderLayout.CENTER);
		gameFrame.setVisible(true);
	}

	public void paint(Graphics g) {
		Tools.drawSharpText("Penis", 25, 25, Color.BLUE, Color.BLACK, g);
	}

	public static void main(String[] arg0) {
		new Game();
	}

}
