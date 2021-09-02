package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement usernameInput =  $(byId("email"));
    public SelenideElement passwordInput =  $(byId("password"));
    public SelenideElement loginButton =  $(byText("Sign in"));
}