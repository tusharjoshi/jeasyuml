/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.branch;

import gui.drawing.IDrawable;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author kamlesh paunikar
 */
public class BlueModernBranch extends AbstractBranchStyle implements IDrawable {

    private final static Color FILLCOLOR = new Color(108, 108, 108);
    private final static Color SHADOWCOLOR = new Color(82, 123, 198);

    public BlueModernBranch(Branch branch) {
      super(branch);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        int nameXPosition = getNameXPosition(graphics2D);
        graphics2D.setColor(FILLCOLOR);
        graphics2D.fillRoundRect((int) (x + (boxWidth * 0.15)), (int) (y + (boxHeight * 0.15)), boxWidth, boxHeight, boxWidth / 3, boxHeight / 3);
        graphics2D.fillRoundRect((int) (x + (boxWidth * 0.15)), (int) (y + (boxHeight * 0.15)) + boxHeight + lineHeight, boxWidth, boxHeight, boxWidth / 3, boxHeight / 3);

        graphics2D.setColor(SHADOWCOLOR);
        graphics2D.fillRoundRect(x, y, boxWidth, boxHeight,boxWidth / 3, boxHeight / 3);
        graphics2D.fillRoundRect(x, y + boxHeight + lineHeight, boxWidth,boxHeight, boxWidth / 3, boxHeight / 3);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(x + boxWidth / 2, y + boxHeight, x + boxWidth / 2, y + boxHeight + lineHeight);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(branchName, nameXPosition, getNameYPosition(graphics2D));
        graphics2D.drawString(branchName, nameXPosition, getName2YPosition(graphics2D));
        graphics2D.setColor(Color.BLACK);
    }
}
