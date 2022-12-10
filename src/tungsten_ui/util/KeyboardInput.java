package tungsten_ui.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInput extends KeyAdapter {

	public static boolean w = false;
	public static boolean s = false;
	public static boolean a = false;
	public static boolean d = false;
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	public static boolean space = false;
	public static boolean esc = false;
	public static boolean enter = false;
	public static boolean backspace = false;

	public static char currentKey;
	public static int currentCode;

	public static boolean typing = false;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		currentKey = e.getKeyChar();
	}

	public void keyPressed(KeyEvent e) {
		// System.out.println("KEY DOWN");
		typing = true;

		if (e.getKeyCode() == KeyEvent.VK_W) {
			w = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			s = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			a = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {
			d = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			space = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			esc = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			enter = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			backspace = true;
		}

		currentCode = e.getKeyCode();
		e.isActionKey();
	}

	public void keyReleased(KeyEvent e) {
		// System.out.println("KEY RELEASED");
		typing = false;

		if (e.getKeyCode() == KeyEvent.VK_W) {
			w = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			s = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			a = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {
			d = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			space = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			esc = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			enter = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			backspace = false;
		}

		currentCode = e.getKeyCode();

	}

	public static boolean canBeTyped(int keyCode) {
		if(keyCode == KeyEvent.VK_SHIFT || keyCode == KeyEvent.VK_CONTROL) {
			return false;
		}

		if(keyCode == KeyEvent.VK_BACK_SPACE) {
			return true;
		}

		char[] keyArray = Character.toChars(keyCode);
		if(keyArray != null) {
			char key = keyArray[0];

			if(Character.isLetterOrDigit(key) || Character.isSpaceChar(key) || key == '_' || key == '.' || key == '!' || key == '&' || key == '?' || key == '-') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

}
