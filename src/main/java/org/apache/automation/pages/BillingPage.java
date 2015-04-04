package org.apache.automation.pages;

import org.cybercat.automation.AutomationFrameworkException;
import org.cybercat.automation.components.AbstractPageObject;
import org.cybercat.automation.components.Button;
import org.cybercat.automation.components.PageElement;

/**
 * Created by mika on 19.03.2015.
 */
public class BillingPage extends AbstractPageObject {


    @Override
    protected void initPageElement() {
        addElement(new Button("BillingPage.payPal", PathType.byXPath, "//div[@id='payment-collapse']//div[contains(text(),'PayPal')]"));
        addElement(new Button("BillingPage.byNow", PathType.byXPath, "//div[@id='paymentItemContent2']/a[contains(text(), 'Buy Now')]"));
    }

    @Override
    protected PageElement getUniqueElement() throws AutomationFrameworkException {
        return getButton("BillingPage.payPal");
    }

    public void buyTemplate() throws AutomationFrameworkException {
        getButton("BillingPage.payPal").click();
        getButton("BillingPage.byNow").click();
    }
}
