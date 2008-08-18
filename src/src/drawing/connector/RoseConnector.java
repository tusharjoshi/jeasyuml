/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.connector;

import gui.drawing.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

/**
 *
 * @author KPServer
 */
public class RoseConnector extends AbstractConnectorStyle implements IDrawable {
    
    private static final Color ARROWCOLOR = new Color(175, 21, 71);
    public RoseConnector(Connector connector) {
        this.connector = connector;
    }

    public void draw(Graphics2D graphics2D) {
        Point point1 = connector.getPoint1();
        Point point2 = connector.getPoint2();
        int lineStyle = connector.getStyle().getLineStyle();
        setArrowDimension(point1, point2, 28, graphics2D);
        
        graphics2D.drawString(connector.getName(), connector.getNameXPosition(), connector.getNameYPosition());
        graphics2D.setColor(ARROWCOLOR);
        if (lineStyle == 1) {
            graphics2D.drawLine(point1.x, point1.y, point2.x, point2.y);
        }
        if (lineStyle == 2) {
            Stroke oldStroke = graphics2D.getStroke();
            BasicStroke basicStroke = new BasicStroke(1.0f, 0, 1, 0.5f, connector.getDash(), 1);
            graphics2D.setStroke(basicStroke);
            graphics2D.drawLine(point1.x, point1.y, point2.x, point2.y);
            graphics2D.setStroke(oldStroke);
        }
        drawSimpleArrow(point2, connector.getArrowUpPoint(), connector.getArrowDownPoint(), graphics2D);
        graphics2D.setColor(Color.black);

    }
}
