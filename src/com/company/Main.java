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
        List<Pair> out = new ArrayList<>();

        for (Charity c : charities) {
            Set<String> charityAttributes = c.convertAttributesToSet();
            charityAttributes.retainAll(wantedAttributes);
            if (charityAttributes.size() != 0) {
                out.add(new Pair(c, charityAttributes.size()));
            }
        }

        Collections.sort(out);
        Collections.reverse(out);

        StringBuilder sb = new StringBuilder();
        sb.append("We have found some charities for YOU!\n");
        int c = 1;
        for (Pair p : out) {
            sb.append(c).append(") ").append(p.getFirst().getName()).append("\n");
            c++;
        }
        System.out.println(sb.toString());

    }

    public static List<Question> initQuestions() {
        Question q1 = new Question("Whats ur name?", Arrays.asList("Aryaman", "Navya"));
        Question q2 = new Question("How old are u?", Arrays.asList("10", "11", "12", "13"));
        return Arrays.asList(q1, q2);
    }

    public static List<Charity> initCharities() {
        Charity c1 = new Charity("Ur Mom Foundation", Arrays.asList("Navya", "10", "12"));
        Charity c2 = new Charity("Omae wa shinderou", Arrays.asList("NANI", "Navya"));
        return Arrays.asList(c2, c1);
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
