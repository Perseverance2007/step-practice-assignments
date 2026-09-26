import java.util.Scanner;

// Common behaviour shared by every delivery type: calculating the fee
interface Delivery {
    double calculateFee();
}

class StandardDelivery implements Delivery {
    private double weight;
    private double distance;

    public StandardDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        // Base $5, plus $0.50 per kg, plus $0.10 per km
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery implements Delivery {
    private double weight;
    private double distance;

    public ExpressDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public double calculateFee() {
        // Base $15, plus $1.00 per kg, plus $0.20 per km
        return 15.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery implements Delivery {
    private double weight;
    private double distance;
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        // Base $25, plus $2.00 per kg, plus $0.50 per km, plus CustomsFee
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class Problem_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            Delivery delivery;
            if (type.equals("STANDARD")) {
                delivery = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                delivery = new ExpressDelivery(weight, distance);
            } else {
                double customsFee = Double.parseDouble(parts[3]);
                delivery = new InternationalDelivery(weight, distance, customsFee);
            }

            double fee = delivery.calculateFee();
            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
