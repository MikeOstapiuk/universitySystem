package com.mike.queryResult;

import com.mike.entity.Lector;

public class CountResult {

    private final long count;
    private final Lector.Degree degree;

    public CountResult(long count, Lector.Degree degree) {
        this.count = count;
        this.degree = degree;
    }

    public long getCount() {
        return count;
    }

    public Lector.Degree getDegree() {
        return degree;
    }
}