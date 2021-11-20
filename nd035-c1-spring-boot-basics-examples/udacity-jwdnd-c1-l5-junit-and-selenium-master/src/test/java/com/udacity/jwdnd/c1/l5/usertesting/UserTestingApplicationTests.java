package com.udacity.jwdnd.c1.l5.usertesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// note: use random server port because there might be multiple tests executed at the same time
class UserTestingApplicationTests {
    @LocalServerPort
    // note: get the random port number
    private Integer port;

    private static WebDriver driver;
    private CounterPage counter;

    @BeforeAll
    // note: initialize the web driver
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    // note: close the web driver
    public static void afterAll() {
        driver.quit();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/counter");
        counter = new CounterPage(driver);
    }

    @Test
    public void testIncrement() {
        int prevValue = counter.getDisplayedCount();
        counter.incrementCount();
        assertEquals(prevValue + 1, counter.getDisplayedCount());
    }

    @Test
    public void testIncrementTenTimes() {
        int prevValue = counter.getDisplayedCount();
        for (int i = 0; i < 10; i++) {
            assertEquals(prevValue + i, counter.getDisplayedCount());
            counter.incrementCount();
        }
    }

    @Test
    public void testReset() {
        counter.resetCount(10);
        assertEquals(10, counter.getDisplayedCount());
        counter.resetCount(0);
        assertEquals(0, counter.getDisplayedCount());
    }

}
