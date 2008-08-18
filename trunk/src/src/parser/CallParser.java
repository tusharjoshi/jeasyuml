/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import parser.event.ICallParserListener;

/**
 *
 * @author sameer.khulkhule
 */
public class CallParser implements IParser {

    private String sourceBranch;
    private String targetBranch;
    private String connectorProperty;
    private ArrayList<ICallParserListener> callParserListenerList = new ArrayList<ICallParserListener>();

    public void addCallParserListener(ICallParserListener callParserListener) {
        callParserListenerList.add(callParserListener);
    }

    public void removeCallParserListener(ICallParserListener callParserListener) {
        callParserListenerList.remove(callParserListener);
    }

    @Override
    public void parse(String lineToParse) {

        String delims = ":";
        String[] tokens = lineToParse.split(delims);
        if(tokens.length==2)
        {
            connectorProperty=tokens[1];
            delims="->";
            String nextTokens[]=tokens[0].split(delims);
            if(nextTokens.length==2)
            {
            sourceBranch=nextTokens[0];
            targetBranch=nextTokens[1];
                fireCallParsed();
            }
            else
            {
                //throw new Exception("");
            }
        }
        else
        {
            //throw new Exception
        }

    }

    public String getSourceBranch() {

        return sourceBranch;
    }

    public String getTargetBranch() {

        return targetBranch;
    }

    public String getConnectorProperty() {

        return connectorProperty;
    }

    public void fireCallParsed() {
        for (ICallParserListener callParserListener : callParserListenerList) {
            callParserListener.callParsed(this);

        }

    }
    
    public String toString()
    {
        String value="Source="+sourceBranch+"\n Target="+
                targetBranch+"\nConnector="+connectorProperty;
        return value;
    }
}
