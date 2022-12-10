package main;

import tungsten_ui.ui.Screen;
import tungsten_ui.ui.ScreenManager;
import tungsten_ui.ui.action.UIActionChangeProperty;
import tungsten_ui.ui.component.UIRectangleComponent;
import tungsten_ui.ui.component.UITextComponent;
import tungsten_ui.ui.component.UITextFieldComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainRender extends JPanel implements ActionListener {

	private Timer gameTimer;

	ScreenManager sm = new ScreenManager();


	public MainRender() {
		super.setDoubleBuffered(true);
		gameTimer = new Timer(16, this);
		gameTimer.start();

		this.setBackground(new Color(0, 200, 0));

		makeUI();
		ScreenManager.setActiveScreen(0);
	}
	
	public void makeUI() {
		Screen homeScreen = new Screen();
		UIRectangleComponent background = new UIRectangleComponent(0, 0, 640, 640, new Color(200, 200, 0));
		UITextComponent titleText = new UITextComponent(40, 20, 560, 80, 50, "TungstenUI Test");
		titleText.addHoverAction(new UIActionChangeProperty(UIActionChangeProperty.BORDER_COLOR, new Color(0, 0, 0)));
		titleText.addUnHoverAction(new UIActionChangeProperty(UIActionChangeProperty.BORDER_COLOR, new Color(0, 0, 0, 0)));
		UITextFieldComponent textField = new UITextFieldComponent(40, 200, 560, 80, 50);
		
		homeScreen.addComponent(background);
		homeScreen.addComponent(titleText);
		homeScreen.addComponent(textField);
		ScreenManager.addScreen(homeScreen);

		Screen gameScreen = new Screen();
		ScreenManager.addScreen(homeScreen);

		ScreenManager.setActiveScreen(1);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		render(g2d);
		ScreenManager.manageScreen(g2d);
	}

	public void render(Graphics2D g) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}
