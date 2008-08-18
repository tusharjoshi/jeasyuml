/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.drawing;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author kamlesh paunikar
 */
public interface IStyleConstants {

    public enum StyleList {

        PlainUML, Rose, qsd, mscgen, Omegapple,BlueModern, GreenEarth, RoundGreen
    };
    public final static int DEFAULT_LINE_THICKNESS = 1;
    
    public final static Color DEFAULT_COLOR = Color.BLACK;
    
    public final static Color DEFAULT_FILL_COLOR = Color.WHITE;
    
    public final static int DEFAULT_SHAPE = 0;
    
    public final static int SOLID_STYLE=1;
    public final static int DASHED_STYLE=2;
    public final static int DOTTED_STYLE=3;
    public final static int DASHED_DOT_STYLE=4;
    public final static int DEFAULT_STYLE=SOLID_STYLE;
    
    public final static String fontList[]={
        "verdana","arial","monospaced","dialog","dialoginput"
    };
    public final static String DEFAULT_FONT=fontList[0];
    
    public final static int FONT_PLAIN=Font.PLAIN;
    public final static int FONT_BOLD=Font.BOLD;
    public final static int FONT_ITALIC=Font.ITALIC;
    public final static int DEFAULT_FONT_STYLE=FONT_PLAIN;
    
    public final static int LARGE_FONT_SIZE=12;
    public final static int MEDIUM_FONT_SIZE=8;
    public final static int SMALL_FONT_SIZE=4;
    public final static int DEFAULT_FONT_SIZE=MEDIUM_FONT_SIZE;
}
