package org.apache.automation.pages;

import org.apache.automation.models.BillingDetails;
import org.cybercat.automation.AutomationFrameworkException;
import org.cybercat.automation.annotations.CCTestCase;
import org.cybercat.automation.components.*;
import org.cybercat.automation.testng.TestNGTestCase;

/**
 * Created by mika on 19.03.2015.
 */


public class CheckoutPage extends AbstractPageObject {


       @Override
    protected void initPageElement() {
           addElement(new CheckBox("CheckoutPage.newCustomer", PathType.byXPath, "//input[@id='new-customer-radio']"));
           addElement(new Button("CheckoutPage.continueAsGuest", PathType.byXPath, "//button[@class='btn btn-default js-new-customer-link']"));

           addElement(new TextField("CheckoutPage.name", PathType.byXPath, "//input[@id='billingInfo-form-name']"));
           addElement(new TextField("CheckoutPage.email", PathType.byXPath, "//input[@id='billingInfo-form-email']"));

           addElement(new TextField("CheckoutPage.address", PathType.byXPath, "//input[@id='billingInfo-form-address']"));
           addElement(new TextField("CheckoutPage.city", PathType.byXPath, "//input[@id='billingInfo-form-city']"));


           addElement(new Button("CheckoutPage.country", PathType.byXPath, "//div[@id='billingInfo_form_country_chosen']/a/span"));
           addElement(new TextField("CheckoutPage.typeCountry", PathType.byXPath, "//div[@id='billingInfo_form_country_chosen']/div/div/input"));
           addElement(new Button("CheckoutPage.arrow", PathType.byXPath, "//div[@id='billingInfo_form_country_chosen']/div/ul/li/em"));


           addElement(new Button("CheckoutPage.state", PathType.byXPath, "//div[@id='billingInfo_form_state_chosen']/a/div/b"));
           addElement(new TextField("CheckoutPage.typeState", PathType.byXPath, "//div[@id='billingInfo_form_state_chosen']/div/div/input"));
           addElement(new Button("CheckoutPage.arrowState", PathType.byXPath, "//div[@id='billingInfo_form_state_chosen']/div/ul/li/em"));

           addElement(new TextField("CheckoutPage.zip", PathType.byXPath, "//input[@id='billingInfo-form-postalcode']"));

           addElement(new TextField("CheckoutPage.phone", PathType.byXPath, "//input[@id='billingInfo-form-phone']"));

           addElement(new Button("CheckoutPage.submit", PathType.byXPath, "//button[@id='billingInfo-form-submit']"));
    }

    @Override
    protected PageElement getUniqueElement() throws AutomationFrameworkException {
        return getCheckBox("CheckoutPage.newCustomer");
    }

    public void commitBuy() throws AutomationFrameworkException {
        getCheckBox("CheckoutPage.newCustomer").check();
        getButton("CheckoutPage.continueAsGuest").click();
    }

    public void setBillingDetails(BillingDetails billingDetails) throws AutomationFrameworkException {
        getTextField("CheckoutPage.name").typeText(billingDetails.getName());
        getTextField("CheckoutPage.email").typeText(billingDetails.getEmail());

        getTextField("CheckoutPage.address").typeText(billingDetails.getAddress());
        getTextField("CheckoutPage.city").typeText(billingDetails.getCity());

        getButton("CheckoutPage.country").click();
        getTextField("CheckoutPage.typeCountry").typeText(billingDetails.getCountry());
        getButton("CheckoutPage.arrow").click();


        pause(2000);

        getButton("CheckoutPage.state").click();
        getTextField("CheckoutPage.typeState").typeText(billingDetails.getState());
        getButton("CheckoutPage.arrowState").click();


        getTextField("CheckoutPage.zip").typeText(billingDetails.getZip());

        getTextField("CheckoutPage.phone").typeText(billingDetails.getBillingPhone());

        getButton("CheckoutPage.submit").click();
    }
}
