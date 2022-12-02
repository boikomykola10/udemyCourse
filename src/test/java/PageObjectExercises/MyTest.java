package PageObjectExercises;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyTest {
    public WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.saucedemo.com/");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void firstTest() throws InterruptedException {
        PersonalInformationPage loginPage = new LoginPage(driver)
                .login("standard_user", "secret_sauce")
                .openShoppingCart()
                .startCheckout()
                .fillOutTheForm();
        Thread.sleep(3000);

        /*ProductsPage productsPage = new ProductsPage(driver);
        productsPage.openShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.startCheckout();
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        personalInformationPage.fillOutTheForm();
        Thread.sleep(5000);*/

    }
}
