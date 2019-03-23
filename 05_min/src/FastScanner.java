import java.io.*;

public class FastScanner {
    final private int bufferSize = 1 << 12;
    private InputStreamReader inputData;
    private char[] buffer;
    private int currentPosition;
    private int cntBytes;

    public FastScanner () {
        inputData = new InputStreamReader(System.in);
        buffer = new char[bufferSize];
        currentPosition = cntBytes = 0;
    }

    public FastScanner (String fileName) throws FileNotFoundException {
        inputData = new InputStreamReader(new FileInputStream(fileName));
        buffer = new char[bufferSize];
        currentPosition = cntBytes = 0;
    }

    private void fillBuffer() throws IOException{
        cntBytes = inputData.read(buffer, 0, bufferSize);
        currentPosition = 0;
    }

    private char read() throws IOException{
        if (currentPosition == cntBytes) {
            fillBuffer();
        }
        return buffer[currentPosition++];
    }

    public String nextLine() throws IOException {
        StringBuilder line = new StringBuilder();
        int cnt = 0;
        char c = read();
        int start = currentPosition - 1;
        if (cntBytes == -1)
            return null;
        while (cntBytes != -1)
        {
            if (c == '\n')
                break;
            cnt++;
            if (currentPosition == cntBytes) {
                line.append(new String(buffer, start, cnt));
                start = 0;
                cnt = 0;
            }
            c = read();
        }

        line.append(new String(buffer, start, cnt));
        return line.toString();
    }
}
