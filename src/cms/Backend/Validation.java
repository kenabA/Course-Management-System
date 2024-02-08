/**
 *
 * @author kenabkc
 */
package cms.Backend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Validation {

    // For getting the error message and error title
    private static String errorMsg;
    private static String errorTitle;

    // Naming convention for each fields
    public static String namingConvention(String field) {

        return switch (field) {

            case "usertype" ->
                """
Please select a user type.
                               """;

            case "username" ->
                """
Naming Conventions :
1. Username must have more than 4 & less than 16 characters.
2. Username must start with a letter.
3. Special characters are not allowed.
4. You may use underscore ( _ ).""";

            case "email" ->
                """
Email Conventions :
1. Must use 'heraldcollege.edu.np' as the domain.
2. Email must have at least 5 characters before ' @ '.
3. You may use numbers & dot ( . ).
""";

            case "phone" ->
                """
Phone Number Conventions :
1. All digits must be numeric, no letter allowed.
2. Total digits must be 10.
""";

            case "pass" ->
                """
Password Conventions :
1. Must contain at least one special character (!,@,#,$,%).
2. Total digits must be greater or equal to 8.
""";

            case "rePass" ->
                """
Passwords do not match or do not meet the criteria.
""";

            case "blankValue" ->
                """
Profile Updating Conventions :
1. Values cannot be blank.
2. Updated data can't be similar to the old ones.
                """;

            default ->
                "Error in the format";
        };
    }

    // To validate if the field is empty
    public static boolean validateIfEmpty(String[] credentials) {
        boolean usertypeValidate = true;
        int length = credentials.length;
        if (length >= 7 && credentials[7].equals("Select User Type")) {
            usertypeValidate = false;
            Validation.errorMsg = namingConvention("usertype");
            Validation.errorTitle = "Registration Error";
            JOptionPane.showMessageDialog(null, errorMsg, errorTitle, JOptionPane.INFORMATION_MESSAGE);
            return !credentials[0].isEmpty() && !credentials[1].isEmpty() && !credentials[2].isEmpty() && !credentials[3].isEmpty() && !credentials[4].isEmpty() && !credentials[5].isEmpty() && !credentials[6].isEmpty() && usertypeValidate;
        }

        return !credentials[0].isEmpty() && !credentials[1].isEmpty() && !credentials[2].isEmpty() && !credentials[3].isEmpty() && !credentials[4].isEmpty();

    }

    // Validates all the details once the fields are not empty
    public static boolean validateDetails(String fName, String lName, String username, String phone, String email, String pass, String rePass, String usertype) {

        String[] detailFields = {"Name", "Username", "Phone", "Email", "Pass"};

        for (String detail : detailFields) {

            switch (detail) {

                case "Name":

                    boolean name = validateName(fName, lName);
                    if (!name) {
                        return false;
                    }

                case "Username":

                    if (!validateUsername(username)) {
                        return false;
                    }

                case "Email":

                    if (!validateEmail(email)) {
                        return false;
                    }

                case "Phone":

                    if (!validatePhone(phone)) {
                        return false;
                    }

                case "Pass":

                    if (!validatePass(pass)) {
                        return false;
                    }

                case "Repass":

                    if (!validateRepass(pass, rePass)) {
                        return false;
                    }
            }
        }

        // Calls the check duplicate function to check if the data already exists in the database
        return Account.checkDuplicate(username, email, usertype);

    }

    // This is used when updating the data to the data : Used concept of overriding : Polymorphism
    public static boolean validateDetails(String details[], String rePass, String role) {

        String[] detailFields = {"Username", "Phone", "Email", "Pass"};

        for (String detail : detailFields) {

            switch (detail) {

                case "Username":

                    if (!validateUsername(details[0])) {
                        return false;
                    }

                case "Email":

                    if (!validateEmail(details[1])) {
                        return false;
                    }

                case "Phone":

                    if (!validatePhone(details[3])) {
                        return false;
                    }

                case "Pass":

                    if (!validatePass(details[2])) {
                        return false;
                    }

                case "Repass":

                    if (!validateRepass(details[2], rePass)) {
                        return false;
                    }
            }
        }
        // Again checks for the duplicate 
        return Account.checkDuplicate(details[0], details[1], role);

    }

    // Validation for Percentage field for grading panel
    public static boolean validatePercentageField(String totalPercentage) {

        if (HelperMethods.allCharactersAreDigits(totalPercentage)) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Please enter the Percentage in Numeric form.", "Grade Students", JOptionPane.INFORMATION_MESSAGE);
        return false;

    }

    // Validation for Name
    private static boolean validateName(String fName, String lName) {

        String[] nameArr = {fName, lName};

        for (String name : nameArr) {
            if (!name.matches("^[a-zA-Z ]+$")) {
                Validation.errorMsg = "The name you entered contains invalid characters. Please use only letters (a-z, A-Z). Refrain from using special characters.";
                Validation.errorTitle = "Registration Error";
                JOptionPane.showMessageDialog(null, errorMsg, errorTitle, JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }

        return true;

    }

    // Validation for Username
    private static boolean validateUsername(String username) {

        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
        Matcher matcher = pattern.matcher(username);
        boolean matchFound = matcher.find();

        if (!matchFound) {
            Validation.errorMsg = namingConvention("username");
            Validation.errorTitle = "Registration Error";
            JOptionPane.showMessageDialog(null, errorMsg, errorTitle, JOptionPane.INFORMATION_MESSAGE);
        }

        return matchFound;

    }

    // Validation for Email
    private static boolean validateEmail(String email) {

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9.]{5,}+@heraldcollege.edu.np$");
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();

        if (!matchFound) {
            Validation.errorMsg = namingConvention("email");
            Validation.errorTitle = "Registration Error";
            JOptionPane.showMessageDialog(null, errorMsg, errorTitle, JOptionPane.INFORMATION_MESSAGE);
        }

        return matchFound;

    }

    // Validation for Phone Number
    private static boolean validatePhone(String phone) {

        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(phone);
        boolean matchFound = matcher.find();

        if (!matchFound) {
            Validation.errorMsg = namingConvention("phone");
            Validation.errorTitle = "Registration Error";
            JOptionPane.showMessageDialog(null, errorMsg, errorTitle, JOptionPane.INFORMATION_MESSAGE);
        }

        return matchFound;

    }

    // Validation for Phone Password
    private static boolean validatePass(String pass) {

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!@#]{8,}$");
        Matcher matcher = pattern.matcher(pass);
        boolean matchFound = matcher.find();

        if (!matchFound) {
            Validation.errorMsg = namingConvention("pass");
            Validation.errorTitle = "Registration Error";
            JOptionPane.showMessageDialog(null, errorMsg, errorTitle, JOptionPane.INFORMATION_MESSAGE);
        }

        return matchFound;
    }

    // Validation for repassword
    private static boolean validateRepass(String pass, String rePass) {

        boolean matchFound = pass.equals(rePass);
        if (!matchFound) {
            Validation.errorMsg = namingConvention("rePass");
            Validation.errorTitle = "Registration Error";
            JOptionPane.showMessageDialog(null, errorMsg, errorTitle, JOptionPane.INFORMATION_MESSAGE);
        }

        return matchFound;
    }

    public static boolean validateQuestionField(String qs) {
        if (!qs.isEmpty()) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Cannot publish empty assignments", "Add Assignments", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }

    public static boolean validateAnnouncementField(String msg) {
        if (!msg.isEmpty()) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Cannot publish empty annonucements", "Add announcements", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }
}
