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
		editDatabaseButton.addClickAction(new UIActionChangeScreen(2));
		UIButtonComponent viewReportButton = new UIButtonComponent(40, 310, 560, 120, "View Report");
		UIButtonComponent pickWinnersButton = new UIButtonComponent(40, 475, 560, 120, "Pick Winners");

		mainMenuScreen.addComponent(background);
		mainMenuScreen.addComponent(mainMenuTitleText);
		mainMenuScreen.addComponent(editDatabaseButton);
		mainMenuScreen.addComponent(viewReportButton);
		mainMenuScreen.addComponent(pickWinnersButton);
		ScreenManager.addScreen(mainMenuScreen);

		Screen editDatabaseScreen = new Screen();
		UITextComponent editDatabaseTitle = new UITextComponent(40, 20, 560, 80, 50, "Edit Database");
		UIDropdownBoxComponent activitySelector = new UIDropdownBoxComponent(160, 160, 320, 40, 11);
		activitySelector.setBorderColor(Color.BLACK);
		activitySelector.setItemHoverBodyColor(new Color(40, 40, 40, 40));
		activitySelector.setItemHoverBorderColor(new Color(40, 40, 40, 40));
		UICompoundComponent activitySelectorItem0 = new UICompoundComponent(0, 0, 320, 40, 2);
		activitySelectorItem0.addComponent(new UIRectangleComponent(0, 0, 320, 40, Color.WHITE));
		activitySelectorItem0.addComponent(new UITextComponent(0, 0, 320, 40, 30, "Edit Students"));
		activitySelector.addComponent(activitySelectorItem0);
		UICompoundComponent activitySelectorItem1 = new UICompoundComponent(0, 0, 320, 40, 2);
		activitySelectorItem1.addComponent(new UIRectangleComponent(0, 0, 320, 40, Color.WHITE));
		activitySelectorItem1.addComponent(new UITextComponent(0, 0, 320, 40, 30, "Tennis Match"));
		activitySelector.addComponent(activitySelectorItem1);
		UICompoundComponent activitySelectorItem2 = new UICompoundComponent(0, 0, 320, 40, 2);
		activitySelectorItem2.addComponent(new UIRectangleComponent(0, 0, 320, 40, Color.WHITE));
		activitySelectorItem2.addComponent(new UITextComponent(0, 0, 320, 40, 30, "Football Game"));
		activitySelector.addComponent(activitySelectorItem2);

		editDatabaseScreen.addComponent(background);
		editDatabaseScreen.addComponent(editDatabaseTitle);
		editDatabaseScreen.addComponent(activitySelector);
		ScreenManager.addScreen(editDatabaseScreen);

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
