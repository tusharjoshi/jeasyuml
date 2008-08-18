/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import application.IAppContext;
import drawing.IDrawingManager;
import parser.event.IActivateParserListener;
import parser.event.ICallParserListener;
import parser.event.IDeactivaeParserListener;
import parser.event.IDestroyParserListener;
import parser.event.IEndParserListener;
import parser.event.IEntityParserListener;
import parser.event.ILoopParserListener;
import parser.event.IOptParserListener;
import parser.event.IParticipantParserListener;
import parser.event.ISequenceParserListener;

/**
 *
 * @author kamlesh paunikar
 */
public class SequenceParserManager implements ISequenceParserManager,ISequenceParserListener,ICallParserListener,
        IActivateParserListener,IDeactivaeParserListener,IDestroyParserListener,
        IEndParserListener,IEntityParserListener,ILoopParserListener,IOptParserListener,
        IParticipantParserListener
{
    private IAppContext appContext;
    private IDrawingManager drawingManager;

    public SequenceParserManager(IAppContext appContext)
    {
        this.appContext=appContext;
        drawingManager = appContext.getDrawingManager();
    }

    @Override
    public void parse(String instructions)
    {
     SequenceParser sp=new SequenceParser(instructions);
     sp.addsequenceParserListener(this);
     
     
     CallParser callParser=new CallParser();
     callParser.addCallParserListener(this);
     
     ActivateParser activateParser=new ActivateParser();
     activateParser.addactivateParseListener(this);
     
     DeactivateParser deactivateParser=new DeactivateParser();
     deactivateParser.addDeactivaeParserListener(this);
     
     DestroyParser destroyParser=new DestroyParser();
     destroyParser.addDestroyParserListener(this);
     
     EndParser endParser=new EndParser();
     endParser.addEndParserListener(this);
     
     EntityParser entityParser=new EntityParser();
     entityParser.addEntryParserListener(this);
     
     LoopParser loopParser=new LoopParser();
     loopParser.addLoopParserListener(this);
     
     OptParser optParser=new OptParser();
     optParser.addOptParserListener(this);
     
     ParticipantParser participantParser=new ParticipantParser();
     participantParser.addParticipantParserListener(this);
     
     sp.addParser(callParser);
     sp.addParser(activateParser);
     sp.addParser(deactivateParser);
     sp.addParser(destroyParser); 
     sp.addParser(endParser);
     sp.addParser(entityParser);
     sp.addParser(loopParser);
     sp.addParser(optParser);
     sp.addParser(participantParser);
     sp.parse();
     
    }
  
    @Override
    public void parsingCompleted(int successCode) {
        System.out.println("Parsing Completed");
    }

    @Override
    public void callParsed(CallParser callParser) {
        String sourceBranch = callParser.getSourceBranch();
        String targetBranch = callParser.getTargetBranch();
        String connectorProperty = callParser.getConnectorProperty();
        drawingManager.addCall(sourceBranch, targetBranch, connectorProperty);
    }

    @Override
    public void activateParser(ActivateParser activateParser) {
       System.out.println("ActivateParser Statement parsing done.");
    }

    @Override
    public void deactivateParsed(DeactivateParser deactivateParser) {
         System.out.println("DeactivateParser Statement parsing done.");
    }

    @Override
    public void destroyParser(DestroyParser destroyParser) {
         System.out.println("DestroyParserStatement parsing done.");
    }

    @Override
    public void endParsed(EndParser endParser) {
         System.out.println("EndParser Statement parsing done.");
    }

    @Override
    public void entityParsed(EntityParser entityParser) {
         System.out.println("EntityParser Statement parsing done.");
    }

    @Override
    public void loopParsed(LoopParser loopParser) {
         System.out.println("LoopParser Statement parsing done.");
    }

    @Override
    public void optParsed(OptParser optParser) {
         System.out.println("OptParser Statement parsing done.");
    }

    @Override
    public void participantParsed(ParticipantParser participantParser) {
         System.out.println("ParticipantParser Statement parsing done.");
    }

}
