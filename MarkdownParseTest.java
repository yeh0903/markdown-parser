import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testMarkdownParse1() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(links, List.of("https://something.com", "some-thing.html"));
    }

    @Test
    public void testMarkdownParse2() throws IOException {
        Path fileName = Path.of("new.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(links, List.of("http://google.com/", "somthing.html"));
    }

    @Test
    public void testMarkdownParse3() throws IOException {
        Path fileName = Path.of("new2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(links, List.of());
    }

    @Test
    public void testMarkdownParse4() throws IOException {
        Path fileName = Path.of("new3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(links, List.of("123.jpeg"));
    }
}