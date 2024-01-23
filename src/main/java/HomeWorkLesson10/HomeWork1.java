package HomeWorkLesson10;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork1 {

    @Test (dataProvider = "langs")
    public void googleTranslate(String lang, String translate){
        open("https://translate.google.com/?sl=uk&tl=" + lang  +"&op=translate");
        if ($x("//h1[contains(text(), \"Before you continue to Google\")]").isDisplayed()) {
            $x("(//button[@aria-label=\"Accept all\"]) [1]").click();
        }
        $x("//a[@aria-label=\"Turn off Input Method\"]").shouldBe(visible).click();
        $x("//textarea").setValue("Я круто вивчу TestNG");
        $x("//span[@class=\"ryNqvb\"]").shouldBe();
        Assert.assertEquals($x("//span[@class=\"ryNqvb\"]").getText(), translate);
    }

    @DataProvider(name = "langs")
    public Object[][] langs() {
        return new Object[][]{
                {"en", "I will study TESTNG cool"},
                {"de", "Ich werde testng cool studieren"},
                {"es", "Estudiaré testng genial"},
                {"pt", "Vou estudar testng legal"},
                {"it", "Studierò Testng Cool"},
                {"bg", "Ще проуча тестова готина"},
                {"cs", "Budu studovat testng cool"},
                {"el", "Θα μελετήσω το testng cool"},
                {"ga", "Déanfaidh mé staidéar ar Testng Cool"},
                {"ja", "テストをクールに勉強します"},
                {"ro", "Voi studia testng cool"},
                {"ko", "나는 테스트를 시원하게 공부할 것이다"},
                {"la", "Ego studere testng refrigescant"},
                {"ar", "سأدرس testng بارد"},
                {"mi", "Ka akohia e au te whakamatautau"},
                {"no", "Jeg vil studere testng kult"},
                {"pl", "Badam testng fajny"},
                {"th", "ฉันจะศึกษา testng เย็น"},
                {"tr", "Testng serin çalışacağım"},
                {"eo", "Mi studos testng malvarmeta"}
        };
    }
}
