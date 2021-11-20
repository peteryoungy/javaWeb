import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumExample {

    public static void main(String[] args) throws InterruptedException {
        // note: get chrome web driver
        WebDriverManager.chromedriver().setup();
        // note: get handle
        WebDriver driver = new ChromeDriver();
        // note: open a link
        driver.get("http://www.google.com");
        // note: get the search bar web element
        WebElement inputField = driver.findElement(By.name("q"));
        // note: input something to search in the search bar
        inputField.sendKeys("selenium");
        // note: 回车
        inputField.submit();
        // note: 在得到的页面中寻找匹配div.g a的 web elements
        List<WebElement> results = driver.findElements(By.cssSelector("div.g a"));
        // note: get all the links and print
        for (WebElement element : results) {
            String link = element.getAttribute("href");
            System.out.println(link);
        }
        Thread.sleep(5000);
        // note: close chrome page after doing all teh test, otherwise the page will still
        //  stay there
        driver.quit();
    }

}
