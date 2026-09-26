import java.util.Scanner;

// Common behaviour shared by every transport type: calculating the fare
interface Transport {
    double calculateFare();
}

class Bus implements Transport {
    private double distance;

    public Bus(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        // Base $2, plus $0.10 per km, capped at $10
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
}

class Train implements Transport {
    private double distance;

    public Train(double distance) {
        this.distance = distance;
    }

    public double calculateFare() {
        // Base $3, plus $0.15 per km
        return 3.0 + (0.15 * distance);
    }
}

class Metro implements Transport {
    private double distance;
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare() {
        // (Base $1.50 + $0.20 per km) multiplied by the peak hour factor
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class Problem_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            Transport transport;
            if (type.equals("BUS")) {
                transport = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                transport = new Train(distance);
            } else {
                double peakHourFactor = Double.parseDouble(parts[2]);
                transport = new Metro(distance, peakHourFactor);
            }

            double fare = transport.calculateFare();
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
