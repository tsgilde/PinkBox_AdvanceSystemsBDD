package pages;

public interface CommonPage {
    String XPATH_TEMPLATE_BUTTON = "//button[text()='%s']";
    String XPATH_TEMPLATE_LINKTEXT = "//a[text()='%s']";
    String XPATH_TEMPLATE_TEXT = "//*[text()='%s']";
    String XPATH_TEMPLATE_TEXT_CONTAINS = "//*[contains(text(), '%s')]";
    String XPATH_TEMPLATE_INPUT_FIELD = "//input[@placeholder='%s']";
    String XPATH_TEMPLATE_HREF_CONTAINS = "//a[contains(@href, '%s')]";
    String XPATH_TEMPLATE_OPTION_TEXT = "//a[text()='%s'][1]";
    String XPATH_TEMPLATE_INPUT_FIELD2 = "//textarea[@placeholder='%s']";

}
