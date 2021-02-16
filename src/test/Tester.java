package test;

import model.customer.Customer;

public class Tester {

    public static void main(String[] args) {
        Customer customer = new Customer("FirstName", "LastName", "j@email.com");

        System.out.println(customer);
    }
}
