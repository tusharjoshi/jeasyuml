/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.branch;

import common.util.Utility;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author kamlesh paunikar
 */
public abstract class AbstractBranchStyle {

    
    protected int x;
    protected int y;
    protected int boxWidth;
    protected int boxHeight;
    protected int lineHeight;
    protected String branchName;
    protected Branch branch;

    protected AbstractBranchStyle(Branch branch) {
        this.branch=branch;
        x = branch.getX();
        y = branch.getY();
        branchName = branch.getBranchName();
        Dimension textBoundingBox = Utility.getTextBoundingBox(branch.getGraphics(), branchName);
        boxWidth =  (int) (Branch.LEFT_GAP + textBoundingBox.width + Branch.RIGHT_GAP);
        boxHeight =(int) (Branch.TOP_GAP +textBoundingBox.height + Branch.BOTTOM_GAP);
        lineHeight=Branch.SINGLE_LEVEL_HEIGHT*(branch.getCurrentLevel()+1);
        
        
    }

    protected int getNameXPosition(Graphics2D graphics2D) {
        int xPosition;
         Dimension textBoundingBox = Utility.getTextBoundingBox(branch.getGraphics(), branchName);
        xPosition = (boxWidth - textBoundingBox.width) / 2;
        return (xPosition + x);
    }

    protected int getNameYPosition(Graphics2D graphics2D) {
        int yPosition;
        Dimension textBoundingBox = Utility.getTextBoundingBox(branch.getGraphics(), branchName);
        yPosition = Branch.TOP_GAP+textBoundingBox.height;
        return (yPosition + y);
    }

    protected int getName2YPosition(Graphics2D graphics2D) {
        int y2Position;
        y2Position =boxHeight+lineHeight+(2*Branch.TOP_GAP);
        return (y2Position + y);
    }
   
}
