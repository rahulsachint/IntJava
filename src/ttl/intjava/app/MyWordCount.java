package ttl.intjava.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by rmadan on 6/5/18.
 */
public class MyWordCount {

    public static void main(String[] args) throws IOException {

        Stream<String> stream = Files.lines(Paths.get("dd"));

    }
}
