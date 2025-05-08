package javaOOP;

public class StringFormat {
    public static String testRestParam(String locator, String... restParameter) {
        return String.format(locator,restParameter);
    }

    public static void main(String[] args) {
        System.out.println(String.format("Test + %s + %s","123","abc"));
        System.out.println(String.format("Test + %s","456"));
        System.out.println(String.format("Test + %s","789"));

        System.out.println(testRestParam("this is a locator with 1st %s and 2nd %s","value", "another value"));
        System.out.println(testRestParam("this is a locator with 1st %s","test value"));

    }
}
