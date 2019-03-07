package utilities;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class InputScanner {

    private InputStream inputStream;
    private final byte buf[] = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputScanner(InputStream inputStream) {
        this.inputStream = inputStream;

    }

    public InputScanner(String fileName) throws FileNotFoundException {
        inputStream = new DataInputStream(new FileInputStream(fileName));
    }

    public int read() {
        if (numChars == -1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = inputStream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int[] readIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }
        return arr;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public char readChar() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        return (char) c;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String readLine() {
        int c = read();
        while (isNewLineChar(c)) c = read();
        StringBuilder res = new StringBuilder();
        do {
            if (c < 0) c += 256;
            res.appendCodePoint(c);
            c = read();
        } while (!isNewLineChar(c));
        return res.toString();
    }

    public String next() {
        return readString();
    }


    public boolean isSpaceChar(int c) {
        if (filter != null) return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isNewLineChar(int c) {
        if (filter != null) return filter.isNewLineChar(c);
        return c == '\n' || c == '\r' || c == -1;
    }

    public void close() {
        if (null != inputStream) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private interface SpaceCharFilter {
        boolean isSpaceChar(int ch);

        boolean isNewLineChar(int ch);
    }
}
