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
public class OmegappleConnector extends AbstractConnectorStyle implements IDrawable {

   
    private static final Color ARRORCOLOR = new Color(217, 51, 119);
    public OmegappleConnector(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        Point point1 = connector.getPoint1();
        Point point2 = connector.getPoint2();
        int lineStyle = connector.getStyle().getLineStyle();
        setArrowDimension(point1, point2, 28, graphics2D);
        graphics2D.drawString(connector.getName(), connector.getNameXPosition(), connector.getNameYPosition());
       
        graphics2D.setColor(ARRORCOLOR);
        if (lineStyle == 1) {
            graphics2D.drawLine(point1.x, point1.y, point2.x, point2.y);
            drawTriangularArrow(point2, connector.getArrowUpPoint(), connector.getArrowDownPoint(), graphics2D);
        }
        if (lineStyle == 2) {
            Stroke oldStroke = graphics2D.getStroke();
            BasicStroke basicStroke = new BasicStroke(1.5f, 0, 1, 0.5f, connector.getDash(), 1);
            graphics2D.setStroke(basicStroke);
            graphics2D.drawLine(point1.x, point1.y, point2.x, point2.y);
            graphics2D.setStroke(new BasicStroke((float) 1.5));
            drawSimpleArrow(point2, connector.getArrowUpPoint(), connector.getArrowDownPoint(), graphics2D);
            graphics2D.setStroke(oldStroke);
        }
        graphics2D.setColor(Color.black);
    }
}
