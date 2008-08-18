/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.IEndParserListener;


/**
 *
 * @author sameer.khulkhule
 */
public class EndParser implements IParser {

    public static final String keyWord = "end";
    private ArrayList<IEndParserListener> endParserListenerList = new ArrayList<IEndParserListener>();

    public void addEndParserListener(IEndParserListener endParserListener) {
        endParserListenerList.add(endParserListener);
    }

    public void removeEndParserListener(IEndParserListener endParserListener) {
        endParserListenerList.remove(endParserListener);
    }

    public void parse(String lineToParse) {
        String delims = "[ ]+";
        String[] tokens = lineToParse.split(delims);
        if (tokens.length == 1) {
            if (tokens[0].equals(keyWord)) {
                System.out.println("The key word is found" + keyWord);
            }
        }
    }
}
