/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.IParticipantParserListener;


/**
 * 
 *  @author kamlesh paunikar
 */
public class ParticipantParser implements IParser {

    public static final String keyWord = "participant";
    private String branchName;
    private ArrayList<IParticipantParserListener> participantParserListenerrList = new ArrayList<IParticipantParserListener>();

    public void addParticipantParserListener(IParticipantParserListener participantParserListener) {
        participantParserListenerrList.add(participantParserListener);
    }

    public void removeParticipantParserListener(IParticipantParserListener participantParserListener) {
        participantParserListenerrList.remove(participantParserListener);
    }

    public void parse(String lineToParse) {
        String delims = "[ ->: ]+";
        String[] tokens = lineToParse.split(delims);
        if (tokens.length == 2) {

            branchName = tokens[1];
            if (tokens[0].equals(keyWord)) {
                System.out.println(" participant is found Draw" + branchName);
            } else {
                System.out.println("participan is not found Draw");
            }
        } else {
            //throw new Exception("Syntax Error");
        }
    }
}
