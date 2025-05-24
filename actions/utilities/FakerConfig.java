package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerConfig {
    Faker faker = new Faker(new Locale("vi"));


    public static FakerConfig getFaker() {
        return new FakerConfig();
    }

    public String getFirstName() {
        return faker.address().firstName();
    }

    public String getLastName() {
        return faker.address().lastName();
    }

    public String getMiddleName() {
        return faker.address().firstName();
    }

    public String getStreetAddress() {
        return faker.address().streetAddress();
    }

    public String getCompanyName() {
        return faker.company().name();
    }

    public String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getZipCode() {
        return faker.address().zipCode();
    }

    public String getCountry() {
        return faker.country().name();
    }

    public String getFullName() {
        return faker.name().fullName();
    }

    public String getRelationship() {
        return faker.relationships().any();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getCityName() {
        return faker.address().cityName();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getUserName() {
        return faker.internet().emailAddress();
    }

    public String getPassword() {
        return faker.internet().password(6,10,true);
    }

    public String getMobilePhone() {
        return faker.phoneNumber().cellPhone();
    }
}
