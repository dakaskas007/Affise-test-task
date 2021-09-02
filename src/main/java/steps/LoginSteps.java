package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("Login page")
    public void openLoginPage() {
        open("");
    }

    @When("I input {string}")
    public void inputPassword(String value) {
        switch (value) {
            case "username":
                loginPage.usernameInput.setValue(BackendSteps.email);
                break;
            case "password":
                loginPage.passwordInput.setValue(BackendSteps.password);
                break;
            default: break;
        }
    }

    @When("I click login")
    public void clickLogin() {
        loginPage.loginButton.click();
    }
}