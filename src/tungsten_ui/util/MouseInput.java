package tungsten_ui.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInput extends MouseAdapter {

	public static int x;
	public static int y;
	public static double scrollX;
	public static double scrollY;
	public static boolean leftClick;
	public static boolean rightClick;

	public MouseInput() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();

		if (e.getButton() == MouseEvent.BUTTON1) {
			leftClick = true;
		} else if (e.getButton() == MouseEvent.BUTTON2) {
			rightClick = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x = e.getX();
		y = e.getY();

		if (e.getButton() == MouseEvent.BUTTON1) {
			leftClick = false;
		} else if (e.getButton() == MouseEvent.BUTTON2) {
			rightClick = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scrollY = e.getPreciseWheelRotation();
	}
}
