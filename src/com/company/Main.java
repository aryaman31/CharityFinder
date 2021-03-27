package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Question> questions = initQuestions();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> wantedAttributes = new HashSet<>();

        for (Question q : questions) {
            StringBuilder s = displayQuestion(q);
            s.deleteCharAt(s.length() - 1);
            System.out.println(s.toString());

            String inp = getInput(reader);
            while (Integer.parseInt(inp) < 0 || Integer.parseInt(inp) > q.getOptions().size())  {
                System.out.println("Invalid Input");
                inp = getInput(reader);
            }
            wantedAttributes.add(q.getOptions().get(Integer.parseInt(inp) - 1));
        }

        List<Charity> charities = initCharities();
        List<Pair<Charity, Integer>> out = new ArrayList<>();

        for (Charity c : charities) {
            Set<String> charityAttributes = c.convertAttributesToSet();
            charityAttributes.containsAll(wantedAttributes);
        }

    }

    public static List<Question> initQuestions() {
        Question q1 = new Question("Whats types of charities are you interested in?",
            Arrays.asList("saving lives", "prevention of poverty", "overseas aid",
                "education", "community development",
                "general charitable purpose", "disability", "animal welfare"));
        Question q2 = new Question("What religion would you?"
            + "prefer the charity to be affiliated with?",
            Arrays.asList("secular", "christian"));
        Question q3 = new Question("Who would you like the charity to be helping?",
            Arrays.asList("physically unwell", "children", "mankind", "refugees",
                "internationals", "mentally unwell"));
        Question q4 = new Question("Would you like the charity to be small, medium-sized"
            + "or big?", Arrays.asList("small", "medium", "big"));
        Question q5 = new Question("How long would you like the charity to have existed for",
            Arrays.asList("0-24", "50-74", "100 - 124", "175-199"));
        return Arrays.asList(q1, q2);
    }

    public static List<Charity> initCharities() {
        // TODO: do it;
        return null;
    }

    public static StringBuilder displayQuestion(Question q) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(q.getQuestion()).append("\n");
        int c = 1;
        for (String s : q.getOptions()) {
            stringBuilder.append("(").append(c).append(")");
            stringBuilder.append(s).append("\n");
            c++;
        }
        return stringBuilder;
    }

    public static String getInput(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}
