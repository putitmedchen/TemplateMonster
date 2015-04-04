package org.apache.automation.features;

import org.apache.automation.models.BillingDetails;
import org.apache.automation.models.JoomlaTemplate;
import org.apache.automation.models.User;
import org.apache.automation.pages.TemplateMonsterLandingPage;
import org.cybercat.automation.AutomationFrameworkException;
import org.cybercat.automation.annotations.CCFeature;
import org.cybercat.automation.annotations.CCPageObject;
import org.cybercat.automation.annotations.CCRedirectionStep;
import org.cybercat.automation.annotations.CCTestStep;
import org.cybercat.automation.test.AbstractFeature;
import org.cybercat.automation.test.IFeature;
import org.cybercat.automation.test.IVersionControl;

/**
 * Created by mika on 19.03.2015.
 */


public interface SampleFeature  {


    SampleFeature login(User user) throws AutomationFrameworkException;

    SampleFeature negativeLogin(User user) throws AutomationFrameworkException;

    @CCRedirectionStep(desctiption = "joomla", url="http://www.templatemonster.com/joomla-templates/50797.html")
    SampleFeature joomplaTemplatesOperations(JoomlaTemplate joomlaTemplate)throws AutomationFrameworkException;

    SampleFeature commitBillingOperations(BillingDetails billingDetails) throws AutomationFrameworkException;

    SampleFeature buyTemplate() throws AutomationFrameworkException;
}
