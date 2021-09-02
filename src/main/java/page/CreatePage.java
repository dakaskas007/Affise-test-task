package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreatePage {
    public SelenideElement changeAvatarButton = $(byXpath("//span[text() ='Change']/.."));
    public SelenideElement affiliateManagerRadioButtonInput = $(byXpath("//input[@type = 'radio' and @value = 'affiliate_manager']"));
    public SelenideElement affiliateManagerRadioButtonLabel = $(byXpath("//input[@type = 'radio' and @value = 'affiliate_manager']/following-sibling::label"));
    public SelenideElement permissionTab = $(byText("Permissions"));
    public SelenideElement generalButton = $(byText("General"));
    public SelenideElement marketplaceButton = $(byXpath("//span[contains(@class, 'PermissionsSelector')]/span[text() = 'Marketplace']"));
    public SelenideElement readRadioButtonInput = $(byXpath("//input[@type = 'radio' and @value = 'read']"));
    public SelenideElement readRadioButtonLabel = $(byXpath("//input[@type = 'radio' and @value = 'read']/following-sibling::label"));
    public SelenideElement usersButton = $(byXpath("//span[contains(@class, 'PermissionsSelector')]/span[text() = 'Users']"));
    public SelenideElement affiliatesEditingButton = $(byXpath("//span[contains(@class, 'PermissionsSelector')]/span[text() = 'Affiliates editing']"));
    public SelenideElement denyRadioButtonInput = $(byXpath("//input[@type = 'radio' and @value = 'deny']"));
    public SelenideElement denyRadioButtonLabel = $(byXpath("//input[@type = 'radio' and @value = 'deny']/following-sibling::label"));
    public SelenideElement readSearchField = $(byXpath("//span[text() = 'Read']/..//span[text() = 'Search ...']"));
    public SelenideElement inputSearchField = $(byXpath("//input[contains(@class, 'AsyncMultiSelect-css__input-open')]"));
    public SelenideElement writeSearchField = $(byXpath("//span[text() = 'Write']/..//span[text() = 'Search ...']"));
    public SelenideElement saveButton = $(byXpath("//span[contains(@class, 'components-Button')]/parent::button"));
    public SelenideElement nameField = $(byXpath("//span[text() = 'Name']/following-sibling::div/input"));
    public SelenideElement surnameField = $(byXpath("//span[text() = 'Surname']/following-sibling::div/input"));
    public SelenideElement emailField = $(byXpath("//span[text() = 'Email']/following-sibling::div/input"));
    public SelenideElement passwordField = $(byXpath("//span[text() = 'Password']/following-sibling::div/input"));
    public SelenideElement searchField = $(byXpath("//input[@placeholder = 'Search']"));
    public SelenideElement searchFieldValue = $(byXpath("//div[contains(@class, 'components-Search-css__focused')]"));
    public SelenideElement cancelAvatarButton = $(byXpath("//button [contains(@class, 'cancelButton') and text() = 'Cancel']"));
    public SelenideElement applyAvatarButton = $(byXpath("//button [contains(@class, 'submitButton') and text() = 'Apply']"));

    public ElementsCollection searchFieldValues = $$(byXpath("//div[contains(@class, 'AsyncMultiSelect-ListItem')]"));
    public ElementsCollection createdUserItemNames = $$(byXpath("//span[contains(@class, 'UserItem-css__name')]"));
    public ElementsCollection createdUserItemsType = $$(byXpath("//span[contains(@class, 'UserItem-css__name')]/following-sibling::span"));
    public ElementsCollection pictures = $$(byXpath("//input[@type = 'file']"));
}