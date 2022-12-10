package tungsten_ui.ui;

import tungsten_ui.ui.component.UIComponent;
import tungsten_ui.util.ConsoleOutputHandler;

import java.awt.*;
import java.util.ArrayList;

public class ScreenManager {

	public static ArrayList<Screen> screens = new ArrayList<Screen>();

	private static int activeScreen = 0;

	private static int actionDelay = 10;

	private static UIComponent checkedComponent;

	private static boolean hasFocus = false;

	public ScreenManager() {
		
	}

	public static void addScreen(Screen screen) {
		screens.add(screen);
	}
	
	public static void setActiveScreen(int screen) {
		ScreenManager.activeScreen = screen;
	}

	public static int getActiveScreen() {
		return activeScreen;
	}

	public static void manageScreen(Graphics2D g) {
		hasFocus = false;
		if(screens.size() == 0) {
			ConsoleOutputHandler.output("You must have at least one screen!", 3);
			System.exit(2);
		}
		screens.get(activeScreen).manage(g);
		actionDelay--;
	}

	public static void resetActionDelay() {
		actionDelay = 10;
	}

	public static boolean isReadyForAction() {
		if (actionDelay < 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void setCheckedComponent(UIComponent uic) {
		checkedComponent = uic;
	}

	public static UIComponent getCheckedComponent() {
		return checkedComponent;
	}

	public static void deselectAll() {
		screens.get(activeScreen).deselectAll();
	}

	public static boolean hasFocus() {
		return hasFocus;
	}

	public static void setFocus(boolean isFocused) {
		hasFocus = isFocused;
	}

}
