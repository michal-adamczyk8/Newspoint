import java.time.LocalDate;


public class User {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private static final String DEFAULT_NUMBER = "0";

    private User(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public static User makingUserWithNoPhoneNumber(String firstName, String lastName, LocalDate dateOfBirth) {
        return new User(firstName, lastName, dateOfBirth, DEFAULT_NUMBER);
    }

    public static User makingUserWithPhoneNumber(String firstName, String lastName, LocalDate dateOfBirth,
                                                 String phoneNumber) {
        return new User(firstName, lastName, dateOfBirth, phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
}
