/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package application;

import drawing.DrawingManager;
import drawing.IDrawingManager;
import gui.GUIManager;
import gui.IGUIManager;
import gui.SplashScreen;
import javax.swing.JDialog;
import javax.swing.JFrame;
import parser.ISequenceParserManager;
import parser.SequenceParserManager;

/**
 *
 * @author kamlesh paunikar
 */
public class ApplicationManager implements IAppContext{

    private GUIManager guiManager;
    private DrawingManager drawingManager;
    private SequenceParserManager sequenceParserManager;
    
    public ApplicationManager()
    {
        drawingManager=new DrawingManager(this);
        sequenceParserManager=new SequenceParserManager(this);
        guiManager=new GUIManager(this);
        
    }
    @Override
    public IGUIManager getGUIManager() {
        return guiManager;
    }

    @Override
    public IDrawingManager getDrawingManager() {
        return drawingManager;
    }

    @Override
    public ISequenceParserManager getSequenceParserManager() {
        return sequenceParserManager;
    }
    
    private void start()
    {
        SplashScreen splashScreen=new SplashScreen(null,true);
        splashScreen.setVisible(true);
        guiManager.start();
    }
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                
               new ApplicationManager().start();
            }
        });
    }
   
}
