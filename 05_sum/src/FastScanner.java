import java.io.*;

public class FastScanner {
    final private int BUFFER_SIZE = 1 << 12;
    private DataInputStream inputData;
    private byte[] buffer;
    private int currentPosition;
    private int cntChars;

    public FastScanner () {
        inputData = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        currentPosition = cntChars =  0;
    }

    public FastScanner (String fileName) throws FileNotFoundException {
        inputData = new DataInputStream(new FileInputStream(fileName));
        buffer = new byte[BUFFER_SIZE];
        currentPosition = cntChars = 0;
    }

    private void fillBuffer() {
        try {
            cntChars = inputData.read(buffer, 0, BUFFER_SIZE);
            currentPosition = 0;
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public String nextLine() {
        StringBuilder line = new StringBuilder();

        int startPosition = currentPosition;
        int symbolsCount = 0;
        char currentSymbol = (char) buffer[currentPosition++];

        while (cntChars != -1)
        {
            if (currentSymbol == '\n')
                break;
            symbolsCount++;
            if (currentPosition == cntChars) {
                line.append(new String(buffer, startPosition, symbolsCount));
                fillBuffer();
                startPosition = 0;
                symbolsCount = 0;
            }
            currentSymbol = (char) buffer[currentPosition++];
        }

        line.append(new String(buffer, startPosition, symbolsCount));
        return line.toString();
    }
    public boolean hasNextLine() {
        if (currentPosition == cntChars) {
            fillBuffer();
        }
        if (cntChars == -1) {
            return false;
        } else {
            return true;
        }
    }
}
