/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.IAltParserListener;

/**
 *
 * @author sameer.khulkhule
 */
public class AltParser implements IParser {

    public static final String keyWord = "alt";
    private String message;
    private ArrayList<IAltParserListener> altParserListenerList = new ArrayList<IAltParserListener>();

    public void addAltParserListener(IAltParserListener altParserListener) {
        altParserListenerList.add(altParserListener);
    }

    public void removeAltParserListener(IAltParserListener altParserListener) {
        altParserListenerList.remove(altParserListener);
    }

    public void parse(String lineToParse) {

        String delims = "[ ]+";
        String[] tokens = lineToParse.split(delims);


        if (tokens[0].equals(keyWord)) {
            message = lineToParse.substring(5);
            System.out.println("alt is found");
        } else {
            System.out.println("alt is not found");
        }


    }
}
