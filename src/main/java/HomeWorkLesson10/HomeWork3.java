package HomeWorkLesson10;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class HomeWork3 {

    @Test (dataProvider = "movieData")
    public void test(String title, String link, String rating, String year) {
        Selenide.open(link);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(title, $x("//span[@class=\"hero__primary-text\"]").getText());
        softAssert.assertEquals(rating, $x("(//span[@class=\"sc-bde20123-1 cMEQkK\"]) [1]").getText());
        softAssert.assertEquals(year, $x("(//a[@class=\"ipc-link ipc-link--baseAlt ipc-link--inherit-color\"]) [6]").getText());
        softAssert.assertAll();
    }

    @DataProvider (name="movieData")
    public Iterator<Object[]> movieData() {
        List<Object[]> list = getInfo();
        return list.iterator();
    }

    public List<Object[]> getInfo(){
        Selenide.open("https://www.imdb.com/chart/top/");
        List movieList = new ArrayList<>();
        for (int i = 1; i <=100; i++) {
            String title = $x("(//div[@class=\"sc-1e00898e-0 jyXHpt cli-children\"]//h3) [" + i + "]").getText();
            title = title.substring(title.indexOf(" ") + 1);
            String link = $x("(//div[@class=\"sc-1e00898e-0 jyXHpt cli-children\"]//a) [" + i + "]").getAttribute("href");
            String rating = $x("(//span[@data-testid=\"ratingGroup--imdb-rating\"]) [" + i + "]").getAttribute("aria-label");
            rating = rating.substring(rating.indexOf(":") + 2);
            String year = $x("(//div[@class=\"sc-1e00898e-7 hcJWUf cli-title-metadata\"]/descendant::span[1]) [" + i + "]").getText();
            String movie[] = {title, link, rating, year};
            movieList.add(movie);
        }
        return movieList;
    }
}
