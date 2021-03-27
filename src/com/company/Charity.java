package com.company;

import java.util.List;

public class Charity {

    final String name;
    final List<String> attributes;

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
}
