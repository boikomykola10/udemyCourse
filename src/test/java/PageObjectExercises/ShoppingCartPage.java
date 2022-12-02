package PageObjectExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getCheckoutButton() {
        return driver.findElement(By.id("checkout"));
    }
    public PersonalInformationPage startCheckout() {
        getCheckoutButton().click();
        return new PersonalInformationPage(driver);
    }

}
