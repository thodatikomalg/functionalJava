package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice", "alice@gmail.com", "+098790009", LocalDate.of(2000, 1, 1)
        );

        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
        System.out.println(customerValidatorService.isValid(customer));

        // We can store customer in db if valid

        System.out.println("Using Combinator method");

        ValidationResult result = isEmailValid().and(isPhoneValid()).and(isAdult()).apply(customer);
        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
