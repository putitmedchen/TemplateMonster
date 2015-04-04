package org.apache.automation;

import org.apache.automation.features.SampleFeature;
import org.apache.automation.models.User;
import org.cybercat.automation.AutomationFrameworkException;
import org.cybercat.automation.annotations.CCFeature;
import org.cybercat.automation.annotations.CCTestCase;
import org.cybercat.automation.testng.TestNGTestCase;
import org.testng.annotations.Test;

/**
 * Created by mika on 19.03.2015.
 */

@CCTestCase(description = "it id designed to check login on TemplateMonster")
public class TemplateMonsterLogin extends TestNGTestCase {

    @CCFeature
    public SampleFeature sampleFeature;

    @Test
    public void login() throws AutomationFrameworkException {
        sampleFeature.login(User.generateUser());
    }

    @Override
    public void setup() throws AutomationFrameworkException {

    }
}
