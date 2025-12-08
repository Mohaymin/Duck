package utils;
import java.utils.TextUtilities;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextUtilitiesTest {
    @Test
    public void testConvertDateAndFormat_HappyPath() {
        // Input is standard YYYY-MM-DD
        String input = "2025-12-31";
        String expected = "12-31-25";

        String actual = TextUtilities.convertDateFormat(input);
        assertEquals(expected, actual, "The date should be converted to MM-dd-yy format");
    }
}

