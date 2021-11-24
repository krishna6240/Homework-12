package computer;

import homepage.Utilites;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestSuite extends Utilites {
    String baseUrl = "https://demo.nopcommerce.com/";
    //WebDriver driver;


    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        clickOnElement(By.xpath("//a[normalize-space()='Computers']"));
        //clickOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        String expectedMessage = "Computers";
        String actualMessage = getTextElement(By.xpath("//a[normalize-space()='Computers']"));
        Assert.assertEquals("products page not displayed", expectedMessage, actualMessage);
    }
    @Test
    public void VerifyPositionDescendingOrder() {
        clickOnElement(By.xpath("//a[normalize-space()='Computers']"));
        clickOnElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));
        selectValueFromdropDown(By.xpath("//select[@id='products-orderby']"), "6");
        String expectedMessage = "Desktops";
        String actualMessage = getTextElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));
        Assert.assertEquals("error msg displayed", expectedMessage, actualMessage);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        clickOnElement(By.xpath("//a[normalize-space()='Computers']"));
        clickOnElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));
        selectValueFromdropDown(By.xpath("//select[@id='products-orderby']"), "5");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully1() throws InterruptedException {
        clickOnElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/1/1/1\"),!1']"));
        //driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']")).click();
        String expectedMessage = "Build your own computer";
        WebElement actualMessage = driver.findElement(By.xpath("//h1[text()='Build your own computer']"));
        String realMessage = actualMessage.getText();
        // String actualMessage = getTextElement(By.xpath("//h1[normalize-space()='Build your own computer']"));
        Assert.assertEquals("error msg displayed", expectedMessage, realMessage);
        clickOnElement(By.xpath("//select[@id='product_attribute_1']"));
        selectValueFromdropDown(By.xpath("//select[@id='product_attribute_1']"), "1");
        selectValueFromdropDown(By.xpath("//select[@id='product_attribute_2']"), "5");
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        clickOnElement(By.id("product_attribute_5_12"));
        String expectedPrice = "$1,475.00";
        WebElement actualPrice = driver.findElement(By.xpath("//span[text()='$1,475.00']"));
        String realPrice = actualPrice.getText();
        Assert.assertEquals("Price is not match", expectedPrice, realPrice);
        clickOnElement(By.id("add-to-cart-button-1"));
        String FinalMsg = "The product has been added to your shopping cart";
        WebElement Msg = driver.findElement(By.className("content"));
        String TrueMsg = Msg.getText();
        Assert.assertEquals("This msg should be appear", FinalMsg, TrueMsg);
        clickOnElement(By.className("close"));
        mouseHoverToElement(By.xpath("//span[text()='Shopping cart']"));
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        String expectedCartMessage = "Shopping cart";
        WebElement actualCartMessage = driver.findElement(By.xpath("//h1[text()='Shopping cart']"));
        String realCartMessage = actualCartMessage.getText();
        Assert.assertEquals("Verify the cart message", expectedCartMessage, realCartMessage);
        //  driver.findElement(By.xpath("//input[@value = '1']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        driver.findElement(By.xpath("//input[@value='1']")).sendKeys("2");
        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));
        String expectedTotalAmount = "$2,950.00";
        WebElement actualTotalAmount = driver.findElement(By.xpath("//span[@class='product-subtotal']"));
        String realTotalAmount = actualTotalAmount.getText();
        Assert.assertEquals("total is wrong", expectedTotalAmount, realTotalAmount);
        clickOnElement(By.cssSelector("#termsofservice"));
        clickOnElement(By.cssSelector("#checkout"));
        String expectedsignMsg = "Welcome, Please Sign In!";
        WebElement actualSignMsg = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        String realsignMsg = actualSignMsg.getText();
        Assert.assertEquals("User can not be in sign Page", expectedsignMsg, realsignMsg);
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[text()='Checkout as Guest']"));
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("krishna");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Patel");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("abc@yahoo.com");
        selectValueFromdropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Harrow");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("7,city Road");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("ha1 2fg");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("07856745634");
        driver.findElement(By.xpath("//button[@onclick='Billing.save()']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(3000);
        clickOnElement(By.cssSelector("#paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        Thread.sleep(1000);
        selectbytextfromdroupdown(By.xpath("//select[@id='CreditCardType']"), "MasterCard");
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("ABC");
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("5367852429396419");
        selectValueFromdropDown(By.xpath("//select[@id='ExpireMonth']"), "7");
        selectValueFromdropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("123");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        clickOnElement(By.xpath("//button[text()='Confirm']"));
        String expectedText = "Payment Method: Credit Card";
        WebElement actualTxtDriver = driver.findElement(By.xpath("//li[@class='payment-method']"));
        String actualText = actualTxtDriver.getText();
        Assert.assertEquals("Please check your payment method", expectedText, actualText);
        String exptxt = "Shipping Method: Next Day Air";
        WebElement actultxtdriver = driver.findElement(By.xpath("//li[@class='shipping-method']"));
        String actultxt = actultxtdriver.getText();
        Assert.assertEquals("Please check your payment method", exptxt, actultxt);
        String expectedTotalText = "Total: $2,950.00";
        WebElement actualTotalTxt = driver.findElement(By.xpath("//tr[@class='order-total']"));
        String actualTotalIs = actualTotalTxt.getText();
        Assert.assertEquals("Total Order Is Incorrect", expectedTotalText, actualTotalIs);
        clickOnElement(By.xpath("//button[@onclick='ConfirmOrder.save()']"));
        String expectedThankYou = "Thank you";
        WebElement actualThankYou = driver.findElement(By.xpath("//h1[text()='Thank you']"));
        String realThankYou = actualThankYou.getText();
        Assert.assertEquals("Thank you message should display", expectedThankYou, realThankYou);
        String expectedSuccess = "Your order has been successfully processed!";
        WebElement actualSuccess = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        String realSuccess = actualSuccess.getText();
        Assert.assertEquals("This message should display", expectedSuccess, realSuccess);
        clickOnElement(By.xpath("//button[@onclick='setLocation(\"/\")']"));
        String expectedLastMessage = "Welcome to our store";
        WebElement actualLastMessage = driver.findElement(By.xpath("//h2[text()='Welcome to our store']"));
        String realLastMessage = actualLastMessage.getText();
        Assert.assertEquals("This message should display", expectedLastMessage, realLastMessage);

    }

    @After
    public void tearDown() {
       // closeBrowser();
    }

}







