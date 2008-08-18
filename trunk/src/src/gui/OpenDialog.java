package gui;


import java.io.File;
import java.io.FileFilter;
import javax.swing.JFileChooser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class OpenDialog extends JFileChooser {

  private final  String IMAGEFILETYPE="Image File(*.jpg,*.png,*.bmp,*.gif,*.tiff)";
  private final  String TEXTFILETYPE="Text File(*.txt)";
  private final  String CUSTOMFILETYPE="Custom File(*.kpf)";
  
 
  
    public void SetFileType() {
       this.setFileFilter(new javax.swing.filechooser.FileFilter() {

            @Override
            public boolean accept(File f) {
                return true;
            }

            @Override
            public String getDescription() {
                return IMAGEFILETYPE;
            }
        });
          this.setFileFilter(new javax.swing.filechooser.FileFilter() {

            @Override
            public boolean accept(File f) {
                return true;
            }

            @Override
            public String getDescription() {
                return TEXTFILETYPE;
            }
        });
          this.setFileFilter(new javax.swing.filechooser.FileFilter() {

            @Override
            public boolean accept(File f) {
                return true;
            }

            @Override
            public String getDescription() {
                return CUSTOMFILETYPE;
            }
        });
    }    
}
