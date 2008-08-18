package reader;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Administrator
 */
public class CustomFileReader {

    private ObjectInputStream objectInputStream;
    private Object object;

    public CustomFileReader(File fileToRead) throws FileNotFoundException, IOException {
        System.out.println("file to read "+fileToRead);
        FileInputStream fileInputStream = new FileInputStream(fileToRead);
        System.out.println("Step 1");
        objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println("Step 2");
    }

    public void readObject() throws IOException, ClassNotFoundException {
        if (objectInputStream != null) {
            object = objectInputStream.readObject();
        }
    }

    public Object getfileObject() {
        return object;
    }

    public void closeFile() throws IOException {
        if (objectInputStream != null) {
            objectInputStream.close();
        }
    }
}
