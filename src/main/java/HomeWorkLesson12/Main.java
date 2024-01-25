package HomeWorkLesson12;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Main {

    @BeforeTest
    public void setUpConfig() {
        Config.setConfig();
    }
    @Test
    public void test() {
        String bookName = "Head First. Патерни проєктування";
        Selenide.open("https://www.yakaboo.ua/");
        $x("//input[@type='search']").setValue(bookName);
        $x("(//div[contains(text(), '" + bookName + "')]) [1]").shouldBe(visible).click();
        if ($x("//div[@class='cl-widget-f8519v8519']").shouldBe(visible).isDisplayed()) { // Перевіряємо чи показався баннер. Якщо так, закриваємо його
            $x("//div[@class='cl-dialog-close-icon']").click();
        }
        if (!$x("//div[@class='side__box']//button[@data-testid='addToCart']").isDisplayed()) { // Перевіряємо чи є в наявності паперова книга
            if ($x("//div[@class='ui-btn-format option-button']//div[contains(text(), 'Електронна')]").isDisplayed()) { // Перевіряємо, чи існує електронна версія книги
                $x("//div[@class='ui-btn-format option-button']").click();
                if (!$x("//div[@class='side__box']//button[@data-testid='addToCart']").isDisplayed()) { // Перевіряємо чи є в наявності електронна книга
                    System.out.println("Паперової та електронної книги немає в наявності");
                }
                else {
                    System.out.println("Ціна електронної книги: " + $x("(//div[@class='side__box']//span) [1]").getText());
                }
            }
            else {
                System.out.println("Паперової книги немає в наявності");
            }
        }
        else {
            System.out.println("Ціна паперової книги: " + $x("(//div[@class='side__box']//span) [1]").getText());
        }
    }
}
