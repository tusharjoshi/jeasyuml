/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package drawing.branch;

import gui.drawing.IDrawable;
import java.awt.Graphics2D;

/**
 *
 * @author kamlesh paunikar
 */
public class MSCGenBranch extends AbstractBranchStyle implements IDrawable{

    MSCGenBranch(Branch branch) {
         super(branch);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        int nameXPosition = getNameXPosition(graphics2D);
        graphics2D.drawLine(x + boxWidth / 2, y + boxHeight, x + boxWidth / 2, y + boxHeight + lineHeight);
        graphics2D.drawString(branchName, nameXPosition, getNameYPosition(graphics2D));
        graphics2D.drawString(branchName, nameXPosition, getName2YPosition(graphics2D));
    }

}
