package HomeWorkLesson10;


import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class HomeWork2 {
    @BeforeTest
    public void login() {
        Selenide.open("https://trello.com");
        $x("(//a[contains(text(), \"Log in\")]) [1]").click();
        $x("//input[@id=\"username\"]").setValue("vitalii.kharitonov@amo.tech");
        $x("//button[@id=\"login-submit\"]").click();
        $x("//input[@id=\"password\"]").setValue("testngtrello");
        $x("//button[@id=\"login-submit\"]").click();
        webdriver().shouldHave(url("https://trello.com/u/vitaliikharitonov1/boards"));
    }

    @Test
    public void dashboard(){
        $x("(//a[@class=\"board-tile\"])").shouldBe(visible).click();
        webdriver().shouldHave(url("https://trello.com/b/A2pRiNcM/test"));
    }

    @Test(dependsOnMethods = "dashboard")
    public void card(){
        $x("(//button[@data-testid=\"list-add-card-button\"]) [2]").click();
        $x("//textarea[@data-testid=\"list-card-composer-textarea\"]").setValue("Test card");
        $x("//button[@data-testid=\"list-card-composer-add-card-button\"]").click();
        $x("//button[@data-testid=\"list-card-composer-cancel-button\"]").click();
        Assert.assertEquals($x("//a[@data-testid=\"card-name\"]").getText(), "Test card");
        sleep(1000);
    }

    @Test(dependsOnMethods = "card", priority = 1)
    public void description(){
        $x("//div[@data-testid=\"trello-card\"]").shouldBe(visible).click();
        $x("//div[@data-testid=\"click-wrapper\"]").shouldBe(visible).click();
        $x("//div[@id=\"ak-editor-textarea\"]").setValue("Test description");
        $x("//button[contains(text(), \"Save\")]").click();
        Assert.assertEquals($x("//p[@dir=\"auto\"]").getText(), "Test description");
        $x("//a[@aria-label=\"Close dialog\"]").click();
    }

    @Test(dependsOnMethods = "card", priority = 2)
    public void comment(){
        $x("//div[@data-testid=\"trello-card\"]").shouldBe(visible).click();
        $x("//input[@data-testid=\"card-back-new-comment-input-skeleton\"]").click();
        $x("//div[@class=\"new-comment mod-card-back\"]//div[@role=\"textbox\"]").setValue("Test comment");
        $x("//button[@data-testid=\"card-back-comment-save-button\"]").click();
        Assert.assertEquals($x("//div[@class=\"comment-container\"]//p").getText(), "Test comment");
        $x("//a[@aria-label=\"Close dialog\"]").click();
    }

    @Test(dependsOnMethods = "card", priority = 3, alwaysRun = true)
    public void delete(){
        $x("//button[@data-testid=\"quick-card-editor-button\"]").shouldBe(visible).click();
        sleep(1000);
        $x("//button[@data-testid=\"quick-card-editor-archive\"]").shouldBe(visible).click();
        $x("//a[contains(text(), \"Test card\")]").shouldBe(disappear);
    }
}
