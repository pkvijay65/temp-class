package interfaces;

/**
 * Class implementing an interface that extends multiple interfaces.
 * Must implement all methods from the inheritance chain.
 */
public class FileHandler implements ReadWritable {
    private String filename;
    private String content = "";

    public FileHandler(String filename) {
        this.filename = filename;
    }

    @Override
    public String read() {
        System.out.println("Reading from " + filename);
        return content;
    }

    @Override
    public void write(String data) {
        System.out.println("Writing to " + filename);
        this.content = data;
    }

    @Override
    public void readAndWrite(String inputFile, String outputFile) {
        System.out.println("Reading from " + inputFile + " and writing to " + outputFile);
    }

    public String getFilename() {
        return filename;
    }
}
