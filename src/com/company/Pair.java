package com.company;

import java.util.Comparator;

public class Pair implements Comparable<Pair> {

    private Charity first;
    private Integer second;

    public Pair(Charity first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Charity getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setFirst(Charity first) {
        this.first = first;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        return second - o.getSecond();
    }
}
