/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser.event;

import parser.NoteParser;


/**
 *
 * @author sameer.khulkhule
 */
public interface INoteParserListener {
void noteParsed(NoteParser noteParser);
}
