package com.sortutils.entity;

public class DistanceMap<K, V> {

    public K key;
    public V value;

    public DistanceMap(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DistanceMap{" + "key=" + key + ", value=" + value + '}';
    }
}
