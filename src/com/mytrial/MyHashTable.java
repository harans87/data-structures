package com.mytrial;

import java.util.Map;

public class MyHashTable<K,V> {
    V value;
    K key;
    int hash;
    int index;
    MyEntry<?,?>[] table;
    int initialCapacity = 10;

    MyHashTable() {
        this.table = new MyEntry<?,?>[initialCapacity];
    }

    void put(K key, V value) {
        this.hash = myHashCode(key);
        this.key = key;
        this.index = hash;
        //existing entry
        if (this.table[index] != null && this.table[index].getKey() == key) {
            MyEntry<K,V> entry = (MyEntry<K,V>)table[index];
            V old = entry.getValue();
            entry.value = value;
            return;
        }
        // collision
        if (this.table[index] != null && this.table[index].getKey() != key) {
            // open addressing
            this.hash= myHashCode(key) - 1;
            this.index = this.hash;
            if (this.hash > initialCapacity) {
                initialCapacity+=10;
            }
        }
        this.table[index] = new MyEntry(hash, key, value);
    }

    public V get(K key) {
        if (key == null) throw new NullPointerException();
        int hashCode = myHashCode(key);
        if (this.table[index] != null && this.table[index].getKey() != key) {
            // open addressing
            this.hash= myHashCode(key) - 1;
            this.index = this.hash;
            return (V) table[index].getValue();
        }
        int index = hashCode;
        return (V) table[index].getValue();
    }

    int myHashCode(K key) {
        return key.hashCode() % table.length;
    }

    public static class MyEntry<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;

        MyEntry(int hash, K key2, V value2) {
            this.hash = hash;
            this.key = key2;
            this.value = value2;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value2) {
            if (value2 == null)
                throw new NullPointerException();

            V oldValue = this.value;
            this.value = value2;
            return oldValue;
        }
    }

}
