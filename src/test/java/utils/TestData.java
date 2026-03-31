package utils;

/**
 * TestData class that contains static constants for test data used across multiple test cases.
 * This includes account information for login and signup, payment information, and order comments.
 */
public class TestData {
    // Account info for login
    public static final String PASSWORD = "Test1234!";
    public static final String NAME = "TestUser";

    // Account info for signup
    public static final String FIRST_NAME = "Test";
    public static final String LAST_NAME = "User";
    public static final String COMPANY = "EPAM";
    public static final String ADDRESS = "123 Test Street";
    public static final String ADDRESS_2 = "456 Test Avenue";
    public static final String COUNTRY = "Canada";
    public static final String STATE = "Ontario";
    public static final String CITY = "Toronto";
    public static final String ZIPCODE = "9011";
    public static final String MOBILE = "1234567890";

    // Payment info
    public static final String CARD_NAME = "Test User";
    public static final String CARD_NUMBER = "4111111111111111";
    public static final String CARD_CVC = "123";
    public static final String CARD_EXPIRY_MONTH = "12";
    public static final String CARD_EXPIRY_YEAR = "2028";

    // Order comment
    public static final String ORDER_COMMENT = "Please deliver.";

    /**
     * Generates a unique email for each test run to avoid conflicts.
     */
    public static String generateEmail() {
        return "testuser" + System.currentTimeMillis() + "@testmail.com";
    }

    private TestData() {
    }
}
