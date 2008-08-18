/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package drawing.branch;

import gui.drawing.IDrawable;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 *
 * @author kamlesh paunikar
 */
public class QSDBranch extends AbstractBranchStyle implements IDrawable{

    QSDBranch(Branch branch) {
         super(branch);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        int nameXPosition = getNameXPosition(graphics2D);
        Stroke oldStroke;
        BasicStroke basicStroke;

        
        graphics2D.drawRect(x, y, boxWidth,boxHeight);
        graphics2D.fillRect(x+boxWidth,(int)(y+(boxHeight*0.15)),(int)(boxWidth*0.15),boxHeight);
        graphics2D.fillRect((int)(x+(boxWidth*0.15)),y+boxHeight,boxWidth,(int)(boxHeight*0.15));
        
        graphics2D.drawRect(x, y +boxHeight + lineHeight,boxWidth, boxHeight);
        graphics2D.fillRect(x+boxWidth,(int)(y +(boxHeight*0.15))+lineHeight+boxHeight, (int)(boxWidth*0.15),boxHeight);
        graphics2D.fillRect((int)(x+(boxWidth*0.15)),y+this.boxHeight+lineHeight+boxHeight,boxWidth,(int)(boxHeight*0.15));
        oldStroke = graphics2D.getStroke();
        basicStroke = new BasicStroke(1.0f,0, 1, 0.5f, branch.getDash(), 1);
        graphics2D.setStroke(basicStroke);  
        graphics2D.drawLine(x + boxWidth / 2, y + this.boxHeight, x + boxWidth / 2, y + boxHeight + lineHeight);
        graphics2D.setStroke(oldStroke); 
        graphics2D.drawString(branchName, nameXPosition, getNameYPosition(graphics2D));
        graphics2D.drawString(branchName, nameXPosition, getName2YPosition(graphics2D));  
    }

}
