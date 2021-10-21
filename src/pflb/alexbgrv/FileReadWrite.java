package pflb.alexbgrv;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReadWrite {
    private PrintStream out = new PrintStream(new FileOutputStream("log.txt", true));

    public FileReadWrite() throws FileNotFoundException {
    }

    public void logWriter(String readLine) {
        this.out.append(readLine + "\n");
    }

    public int getLastGameId() throws IOException {
        int gameId = 1;
        List<String> lines = Files.readAllLines(Path.of("log.txt"));
        Pattern pattern = Pattern.compile("(.+?[№])(\\d+)");
        Matcher matcher = pattern.matcher(lines.toString());
        while (matcher.find()) {
            gameId = Integer.valueOf(matcher.group(2)) + 1;
        }
        return gameId;
    }

}
