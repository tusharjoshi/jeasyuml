/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.branch;

import gui.drawing.IDrawable;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 *
 * @author kamlesh paunikar
 */
public class RoseBranch extends AbstractBranchStyle implements IDrawable {

    private static final Color FILLCOLOR = new Color(255, 255, 207);
    private static final Color RECTCOLOR = new Color(175, 21, 71);

    RoseBranch(Branch branch) {
         super(branch);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        int nameXPosition = getNameXPosition(graphics2D);
        Stroke oldStroke;
        BasicStroke basicStroke;
 
        graphics2D.setColor(FILLCOLOR);
        graphics2D.fillRect(x, y, boxWidth, boxHeight);
        graphics2D.fillRect(x, y + boxHeight+ lineHeight, boxWidth, boxHeight);
        graphics2D.setColor(RECTCOLOR);
        graphics2D.drawRect(x, y, boxWidth, boxHeight);
        graphics2D.drawRect(x, y + boxHeight +lineHeight, boxWidth, boxHeight);
        oldStroke = graphics2D.getStroke();
        basicStroke = new BasicStroke(1.0f,0, 1, 0.5f, branch.getDash(), 1);
        graphics2D.setStroke(basicStroke);  
        graphics2D.drawLine(x + boxWidth / 2, y + boxHeight, x +boxWidth/ 2, y + boxHeight + lineHeight);
        graphics2D.setStroke(oldStroke);  
        graphics2D.setColor(Color.BLACK);

        graphics2D.drawString(branchName, nameXPosition, getNameYPosition(graphics2D));
        graphics2D.drawString(branchName, nameXPosition, getName2YPosition(graphics2D));
    }
}
