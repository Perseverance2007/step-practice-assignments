// Problem 4: The Locker Code
// Combination code is private with no getter at all (write-only field).
public class Problem_4 {

    static class Locker {
        private final int lockerNumber;
        private String code;

        public Locker(int lockerNumber, String initialCode) {
            this.lockerNumber = lockerNumber;
            this.code = initialCode;
        }

        public boolean changeCode(String currentCode, String newCode) {
            if (currentCode.equals(code)) {
                code = newCode;
                return true;
            }
            return false;
        }

        public int getLockerNumber() {
            return lockerNumber;
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        boolean result1 = l.changeCode("1234", "5678");
        System.out.println("changeCode(\"1234\",\"5678\") success: " + result1);

        boolean result2 = l.changeCode("0000", "9999");
        System.out.println("changeCode(\"0000\",\"9999\") success: " + result2);

        System.out.println("Locker Number: " + l.getLockerNumber());
        System.out.println("(No getter exists to read the current code from outside)");
    }
}
