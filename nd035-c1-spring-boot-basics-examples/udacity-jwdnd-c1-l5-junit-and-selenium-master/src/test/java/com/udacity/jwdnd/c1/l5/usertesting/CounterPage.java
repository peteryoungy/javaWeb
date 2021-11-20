package com.udacity.jwdnd.c1.l5.usertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// note: selenium style: WebElement and FindBy
// note: 这个类模拟了user在网页上可能进行的一系列操作
public class CounterPage {

    @FindBy(id = "count-display")
    private WebElement countDisplay;

    @FindBy(id = "increment-button")
    private WebElement incrementButton;

    @FindBy(id = "reset-value-field")
    private WebElement resetValueField;

    @FindBy(id = "reset-button")
    private WebElement resetButton;

    public CounterPage(WebDriver driver) {
        // note: use a web driver to initialize all the elements in the page
        PageFactory.initElements(driver, this);
    }

    public int getDisplayedCount() {
        return Integer.parseInt(countDisplay.getText());
    }

    public void incrementCount() {
        incrementButton.click();
    }

    public void resetCount(int value) {
        resetValueField.clear();
        resetValueField.sendKeys(String.valueOf(value));
        resetButton.click();
    }
}
