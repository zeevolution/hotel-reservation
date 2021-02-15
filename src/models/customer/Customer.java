package models.customer;

import java.util.regex.Pattern;

public class Customer {

    private static final String EMAIL_REGEX_PATTERN = "^(.+)@(.+).(.+)$";

    private String firstName;
    private String lastName;
    private String email;

    public Customer(final String firstName, final String lastName, final String email) {
        this.isValidEmail(email);

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private void isValidEmail(final String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);

        if(!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "First Name: " + this.firstName
                + " Last Name: " + this.lastName
                + " Email: " + this.email;
    }
}
