package main;

import tungsten_ui.ui.Screen;
import tungsten_ui.ui.ScreenManager;
import tungsten_ui.ui.action.UIActionChangeProperty;
import tungsten_ui.ui.action.UIActionChangeScreen;
import tungsten_ui.ui.component.*;

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
		UITextComponent titleText = new UITextComponent(40, 20, 560, 80, 50, "FBLAThing");
		UIButtonComponent newFileButton = new UIButtonComponent(40, 210, 560, 105, "New File");
		newFileButton.addClickAction(new UIActionChangeScreen(1));
		UIButtonComponent openFileButton = new UIButtonComponent(40, 415, 560, 105, "Open File");
		openFileButton.addClickAction(new UIActionChangeScreen(1));

		homeScreen.addComponent(background);
		homeScreen.addComponent(titleText);
		homeScreen.addComponent(newFileButton);
		homeScreen.addComponent(openFileButton);
		ScreenManager.addScreen(homeScreen);

		Screen mainMenuScreen = new Screen();
		UITextComponent mainMenuTitleText = new UITextComponent(40, 20, 560, 80, 50, "Main Menu");
		UIButtonComponent editDatabaseButton = new UIButtonComponent(40, 145, 560, 120, "Edit Database");
		UIButtonComponent viewReportButton = new UIButtonComponent(40, 310, 560, 120, "View Report");
		UIButtonComponent pickWinnersButton = new UIButtonComponent(40, 475, 560, 120, "Pick Winners");

		mainMenuScreen.addComponent(background);
		mainMenuScreen.addComponent(mainMenuTitleText);
		mainMenuScreen.addComponent(editDatabaseButton);
		mainMenuScreen.addComponent(viewReportButton);
		mainMenuScreen.addComponent(pickWinnersButton);
		ScreenManager.addScreen(mainMenuScreen);

		ScreenManager.setActiveScreen(0);
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
