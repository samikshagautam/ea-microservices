package com.ea.project2.trans;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Trans {

    private static Map<String, String> translations = new HashMap<>();

    public Trans() {
        translations.put("Card is already reistered", "Card is already registered");
    }

    public String late(String key) {
        if (translations.containsKey(key)) {
            return translations.get(key);

        }
        return key;

    }
}
