// Problem 3: The Nickname Tag
// Immutable class: full name is split once in the constructor and never changed.
public class Problem_3 {

    static class NameTag {
        private final String firstName;
        private final String lastName;

        public NameTag(String fullName) {
            String[] parts = fullName.split(" ");
            this.firstName = parts[0];
            this.lastName = parts[1];
        }

        public String getNickname() {
            return firstName + " " + lastName.charAt(0) + ".";
        }
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
