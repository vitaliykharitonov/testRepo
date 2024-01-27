package HomeWorkLesson13.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InformationPage {
    private final SelenideElement firstNameField = $x("//input[@id='first-name']");
    private final SelenideElement lastNameField = $x("//input[@id='last-name']");
    private final SelenideElement postalCodeField = $x("//input[@id='postal-code']");
    private final SelenideElement continueButton = $x("//input[@id='continue']");

    public InformationPage setFirstName(String firstname) {
        firstNameField.setValue(firstname);
        return this;
    }
    public InformationPage setLastName(String lastname) {
        lastNameField.setValue(lastname);
        return this;
    }
    public InformationPage setPostalCode(String postalcode) {
        postalCodeField.setValue(postalcode);
        return this;
    }
    public InformationPage clickContinueButton() {
        continueButton.click();
        return this;
    }
}
