package core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import input.Input;
import ui.BufferPanel;
import utilities.Tools;

public class Game {

	private BufferPanel panel = null;
	private JFrame gameFrame = new JFrame(Constants.name + "   -- " + Constants.version);
	private Input input = new Input(this);

	public Game() {
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(500, 500);
		panel = new BufferPanel(this);
		gameFrame.add(panel, BorderLayout.CENTER);
		gameFrame.addMouseMotionListener(input);
		gameFrame.addMouseListener(input);
		gameFrame.addKeyListener(input);
		gameFrame.setVisible(true);
	}

	public void paint(Graphics g) {
		Tools.drawSharpText("" + input.getMouseXY(), 25, 25, Color.BLUE, Color.BLACK, g);	//
	}

	public static void main(String[] arg0) {
		new Game();
	}

}
