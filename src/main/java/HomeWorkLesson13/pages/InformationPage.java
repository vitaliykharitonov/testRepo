package HomeWorkLesson13.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class InformationPage {
    private final SelenideElement firstNameField = $x("//input[@id='first-name']");
    private final SelenideElement lastNameField = $x("//input[@id='last-name']");
    private final SelenideElement postalCodeField = $x("//input[@id='postal-code']");
    private final SelenideElement continueButton = $x("//input[@id='continue']");

    @Step("Set first name")
    public InformationPage setFirstName(String firstname) {
        firstNameField.setValue(firstname);
        return this;
    }
    @Step("Set last name")
    public InformationPage setLastName(String lastname) {
        lastNameField.setValue(lastname);
        return this;
    }
    @Step("Set postal code")
    public InformationPage setPostalCode(String postalcode) {
        postalCodeField.setValue(postalcode);
        return this;
    }
    @Step("Click continue button")
    public InformationPage clickContinueButton() {
        continueButton.click();
        return this;
    }
}
