package com.sortutils.entity;

/**
 * A POJO entity representing a distance map model
 *
 *
 * @author Joshua Nwankwo
 * @version 1.0
 * @since April 2019
 */

public class DistanceMap<K, V> {

    private K key;
    private V value;

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
