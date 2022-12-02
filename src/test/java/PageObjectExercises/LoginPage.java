package PageObjectExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getUserNameField() {
        return driver.findElement(By.id("user-name"));
    }
    public ProductsPage login(String userName, String password) {
        getUserNameField().sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("btn_action")).submit();
        return new ProductsPage(driver);
    }


}
