/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author kamlesh paunikar
 */
public class Utility {

    private static int maximumHeight;
    public static Dimension getTextBoundingBox(Graphics graphics, String string) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        Dimension dimension = new Dimension();
        TextLayout textLayout = new TextLayout(string, graphics2D.getFont(), graphics2D.getFontRenderContext());
        Rectangle2D bounds = textLayout.getBounds();
        if(maximumHeight==0)
        {
            calculateMaximumHeight(graphics);
        }
        double height = maximumHeight;
        double width = bounds.getWidth();

        dimension.width = (int) width;
        dimension.height = (int) height;

        return dimension;
    }

    public static int calculateMaximumHeight(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        for (int i = 0; i < 256; i++) {
            String string = "" + (char) i;
            TextLayout textLayout = new TextLayout(string, graphics2D.getFont(), graphics2D.getFontRenderContext());
            Rectangle2D bounds = textLayout.getBounds();
            if (bounds.getHeight() > maximumHeight) {
                maximumHeight =(int) bounds.getHeight();
            }
        }
        return maximumHeight;
    }
}
