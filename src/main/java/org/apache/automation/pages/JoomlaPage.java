package org.apache.automation.pages;

import org.apache.automation.models.JoomlaTemplate;
import org.apache.commons.lang3.StringUtils;
import org.cybercat.automation.AutomationFrameworkException;
import org.cybercat.automation.PageObjectException;
import org.cybercat.automation.annotations.CCPageURL;
import org.cybercat.automation.components.AbstractPageObject;
import org.cybercat.automation.components.Button;
import org.cybercat.automation.components.PageElement;
import org.cybercat.automation.components.TextContainer;

/**
 * Created by mika on 19.03.2015.
 */


public class JoomlaPage extends AbstractPageObject {
    @Override
    protected void initPageElement() {
        addElement(new Button("JoomlaPage.1yearHosting", PathType.byXPath, "//h4[contains(text(),'Template + Installation + 1 Year Hosting')]"));
        addElement(new Button("JoomlaPage.addToCart", PathType.byXPath, "//div[@id='collapse1']/div[3]/button"));


        addElement(new TextContainer("JoomlaPage.educationTemplate", PathType.byXPath, "//span[contains(text(), 'Education Centre Joomla Template')]"));
        addElement(new TextContainer("JoomlaPage.price", PathType.byXPath, "(//span[@data-price])[5]"));

        addElement(new Button("JoomlaPage.checkoutNow", PathType.byXPath, "//button[(contains(text(),'Checkout Now'))]"));
    }

    @Override
    protected PageElement getUniqueElement() throws AutomationFrameworkException {
        return getButton("JoomlaPage.1yearHosting");
    }

    public void commitOperations(JoomlaTemplate joomlaTemplate) throws AutomationFrameworkException {
        getButton("JoomlaPage.1yearHosting").click();
        getButton("JoomlaPage.addToCart").click();

        pause(3000);

        validateText(joomlaTemplate.getName(), getTextContainer("JoomlaPage.educationTemplate"));
        validateText(joomlaTemplate.getPrice(), getTextContainer("JoomlaPage.price"));

        getButton("JoomlaPage.checkoutNow").click();
    }

    private void validateText(String expected, PageElement value) throws PageObjectException {
        if(!StringUtils.contains(expected, value.getText())){
            throw new PageObjectException(value.getName() + "field have text:" + value.getText() + " but expected value is :" + expected);
        }
    }

}
