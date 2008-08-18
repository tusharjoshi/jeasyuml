/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.ISequenceParserListener;


/**
 *
 * @author sameer.khulkhule
 */
public class SequenceParser {

    private ArrayList<IParser> parserList = new ArrayList<IParser>();
    private ArrayList<ISequenceParserListener> sequenceParserListenerList = new ArrayList<ISequenceParserListener>();
    private String lines;
     
    public SequenceParser() {
    }

    public SequenceParser(String instructions) {
        lines = instructions;
        
    }

    public void addsequenceParserListener(ISequenceParserListener sequenceParserListener) {
        sequenceParserListenerList.add(sequenceParserListener);

    }

    public void removesequenceParserListener(ISequenceParserListener sequenceParserListener) {
        sequenceParserListenerList.remove(sequenceParserListener);
    }

    public void addParser(IParser parser) {
        parserList.add(parser);
    }

    public void removeParser(IParser parser) {
        parserList.remove(parser);
    }

    public void parse() {
        String[] line = lines.split("\n");
        for (int index = 0; index < line.length; index++) {
            String singleInstruction=line[index];
            for (IParser parser : parserList) {
                parser.parse(singleInstruction);
            }
        }
        
       
    }
}
