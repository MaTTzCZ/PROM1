package com.mattz.data.analysis;

import java.text.Collator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class CharAnalyzer implements Analyzer {
    @Override
    public Map<String, Integer> analyze(String text) {
        Collator collator = Collator.getInstance();
        Map<String, Integer> map = new TreeMap<>(collator);
        char[] chars = text.toCharArray();
        for (Character character : chars) {
            if (!character.toString().isBlank()) map.merge(character.toString().toLowerCase(), 1, Integer::sum);
        }
        return map;
    }
}
