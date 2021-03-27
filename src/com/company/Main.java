package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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
        int c = 0;
        while (c < 3 && c < out.size()) {
            Pair p = out.get(c);
            sb.append(c+1).append(") ").append(p.getFirst().getName()).append("\n");
            c++;
        }


//        for (Pair p : out) {
//            sb.append(c).append(") ").append(p.getFirst().getName()).append("\n");
//            c++;
//        }
        System.out.println(sb.toString());

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
                Arrays.asList("0-24", "50-74", "75-99", "100 - 124","125-149", "150-174","175-199"));
        return Arrays.asList(q1, q2, q3, q4, q5);
    }

    public static List<Charity> initCharities() throws IOException {
        BufferedReader fReader = new BufferedReader(new FileReader("data/charities.txt"));
        return fReader.lines().map(c -> c.split(", "))
                .map(l -> new Charity(l[0], Arrays.asList(Arrays.copyOfRange(l, 1, l.length))))
                .collect(Collectors.toList());
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
