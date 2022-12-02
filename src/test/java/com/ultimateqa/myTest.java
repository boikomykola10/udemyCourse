package com.ultimateqa;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class myTest {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void shouldBeAbleToCheckout() {
        PersonalInformationPage personalInfo = new PersonalInformationPage(driver);
        personalInfo.open();
        personalInfo.submitPersonalInformation();
        new CheckoutOverviewPage(driver).finish();
        Assert.assertTrue(new OrderConfirmationPage(driver).isSuccessful());
    }
}
