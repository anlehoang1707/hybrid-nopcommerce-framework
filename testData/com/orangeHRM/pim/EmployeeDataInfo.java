package com.orangeHRM.pim;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;
import org.testng.annotations.Parameters;

import java.io.File;

public class EmployeeDataInfo {

    public static EmployeeDataInfo getEmployeeDataInfo() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.EMPLOYEE_DATA_TEST_PATH + "EmployeeData.json"),EmployeeDataInfo.class);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("employee")
    private EmployeeDetails employee;

    public static class EmployeeDetails {

        @JsonProperty("personalInfo")
        private PersonalInfo personalInfo;

        @JsonProperty("emergencyContact")
        private EmergencyContact emergencyContact;

        @JsonProperty("dependent")
        private Dependent dependent;

    }

    public static class PersonalInfo {

        @JsonProperty("initialEmployeeID")
        private String initialEmployeeID;

        @JsonProperty("username")
        private String username;

        @JsonProperty("firstName")
        private String firstName;

        @JsonProperty("lastName")
        private String lastName;

        @JsonProperty("middleName")
        private String middleName;

        @JsonProperty("contact")
        private Contact contact;

        @JsonProperty("address")
        private Address address;

    }

    public static class Contact {

        @JsonProperty("homePhone")
        private String homePhone;

        @JsonProperty("workPhone")
        private String workPhone;

        @JsonProperty("mobilePhone")
        private String mobilePhone;

        @JsonProperty("workEmail")
        private String workEmail;

        @JsonProperty("otherEmail")
        private String otherEmail;

    }

    public static class Address {

        @JsonProperty("street1")
        private String street1;

        @JsonProperty("street2")
        private String street2;

        @JsonProperty("city")
        private String city;

        @JsonProperty("stateProvince")
        private String stateProvince;

        @JsonProperty("zipPostalCode")
        private String zipPostalCode;

        @JsonProperty("countryName")
        private String countryName;

    }

    public static class EmergencyContact {

        @JsonProperty("name")
        private String emergencyContactName;

        @JsonProperty("relationship")
        private String emergencyContactRelationship;

        @JsonProperty("homePhone")
        private String emergencyHomePhone;

    }

    public static class Dependent {

        @JsonProperty("name")
        private String dependentName;

    }

    public String getUsername() {
        return employee.personalInfo.username;
    }

    public String getLastName() {
        return employee.personalInfo.lastName;
    }

    public String getMiddleName() {
        return employee.personalInfo.middleName;
    }

    public String getFirstName() {
        return employee.personalInfo.firstName;
    }

    public String getHomePhone() {
        return employee.personalInfo.contact.homePhone;
    }

    public String getWorkPhone() {
        return employee.personalInfo.contact.workPhone;
    }

    public String getMobilePhone() {
        return employee.personalInfo.contact.mobilePhone;
    }

    public String getWorkEmail() {
        return employee.personalInfo.contact.workEmail;
    }

    public String getOtherEmail() {
        return employee.personalInfo.contact.otherEmail;
    }

    public String getStreet1() {
        return employee.personalInfo.address.street1;
    }

    public String getStreet2() {
        return employee.personalInfo.address.street2;
    }

    public String getCity() {
        return employee.personalInfo.address.city;
    }

    public String getStateProvince() {
        return employee.personalInfo.address.stateProvince;
    }

    public String getZipPostalCode() {
        return employee.personalInfo.address.zipPostalCode;
    }

    public String getCountryName() {
        return employee.personalInfo.address.countryName;
    }

    public String getEmergencyContactName() {
        return employee.emergencyContact.emergencyContactName;
    }

    public String getEmergencyContactRelationship() {
        return employee.emergencyContact.emergencyContactRelationship;
    }

    public String getEmergencyContactHomePhone() {
        return employee.emergencyContact.emergencyHomePhone;
    }

    public String getDependentName() {
        return employee.dependent.dependentName;
    }
}
