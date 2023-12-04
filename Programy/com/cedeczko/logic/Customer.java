package com.cedeczko.logic;

import com.cedeczko.errors.EmptyStringError;
import com.cedeczko.errors.NegativeValueError;
import com.cedeczko.errors.WrongEmailError;
import com.cedeczko.errors.WrongPostalCodeError;

public class Customer {
    private String name;
    private String surname;
    private String street;
    private String building; //może lepiej int ale czasem jest ulica 19c czy coś
    private int flat;
    private String postal_code;
    private String city;
    private String email;

    public Customer(String given_name, String given_surname, String given_street, String given_building, int given_flat, String given_postal_code, String given_city, String given_email) {
        if (given_name == "") {
            throw new EmptyStringError("Name cannot be empty.");
        }
        this.name = given_name;
        if (given_surname == "") {
            throw new EmptyStringError("Surname cannot be empty.");
        }
        this.surname = given_surname;
        if (given_street == "") {
            throw new EmptyStringError("Street cannot be empty.");
        }
        this.street = given_street;
        if (given_building == "") {
            throw new EmptyStringError("Building cannot be empty.");
        }
        this.building = given_building;
        if (given_flat <= 0) {
            throw new NegativeValueError("Flat number has to be positive.");
        }
        this.flat = given_flat;
        if (!check_postal_code(given_postal_code)) {
            throw new WrongPostalCodeError("Postal code has to have XX-XXX format (X - integer)");
        }
        this.postal_code = given_postal_code;
        if (given_city == "") {
            throw new EmptyStringError("Building cannot be empty.");
        }
        this.city = given_city;
        if (!check_email(given_email)) {
            throw new WrongEmailError("Email has to have @");
        }
        this.email = given_email;
    }

    private boolean check_postal_code(String given_postal_code) {
      boolean ok = true;
      if (given_postal_code.length() == 6) {
          if (given_postal_code.charAt(2) != '-') {
              ok = false;
          } else {
              for (int i = 0; i < 6; i++) {
                  if ((i != 2) && (!Character.isDigit(given_postal_code.charAt(i)))) {
                      ok = false;
                  }
              }
          }
      } else {
          ok = false;
      }
      return ok;
    }

    private boolean check_email(String given_email) {
        boolean has_dot_at = false;
        if (given_email.length() >= 5){
            for (int i = 1; i < given_email.length() - 3; i++) {
                if (given_email.charAt(i) == '@') {
                    for (int j = i + 2; j < given_email.length() - 1; j++) {
                        if (given_email.charAt(j) == '.') {
                            has_dot_at = true;
                        }
                    }
                }
            }
        }
        return has_dot_at;
    }

    public String get_name(){
        return this.name;
    }
    
    public String get_surname(){
        return this.surname;
    }
    
    public String get_street(){
        return this.street;
    }

    public String get_building(){
        return this.building;
    }

    public int get_flat(){
        return this.flat;
    }

    public String get_postal_code(){
        return this.postal_code;
    }

    public String get_city(){
        return this.city;
    }

    public String get_email(){
        return this.email;
    }

    public void set_name(String new_name){
        if (new_name == "") {
            throw new EmptyStringError("Name cannot be empty.");
        }
        this.name = new_name;
    }
    
    public void set_surname(String new_surname){
        if (new_surname == "") {
              throw new EmptyStringError("Surname cannot be empty.");
        }
        this.surname = new_surname;
    }
    
    public void set_street(String new_street){
        if (new_street == "") {
              throw new EmptyStringError("Street cannot be empty.");
        }
        this.street = new_street;
    }

    public void set_building(String new_building){
        if (new_building == "") {
              throw new EmptyStringError("Building cannot be empty.");
        }
        this.building = new_building;
    }

    public void set_flat(int new_flat){
        if (new_flat <= 0) {
              throw new EmptyStringError("Flat number has to be positive.");
        }
        this.flat = new_flat;
    }

    public void set_postal_code(String new_postal_code){
        if (!check_postal_code(new_postal_code)) {
            throw new WrongPostalCodeError("Postal code has to have XX-XXX format (X - integer)");
        }
        this.postal_code = new_postal_code;
    }

    public void set_city(String new_city){
        if (new_city == "") {
              throw new EmptyStringError("Building cannot be empty.");
        }
        this.city = new_city;
    }

    public void set_email(String new_email){
        if (!check_email(new_email)) {
            throw new WrongEmailError("Email has to have @");
        }
        this.email = new_email;
    }
}