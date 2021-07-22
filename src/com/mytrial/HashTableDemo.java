package com.mytrial;

import java.util.LinkedHashMap;

public class HashTableDemo {

    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap<>();
        
        MyHashTable<String, String> myHashTable = new MyHashTable<>();
        myHashTable.put("key", "value");
        myHashTable.put("key2", "value2");
        myHashTable.put("key", "overrideValue");

        System.out.println("my hash table -->"+myHashTable.get("key"));
        System.out.println("my hash table entry 2 -->"+myHashTable.get("key2"));
    }
    
}
