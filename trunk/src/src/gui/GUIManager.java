/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import application.IAppContext;

/**
 *
 * @author kamlesh paunikar
 */
public class GUIManager implements IGUIManager {

    private IAppContext appContext;
    private MainWindow mainWindow;

    public GUIManager(IAppContext appContext) {
        this.appContext = appContext;
        mainWindow=new MainWindow(appContext);
    }

    public void start() {
        mainWindow.setVisible(true);
    }

    @Override
    public IMainWindow getMainWindow() {
        return mainWindow;
    }
}
