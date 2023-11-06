package lab_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyWordCount {
    public static final String fileName = "data/fit.txt";
    private List<String> words = new ArrayList<>();

    public MyWordCount() {
        try {
            this.words.addAll(loadWords(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<WordCount> getWordCounts() {
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        List<WordCount> wordCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            wordCounts.add(new WordCount(entry.getKey(), entry.getValue()));
        }

        return wordCounts;
    }

    public Set<String> getUniqueWords() {
        return new HashSet<>(words);
    }

    public Set<String> getDistinctWords() {
        return new LinkedHashSet<>(words);
    }

    public Set<WordCount> exportWordCounts() {
        List<WordCount> wordCounts = getWordCounts();
        return new TreeSet<>(wordCounts);
    }

    public Set<WordCount> exportWordCountsOrderByOccurence() {
        List<WordCount> wordCounts = getWordCounts();
        wordCounts.sort(Comparator.comparingInt(WordCount::getCount).reversed());
        return new LinkedHashSet<>(wordCounts);
    }

    public Set<WordCount> filterWords(String pattern) {
        Set<WordCount> filteredWordCounts = new HashSet<>();

        for (String word : words) {
            if (!word.startsWith(pattern)) {
                int count = Collections.frequency(words, word);
                filteredWordCounts.add(new WordCount(word, count));
            }
        }

        return filteredWordCounts;
    }

    private List<String> loadWords(String fileName) throws FileNotFoundException {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.trim().split("\\s+");
                words.addAll(Arrays.asList(tokens));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    public static void main(String[] args) {
        MyWordCount wordCount = new MyWordCount();

        List<WordCount> wordCounts = wordCount.getWordCounts();
        for (WordCount wc : wordCounts) {
            System.out.println(wc.getWord() + " - " + wc.getCount());
        }
    }


}
