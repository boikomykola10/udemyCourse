package PageObjectExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getShoppingCartElement() {
        return driver.findElement(By.className("shopping_cart_link"));
    }
    public ShoppingCartPage openShoppingCart() {
        getShoppingCartElement().click();
        return new ShoppingCartPage(driver);
    }
}
