package HomeWorkLesson13;

import HomeWorkLesson13.base.Config;
import HomeWorkLesson13.pages.*;
import io.qameta.allure.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {
    private final LoginPage loginPage = new LoginPage();
    private final ProductsPage productsPage = new ProductsPage();
    private final CartPage cartPage = new CartPage();
    private final InformationPage informationPage = new InformationPage();
    private final OverviewPage overviewPage = new OverviewPage();
    private final CompletePage completePage = new CompletePage();

    @BeforeTest
    public void setUpConfig() {
        Config.setConfiguration();
    }

    @Test
    @Feature("Frontend")
    @Issue("AQA-001")
    @TmsLink("TMS")
    @Owner("Vitaliy Kharitonov")
    @Link(name = "YouTube", url = "https://www.youtube.com/watch?v=9Ax-GSn52fc")
    @Severity(SeverityLevel.BLOCKER)
    public void login() {
        loginPage.loginPageOpen()
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .clickLoginButton();
        productsPage.checkProductsPageOpen();
    }

    @Test(dependsOnMethods = "login")
    @Feature("Frontend")
    @Owner("Vitaliy Kharitonov")
    @Severity(SeverityLevel.CRITICAL)
    public void addToCart() {
        productsPage.clickAddToCartButtonPrice1()
                .clickAddToCartButtonPrice2()
                .checkCartAdding();
    }

    @Test(dependsOnMethods = "addToCart")
    @Feature("Frontend")
    @Flaky
    @Owner("Vitaliy Kharitonov")
    @Severity(SeverityLevel.CRITICAL)
    public void cartCheck() {
        productsPage.clickCartButton();
        cartPage.checkCartPrice1(productsPage.getPrice1())
                .checkCartPrice2(productsPage.getPrice2())
                .clickCheckoutButton();
    }

    @Test(dependsOnMethods = "cartCheck")
    @Feature("Frontend")
    @Owner("Vitaliy Kharitonov")
    @Severity(SeverityLevel.CRITICAL)
    public void setInformation() {
        informationPage.setFirstName("TestFirstName")
                .setLastName("TestLastName")
                .setPostalCode("TestPostalCode")
                .clickContinueButton();
        overviewPage.checkOverviewPageOpen();
    }

    @Test(dependsOnMethods = "setInformation")
    @Feature("Frontend")
    @Owner("Vitaliy Kharitonov")
    @Severity(SeverityLevel.NORMAL)
    public void overview() {
        System.out.println("Tax is " + Math.round(overviewPage.taxPercentCalc()) + "%");
        overviewPage.clickFinishButton();
        completePage.checkCompleteHeader();
    }
}
