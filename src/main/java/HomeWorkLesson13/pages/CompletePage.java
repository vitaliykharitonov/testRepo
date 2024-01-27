package HomeWorkLesson13.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class CompletePage {
    private final SelenideElement completeHeader = $x("//h2");

    public void checkCompleteHeader() {
        completeHeader.shouldHave(text("Thank you for your order!"));
    }
}
