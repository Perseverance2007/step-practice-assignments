import java.util.Scanner;

// Common behaviour shared by every payment type: adjusting the amount for fees
interface PaymentMethod {
    double getAdjustedAmount(double amount);
}

class Card implements PaymentMethod {
    public double getAdjustedAmount(double amount) {
        // 2% processing fee
        return amount + (amount * 0.02);
    }
}

class Wallet implements PaymentMethod {
    public double getAdjustedAmount(double amount) {
        // 1% processing fee
        return amount + (amount * 0.01);
    }
}

class BankTransfer implements PaymentMethod {
    public double getAdjustedAmount(double amount) {
        // no processing fee
        return amount;
    }
}

public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            PaymentMethod method;
            if (type.equals("CARD")) {
                method = new Card();
            } else if (type.equals("WALLET")) {
                method = new Wallet();
            } else {
                method = new BankTransfer();
            }

            double adjustedAmount = method.getAdjustedAmount(amount);
            System.out.printf("%s: %.2f%n", type, adjustedAmount);
            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
