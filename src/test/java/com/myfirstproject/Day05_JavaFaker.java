package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {
    /*
    data : username, password, phone number, test environment, city, ssn, test url, job title,...
    -Where do you get your test data in your company?
    ---BA(Business Analyst) : Writes the acceptance criteria or requirements
    ---Test Lead
    ---Manual Tester
    ---Tech Lead (Team Lead)
    ---PO (Product Owner) : Maintains product backlog
    ---Developers
    ---from the database
    ---from API calls
    in addition to all these, we can use java Faker if we need some fake data


     */
    @Test
    public void javaFaker (){
        //1.Create a Faker object
        Faker faker = new Faker();

        //2.user faker object or generate fake test data
        String firstName = faker.name().firstName();
        System.out.println("first name : " +firstName);

        //last name
        System.out.println("last name : " +faker.name().lastName());

        //title
        System.out.println("title : "  + faker.name().title());

        //city
        System.out.println( "city : " + faker.address().city());

        //state
        System.out.println(  "state : " + faker.address().state());

        //country
        System.out.println("country : "  +  faker.address().country());

        //address
        System.out.println("address : "+faker.address().fullAddress());

        //zipcode
        System.out.println("zipcode : "+faker.address().zipCode());

        //random number : 10 digit number
        System.out.println("random number with 10 digits : "+faker.number().digits(10));

        //cell phone number
        System.out.println("cell phone number : "+faker.phoneNumber().cellPhone());

        //ssn
        System.out.println("ssn : " + faker.idNumber().ssnValid());

        //email
        System.out.println("email : " + faker.internet().emailAddress());

        //date
        System.out.println("date : " + faker.date().birthday());
    }
}
