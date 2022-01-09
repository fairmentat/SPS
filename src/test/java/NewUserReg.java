import org.openqa.selenium.By;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class NewUserReg extends Data {

    public By signIn = By.linkText("Sign in");
    public By inputEmail = By.id("email_create");
    public By createAnAccountButton = By.xpath("//button[@class='btn btn-default button button-medium exclusive']");
    public By genderCheck = By.xpath("//input[@id=\"id_gender1\"]");
    public By firstNameField = By.id("customer_firstname");
    public By lastNameField = By.id("customer_lastname");
    public By passwordField = By.id("passwd");
    public By newsCheck = By.xpath("//div[@class='checker']//input[@id='newsletter']");
    public By optinCheck = By.xpath("//div[@class='checker']//input[@id='optin']");
    public By companyField = By.id("company");
    public By address1Field = By.id("address1");
    public By address2Field = By.id("address2");
    public By cityField = By.id("city");
    public By stateField = By.id("id_state");
    public By zipField = By.id("postcode");
    public By countryField = By.id("id_country");
    public By additionalField = By.id("other");
    public By mobileField = By.id("phone_mobile");
    public By aliasField = By.id("alias");
    public By daysField = By.id("days");
    public By monthsField = By.id("months");
    public By yearsField = By.id("years");
    public By regButton = By.id("submitAccount");
    public By userNameCheck = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");



    @Test
    public void registration() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // Open browser in fullscreen
        driver.get(url); // Open website
        driver.findElement(signIn).click(); // Open window registration
        driver.findElement(inputEmail).sendKeys(email+d); // Input email in text field
        driver.findElement(createAnAccountButton).click(); // Push the button 'Create an account'

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Sleep time for download page


        driver.findElement(genderCheck).click(); // Check gender
        driver.findElement(firstNameField).sendKeys(firstName); //Input first name
        driver.findElement(lastNameField).sendKeys(lastName); //Input last name


        driver.findElement(passwordField).sendKeys(pass); //Input password

        // Select days
        WebElement daySelect = driver.findElement(daysField);
        Select selectDay = new Select(daySelect);
        selectDay.selectByValue(day);

        // Select months
        WebElement monthsSelect = driver.findElement(monthsField);
        Select selectMonths = new Select(monthsSelect);
        selectMonths.selectByValue(month);

        // Select year
        WebElement yearSelect = driver.findElement(yearsField);
        Select selectYear = new Select(yearSelect);
        selectYear.selectByValue(year);

        driver.findElement(newsCheck).click(); // Check news
        driver.findElement(optinCheck).click(); // Check offers

        driver.findElement(companyField).sendKeys(company); //Input company name
        driver.findElement(address1Field).sendKeys(address); //Input address 1
        driver.findElement(address2Field).sendKeys(address1); //Input address 2
        driver.findElement(cityField).sendKeys(city); //Input city name

        // Select state
        WebElement stateSelect = driver.findElement(stateField);
        Select selectState = new Select(stateSelect);
        selectState.selectByVisibleText(state);

        driver.findElement(zipField).sendKeys(zip); //Input postcode

        // Select country
        WebElement countrySelect = driver.findElement(countryField);
        Select selectCountry = new Select(countrySelect);
        selectCountry.selectByVisibleText(country);

        driver.findElement(additionalField).sendKeys(addInfo); //Input additional information
        driver.findElement(mobileField).sendKeys(mobileNum); //Input mobile phone number

        //Input assign an address alias for future reference
        driver.findElement(aliasField).clear();
        driver.findElement(aliasField).sendKeys(nameAddress);

        driver.findElement(regButton).click(); // Finish registration

        // Validate user creation
        String userName = driver.findElement(userNameCheck).getText();
        if(userName.contains(lastName)) {
            System.out.println("User " + userName + " created, Test case Passed");
        }
        else {
            System.out.println("User registration failed,Test case Failed");
        }


        //driver.close();
    }















































    }












