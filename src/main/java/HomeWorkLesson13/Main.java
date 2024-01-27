package HomeWorkLesson13;

import HomeWorkLesson13.pages.*;
import org.testng.annotations.Test;

public class Main {
    private final LoginPage loginPage = new LoginPage();
    private final ProductsPage productsPage = new ProductsPage();
    private final CartPage cartPage = new CartPage();
    private final InformationPage informationPage = new InformationPage();
    private final OverviewPage overviewPage = new OverviewPage();
    private final CompletePage completePage = new CompletePage();

    @Test
    public void login() {
        loginPage.loginPageOpen()
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton();
        productsPage.checkProductsPageOpen();
    }

    @Test(dependsOnMethods = "login")
    public void addToCart() {
        productsPage.clickAddToCartButtonPrice1()
                .clickAddToCartButtonPrice2()
                .checkCartAdding();
    }

    @Test(dependsOnMethods = "addToCart")
    public void cartCheck() {
        productsPage.clickCartButton();
        cartPage.checkCartPrice1(productsPage.getPrice1())
                .checkCartPrice2(productsPage.getPrice2())
                .clickCheckoutButton();
    }

    @Test(dependsOnMethods = "cartCheck")
    public void setInformation() {
        informationPage.setFirstName("TestFirstName")
                .setLastName("TestLastName")
                .setPostalCode("TestPostalCode")
                .clickContinueButton();
        overviewPage.checkOverviewPageOpen();
    }

    @Test(dependsOnMethods = "setInformation")
    public void overview() {
        System.out.println("Tax is " + Math.round(overviewPage.taxPercentCalc()) + "%");
        overviewPage.clickFinishButton();
        completePage.checkCompleteHeader();
    }
}
