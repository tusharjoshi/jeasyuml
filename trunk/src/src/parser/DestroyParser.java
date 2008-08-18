/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.IDestroyParserListener;


/**
 *
 * @author sameer.khulkhule
 */
public class DestroyParser implements IParser {

    public static final String keyWord = "destroy";
    private String branchName;
    private ArrayList<IDestroyParserListener> destroyParserListenerList = new ArrayList<IDestroyParserListener>();

    public void addDestroyParserListener(IDestroyParserListener destroyParserListener) {
        destroyParserListenerList.add(destroyParserListener);
    }

    public void removeDestroyParserListener(IDestroyParserListener destroyParserListener) {
        destroyParserListenerList.remove(destroyParserListener);
    }

    public void parse(String lineToParse) {
        String delims = "[ ]+";
        String[] tokens = lineToParse.split(delims);
        if (tokens.length == 2) {
            branchName = tokens[1];
            if (tokens[0].equals(keyWord)) {
                System.out.println("destroy is found Draw" + branchName);
            } else {
                System.out.println("destroy is not found Draw");
            }
        } else {
            //throw new Exception("Syntax Error");
        }

    }
}
