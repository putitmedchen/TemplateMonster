package org.apache.automation.models;

/**
 * Created by mika on 19.03.2015.
 */
public class BillingDetails {

    private String name;
    private String email;

    private String address;
    private String city;
    private String country;

    private String state;
    private String zip;

    private String billingPhone;

    private static BillingDetails billingDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BillingDetails() {
    }

    public static BillingDetails  generateBuillingDetails(){
        billingDetails = new BillingDetails();

        billingDetails.setName("DATE Tester");
        billingDetails.setEmail("sgo12@mail.ru");

        billingDetails.setAddress("12 street");
        billingDetails.setCity("New York");
        billingDetails.setCountry("United States");
        billingDetails.setState("New York");

        billingDetails.setZip("777");
        billingDetails.setBillingPhone("7777777");


        return billingDetails;
    }


}
