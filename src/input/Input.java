package input;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import core.Game;
import utilities.Tools;

public class Input implements MouseMotionListener, MouseListener, KeyListener {

	private Point mouseXY = new Point(-1, -1);
	private Game game = null;

	public Input(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Tools.log(e.getKeyCode());

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		setMouseXY(new Point(e.getX(), e.getY()));

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setMouseXY(new Point(e.getX(), e.getY()));

	}

	@Override
	public void mouseExited(MouseEvent e) {
		setMouseXY(new Point(e.getX(), e.getY()));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		setMouseXY(new Point(e.getX(), e.getY()));

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setMouseXY(new Point(e.getX(), e.getY()));

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		setMouseXY(new Point(e.getX(), e.getY()));

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		setMouseXY(new Point(e.getX(), e.getY()));

	}

	public Point getMouseXY() {
		return mouseXY;
	}

	public void setMouseXY(Point mouseXY) {
		this.mouseXY = mouseXY;
	}

}
