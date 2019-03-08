package utilities;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class OutputWriterHelper {

    private final PrintWriter writer;

    public OutputWriterHelper(OutputStream stream) {
        this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(stream)));
    }

    public OutputWriterHelper(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void println(Object... objects) {
        print(objects);
        writer.println();
    }

    public void flush() {
        writer.flush();
    }

    public void close() {
        writer.close();
    }
}
