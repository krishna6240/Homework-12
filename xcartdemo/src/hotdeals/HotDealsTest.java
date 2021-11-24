package hotdeals;

import homepage.Utilites;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HotDealsTest extends Utilites {
    String baseUrl = " https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() {
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
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverToClickElement(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        String saleMsg = "Sale";
        String actualSalesMsg = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("UserIs Not On Sales Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverToClickElement(By.xpath("//a[normalize-space()='Price Low - High']"));
        String LowToHigh = "Price Low - High";
        String actualLowHigh = getTextElement(By.xpath("//span[text()='Price Low - High']"));
        Assert.assertEquals("UserIs Not On Sales Page", LowToHigh, actualLowHigh);
    }
    @Test
    public void vefirySalesProductsArrangedByRates(){
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverToClickElement(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        String saleMsg = "Sale";
        String actualSalesMsg = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("UserIs Not On Sales Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverToClickElement(By.xpath("//a[@data-sort-by='r.rating']"));
        String Rates = "Rates";
        String actualRates = getTextElement(By.xpath("//span[text()='Rates ']"));
        Assert.assertEquals("UserIs Not On Sales Page", Rates, actualRates);
    }
    @Test
    public void verifyBestSellersProductsArrangeByZToA(){
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverToClickElement(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        String saleMsg = "Sale";
        String actualSalesMsg = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("UserIs Not On Sales Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverToClickElement(By.xpath("//a[normalize-space()='Name Z - A']"));
        String ZToA = "Name Z - A";
        String actualZToA = getTextElement(By.xpath("//span[text()='Name Z - A']"));
        Assert.assertEquals("UserIs Not On Sales Page", actualZToA, actualZToA);
    }
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow(){
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverToClickElement(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        String saleMsg = "Bestsellers";
        String actualSalesMsg = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("UserIs Not On Sales Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverToClickElement(By.xpath("//a[normalize-space()='Price High - Low']"));
        String ZToA = "Price High - Low";
        String actualZToA = getTextElement(By.xpath("//span[text()='Price High - Low']"));
        Assert.assertEquals("UserIs Not On Sales Page", actualZToA, actualZToA);

    }
    @Test
    public void verifyBestSellersProductsArrangeByRates(){
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverToClickElement(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        String saleMsg = "Bestsellers";
        String actualSalesMsg = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("UserIs Not On Sales Page", saleMsg, actualSalesMsg);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverToClickElement(By.xpath("//a[@data-sort-by='r.rating']"));
        String Rates = "Rates";
        String actualRates = getTextElement(By.xpath("//span[text()='Rates ']"));
        Assert.assertEquals("UserIs Not On Sales Page", actualRates,Rates );
    }
    }

