package steps;

import io.cucumber.java.en.Then;
import page.MainPage;

import static com.codeborne.selenide.Condition.exist;

public class MainSteps {
    MainPage mainPage = new MainPage();

    @Then("I wait loading main page")
    public void waitLoadingMainPage() {
        mainPage.pageBody.waitUntil(exist, 15000);
    }

    @Then("I go to {string} page")
    public void goToUsersManagementPage(String page){
        mainPage.usersDropDownList.click();
        mainPage.getDropDownListValueByName(page).click();
    }
}