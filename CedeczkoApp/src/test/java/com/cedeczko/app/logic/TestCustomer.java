package com.cedeczko.app.logic;

import com.cedeczko.app.errors.EmptyStringError;
import com.cedeczko.app.errors.NegativeValueError;
import com.cedeczko.app.errors.WrongEmailError;
import com.cedeczko.app.errors.WrongPostalCodeError;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class TestCustomer {
    @Test
    public void testConstructorAndGetters() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john.smith@example.com");

        assertEquals("John", customer.get_name());
        assertEquals("Smith", customer.get_surname());
        assertEquals("Green St.", customer.get_street());
        assertEquals("123", customer.get_building());
        assertEquals(10, customer.get_flat());
        assertEquals("12-345", customer.get_postal_code());
        assertEquals("Warsaw", customer.get_city());
        assertEquals("john.smith@example.com", customer.get_email());
    }
    @Test
    public void testSetName() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_name("NewName");
        assertEquals("NewName", customer.get_name());
    }

    @Test(expected = EmptyStringError.class)
    public void testSetNameEmpty() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john-smith@example.com");
        customer.set_name("");
    }

    @Test
    public void testSetSurname() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john3@example.com");
        customer.set_surname("NewSurname");
        assertEquals("NewSurname", customer.get_surname());
    }

    @Test(expected = EmptyStringError.class)
    public void testSetSurnameEmpty() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.gmail.com");
        customer.set_surname("");
    }

    @Test
    public void testSetStreet() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_street("NewGreen St.");
        assertEquals("NewGreen St.", customer.get_street());
    }

    @Test(expected = EmptyStringError.class)
    public void testSetStreetEmpty() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_street("");
    }

    @Test
    public void testSetBuilding() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_building("456");
        assertEquals("456", customer.get_building());
    }

    @Test(expected = EmptyStringError.class)
    public void testSetBuildingEmpty() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_building("");
    }

    @Test
    public void testSetFlat() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_flat(2);
        assertEquals(2, customer.get_flat());
    }

    @Test(expected = NegativeValueError.class)
    public void testSetFlatNegative() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_flat(-1);
    }

    @Test
    public void testSetPostalCode() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_postal_code("11-111");
        assertEquals("11-111", customer.get_postal_code());
    }

    @Test(expected = WrongPostalCodeError.class)
    public void testSetPostalCodeInvalidLength() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_postal_code("00000");
    }

    @Test(expected = WrongPostalCodeError.class)
    public void testSetPostalCodeInvalidFormat() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_postal_code("000000");
    }

    @Test(expected = WrongPostalCodeError.class)
    public void testSetPostalCodeNonNumeric() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_postal_code("00-abc");
    }
    @Test
    public void testSetWarsaw() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_city("NewWarsaw");
        assertEquals("NewWarsaw", customer.get_city());
    }

    @Test(expected = EmptyStringError.class)
    public void testSetWarsawEmpty() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_city("");
    }

    @Test
    public void testSetEmail() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john@example.com");
        customer.set_email("new.email@example.com");
        assertEquals("new.email@example.com", customer.get_email());
    }

    @Test(expected = WrongEmailError.class)
    public void testSetEmailInvalidFormat() {
        Customer customer = new Customer("John", "Smith", "Green St.", "123", 10, "12-345", "Warsaw", "john.smith@example.com");
        customer.set_email("invalid_email");
    }

}
