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
	private JFrame gameFrame = new JFrame(Constants.name + "   --   " + Constants.version);
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
		Tools.showErrorMessage("Mark is dumb", gameFrame);
	}

	public void paint(Graphics g) {
<<<<<<< HEAD
		Tools.drawSharpText("" + input.getMouseXY(), 25, 25, Color.BLUE, Color.BLACK, g);	//
=======
		Tools.drawSharpText(input.getMouseXY(), 25, 25, Color.BLUE, Color.BLACK, g);
>>>>>>> 598fd27284f9d6337a19dc7a3f396c5eaad4e039
	}

	public static void main(String[] arg0) {
		new Game();
	}

}
