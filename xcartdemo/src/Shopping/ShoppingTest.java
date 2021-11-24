package Shopping;

import homepage.Utilites;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ShoppingTest extends Utilites {
    String baseUrl = " https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverToClickElement(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        String saleMsg = "Sale";
        String actualSalesMsg = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("UserIs Not On Sales Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverToClickElement(By.xpath("//a[normalize-space()='Name A - Z']"));
        String AToZ = "Name A - Z";
        String actualAToZ = getTextElement(By.xpath("//span[text()='Name A - Z']"));
        Assert.assertEquals("UserIs Not On Sales Page", AToZ, actualAToZ);
        clickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]"));
        Thread.sleep(3000);
        String ProductAdd = "Product has been added to your cart";
        String actualProductAdd = getTextElement(By.xpath("//li[text()='Product has been added to your cart']"));
        Assert.assertEquals("Product Added sucessfully", ProductAdd, actualProductAdd);
        clickOnElement(By.xpath("//a[@class='close']"));//click on close sign(in green bar)
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[normalize-space()='View cart']"));
        String expectedProductAddedMsg="Your shopping cart - 1 item";//product added assert
        String realProductAddedMsg=getTextElement(By.id("page-title"));
        Assert.assertEquals("Show the message if product is not added",expectedProductAddedMsg,realProductAddedMsg);
        driver.findElement(By.id("amount16")).clear();//first remove 1 quantity
        Thread.sleep(2000);
        driver.findElement(By.id("amount16")).click(); //click on quantity
        driver.findElement(By.id("amount16")).sendKeys("2");//add 2
        String added2ProductMsg = "Your shopping cart - 2 items";    //assert for 2 quantity added
        String real2ProductMsg = getTextElement(By.xpath("//h1[text()='Your shopping cart - 2 items']"));
        Assert.assertEquals("Cart Does nOt Have 2 Items",added2ProductMsg, real2ProductMsg);
        String subTotal = "Subtotal: $29.98";  //assert for newly added product
        String realSubTotal = getTextElement(By.xpath("//span[@class='cart-subtotal']/parent::li/ancestor::ul"));
        Assert.assertEquals("SubTotal Is Wrong", subTotal, realSubTotal);
        String totalAmount = "$36.00";                     //verify Total
        String realTotalAmount = getTextElement(By.xpath("//li[@class='total']"));
        Assert.assertEquals("Total Is Incorrect", totalAmount, realTotalAmount);
        clickOnElement(By.xpath("//span[normalize-space()='Go to checkout']"));
        String PageVerifiy = "Log in to your account";                     //verify Total
        String ExpectedPage = getTextElement(By.xpath("//h3[normalize-space()='Log in to your account']"));
        Assert.assertEquals("Total Is Incorrect", PageVerifiy, ExpectedPage);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abcd@yahoo.com");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[normalize-space()='Continue']"));
        String expectedSecureText = "Secure Checkout";                            //asert for secure checkout
        String realSecureText = getTextElement(By.xpath("//h1[@class='title']"));
        Assert.assertEquals("User Is Not On secureCheckout page", expectedSecureText, realSecureText);
        driver.findElement(By.xpath("//input[@id='shippingaddress-firstname']")).sendKeys("Krishna");
        driver.findElement(By.xpath("//input[@id='shippingaddress-lastname']")).sendKeys("Patel");
        driver.findElement(By.xpath("//input[@id='shippingaddress-street']")).sendKeys("UK");
        driver.findElement(By.xpath("//input[@id='shippingaddress-city']")).sendKeys("London");
        selectValueFromdropDown(By.xpath("//select[@id='shippingaddress-country-code']"), "GB");
        driver.findElement(By.xpath("//input[@id='shippingaddress-custom-state']")).sendKeys("Middlesex");
        driver.findElement(By.xpath("//input[@id='shippingaddress-phone']")).sendKeys("015550000000");
        clickOnElement(By.xpath("//input[@id='create_profile']"));
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("4gfdtrt!yu");
        Thread.sleep(2000);
        mouseHoverToElement(By.id("method128"));
        clickOnElement(By.id("method128"));   //click on local shipping method
        Thread.sleep(1000);
        clickOnElement(By.id("pmethod6"));//cod click
        mouseHoverToElement(By.xpath("//span[normalize-space()='Place order: $37.03']"));
        clickOnElement(By.xpath("//span[normalize-space()='Place order: $37.03']"));
         String expectedLastMsg = "Thank you for your order";    //verifying thank you page
        String realLastMsg = getTextElement(By.cssSelector("#page-title"));
        Assert.assertEquals("Order Has Not Been Placed ", expectedLastMsg, realLastMsg);
   }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        clickOnElement(By.linkText("Bestsellers"));
        String expectedMessage = "Bestsellers";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Bestsellers", expectedMessage, actualMessage);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[normalize-space()='Name A - Z']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']"));
        clickOnElement(By.xpath("//button[@class='btn  regular-button regular-main-button add2cart submit']"));
        Thread.sleep(2000);
        String expectedMsg = "Product has been added to your cart";
        String actualMsg = getTextElement(By.xpath("//li[@class='info']"));
        Assert.assertEquals("Verification failed for Text : Product has been added to your cart", expectedMsg, actualMsg);
        clickOnElement(By.xpath("//a[@class='close']"));
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        String expectedMsgcart = "Your shopping cart - 1 item";
        String actualMsgcart = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Your shopping cart - 1 item", expectedMsgcart, actualMsgcart);
        clickOnElement(By.xpath("//a[normalize-space()='Empty your cart']"));
        String emptyCartMsg = "Are you sure you want to clear your cart?";
        String realEmptyCartMsg = driver.switchTo().alert().getText();//to get text which we can not inspect
        Assert.assertEquals("Cart Is Not Being Emptied", emptyCartMsg, realEmptyCartMsg);
        driver.switchTo().alert().accept();//when ok is also not inspected
        String empryCartMsg = "Item(s) deleted from your cart";
        String actualEmptyCartMsgIs = getTextElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        Assert.assertEquals("Customer's Cart Is Not Empty", empryCartMsg, actualEmptyCartMsgIs);
        String lastEmptyCartMessage = "Your cart is empty";    //verifying your cart is empty text
        String actualLastEmptyCartMessage = getTextElement(By.xpath("//h1[text()='Your cart is empty']"));
        Assert.assertEquals("Your  empty cart message is wrong", lastEmptyCartMessage, actualLastEmptyCartMessage);
    }
}


