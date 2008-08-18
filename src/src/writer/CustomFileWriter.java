package writer;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 *
 * @author kamlesh paunikar
 */
public class CustomFileWriter {

    private ObjectOutputStream objectOutputStream;

    public CustomFileWriter(File fileToWrite) throws FileNotFoundException, IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileToWrite);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
    }

    public void writeObject(Object object) throws IOException {

        if (objectOutputStream != null) {
            objectOutputStream.writeObject(object);
        }
    }
    public void closeFile() throws IOException
    {
        if(objectOutputStream!=null)
        {
            objectOutputStream.close();
        }
    }
}
