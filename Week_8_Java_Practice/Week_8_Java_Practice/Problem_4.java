import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Common behaviour shared by every question type: grading the student's answer
interface Question {
    double calculateScore(String correctAnswer, String studentAnswer, int points);
}

class MCQQuestion implements Question {
    public double calculateScore(String correctAnswer, String studentAnswer, int points) {
        // Full points only on an exact match
        return correctAnswer.equals(studentAnswer) ? points : 0.0;
    }
}

class TFQuestion implements Question {
    public double calculateScore(String correctAnswer, String studentAnswer, int points) {
        // Full points only on an exact match
        return correctAnswer.equals(studentAnswer) ? points : 0.0;
    }
}

class EssayQuestion implements Question {
    public double calculateScore(String correctAnswer, String studentAnswer, int points) {
        // CorrectAnswer is a comma-separated list of keywords
        String[] keywords = correctAnswer.split(",");
        String studentLower = studentAnswer.toLowerCase();

        int matchCount = 0;
        for (String keyword : keywords) {
            String keywordLower = keyword.trim().toLowerCase();
            if (!keywordLower.isEmpty() && studentLower.contains(keywordLower)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class Problem_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalScore = 0.0;

        // Pattern to pull out the three quoted fields on each line
        Pattern quotedPattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            // The question type is the word before the first quote
            String type = line.substring(0, line.indexOf('"')).trim();

            Matcher matcher = quotedPattern.matcher(line);
            List<String> quoted = new ArrayList<>();
            while (matcher.find()) {
                quoted.add(matcher.group(1));
            }

            // quoted.get(0) = QuestionText, quoted.get(1) = CorrectAnswer,
            // quoted.get(2) = StudentAnswer
            String correctAnswer = quoted.get(1);
            String studentAnswer = quoted.get(2);

            // Points come after the last closing quote
            String pointsText = line.substring(line.lastIndexOf('"') + 1).trim();
            int points = Integer.parseInt(pointsText);

            Question question;
            if (type.equals("MCQ")) {
                question = new MCQQuestion();
            } else if (type.equals("TF")) {
                question = new TFQuestion();
            } else {
                question = new EssayQuestion();
            }

            double score = question.calculateScore(correctAnswer, studentAnswer, points);
            System.out.printf("%s: %.2f%n", type, score);
            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
        sc.close();
    }
}
