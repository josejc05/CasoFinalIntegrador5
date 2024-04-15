package information;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<Integer> binarySearchInFile(String filePath, String searchTerm) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        Collections.sort(lines);

        List<Integer> lineNumbers = new ArrayList<>();
        int start = 0;
        int end = lines.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (lines.get(mid).contains(searchTerm)) {
                lineNumbers.add(mid + 1);
                break;
            } else if (lines.get(mid).compareTo(searchTerm) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return lineNumbers;
    }
}