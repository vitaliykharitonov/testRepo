package HomeWorkLesson13.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ProductsPage {
    public final String productsPageLink = "https://www.saucedemo.com/inventory.html";
    private final String price1 = "7.99";
    private final String price2 = "9.99";
    private final SelenideElement addToCartButtonPrice1 = $x("//div[text() = '" + price1 +"']/../button");
    private final SelenideElement addToCartButtonPrice2 = $x("//div[text() = '" + price2 +"']/../button");
    private final SelenideElement cartBadge = $x("//span[@class='shopping_cart_badge']");
    private final SelenideElement cartButton = $x("//a[@class='shopping_cart_link']");

    @Step("Add to cart first product")
    public ProductsPage clickAddToCartButtonPrice1() {
        addToCartButtonPrice1.click();
        return this;
    }
    @Step("Add to cart second product")
    public ProductsPage clickAddToCartButtonPrice2() {
        addToCartButtonPrice2.click();
        return this;
    }
    @Step("Check products page open")
    public ProductsPage checkProductsPageOpen() {
        webdriver().shouldHave(url(productsPageLink));
        return this;
    }
    @Step("Check cart adding")
    public ProductsPage checkCartAdding() {
        cartBadge.shouldHave(visible);
        return this;
    }
    @Step("Click cart button")
    public ProductsPage clickCartButton() {
        cartButton.click();
        return this;
    }

    public String getPrice1() {
        return price1;
    }
    public String getPrice2() {
        return price2;
    }
}
