package org.apache.automation.models;

/**
 * Created by mika on 19.03.2015.
 */
public class JoomlaTemplate {

    private String name;
    private String price;

    private static  JoomlaTemplate  joomlaTemplate;
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static JoomlaTemplate generateTemplate(){
        joomlaTemplate = new JoomlaTemplate();
        joomlaTemplate.setName("Education Centre Joomla Template");
        joomlaTemplate.setPrice("$157");

        return joomlaTemplate;
    }

}
