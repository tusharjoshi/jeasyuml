/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.INoteParserListener;

/**
 *
 * @author sameer.khulkhule
 */
public class NoteParser implements IParser {

    private ArrayList<INoteParserListener> noteParserListenerList = new ArrayList<INoteParserListener>();

    public void addNoteParserListener(INoteParserListener noteParserListener) {
        noteParserListenerList.add(noteParserListener);
    }

    public void removeNoteParserListener(INoteParserListener noteParserListener) {
        noteParserListenerList.remove(noteParserListener);
    }
    private String keyWord;
    private String message;

    public void parse(String lineToParse) {

        String delims = "[:]+";
        String[] tokens = lineToParse.split(delims);
        keyWord = tokens[0];
        message = tokens[1];

        if (keyWord == "note right") {
            System.out.println("Dra on right" + tokens[1]);
        }

        if (keyWord == "note on left") {
            System.out.println("Dra on right" + tokens[1]);
        }
        if (keyWord == "note on right") {
            System.out.println("Dra on right" + tokens[1]);
        }
    }
}
