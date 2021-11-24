package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends Utilites {
    String baseUrl = " https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf']//a[@href='shipping.html']//span[contains(text(),'Shipping')]"));
        String expectedText = "Shipping";
        WebElement ActualText = driver.findElement(By.xpath("(//span[contains(text(),'Shipping')])[2]"));
        String RealText = ActualText.getText();
        Assert.assertEquals("Verify the text is not match", expectedText, RealText);
        Thread.sleep(2000);
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'New!')]"));
        String expectedText1 = "New arrivals";
        WebElement ActualText1 = driver.findElement(By.xpath("//h1[@id='page-title']"));
        String RealText1 = ActualText1.getText();
        Assert.assertEquals("Verify the text is not match", expectedText1, RealText1);

    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf']//a[@href='shipping.html']//span[contains(text(),'Shipping')]"));
        String expectedText2 = "Coming soon";
        WebElement ActualText2 = driver.findElement(By.xpath("(//span[contains(text(),'Coming soon')])[2]"));
        String RealText2 = ActualText2.getText();
        Assert.assertEquals("Verify the text is not match", expectedText2, RealText2);
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf last']//a"));
        String expectedText3 = "Contact us";
        WebElement ActualText3 = driver.findElement(By.xpath("(//span[contains(text(),'Contact us')])[2]"));
        String RealText3 = ActualText3.getText();
        Assert.assertEquals("Verify the text is not match", expectedText3, RealText3);


    }
}
