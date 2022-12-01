import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class WebDriverMethodsExam {
    WebDriver driver;
    WebElement element;
    private JavascriptExecutor javascriptExecutor;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        javascriptExecutor = ((JavascriptExecutor) driver);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void actions() {
        driver.get("https://example.cypress.io/commands/actions");
        element = driver.findElement(By.cssSelector(".action-focus"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@for='password1']"))
                .getAttribute("style").contains("color: orange;"));
    }

    @Test
    public void cookies() {
        driver.get("https://example.cypress.io/commands/cookies");
        element = driver.findElement(By.className("set-a-cookie"));
        element.click();

        var cookie = driver.manage().getCookieNamed("token");
        Assert.assertEquals("123ABC", cookie.getValue());
    }

    @Test
    public void scrollToBottom() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page/");
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(4000);
    }

    @Test
    public void scrollToTop() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page/");
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(4000);
        javascriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(4000);
    }
}
