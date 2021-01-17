package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println("Without using predicate");
        System.out.println(isPhoneNumberValid("09333333"));
        System.out.println(isPhoneNumberValid("07978909009"));
        System.out.println("*** Predicate represent boolean value of a function ***");

        System.out.println(isPhoneNumberValidPredicate.test("09333333"));
        System.out.println(isPhoneNumberValidPredicate.test("07978909009"));

        System.out.println("Chaining predicate functions");
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07978909009"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("07978909009"));

        System.out.println("*** BiPredicates take two arguments as inputs ***");
    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length()==11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length()==11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");


}
