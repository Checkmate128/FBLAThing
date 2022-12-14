package main;

import student.StudentManager;
import tungsten_ui.ui.Screen;
import tungsten_ui.ui.ScreenManager;
import tungsten_ui.ui.action.UIActionAddStudent;
import tungsten_ui.ui.action.UIActionChangeProperty;
import tungsten_ui.ui.action.UIActionChangeScreen;
import tungsten_ui.ui.action.UIActionReloadDatabase;
import tungsten_ui.ui.component.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainRender extends JPanel implements ActionListener {

	private Timer gameTimer;
	public static int databasePage = 0;
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

		ScreenManager.addScreen(new Screen());
		MainRender.remakeDatabaseScreen(0);

//		Screen editDatabaseScreen = new Screen();
//		UITextComponent editDatabaseTitle = new UITextComponent(40, 20, 560, 80, 50, "Edit Database");
//		UIDropdownBoxComponent activitySelector = new UIDropdownBoxComponent(160, 160, 320, 40, 11);
//		activitySelector.setBorderColor(Color.BLACK);
//		activitySelector.setItemHoverBodyColor(new Color(40, 40, 40, 40));
//		activitySelector.setItemHoverBorderColor(new Color(40, 40, 40, 40));
//		UICompoundComponent activitySelectorItem0 = new UICompoundComponent(0, 0, 320, 40, 2);
//		activitySelectorItem0.addComponent(new UIRectangleComponent(0, 0, 320, 40, Color.WHITE));
//		activitySelectorItem0.addComponent(new UITextComponent(0, 0, 320, 40, 30, "Edit Students"));
//		activitySelector.addComponent(activitySelectorItem0);
//		UICompoundComponent activitySelectorItem1 = new UICompoundComponent(0, 0, 320, 40, 2);
//		activitySelectorItem1.addComponent(new UIRectangleComponent(0, 0, 320, 40, Color.WHITE));
//		activitySelectorItem1.addComponent(new UITextComponent(0, 0, 320, 40, 30, "Tennis Match"));
//		activitySelector.addComponent(activitySelectorItem1);
//		UICompoundComponent activitySelectorItem2 = new UICompoundComponent(0, 0, 320, 40, 2);
//		activitySelectorItem2.addComponent(new UIRectangleComponent(0, 0, 320, 40, Color.WHITE));
//		activitySelectorItem2.addComponent(new UITextComponent(0, 0, 320, 40, 30, "Football Game"));
//		activitySelector.addComponent(activitySelectorItem2);
//
//		editDatabaseScreen.addComponent(background);
//		editDatabaseScreen.addComponent(editDatabaseTitle);
//		editDatabaseScreen.addComponent(activitySelector);
//		ScreenManager.addScreen(editDatabaseScreen);

		ScreenManager.setActiveScreen(0);
	}

	public static void remakeDatabaseScreen(int page) {
		Screen editDatabaseScreen = new Screen();
		UITextComponent editDatabaseTitle = new UITextComponent(40, 20, 560, 80, 50, "Edit Database");
		UIDropdownBoxComponent activitySelector = new UIDropdownBoxComponent(160, 80, 320, 40, 11);
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

		UIButtonComponent newStudentButton = new UIButtonComponent(80, 160 + (StudentManager.getStudents().size() % 5) * 70, 480, 60, "Add Student");
		newStudentButton.addClickAction(new UIActionAddStudent());
		newStudentButton.addClickAction(new UIActionReloadDatabase(0));
		if(StudentManager.getStudents().size() % 5 == 0 && !(5 * MainRender.databasePage == StudentManager.getStudents().size())) {
			newStudentButton.setVisible(false);

		}

		UITextComponent pageDisplayLabel = new UITextComponent(240, 500, 160, 140, 25, "Page " + (MainRender.databasePage + 1) + "/" + (StudentManager.getStudents().size() / 5 + 1));
		UIButtonComponent pageBackButton = new UIButtonComponent(120, 500, 120, 140, "<-");
		pageBackButton.addClickAction(new UIActionReloadDatabase(-1));
		if(MainRender.databasePage <= 1) {
			pageBackButton.setVisible(false);
		}
		UIButtonComponent pageForwardButton = new UIButtonComponent(400, 500, 120, 140, "->");
		pageForwardButton.addClickAction(new UIActionReloadDatabase(1));
		if(MainRender.databasePage >= StudentManager.getStudents().size() / 5) {
			pageForwardButton.setVisible(false);
		}

		editDatabaseScreen.addComponent(new UIRectangleComponent(0, 0, 640, 640, new Color(200, 200, 0)));
		editDatabaseScreen.addComponent(editDatabaseTitle);
		editDatabaseScreen.addComponent(activitySelector);
		for(int i = 0; i < StudentManager.getStudents().size(); i++) {
			if(i - MainRender.databasePage * 5 <= 5 && i - MainRender.databasePage * 5 >= 0) {
				editDatabaseScreen.addComponent(new UIStudentComponent(0, 160 + (i % 5) * 70, StudentManager.getStudents().get(i)));
			}
		}
		editDatabaseScreen.addComponent(newStudentButton);
		editDatabaseScreen.addComponent(pageDisplayLabel);
		editDatabaseScreen.addComponent(pageBackButton);
		editDatabaseScreen.addComponent(pageForwardButton);
		ScreenManager.screens.set(2, editDatabaseScreen);
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
