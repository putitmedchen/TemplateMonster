package org.apache.automation.pages;

import org.apache.automation.models.User;
import org.apache.commons.lang3.StringUtils;
import org.cybercat.automation.AutomationFrameworkException;
import org.cybercat.automation.PageObjectException;
import org.cybercat.automation.components.*;

/**
 * Created by mika on 19.03.2015.
 */

public class TemplateMonsterLandingPage extends AbstractPageObject {

    @Override
    protected void initPageElement() {
        addElement(new Button("LandingPage.signIn", PathType.byId, "signin-link"));

        addElement(new TextField("LandingPage.email", PathType.byId, "signin-form-email"));
        addElement(new TextField("LandingPage.password", PathType.byId, "signin-form-password"));

        addElement(new Button("LandingPage.submit", PathType.byId, "signin-form-submit"));

        addElement(new TextContainer("LandingPage.name", PathType.byXPath, "//a[@id='your-account-link']/span"));

        addElement(new Button("LandingPage.signOut",PathType.byXPath,"//a[@id='signout-link']/span"));

        addElement(new TextContainer("LandingPage.errorEnterPassword", PathType.byXPath, "//div[@class='popover-content']"));
        addElement(new TextContainer("LandingPage.errorIncorrectPassword", PathType.byXPath, "//div[@class='popover-content']"));

        addElement(new Button("LandingPage.JoomplaTemplate", PathType.byLinkText, "Joomla Templates"));
    }


    @Override
    protected PageElement getUniqueElement() throws AutomationFrameworkException {
        return getButton("LandingPage.signIn") ;
    }

    public void login(User user) throws AutomationFrameworkException {
        getButton("LandingPage.signIn").click();

        getTextField("LandingPage.password").typeText(user.getPassword());
        getTextField("LandingPage.email").typeText(user.getLogin());


        getButton("LandingPage.submit").click();

        validateText("test-user@rocky.devoffice.com",getTextContainer("LandingPage.name"));

        validateElement("LandingPage.signOut", StatefulElement.PresentStatus.VISIBLE);

    }

    public void signOut() throws AutomationFrameworkException {
        getButton("LandingPage.signOut").click();

        validateElement("LandingPage.signIn", StatefulElement.PresentStatus.VISIBLE);
    }

    private void validateText(String expected, PageElement value) throws PageObjectException {
        if(!StringUtils.contains(expected, value.getText())){
            throw new PageObjectException(value.getName() + "field have text:" + value.getText() + " but expected value is :" + expected);
        }
    }


    public void negativeLogin(User user) throws AutomationFrameworkException {
        getButton("LandingPage.signIn").click();
        getTextField("LandingPage.email").typeText(user.getLogin());
        getButton("LandingPage.submit").click();
        validateElement("LandingPage.errorEnterPassword", StatefulElement.PresentStatus.VISIBLE);
        getTextField("LandingPage.password").typeText(user.getPassword());
        validateElement("LandingPage.errorIncorrectPassword", StatefulElement.PresentStatus.VISIBLE);
    }

    public void productBuy() throws AutomationFrameworkException {
        getButton("LandingPage.JoomplaTemplate").click();
    }
}
