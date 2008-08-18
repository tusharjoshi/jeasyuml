/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import drawing.IDrawingManager;
import gui.IGUIManager;
import parser.ISequenceParserManager;

/**
 *
 * @author kamlesh paunikar
 */
public interface IAppContext {

    IGUIManager getGUIManager();

    IDrawingManager getDrawingManager();

    ISequenceParserManager getSequenceParserManager();
}
