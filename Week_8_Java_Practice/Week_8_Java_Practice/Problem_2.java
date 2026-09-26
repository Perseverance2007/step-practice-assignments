import java.time.LocalDate;
import java.util.Scanner;

// Common behaviour shared by every library item type: the borrowing period
interface LibraryItem {
    int getLoanPeriodDays();
}

class Book implements LibraryItem {
    public int getLoanPeriodDays() {
        return 14;
    }
}

class DVD implements LibraryItem {
    public int getLoanPeriodDays() {
        return 7;
    }
}

class Magazine implements LibraryItem {
    public int getLoanPeriodDays() {
        return 3;
    }
}

public class Problem_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        // Fixed "current date" as stated in the problem
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            // The line looks like: TYPE "Item Title With Possible Spaces"
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String remainder = line.substring(firstSpace + 1).trim();

            // Strip the surrounding quotes from the title
            String title = remainder;
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;
            if (type.equals("BOOK")) {
                item = new Book();
            } else if (type.equals("DVD")) {
                item = new DVD();
            } else {
                item = new Magazine();
            }

            LocalDate dueDate = currentDate.plusDays(item.getLoanPeriodDays());
            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}
