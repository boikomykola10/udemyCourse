package com.ultimateqa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInformationPage {
    private WebDriver driver;
    public PersonalInformationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void submitPersonalInformation() {
        getFirstName().sendKeys("first name");
        getLastName().sendKeys("last name");
        getZipCode().sendKeys("12345");
        getSubmitButton().click();
    }

    private WebElement getSubmitButton() {
        return driver.findElement(By.className("cart-button"));
    }

    private WebElement getZipCode() {
        return driver.findElement(By.id("postal-code"));
    }

    private WebElement getLastName() {
        return driver.findElement(By.id("last-name"));
    }

    private WebElement getFirstName() {
        return driver.findElement(By.cssSelector("#first-name"));
    }

    public void open() {
        driver.navigate().to("https://www.saucedemo.com/checkout-step-one.html");
    }
}
