import org.junit.Assert;
import org.openqa.selenium.By;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;



public class TestAuthorizationEmail extends NewUserReg {

    public By errorUsingAccount = By.xpath("//div[@class='alert alert-danger']/ol/li");


    @Test
    public void emailTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Open browser in fullscreen
        driver.get(url_reg); // Open page registration


        // Leave the 'Email address' text field blank and click the 'Create an account' button
        driver.findElement(createAnAccountButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String errorEmail = driver.findElement(errorUsingAccount).getText();

        Assert.assertEquals("Invalid email address.", errorEmail);

        // Enter email in the 'Email address' field of the previously registered mailing address
        // and click the 'Create an account' button

        driver.findElement(inputEmail).sendKeys(emailReady);
        driver.findElement(createAnAccountButton).click();
        errorEmail = driver.findElement(errorUsingAccount).getText();
        Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.", errorEmail);

        // Enter data in the 'Email address' field -sperasoft@mail.ru
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys(emailWithExclamation);
        driver.findElement(createAnAccountButton).click();
        errorEmail = driver.findElement(errorUsingAccount).getText();
        Assert.assertEquals("Invalid email address.", errorEmail);

        // Enter data in the 'Email address' field sper@softm@il.ru
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys(emailWithTwoAt);
        driver.findElement(createAnAccountButton).click();
        errorEmail = driver.findElement(errorUsingAccount).getText();
        Assert.assertEquals("Invalid email address.", errorEmail);

        // Enter data in the 'Email address' field sperasoft@mail.
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys(emailWithoutDomainZone);
        driver.findElement(createAnAccountButton).click();
        errorEmail = driver.findElement(errorUsingAccount).getText();
        Assert.assertEquals("Invalid email address.", errorEmail);

        // Enter data in the 'Email address' field sperasoft@mailru
        driver.findElement(inputEmail).clear();
        driver.findElement(inputEmail).sendKeys(emailWithoutPoint);
        driver.findElement(createAnAccountButton).click();
        errorEmail = driver.findElement(errorUsingAccount).getText();
        Assert.assertEquals("Invalid email address.", errorEmail);



        //driver.close();





























    }






}
