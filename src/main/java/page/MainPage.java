package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public final String usersDropDownListValue = "//a[contains(text(), '%s')]";
    public final String dropDownList = "//span[contains(text(), '%s')]";

    public SelenideElement pageBody =  $(byId("root"));
    public SelenideElement usersDropDownList =  $(byText("Users"));

    public SelenideElement getDropDownListValueByName(String name){
        String path = String.format(usersDropDownListValue, name);
        return $(byXpath(path));
    }

    public SelenideElement getDropDownListByName(String name){
        String path = String.format(dropDownList, name);
        return $(byXpath(path));
    }
}