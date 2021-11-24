package homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Utilites extends BaseTest{
    public void selectFromDropDown(By by,String value){
        WebElement dropDown1=driver.findElement(by);
        // dropDown1.click();
        Select select = new Select(dropDown1);
        select.selectByValue(value);
    }
    /*
    this method will get text fram element
    @pram by
    @return
     */
    public String getTextElement(By by) {
        return driver.findElement(by).getText();
       /* WebElement message = driver.findElement(by);
        String actualMessage = message.getText();
        return  actualMessage;*/
    }
    /*
    this method will send text on element
    @pram by
    @param text
     */

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    //clickable
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }
    public void selectbytextfromdroupdown(By by, String text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);

    }
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(1000);
    public void setEmailLink(By by,String email){
        WebElement emailTextBx = driver.findElement(by);
        emailTextBx.click();
        emailTextBx. sendKeys("username"+ randomInt +"@gmail.com");
    }

    public void selectValueFromdropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();


    }
    public void mouseHoverToClickElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }




}
