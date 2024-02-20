package com.example.simpledictionary.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AppService{
    private Map<String, String> dictionary;

    public AppService() {
        dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
    }

    public String translate(String englishWord) {
        return dictionary.getOrDefault(englishWord.toLowerCase(), "Không tìm thấy từ trong từ điển.");
    }
}
