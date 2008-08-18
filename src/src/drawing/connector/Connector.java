/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.connector;

import gui.drawing.*;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author kamlesh paunikar
 */
public class Connector implements IDrawable {

    private Point point1;
    private Point point2;
    private String name;
    private Style style;
    private int nameXPosition;
    private int nameYPosition;
    private int theta;
    private float dash[] = {3.0f, 3.0f};
    private int arrowLength = 12;
    private Point arrowUpPoint;
    private Point arrowDownPoint;

    
    public Connector(Point point1, Point point2, String name) {
        this.point1 = point1;
        this.point2 = point2;
        this.name = name;
        style = new Style();
    }

    public Connector(Point point1, Point point2, String name, Style style) {
        this.point1 = point1;
        this.point2 = point2;
        this.name = name;
        this.style = style;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        IDrawable iDrawable = null;
        switch (style.getStyleName()) {
            case PlainUML:
                iDrawable = new PlainUMLConnector(this);
                break;

            case Rose:
                iDrawable = new RoseConnector(this);
                break;

            case qsd:
                iDrawable = new QSDConnector(this);
                break;

            case mscgen:
                iDrawable = new MSCGenConnector(this);
                break;

            case Omegapple:
                iDrawable = new OmegappleConnector(this);
                break;

            case BlueModern:
            case GreenEarth:
            case RoundGreen:
                iDrawable = new CommonConnector(this);
                break;
        }
        iDrawable.draw(graphics2D);   
    }

    public float[] getDash() {
        return dash;
    }

    

    public void setStyle(Style style) {
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public String getName() {
        return name;
    }

    public Point getArrowDownPoint() {
        return arrowDownPoint;
    }

    public void setArrowDownPoint(Point arrowDownPoint) {
        this.arrowDownPoint = arrowDownPoint;
    }

    public Point getArrowUpPoint() {
        return arrowUpPoint;
    }

    public void setArrowUpPoint(Point arrowUpPoint) {
        this.arrowUpPoint = arrowUpPoint;
    }

    public int getNameXPosition() {
        return nameXPosition;
    }

    public void setNameXPosition(int nameXPosition) {
        this.nameXPosition = nameXPosition;
    }

    public int getNameYPosition() {
        return nameYPosition;
    }

    public void setNameYPosition(int nameYPosition) {
        this.nameYPosition = nameYPosition;
    }

    public int getArrowLength() {
        return arrowLength;
    }

    public int getTheta() {
        return theta;
    }
}