/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import java.util.ArrayList;
import parser.event.IDeactivaeParserListener;


/**
 *
 * @author sameer.khulkhule
 */
public class DeactivateParser implements IParser{
    public static final String keyWord = "deactivate";
    private String branchName;
    
    
 private ArrayList <IDeactivaeParserListener> deactivaeParserListenerList=new ArrayList
	<IDeactivaeParserListener>();
 
  public void addDeactivaeParserListener(IDeactivaeParserListener deactivaeParserListener)
	{
	deactivaeParserListenerList.add(deactivaeParserListener);
	}
	 public void removeDeactivaeParserListener(IDeactivaeParserListener deactivaeParserListener)
	{
	deactivaeParserListenerList.remove(deactivaeParserListener);
	}
 
 
   public void parse(String lineToParse) {
         String delims = "[ ]+";
        String[] tokens = lineToParse.split(delims);
        if(tokens.length==2)
        {
        
           branchName=tokens[1];
            if(tokens[0].equals( keyWord))
            {
              System.out.println("deactivate is found Draw"+branchName);
            }
            else{
                System.out.println("deactivate is not found Draw");
                }
        }
     else
        {
          //throw new Exception("Syntax Error");
        }
     
    }

}
