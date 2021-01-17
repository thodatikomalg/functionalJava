package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer customer = new Customer("Maria", "999-999-9999");
        greetCustomer(customer);

        System.out.println("--Printing from consumer");
        greetCustomerConsumer.accept(customer);

        System.out.println("--Printing from Biconsumer");
        getGreetCustomerBiConsumer.accept(customer, true);
        getGreetCustomerBiConsumer.accept(customer, false);
    }

    static void greetCustomer(Customer customer){
        System.out.println("Hello "+ customer.customerName + " thanks for registering phone number " + customer.customerPhoneNumber);
    }

    static Consumer<Customer> greetCustomerConsumer =
            customer -> System.out.println("Hello "+ customer.customerName + " thanks for registering phone number " + customer.customerPhoneNumber);

   static BiConsumer<Customer, Boolean> getGreetCustomerBiConsumer = (Customer, showCustomerPhoneNumber) ->
           System.out.println("Hello "+ Customer.customerName + (showCustomerPhoneNumber ? Customer.customerPhoneNumber : "*******"));

    public static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
