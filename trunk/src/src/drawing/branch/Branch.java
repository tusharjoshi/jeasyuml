/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.branch;

import common.util.Utility;
import gui.drawing.Style;
import gui.drawing.IDrawable;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author kamlesh paunikar
 */
public class Branch implements IDrawable {

    public final static int LEFT_GAP = 10;
    public static final int RIGHT_GAP = 10;
    public static final int TOP_GAP = 10;
    public static final int BOTTOM_GAP = 10;
    public static final int SINGLE_LEVEL_HEIGHT = 40;
    private int x;
    private int y;
    private int width;
    private int height;
    private String branchName;
    private int currentLevel;
    private Style style;
    private float dash[] = {4.0f, 4.0f};
    private Dimension textBoundingBox;
    private Graphics graphics;

    public void setStyle(Style style) {
        this.style = style;
    }

    Branch(String branchName, Graphics graphics) {
        this.branchName = branchName;
        x = 0;
        y = 0;
        currentLevel = 0;
        style = new Style();
        init(graphics);
    }

    public Branch(String branchName, int x, int y, Graphics graphics) {
        this.branchName = branchName;
        this.x = x;
        this.y = y;
        currentLevel = 0;
        style = new Style();
        init(graphics);
    }

    public Branch(String branchName, int x, int y, Style style, Graphics graphics) {
        this.branchName = branchName;
        this.x = x;
        this.y = y;
        currentLevel = 0;
        this.style = style;
        init(graphics);
    }

    @Override
    public void draw(Graphics2D graphics2D) {

        IDrawable iDrawable = null;
        switch (style.getStyleName()) {
            case PlainUML:
                iDrawable = new PlainUMLBranch(this);
                break;
            case Rose:
                iDrawable = new RoseBranch(this);
                break;
            case qsd:
                iDrawable = new QSDBranch(this);
                break;
            case mscgen:
                iDrawable = new MSCGenBranch(this);
                break;
            case Omegapple:
                iDrawable = new OmegappleBranch(this);
                break;
            case BlueModern:
                iDrawable = new BlueModernBranch(this);
                break;
            case GreenEarth:
                iDrawable = new GreenEarthBranch(this);
                break;
            case RoundGreen:
                iDrawable = new RoundGreenBranch(this);
                break;
        }
        iDrawable.draw(graphics2D);
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public float[] getDash() {
        return dash;
    }

    public String getBranchName() {
        return branchName;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point getConnectorLocation(int connectorNumber) {
        int locationX = x + width / 2;
        double textHeight = textBoundingBox.getHeight();
        int boxHeight = (int) (TOP_GAP + textHeight + BOTTOM_GAP);
        int locationY = y + boxHeight + (connectorNumber+1) * SINGLE_LEVEL_HEIGHT;

        return new Point(locationX, locationY);
    }

    public void move(int distanceX, int distanceY) {
        x = x + distanceX;
        y = y + distanceY;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    private void init(Graphics graphics) {
         this.graphics=graphics;
        textBoundingBox = Utility.getTextBoundingBox(graphics, branchName);
        double textWidth = textBoundingBox.getWidth();
        double textHeight = textBoundingBox.getHeight();
        width = (int) (LEFT_GAP + textWidth + RIGHT_GAP);
        int boxHeight = (int) (TOP_GAP + textHeight + BOTTOM_GAP);
        height = (int) (boxHeight + (SINGLE_LEVEL_HEIGHT * (currentLevel + 1)) + boxHeight);
    }
}
