package com.example.simpledictionary.service;

import java.util.HashMap;
import java.util.Map;

public class AppService {
    private static Map<String, String> listMap = new HashMap<>();
    static {
        listMap.put("red" , "đỏ");
        listMap.put("blue" , "xanh");
        listMap.put("yellow" , "vàng");
    }
}
