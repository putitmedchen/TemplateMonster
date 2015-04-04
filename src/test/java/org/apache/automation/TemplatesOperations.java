package org.apache.automation;

import org.apache.automation.features.SampleFeature;
import org.apache.automation.models.BillingDetails;
import org.apache.automation.models.JoomlaTemplate;
import org.cybercat.automation.AutomationFrameworkException;
import org.cybercat.automation.annotations.CCFeature;
import org.cybercat.automation.annotations.CCTestCase;
import org.cybercat.automation.testng.TestNGTestCase;
import org.testng.annotations.Test;

/**
 * Created by mika on 19.03.2015.
 */

@CCTestCase(description = "templates operations")
public class TemplatesOperations extends TestNGTestCase {

    @CCFeature
    public SampleFeature sampleFeature;

    @Test
    public void commitTemplatesOperations() throws AutomationFrameworkException {
        sampleFeature.joomplaTemplatesOperations(JoomlaTemplate.generateTemplate());

        sampleFeature.commitBillingOperations(BillingDetails.generateBuillingDetails());

        sampleFeature.buyTemplate();
    }

    @Override
    public void setup() throws AutomationFrameworkException {
    }
}
