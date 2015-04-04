package org.apache.automation.features;

import org.apache.automation.models.BillingDetails;
import org.apache.automation.models.JoomlaTemplate;
import org.apache.automation.models.User;
import org.apache.automation.pages.BillingPage;
import org.apache.automation.pages.CheckoutPage;
import org.apache.automation.pages.JoomlaPage;
import org.apache.automation.pages.TemplateMonsterLandingPage;
import org.cybercat.automation.AutomationFrameworkException;
import org.cybercat.automation.annotations.CCPageObject;
import org.cybercat.automation.annotations.CCRedirectionStep;
import org.cybercat.automation.annotations.CCTestStep;
import org.cybercat.automation.test.AbstractFeature;

/**
 * Created by mika on 19.03.2015.
 */
public class SampleFeatureImpl extends AbstractFeature implements SampleFeature  {

    @CCPageObject
    public TemplateMonsterLandingPage templateMonsterLandingPage;
    @CCPageObject
    public JoomlaPage joomlaPage;
    @CCPageObject
    public CheckoutPage checkoutPage;
    @CCPageObject
    public BillingPage billingPage;



    @Override
    @CCTestStep(value = "login")
    public SampleFeature login(User user) throws AutomationFrameworkException {
        templateMonsterLandingPage.login(user);
        return this;
    }

    @Override
    public SampleFeature negativeLogin(User user) throws AutomationFrameworkException {
        templateMonsterLandingPage.negativeLogin(user);
        return this;
    }

    @Override
    @CCRedirectionStep(desctiption = "joomla", url="http://www.templatemonster.com/joomla-templates/50797.html")
    public SampleFeature joomplaTemplatesOperations(JoomlaTemplate joomlaTemplate)throws AutomationFrameworkException{
         joomlaPage.commitOperations(joomlaTemplate);
        return this;
    }

    @Override
    public SampleFeature commitBillingOperations(BillingDetails billingDetails) throws AutomationFrameworkException {

        checkoutPage.commitBuy();
        checkoutPage.setBillingDetails(billingDetails);
        return this;
    }

    @Override
    public SampleFeature buyTemplate() throws AutomationFrameworkException{
        billingPage.buyTemplate();
        return this;
    }

}
