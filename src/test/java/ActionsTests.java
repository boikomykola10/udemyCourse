import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsTests {
    WebDriver driver;
    WebElement element;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.xpath("//select[@id='dropdown']"));
        element.click();
        WebElement option1 = element.findElement(By.cssSelector("option[value='1']"));
        WebElement option2 = element.findElement(By.cssSelector("option[value='2']"));
        option1.click();
        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());
    }
    @Test
    public void secondTest() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.className("figure"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        element = driver.findElement(By.xpath("//*[contains(text(),'name: user1')]"));
        Assert.assertTrue("user1 should appear because we hovered over that image", element.isDisplayed());
    }
    @Test
    public void thirdTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).pause(3000).perform();
        driver.switchTo().alert().accept();
    }
    @Test
    public void fourthTest() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        element = driver.findElement(By.id("target"));
        element.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_RIGHT).pause(3000).perform();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: RIGHT", result);

    }
    @Test
    public void fifthTest() {
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        element = driver.findElement(By.xpath("//*[contains(text(),'Clickable Icon')]"));
        Assert.assertEquals("https://ultimateqa.com/link-success/", element.getAttribute("href"));
        Assert.assertEquals("padding-box", element.getCssValue("background-origin"));
    }
}
