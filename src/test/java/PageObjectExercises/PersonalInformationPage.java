package PageObjectExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInformationPage {
    private WebDriver driver;

    public PersonalInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getFirstNameField() {
       return driver.findElement(By.id("first-name"));
    }
    private WebElement getLastNameField() {
        return driver.findElement(By.id("last-name"));
    }
    private WebElement getZipCodeField() {
        return driver.findElement(By.id("postal-code"));
    }
    public PersonalInformationPage fillOutTheForm() {
        getFirstNameField().sendKeys("firstName");
        getLastNameField().sendKeys("lastName");
        getZipCodeField().sendKeys("12345");
        return this;
    }
}
