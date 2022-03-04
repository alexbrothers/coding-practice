package practice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import practice.questions.FileSystemSearch;
import practice.questions.common.File;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemSearchTest {

    private static FileSystemSearch fileSystemSearch;
    private static File root;

    @BeforeAll
    public static void setUp() {
        fileSystemSearch = new FileSystemSearch();

        File file1 = new File("text_file_1.txt", 12);
        File file2 = new File("photo_1.png", 22);
        File file3 = new File("doc_1.doc", 15);
        File file4 = new File("text_file_2.txt", 30);
        File dir1 = new File("photos", 22, Arrays.asList(file2));
        File dir2 = new File("docs", 15, Arrays.asList(file3));
        File dir3 = new File("txt_files", 42, Arrays.asList(file1, file4));
        File file5 = new File("random.json", 50);

        root = new File("root", 134, Arrays.asList(dir1, file5, dir2, dir3));
    }

    @Test
    public void testSize() {
        List<File> results = fileSystemSearch.findFiles(root, file -> file.getSize() > 20);

        assertEquals(3, results.size());
    }

    @Test
    public void testExtension() {
        List<File> results = fileSystemSearch.findFiles(root, file -> file.getName().endsWith(".json"));

        assertEquals(1, results.size());
        assertEquals("random.json", results.get(0).getName());
    }

}
