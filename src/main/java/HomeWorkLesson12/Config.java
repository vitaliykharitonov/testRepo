package HomeWorkLesson12;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.TextCheck;

public class Config {
    public static void  setConfig() {
        var config = new SelenideConfig();
        config.browser("chrome");
        config.browserSize("1920x1080");
        config.pageLoadStrategy("normal");
        config.pageLoadTimeout(15000);
        config.timeout(10000);
        config.textCheck(TextCheck.FULL_TEXT);
    }
}
