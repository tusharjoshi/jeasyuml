/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.connector;

import common.util.Utility;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author KPServer
 */
public abstract class AbstractConnectorStyle {

    Connector connector;
 
    protected AbstractConnectorStyle() {
    }
    
    protected AbstractConnectorStyle(Connector connector) {
        this.connector = connector;
    }

    protected void drawSimpleArrow(Point point2, Point arrowUpPoint, Point arrowDownPoint, Graphics2D graphics2D) {
        graphics2D.drawLine(arrowUpPoint.x, arrowUpPoint.y, point2.x, point2.y);
        graphics2D.drawLine(arrowDownPoint.x, arrowDownPoint.y, point2.x, point2.y);
    }

    protected void drawTriangularArrow(Point point2, Point arrowUpPoint, Point arrowDownPoint, Graphics2D graphics2D) {
        int xPoints[];
        int yPoints[];
        xPoints = new int[3];
        xPoints[0] = point2.x;
        xPoints[1] = arrowUpPoint.x;
        xPoints[2] = arrowDownPoint.x;
        yPoints = new int[3];
        yPoints[0] = point2.y;
        yPoints[1] = arrowUpPoint.y;
        yPoints[2] = arrowDownPoint.y;
        graphics2D.fillPolygon(xPoints, yPoints, 3);
    }

    protected void setArrowDimension(Point p1, Point p2, int theta, Graphics2D graphics2D) {
        Point arrowUpPoint = new Point();
        Point arrowDownPoint = new Point();
        Dimension textBoundingBox = Utility.getTextBoundingBox(graphics2D, connector.getName());
        int arrowLength = connector.getArrowLength();
        if (p2.x > p1.x) {

            arrowUpPoint.x = (int) (p2.x + arrowLength * Math.cos(Math.toRadians(180 + theta)));
            arrowUpPoint.y = (int) (p2.y + arrowLength * Math.sin(Math.toRadians(180 + theta)));
            connector.setArrowUpPoint(arrowUpPoint);
            arrowDownPoint.x = (int) (p2.x + arrowLength * Math.cos(Math.toRadians(180 - theta)));
            arrowDownPoint.y = (int) (p2.y + arrowLength * Math.sin(Math.toRadians(180 - theta)));
            connector.setArrowDownPoint(arrowDownPoint);
            connector.setNameXPosition(p1.x + ((p2.x - p1.x) / 2) - (textBoundingBox.width / 2));
            connector.setNameYPosition(p1.y - textBoundingBox.height);
        } else {
            arrowUpPoint.x = (int) (p2.x + arrowLength * Math.cos(Math.toRadians(360 - theta)));
            arrowUpPoint.y = (int) (p2.y + arrowLength * Math.sin(Math.toRadians(360 - theta)));
            connector.setArrowUpPoint(arrowUpPoint);
            arrowDownPoint.x = (int) (p2.x + arrowLength * Math.cos(Math.toRadians(theta)));
            arrowDownPoint.y = (int) (p2.y + arrowLength* Math.sin(Math.toRadians(theta)));
            connector.setArrowDownPoint(arrowDownPoint);
            connector.setNameXPosition(p2.x + ((p1.x - p2.x) / 2) - (textBoundingBox.width / 2));
            connector.setNameYPosition(p1.y - textBoundingBox.height);
        }
    }
}
