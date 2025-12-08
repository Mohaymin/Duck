package java.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TextUtilities {
    public static boolean isValidEmailFormat(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }

    /**
     * Converts a date string from YYYY-MM-DD to MM-DD-YY.*/

    public static String convertDateFormat(String inputDate){
        if (inputDate == null || inputDate.isEmpty()){
            return null;
        }
        try{
            LocalDate date = LocalDate.parse(inputDate);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM-dd-yy");
            return date.format(outputFormatter);
        }
        catch (DateTimeParseException e){
            System.err.println("Invalid Date Format: " + inputDate);
            return null;
        }
    }
}
