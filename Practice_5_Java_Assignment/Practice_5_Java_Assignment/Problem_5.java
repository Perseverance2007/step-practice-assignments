// Problem 5: Placement Drive Shortlisting & Ranking Engine
import java.util.Arrays;

public class Problem_5 {

    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;
        double compositeScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            // composite score gives CGPA more weight than the coding test
            this.compositeScore = (cgpa * 10) + (codingScore * 0.5);
        }

        @Override
        public int compareTo(Candidate other) {
            // Descending order by composite score
            return Double.compare(other.compositeScore, this.compositeScore);
        }
    }

    // Quick filter: a strong CGPA alone is enough
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Combined filter: a borderline CGPA can still qualify with a good coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return (cgpa >= 6.5 && cgpa < 7.5) && (codingScore >= 60);
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] temp = new Candidate[candidates.length];
        int count = 0;

        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                temp[count] = c;
                count++;
            }
        }

        Candidate[] shortlisted = Arrays.copyOf(temp, count);
        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1).append(". ")
                  .append(shortlisted[i].name)
                  .append(" (").append(shortlisted[i].compositeScore).append(")");
            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
