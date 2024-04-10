package information;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextSearcher {

    public List<Integer> searchInFile(String filePath, String searchTerm) throws IOException {
        List<Integer> lineNumbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchTerm)) {
                    lineNumbers.add(lineNumber);
                }
                lineNumber++;
            }
        }
        return lineNumbers;
    }
}