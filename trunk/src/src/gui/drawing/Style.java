/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.drawing;

import java.awt.Color;

/**
 *
 * @author kamlesh paunikar
 */
public class Style implements IStyleConstants{

    private StyleList styleName=StyleList.PlainUML;
    private int lineThickness=DEFAULT_LINE_THICKNESS;
    private Color color=DEFAULT_COLOR;
    private Color fillColor=DEFAULT_FILL_COLOR;
    private int shape=DEFAULT_SHAPE;
    private int lineStyle=DEFAULT_STYLE;
    private String fontName=DEFAULT_FONT;
    private int fontStyle=DEFAULT_FONT_STYLE;
    private int fontSize=DEFAULT_FONT_SIZE;
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public int getLineThickness() {
        return lineThickness;
    }

    public void setLineThickness(int lineThickness) {
        this.lineThickness = lineThickness;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    public int getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(int lineStyle) {
        this.lineStyle = lineStyle;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public StyleList getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleList styleName) {
        this.styleName = styleName;
    }
    
}
