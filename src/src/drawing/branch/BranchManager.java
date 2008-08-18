/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.branch;

import application.IAppContext;
import drawing.IDrawingManager;
import gui.drawing.IDrawable;
import gui.drawing.IStyleConstants.StyleList;
import gui.drawing.Style;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author kamlesh paunikar
 */
public class BranchManager {

    public final static int BRANCH_GAP = 10;
    private IDrawingManager drawingManager;
    private ArrayList<IDrawable> drawableList;
    private Graphics graphics;
    private Style selectedStyle;
    public BranchManager(IAppContext appContext) {
        drawingManager = appContext.getDrawingManager();
        drawableList = this.drawingManager.getDrawableList();
        graphics = drawingManager.getGraphics();
        StyleList styleName = appContext.getGUIManager().getMainWindow().getStatusPanel().getSelectedStyle();
        selectedStyle=new Style();
        selectedStyle.setStyleName(styleName);
    }

    public boolean isBranchExists(String branchName) {
        for (IDrawable drawable : drawableList) {
            if (drawable instanceof Branch) {
                Branch branch = (Branch) drawable;
                if (branch.getBranchName().equals(branchName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Branch getLastBranch() {
        Branch lastBranch = null;
        for (IDrawable drawable : drawableList) {
            if (drawable instanceof Branch) {
                lastBranch = (Branch) drawable;
            }
        }
        return lastBranch;
    }

    public Branch getBranch(String branchName) {
        for (IDrawable drawable : drawableList) {
            if (drawable instanceof Branch) {
                Branch branch = (Branch) drawable;
                if (branch.getBranchName().equals(branchName)) {
                    return branch;
                }
            }
        }
        return null;
    }

    public ArrayList<Branch> getRearBranchList(String branchName) {
        ArrayList<Branch> rearBranchList = new ArrayList<Branch>();
        int size = drawableList.size();
        int position = 0;
        for (int index = 0; index < size; index++) {
            IDrawable drawable = drawableList.get(index);
            if (drawable instanceof Branch) {
                position = index;
                break;
            }
        }
        for (int index = position + 1; index < size; index++) {
            IDrawable drawable = drawableList.get(index);
            if (drawable instanceof Branch) {
                rearBranchList.add((Branch) drawable);
            }
        }

        return rearBranchList;
    }

    public Branch addBranch(String branchName) {
        Branch branch = null;
        int branchCount = getBranchCount();
        System.out.println("Branch Count=" + branchCount);
        if (branchCount == 0) {
            //add new branch
            branch = new Branch(branchName, graphics);
            
            drawableList.add(branch);
        } else {
            //check branch not exist
            if (!isBranchExists(branchName)) {
                System.out.println("Branch not exist");
                Branch lastBranch = getLastBranch();
                int x = lastBranch.getX();
                int y = lastBranch.getY();
                int width = lastBranch.getWidth();
                int newX = x + width + BRANCH_GAP;
                int newY = y;
                System.out.println("NewX=" + newX);
                System.out.println("NewY=" + newY);
                branch = new Branch(branchName, newX, newY, graphics);
                drawableList.add(branch);
                System.out.println("New Branch=" + branch);
            } else {
                System.out.println("Branch Exist");
                branch = getBranch(branchName);
                System.out.println("Branch Found");
            }
        }
        branch.setStyle(selectedStyle);
        return branch;
    }

    public void setCurrentLevel(int currentLevel) {
        for (IDrawable drawable : drawableList) {
            if (drawable instanceof Branch) {
                Branch branch = (Branch) drawable;
                branch.setCurrentLevel(currentLevel);
            }
        }
    }

    private int getBranchCount() {
        int count = 0;
        for (IDrawable drawable : drawableList) {
            if (drawable instanceof Branch) {
                count++;
            }
        }
        return count;
    }
}
