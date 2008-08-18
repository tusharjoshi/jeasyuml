/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import application.IAppContext;
import drawing.branch.BranchManager;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import drawing.branch.Branch;
import drawing.connector.Connector;
import drawing.connector.ConnectorManager;
import gui.drawing.IDrawable;
import java.awt.Color;

/**
 *
 * @author kamlesh paunikar
 */
public class DrawingManager implements IDrawingManager {

    private IAppContext appContext;
    private int currentLevel = 0;
    private ArrayList<IDrawable> drawableList = new ArrayList<IDrawable>();
    private Graphics graphics;

    public DrawingManager(IAppContext appContext) {
        this.appContext = appContext;
    }

    @Override
    public ArrayList<IDrawable> getDrawableList() {
        return drawableList;
    }

    @Override
    public void addCall(String sourceBranch, String targetBranch, String connectorName) {
        BranchManager branchManager = new BranchManager(appContext);
        Branch source = branchManager.addBranch(sourceBranch);
        Branch target = branchManager.addBranch(targetBranch);
        ConnectorManager connectorManager = new ConnectorManager(appContext);
        Connector connector = connectorManager.addConnector(source, target, connectorName);
        drawableList.add(connector);
        currentLevel++;
        branchManager.setCurrentLevel(currentLevel);

    }

    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        
        graphics2D.setBackground(Color.WHITE);
        for (IDrawable drawable : drawableList) {
            drawable.draw(graphics2D);
        }
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public void setGraphics(Graphics graphics) {
        this.graphics=graphics;
    }

    @Override
    public void reset() {
        currentLevel=0;
        drawableList.clear();
    }
}
