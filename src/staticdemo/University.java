package staticdemo;

/**
 * Demonstrates static nested classes vs inner classes.
 */
public class University {
    private String universityName;
    private static int totalUniversities = 0;

    public University(String name) {
        this.universityName = name;
        totalUniversities++;
    }

    // Non-static inner class - has access to outer class instance
    public class Student {
        private String studentName;
        private int studentId;

        public Student(String name, int id) {
            this.studentName = name;
            this.studentId = id;
        }

        public void displayInfo() {
            // Can access outer class's instance variable!
            System.out.println("Student: " + studentName +
                    " (ID: " + studentId + ")");
            System.out.println("University: " + universityName); // Accessing outer instance
        }
    }

    // Static nested class - NO access to outer class instance
    public static class Address {
        private String city;
        private String country;
        private String zipCode;

        public Address(String city, String country, String zipCode) {
            this.city = city;
            this.country = country;
            this.zipCode = zipCode;
        }

        public void displayAddress() {
            // Cannot access universityName here! (no instance reference)
            // System.out.println(universityName); // ERROR!

            // Can access static members of outer class
            System.out.println("Total universities: " + totalUniversities);
            System.out.println("Address: " + city + ", " + country + " - " + zipCode);
        }
    }

    // Static nested class - Builder Pattern (common use case)
    public static class Builder {
        private String name;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public University build() {
            if (name == null || name.isEmpty()) {
                throw new IllegalStateException("University name is required");
            }
            return new University(name);
        }
    }

    public String getUniversityName() {
        return universityName;
    }

    public static int getTotalUniversities() {
        return totalUniversities;
    }
}
