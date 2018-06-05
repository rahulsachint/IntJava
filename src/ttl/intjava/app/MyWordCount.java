package ttl.intjava.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rmadan on 6/5/18.
 */
public class MyWordCount {

    public static void main(String[] args) throws IOException {

        Stream<String> stream = Files.lines(Paths.get("resources/oliver-twist-vol1.txt"));
        // stream.forEach(System.out::println);

        Stream<String> tokens = stream.flatMap(str -> Arrays.stream(str.split("\\W")));
//        Map<String, Long> outputMap = tokens
//                .map(token -> token.replaceAll("[^a-zA-Z0-9]+", "").trim())
//                .filter(token -> !token.isEmpty())
//                .collect(Collectors.groupingBy(token -> token, Collectors.counting()));

        Map<String, Long> outputMap = tokens
            .map(token -> token.replaceAll("[^a-zA-Z0-9]+", "").trim())
            .filter(token -> !token.isEmpty())
            .collect(Collectors.groupingBy(
                    token -> token,
                    TreeMap::new,               // () -> new TreeMap<>(),
                    Collectors.counting()));




//        Map<String, Integer> outputMap = tokens
//                .map(token -> token.replaceAll("[^a-zA-Z0-9]+", "").trim())
//                .filter(token -> !token.isEmpty())
//                .collect(
//                () -> {
//                    return new HashMap<>();
//                },
//                (wordMap, word) -> {
//                    if (wordMap.containsKey(word)) {
//                        int wordCount = wordMap.get(word);
//                        wordMap.put(word, wordCount + 1);
//                    } else {
//                        wordMap.put(word, 1);
//                    }
//                },
//                (map1, map2) -> {
//                    map2.forEach(
//                        (k, v) -> {
//                            if (map1.containsKey(k)) {
//                                int map1Count = map1.get(k);
//                                map1.put(k, map1Count + v);
//                            }
//                        }
//                    );
//                });


        // TREE MAP COMPARATOR
        Comparator<String> cs = (k1, k2) -> {
            long v1 = outputMap.get(k1);
            long v2 = outputMap.get(k2);
            int ret = (int) (v2 - v1);
            // NEED TO DO THIS
            if (ret == 0) {
                ret = k1.compareTo(k2);
            }
            return ret;
        };

        Map<String, Long> sortedMap = new TreeMap<>(cs);
        sortedMap.putAll(outputMap);

        sortedMap.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("TOTAL UNIQUE WORD COUNT: " + outputMap.size());
        int totalWordCount = sortedMap.values().stream().mapToInt(i -> i.intValue()).sum();
        System.out.println("TOTAL WORD COUNT: " + totalWordCount);

//        int totalWordCount = outputMap.values().stream().collect()

    }
}
