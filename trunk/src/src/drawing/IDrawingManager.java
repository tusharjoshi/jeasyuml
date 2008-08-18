/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package drawing;

import gui.drawing.IDrawable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author kamlesh paunikar
 */
public interface IDrawingManager {
    
    public void draw(Graphics2D graphics2D);
    public void addCall(String sourceBranch, String targetBranch, String connectorName);
    public ArrayList<IDrawable> getDrawableList();
    public Graphics getGraphics();
    public void reset();
    public void setGraphics(Graphics graphics);
    public int getCurrentLevel();

}
