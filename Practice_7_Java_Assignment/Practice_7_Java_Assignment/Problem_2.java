// Problem 2: The Quiz Scorecard
// Results are stored privately; only the total score is ever revealed.
public class Problem_2 {

    static class Scorecard {
        private final boolean[] results;
        private int recordedCount;

        public Scorecard(int totalQuestions) {
            results = new boolean[totalQuestions];
            recordedCount = 0;
        }

        public void recordAnswer(boolean correct) {
            if (recordedCount < results.length) {
                results[recordedCount] = correct;
                recordedCount++;
            } else {
                System.out.println("Cannot record: all questions already answered");
            }
        }

        public int getScore() {
            int score = 0;
            for (int i = 0; i < recordedCount; i++) {
                if (results[i]) {
                    score++;
                }
            }
            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
