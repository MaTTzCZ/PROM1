package com.mattz.data.analysis;

import java.util.HashMap;
import java.util.Map;

public class WordAnalyzer implements Analyzer {
    @Override
    public Map<String, Integer> analyze(String text) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : text.split("[\\s.,;!?]")) {
            if (!word.strip().trim().isEmpty()) map.merge(word.toLowerCase(), 1, Integer::sum);
        }
        return map;
    }
}
