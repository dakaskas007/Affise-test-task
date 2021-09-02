package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UsersManagementPage {

    public SelenideElement createUserButton =  $(byXpath("//span[contains(text(), 'Create User')]/.."));
}