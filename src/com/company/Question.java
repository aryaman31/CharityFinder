package com.company;

import java.util.List;

public class Question {

    final private List<String> options;
    final private String question;

    public Question(String question, List<String> options) {
        this.options = options;
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getQuestion() {
        return question;
    }
}
