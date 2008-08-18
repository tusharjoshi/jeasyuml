/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.IEntityParserListener;


/**
 *
 * @author sameer.khulkhule
 */
public class EntityParser implements IParser {

    public static final String keyWord = "entity";
    private ArrayList<IEntityParserListener> destroyParserListenerListList = new ArrayList<IEntityParserListener>();

    public void addEntryParserListener(IEntityParserListener entryParserListener) {
        destroyParserListenerListList.add(entryParserListener);
    }

    public void removeEntryParserListener(IEntityParserListener entryParserListener) {
        destroyParserListenerListList.remove(entryParserListener);
    }
    private String branchName;

    public void parse(String lineToParse) {

        String delims = "[ ]+";
        String[] tokens = lineToParse.split(delims);
        if (tokens.length == 2) {
            if (tokens[0].equals(keyWord)) {
                branchName = tokens[1];

            } else {
                System.out.println("Keword is not found");
            }
        } else {
            //   throw new Exception("Syntax Error");
        }
    }
}
