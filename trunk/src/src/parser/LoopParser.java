/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.ILoopParserListener;

/**
 *
 * @author sameer.khulkhule
 */
public class LoopParser implements IParser {

    private String keyWord;
    private ArrayList<ILoopParserListener> loopParserListenerList = new ArrayList<ILoopParserListener>();

    public void addLoopParserListener(ILoopParserListener loopParserListener) {
        loopParserListenerList.add(loopParserListener);
    }

    public void removeLoopParserListener(ILoopParserListener loopParserListener) {
        loopParserListenerList.remove(loopParserListener);
    }

    public void parse(String lineToParse) {
        String delims = "[ ]+";
        String[] tokens = lineToParse.split(delims);

        keyWord = tokens[0];

        if (keyWord.equals("loop")) {
            System.out.println("loop is found Draw" + lineToParse.substring(6));
        } else {
            System.out.println("loop is not found Draw");
        }


    }
}
