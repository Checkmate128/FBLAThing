package main;

import tungsten_ui.util.KeyboardInput;
import tungsten_ui.util.MouseInput;

import javax.swing.*;

public class Main extends JFrame {

	public static KeyboardInput ki = new KeyboardInput();
	public static MouseInput mi = new MouseInput();
	public static int WINDOW_WIDTH = 1400;
	public static int WINDOW_HEIGHT = 800;
	private static JFrame window;

	public static void main(String[] args) {
		window = new JFrame();

		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.add(new MainRender());
		window.setVisible(true);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setTitle("Studying Software");
		window.setResizable(false);

		window.addKeyListener(ki);
		window.addMouseListener(mi);
		window.addMouseMotionListener(mi);
	}

	public static JFrame getWindow() {
		return window;
	}
}
