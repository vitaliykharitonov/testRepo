package HomeWorkLesson13.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private final SelenideElement cartPrice1 = $x("(//div[@class='inventory_item_price']) [1]");
    private final SelenideElement cartPrice2 = $x("(//div[@class='inventory_item_price']) [2]");
    private final SelenideElement checkoutButton = $x("//button[@id='checkout']");

    public CartPage checkCartPrice1(String price1) {
        cartPrice1.shouldHave(partialText(price1));
        return this;
    }
    public CartPage checkCartPrice2(String price2) {
        cartPrice2.shouldHave(partialText(price2));
        return this;
    }
    public CartPage clickCheckoutButton() {
        checkoutButton.click();
        return this;
    }
}
