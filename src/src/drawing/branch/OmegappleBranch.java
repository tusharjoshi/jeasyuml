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
public class OmegappleBranch extends AbstractBranchStyle implements IDrawable {

    private static final Color FILLCOLOR = new Color(217, 51, 119);

    OmegappleBranch(Branch branch) {
        super(branch);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        int nameXPosition = getNameXPosition(graphics2D);
        graphics2D.setColor(FILLCOLOR);
        graphics2D.fillRoundRect(x, y, boxWidth, boxHeight, boxWidth / 3, boxHeight / 3);
        graphics2D.fillRoundRect(x, y + boxHeight + lineHeight, boxWidth, boxHeight, boxWidth / 3, boxHeight / 3);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(x + boxWidth / 2, y + boxHeight, x + boxWidth / 2, y + boxHeight + lineHeight);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(branchName, nameXPosition, getNameYPosition(graphics2D));
        graphics2D.drawString(branchName, nameXPosition, getName2YPosition(graphics2D));
        graphics2D.setColor(Color.BLACK);
    }
}
