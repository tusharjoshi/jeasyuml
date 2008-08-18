/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.IActivateParserListener;


/**
 *
 * @author sameer.khulkhule
 */
public class ActivateParser implements IParser {

    public static final String keyWord = "activate";
    private String branchName;
    private ArrayList<IActivateParserListener> activateParserListenerList = new ArrayList<IActivateParserListener>();

    public void addactivateParseListener(IActivateParserListener activateParserListener) {
        activateParserListenerList.add(activateParserListener);
    }

    public void removeactivateParseListener(IActivateParserListener activateParserListener) {
        activateParserListenerList.remove(activateParserListener);
    }

    public void parse(String lineToParse) {
        String delims = "[ ]+";
        String[] tokens = lineToParse.split(delims);
        if (tokens.length == 2) {
            branchName = tokens[1];
            if (tokens[0].equals("activate")) {
                System.out.println("activate is found Draw" + branchName);
            } else {
                System.out.println("activate is not found Draw");
            }
        } else {
                 //throw new Exception("Syntax Error");
        }

    }
}
