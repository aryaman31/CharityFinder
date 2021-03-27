package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Question> questions = initQuestions();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> wantedAttributes = new ArrayList<>();

        for (Question q : questions) {
            displayQuestion(q);
            String inp = getInput(reader);
            while (Integer.parseInt(inp) < 0 || Integer.parseInt(inp) > q.getOptions().size() + 1)  {
                System.out.println("Invalid Input");
                inp = getInput(reader);
            }

            wantedAttributes.add(q.getOptions().get(Integer.parseInt(inp) - 1));
        }



    }

    public static List<Question> initQuestions() {
        // TODO: Create the questions
        return null;
    }

    public static void displayQuestion(Question q) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(q.getQuestion()).append("\n");
        int c = 1;
        for (String s : q.getOptions()) {
            stringBuilder.append("(").append(c).append(")");
            stringBuilder.append(s).append("\n");
            c++;
        }
        System.out.println(stringBuilder.toString());
    }

    public static String getInput(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}
