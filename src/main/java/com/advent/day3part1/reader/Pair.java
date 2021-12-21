package com.advent.day3part1.reader;

public class Pair {
    private String key;
    private Integer value;

    public Pair(String key, Integer value){
        setKey(key);
        setValue(value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
