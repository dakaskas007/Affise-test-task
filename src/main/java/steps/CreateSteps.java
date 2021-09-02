package steps;

import io.cucumber.java.en.Then;
import page.CreatePage;
import tools.DataGenerator;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.exist;
import static org.awaitility.Awaitility.with;
import static org.junit.Assert.assertEquals;

public class CreateSteps {

    CreatePage createPage = new CreatePage();

    String name = "";
    String surname = "";

    @Then("I wait loading create user page")
    public void waitLoadingCreateUserPage() {
        createPage.changeAvatarButton.waitUntil(exist, 15000);
    }

    @Then("I click on {string}")
    public void clickOButton(String button){
        switch (button) {
            case "change avatar button":
                createPage.changeAvatarButton.click();
                break;
            case "affiliates editing button":
                createPage.affiliatesEditingButton.click();
                break;
            case "cancel avatar button":
                createPage.cancelAvatarButton.click();
                break;
            case "general button":
                createPage.generalButton.click();
                break;
            case "marketplace button":
                createPage.marketplaceButton.click();
                break;
            case "save button":
                createPage.saveButton.click();
                break;
            case "users button":
                createPage.usersButton.click();
                break;
            case "permission tab":
                createPage.permissionTab.click();
                break;
            case "read search field":
                createPage.readSearchField.click();
                break;
            case "write search field":
                createPage.writeSearchField.click();
                break;
            case "apply avatar button":
                createPage.applyAvatarButton.click();
                break;
            case "first value from list":
                createPage.searchFieldValues.first().click();
                break;
            default:
                break;
        }
    }

    @Then("I fill defined data {string} to {string} field")
    public void fillField(String value, String field) {
        switch (field) {
            case "input search":
                createPage.inputSearchField.sendKeys(value);
                break;
            case "search value":
                createPage.searchFieldValue.sendKeys(value);
                break;
            default:
                break;
        }
    }

    @Then("I fill random data to {string} field")
    public void fillField(String field) {
        switch (field) {
            case "email":
                createPage.emailField.sendKeys("auto_test_" + DataGenerator.generateString(6)  + "@mail.com");
                break;
            case "name":
                name = "auto_name" + DataGenerator.generateString(6);
                createPage.nameField.sendKeys(name);
                break;
            case "password":
                createPage.passwordField.sendKeys("" + DataGenerator.generateString(6));
                break;
            case "surname":
                surname = "auto_surname" + DataGenerator.generateString(6);
                createPage.surnameField.sendKeys(surname);
                break;
            default:
                break;
        }
    }

    @Then("I search created user")
    public void searchCreatedUser() {
        createPage.searchField.sendKeys(name);
        with().pollInterval(3, TimeUnit.SECONDS).await().until(() -> true);
    }

    @Then("I see created user with type {string}")
    public void seeCreatedUser(String type) {
        assertEquals(name + " " + surname, createPage.createdUserItemNames.first().getText());
        assertEquals(type, createPage.createdUserItemsType.first().getText());
    }

    @Then("I select {string} radio button")
    public void selectRadioButton(String button) {
        switch (button) {
            case "affiliate manager":
                if(!createPage.affiliateManagerRadioButtonInput.isSelected()){
                    createPage.affiliateManagerRadioButtonLabel.click();
                }
                break;
            case "read":
                if(!createPage.readRadioButtonInput.isSelected()){
                    createPage.readRadioButtonLabel.click();
                }
                break;
            case "deny":
                if(!createPage.denyRadioButtonInput.isSelected()){
                    createPage.denyRadioButtonLabel.click();
                }
                break;
            default:
                break;
        }
    }
}