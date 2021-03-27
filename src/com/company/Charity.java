package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Charity {

    final private String name;
    final private List<String> attributes;

    public Charity(String name, List<String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public Set<String> convertAttributesToSet() {
        return new HashSet<>(attributes);
    }
}
