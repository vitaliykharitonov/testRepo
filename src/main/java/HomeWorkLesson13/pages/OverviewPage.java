package HomeWorkLesson13.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class OverviewPage {
    private final String overviewPageLink = "https://www.saucedemo.com/checkout-step-two.html";
    private final SelenideElement subtotalString = $x("//div[@class='summary_subtotal_label']");
    private final SelenideElement taxString = $x("//div[@class='summary_tax_label']");
    private final SelenideElement finishButton = $x("//button[@id='finish']");

    public OverviewPage checkOverviewPageOpen() {
        webdriver().shouldHave(url(overviewPageLink));
        return this;
    }
    public Double taxPercentCalc() {
        Double subtotal = Double.valueOf(subtotalString.getText().substring(subtotalString.getText().indexOf("$") + 1));
        Double tax = Double.valueOf(taxString.getText().substring(taxString.getText().indexOf("$") + 1));
        Double taxPercent = tax * 100 / subtotal;
        return taxPercent;
    }
    public OverviewPage clickFinishButton() {
        finishButton.click();
        return this;
    }
}
