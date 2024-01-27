package HomeWorkLesson13.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final String loginPageLink = "https://www.saucedemo.com";
    private final SelenideElement userNameField = $x("//input[@id='user-name']");
    private final SelenideElement passwordField = $x("//input[@id='password']");
    private final SelenideElement loginButton = $x("//input[@id='login-button']");

    public LoginPage loginPageOpen() {
        Selenide.open(loginPageLink);
        return this;
    }
    public LoginPage setUserName(String username) {
        userNameField.setValue(username);
        return this;
    }
    public LoginPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }
}
