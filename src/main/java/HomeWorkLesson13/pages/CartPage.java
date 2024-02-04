package HomeWorkLesson13.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private final SelenideElement cartPrice1 = $x("(//div[@class='inventory_item_price']) [1]");
    private final SelenideElement cartPrice2 = $x("(//div[@class='inventory_item_price']) [2]");
    private final SelenideElement checkoutButton = $x("//button[@id='checkout']");

    @Step("Check first product at cart")
    public CartPage checkCartPrice1(String price1) {
        cartPrice1.shouldHave(partialText(price1));
        return this;
    }
    @Step("Check second product at cart")
    public CartPage checkCartPrice2(String price2) {
        cartPrice2.shouldHave(partialText(price2));
        return this;
    }
    @Step("Click checkout button")
    public CartPage clickCheckoutButton() {
        checkoutButton.click();
        return this;
    }
}
