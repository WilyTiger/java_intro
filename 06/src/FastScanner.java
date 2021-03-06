import java.io.*;


public class FastScanner implements AutoCloseable {
    final private int bufferSize = 1 << 12;
    private InputStreamReader inputData;
    private char[] buffer;
    private int currentPosition;
    private int cntChars;

    public FastScanner () {
        inputData = new InputStreamReader(System.in);
        buffer = new char[bufferSize];
        currentPosition = cntChars =  0;
    }

    public FastScanner (String fileName) throws FileNotFoundException {
        inputData = new InputStreamReader(new FileInputStream(fileName));
        buffer = new char[bufferSize];
        currentPosition = cntChars = 0;
    }

    private void fillBuffer() {
        try {
            cntChars = inputData.read(buffer, 0, bufferSize);
            currentPosition = 0;
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public String nextLine() {
        StringBuilder line = new StringBuilder();

        if (currentPosition == cntChars) {
            fillBuffer();
            if (cntChars == -1)
                return null;
        }

        int startPosition = currentPosition;
        int symbolsCount = 0;
        char currentSymbol = buffer[currentPosition++];

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
            currentSymbol = buffer[currentPosition++];
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

    public void close() {
        try {
            inputData.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
