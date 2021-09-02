package steps;

import io.cucumber.java.en.Then;
import page.UsersManagementPage;

import static com.codeborne.selenide.Condition.exist;

public class UserManagementSteps {

    UsersManagementPage usersManagementPage = new UsersManagementPage();

    @Then("I wait loading create user button")
    public void waitLoadingCreatUserButton() {
        usersManagementPage.createUserButton.waitUntil(exist, 15000);
    }

    @Then("I click create user button")
    public void clickCreateUserButton() {
        usersManagementPage.createUserButton.click();
    }
}