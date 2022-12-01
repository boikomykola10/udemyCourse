import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InspectionQuiz {

    @Test
    public void typesOfLocators() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement element;
        //ID
        element = driver.findElement(By.id("user-name"));
        //NAME
        //driver.findElement(By.name("name of locator"));
        //Class name
        driver.findElement(By.className("form_input"));
        //Tag name
        driver.findElement(By.tagName("input"));
        //Css selector
        driver.findElement(By.cssSelector("#user-name"));
        //Xpath
        driver.findElement(By.xpath("//*[@id=\"user-name\"]"));

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        //Link text
        driver.findElement(By.linkText("Click me using this link text!"));
        //Partial link text
        driver.findElement(By.partialLinkText("link text!"));

        driver.quit();
    }
}
