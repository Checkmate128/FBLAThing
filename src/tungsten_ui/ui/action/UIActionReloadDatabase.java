package tungsten_ui.ui.action;

import main.MainRender;

public class UIActionReloadDatabase extends UIAction {

    int pageDifference;

    public UIActionReloadDatabase(int pageDifference) {
        this.pageDifference = pageDifference;
    }
    public void run() {
        MainRender.databasePage += pageDifference;
        MainRender.remakeDatabaseScreen(MainRender.databasePage);
    }
}
