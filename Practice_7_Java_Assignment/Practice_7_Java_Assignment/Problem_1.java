// Problem 1: The Piggy Bank
// Savings is private and can only change through deposit/withdraw methods.
public class Problem_1 {

    static class PiggyBank {
        private final String id;
        private double savings;

        public PiggyBank(String id) {
            this.id = id;
            this.savings = 0;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                savings += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount <= savings) {
                savings -= amount;
            } else {
                System.out.println("Withdrawal of " + amount + " rejected, insufficient savings");
            }
        }

        public double getSavings() {
            return savings;
        }

        public String getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("Starting savings: " + pb.getSavings());

        pb.deposit(100);
        System.out.println("After deposit(100): " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After withdraw(30): " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("After withdraw(500) [should be rejected]: " + pb.getSavings());

        System.out.println("Piggy Bank ID: " + pb.getId());
    }
}
