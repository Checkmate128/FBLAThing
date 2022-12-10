package tungsten_ui.ui.action;

import tungsten_ui.ui.ScreenManager;

public class UIActionChangeScreen extends UIAction {

	int screen = 0;

	public UIActionChangeScreen(int screen) {
		this.screen = screen;
	}

	@Override
	public void run() {
		ScreenManager.setActiveScreen(screen);
	}

}
