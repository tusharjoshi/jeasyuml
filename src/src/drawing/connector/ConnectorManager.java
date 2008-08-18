/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.connector;

import application.IAppContext;
import common.util.Utility;
import drawing.IDrawingManager;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import drawing.branch.Branch;
import gui.drawing.IDrawable;
import gui.drawing.IStyleConstants.StyleList;
import gui.drawing.Style;
import java.awt.Graphics;

/**
 *
 * @author kamlesh paunikar
 */
public class ConnectorManager {

    private IDrawingManager drawingManager;
    private ArrayList<IDrawable> drawableList;
    private Style selectedStyle;

    public ConnectorManager(IAppContext appContext) {
        drawingManager = appContext.getDrawingManager();
        drawableList = this.drawingManager.getDrawableList();

        StyleList styleName = appContext.getGUIManager().getMainWindow().getStatusPanel().getSelectedStyle();
        selectedStyle = new Style();
        selectedStyle.setStyleName(styleName);

    }

    public Connector addConnector(Branch source, Branch target, String connectorName) {
        Graphics graphics = drawingManager.getGraphics();
        int currentLevel = drawingManager.getCurrentLevel();
        Dimension textBoundingBox = Utility.getTextBoundingBox(graphics, connectorName);
        int connectorWidth = (source.getWidth() / 2) + textBoundingBox.width + (target.getWidth());
        Connector connector = null;
        Point point1 = source.getConnectorLocation(currentLevel);
        Point point2 = target.getConnectorLocation(currentLevel);

        if (point1.x > point2.x) {
//            shift Point1
            int d = point1.x - point2.x;
            if (d < connectorWidth) {
                int diff = connectorWidth - d;
                source.move(diff, 0);
            }
            point1 = source.getConnectorLocation(currentLevel);
        } else {
            //            shift point2;
            int d = point2.x - point1.x;
            if (d < connectorWidth) {
                int diff = connectorWidth - d;
                target.move(diff, 0);
            }
            point2 = target.getConnectorLocation(currentLevel);
        }
        connector = new Connector(point1, point2, connectorName);
        connector.setStyle(selectedStyle);
        return connector;
    }
}
