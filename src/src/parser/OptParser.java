/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.IOptParserListener;


/**
 *
 * @author sameer.khulkhule
 */
public class OptParser implements IParser {

    public static final String keyWord = "opt";
    private ArrayList<IOptParserListener> optParserListenerList = new ArrayList<IOptParserListener>();

    public void addOptParserListener(IOptParserListener optParserListener) {
        optParserListenerList.add(optParserListener);
    }

    public void removeOptParserListener(IOptParserListener optParserListener) {
        optParserListenerList.remove(optParserListener);
    }

    public void parse(String lineToParse) {
        String delims = "[ ]+";
        String[] tokens = lineToParse.split(delims);
        if (tokens.length == 1) {

            if (tokens[0].equals(keyWord)) {
                System.out.println("opt is found Draw");
            } else {
                System.out.println("opt is not found Draw");
            }
        } else {
            //throw new Exception("Syntax Error");
        }

    }
}
