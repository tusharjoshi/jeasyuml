package gui;


import java.io.File;
import java.util.Iterator;
import javax.swing.JFileChooser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Administrator
 */
public class SaveDialog extends JFileChooser implements IFileTypeListener {

    private int selectedFileType;

    public SaveDialog() {
    }

    public void SetDialog() {
        ChooseFileTypeDialog chooseFileTypeDialog = (ChooseFileTypeDialog) this.getAccessory();
        chooseFileTypeDialog.addFileTypeListener(this);
    }

    public void SetFileChooser(int selectedFileType) {
        this.selectedFileType = selectedFileType;
    }

    public void SetFileType() {
        FileFilter[] choosableFileFilters = this.getChoosableFileFilters();
        if (choosableFileFilters != null) {
            for (int index = 0; index < choosableFileFilters.length; index++) {
                this.removeChoosableFileFilter(choosableFileFilters[index]);

            }
        }
        if (selectedFileType == 1) {
            this.setFileFilter(new FileFilter() {

                @Override
                public boolean accept(File f) {
                    return true;
                }

                @Override
                public String getDescription() {
                    return "Text File(*.txt)";
                }
            });
        }
        if (selectedFileType == 2) {
            this.setFileFilter(new FileFilter() {

                @Override
                public boolean accept(File f) {
                    return true;
                }

                @Override
                public String getDescription() {
                    
                    return "Image File(*.jpg,*.png,*.bmp,*.gif,*.tiff)";
                }
            });
        }
        if (selectedFileType == 3) {
            this.setFileFilter(new FileFilter() {

                @Override
                public boolean accept(File f) {
                    return true;
                }

                @Override
                public String getDescription() {
                    return "Custom File(*.kpf)";
                }
            });
        }
    }
}
