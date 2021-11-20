package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        // note: get chrome web driver
        WebDriverManager.chromedriver().setup();
        // note: get handle
        WebDriver driver = new ChromeDriver();
        // note: open a link
        driver.get("http://localhost:8080/animal");
        // note: get the search bar web element
        WebElement inputField = driver.findElement(By.id("animalText"));
        inputField.sendKeys("tiger");
        inputField = driver.findElement(By.id("adjective"));
        inputField.sendKeys("cute");
        // note: 回车
//        for(int i =0;i<5;i++){
//            inputField.submit();
//        }
//        inputField.submit();
//        inputField.submit();
//        inputField.submit();
//        inputField.submit();
//        inputField.submit();

        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("submit")).click();

        WebElement result = driver.findElement(By.className("conclusionMessage"));
        System.out.println(result.getText());

        Thread.sleep(5000);
        driver.quit();
    }

}
