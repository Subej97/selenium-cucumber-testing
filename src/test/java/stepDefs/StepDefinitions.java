package stepDefs; //vi jobbar på det

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StepDefinitions {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rasmus\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("I fill in the registration form with valid details")
    public void i_fill_in_the_registration_form_with_valid_details() {
        try {
            waitForVisibility(By.id("member_emailaddress"), 10);  // Replaces WebDriverWait block

            WebElement emailAddr = driver.findElement(By.id("member_emailaddress"));
            WebElement conEmailAdd = driver.findElement(By.id("member_confirmemailaddress"));
            WebElement dateOfBirth = driver.findElement(By.id("dp"));
            WebElement firstName = driver.findElement(By.id("member_firstname"));
            WebElement lastName = driver.findElement(By.id("member_lastname"));
            WebElement password = driver.findElement(By.id("signupunlicenced_password"));
            WebElement confirmPassword = driver.findElement(By.id("signupunlicenced_confirmpassword"));
            WebElement termsCheckbox = driver.findElement(By.cssSelector("label[for='sign_up_25']"));
            WebElement adultCheckbox = driver.findElement(By.cssSelector("label[for='sign_up_26']"));
            WebElement cocCheckbox = driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']"));

            emailAddr.sendKeys("johndoe6@email.com");
            conEmailAdd.sendKeys("johndoe6@email.com");
            dateOfBirth.sendKeys("17/05/1997");
            firstName.sendKeys("John");
            lastName.sendKeys("Doe");
            password.sendKeys("Password123");
            confirmPassword.sendKeys("Password123");

            termsCheckbox.click();
            adultCheckbox.click();
            cocCheckbox.click();

            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='join']"));
            submitButton.click();

            // Print any validation errors
            List<WebElement> errors = driver.findElements(By.className("field-validation-error"));
            for (WebElement error : errors) {
                System.out.println("Validation error: " + error.getText());
            }

            System.out.println("Current URL after submit: " + driver.getCurrentUrl());

            // Wait for success message or redirect
            waitForVisibility(By.xpath("//h2[contains(text(), 'THANK YOU FOR CREATING AN ACCOUNT')]"), 10);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Then("I should see a confirmation message that the account is created")
    public void i_should_see_a_confirmation_message_that_the_account_is_created() {
        try {
            WebElement confirmationMessage = driver.findElement(By.xpath("//h2[contains(text(), 'THANK YOU FOR CREATING AN ACCOUNT')]"));
            assertTrue(confirmationMessage.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Confirmation message not found.");
        }
    }

    @When("I fill in the registration form with missing last name")
    public void i_fill_in_the_registration_form_with_missing_last_name() {
        try {
            waitForVisibility(By.id("member_emailaddress"), 10);

            WebElement emailAddr = driver.findElement(By.id("member_emailaddress"));
            WebElement conEmailAdd = driver.findElement(By.id("member_confirmemailaddress"));
            WebElement dateOfBirth = driver.findElement(By.id("dp"));
            WebElement firstName = driver.findElement(By.id("member_firstname"));
            WebElement lastName = driver.findElement(By.id("member_lastname"));
            WebElement password = driver.findElement(By.id("signupunlicenced_password"));
            WebElement confirmPassword = driver.findElement(By.id("signupunlicenced_confirmpassword"));
            WebElement termsCheckbox = driver.findElement(By.cssSelector("label[for='sign_up_25']"));
            WebElement adultCheckbox = driver.findElement(By.cssSelector("label[for='sign_up_26']"));
            WebElement cocCheckbox = driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']"));

            emailAddr.sendKeys("johndoe5@email.com");
            conEmailAdd.sendKeys("johndoe5@email.com");
            dateOfBirth.sendKeys("17/05/1997");
            firstName.sendKeys("John");
            password.sendKeys("Password123");
            confirmPassword.sendKeys("Password123");

            termsCheckbox.click();
            adultCheckbox.click();
            cocCheckbox.click();

            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='join']"));
            submitButton.click();

            // Print any validation errors
            List<WebElement> errors = driver.findElements(By.className("field-validation-error"));
            for (WebElement error : errors) {
                System.out.println("Validation error: " + error.getText());
            }

            System.out.println("Current URL after submit: " + driver.getCurrentUrl());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should see an error message stating that last name is required")
    public void i_should_see_an_error_message_stating_that_the_last_name_is_required() {
        try {
            WebElement errorLNMessage = driver.findElement(By.xpath("//span[@for='member_lastname' and text()='Last Name is required']"));
            assertTrue(errorLNMessage.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error message not found.");
        }
    }

    @When("I fill in the registration form with mismatched passwords")
    public void i_fill_in_the_registration_form_with_mismatched_passwords() {
        try {
            waitForVisibility(By.id("member_emailaddress"), 10);

            WebElement emailAddr = driver.findElement(By.id("member_emailaddress"));
            WebElement conEmailAdd = driver.findElement(By.id("member_confirmemailaddress"));
            WebElement dateOfBirth = driver.findElement(By.id("dp"));
            WebElement firstName = driver.findElement(By.id("member_firstname"));
            WebElement lastName = driver.findElement(By.id("member_lastname"));
            WebElement password = driver.findElement(By.id("signupunlicenced_password"));
            WebElement confirmPassword = driver.findElement(By.id("signupunlicenced_confirmpassword"));
            WebElement termsCheckbox = driver.findElement(By.cssSelector("label[for='sign_up_25']"));
            WebElement adultCheckbox = driver.findElement(By.cssSelector("label[for='sign_up_26']"));
            WebElement cocCheckbox = driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']"));

            emailAddr.sendKeys("johndoe5@email.com");
            conEmailAdd.sendKeys("johndoe5@email.com");
            dateOfBirth.sendKeys("17/05/1997");
            firstName.sendKeys("John");
            lastName.sendKeys("Doe");
            password.sendKeys("Password123");
            confirmPassword.sendKeys("Password1234");

            termsCheckbox.click();
            adultCheckbox.click();
            cocCheckbox.click();

            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='join']"));
            submitButton.click();

            // Print any validation errors
            List<WebElement> errors = driver.findElements(By.className("field-validation-error"));
            for (WebElement error : errors) {
                System.out.println("Validation error: " + error.getText());
            }

            System.out.println("Current URL after submit: " + driver.getCurrentUrl());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should see an error message stating that passwords do not match")
    public void i_should_see_an_error_message_stating_that_passwords_do_not_match() {
        try {
            WebElement errorMPMessage = driver.findElement(By.xpath("//span[@for='signupunlicenced_confirmpassword' and text()='Password did not match']"));
            assertTrue(errorMPMessage.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Confirmation message not found.");
        }
    }

    @When("I fill the form with password {string} and confirm password {string}")
    public void i_fill_the_form_with_password_and_confirm_password(String passwordVal, String confirmPasswordVal) {
        try {
            waitForVisibility(By.id("member_emailaddress"), 10);

            WebElement emailAddr = driver.findElement(By.id("member_emailaddress"));
            WebElement conEmailAdd = driver.findElement(By.id("member_confirmemailaddress"));
            WebElement dateOfBirth = driver.findElement(By.id("dp"));
            WebElement firstName = driver.findElement(By.id("member_firstname"));
            WebElement lastName = driver.findElement(By.id("member_lastname"));
            WebElement password = driver.findElement(By.id("signupunlicenced_password"));
            WebElement confirmPassword = driver.findElement(By.id("signupunlicenced_confirmpassword"));
            WebElement termsCheckbox = driver.findElement(By.cssSelector("label[for='sign_up_25']"));
            WebElement adultCheckbox = driver.findElement(By.cssSelector("label[for='sign_up_26']"));
            WebElement cocCheckbox = driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']"));

            // Give each user a unique email
            String uniqueEmail = "user" + System.currentTimeMillis() + "@test.com";

            emailAddr.sendKeys(uniqueEmail);
            conEmailAdd.sendKeys(uniqueEmail);
            dateOfBirth.sendKeys("17/05/1997");
            firstName.sendKeys("John");
            lastName.sendKeys("Doe");
            password.sendKeys(passwordVal);
            confirmPassword.sendKeys(confirmPasswordVal);

            termsCheckbox.click();
            adultCheckbox.click();
            cocCheckbox.click();

            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='join']"));
            submitButton.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should see an error message stating that passwords do not match2")
    public void i_should_see_an_error_message_stating_that_passwords_do_not_match2() {
        try {
            WebElement errorMPMessage = driver.findElement(By.xpath("//span[@for='signupunlicenced_confirmpassword' and text()='Password did not match']"));
            assertTrue(errorMPMessage.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Confirmation message not found.");
        }
    }

    @When("I fill in the registration form without accepting the terms and conditions")
    public void i_fill_in_the_registration_form_without_accepting_the_terms_and_conditions() {
        try {
            waitForVisibility(By.id("member_emailaddress"), 10);

            WebElement emailAddr = driver.findElement(By.id("member_emailaddress"));
            WebElement conEmailAdd = driver.findElement(By.id("member_confirmemailaddress"));
            WebElement dateOfBirth = driver.findElement(By.id("dp"));
            WebElement firstName = driver.findElement(By.id("member_firstname"));
            WebElement lastName = driver.findElement(By.id("member_lastname"));
            WebElement password = driver.findElement(By.id("signupunlicenced_password"));
            WebElement confirmPassword = driver.findElement(By.id("signupunlicenced_confirmpassword"));
            WebElement termsCheckbox = driver.findElement(By.cssSelector("label[for='sign_up_25']"));
            WebElement adultCheckbox = driver.findElement(By.cssSelector("label[for='sign_up_26']"));
            WebElement cocCheckbox = driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']"));

            emailAddr.sendKeys("johndoe5@email.com");
            conEmailAdd.sendKeys("johndoe5@email.com");
            dateOfBirth.sendKeys("17/05/1997");
            firstName.sendKeys("John");
            lastName.sendKeys("Doe");
            password.sendKeys("Password123");
            confirmPassword.sendKeys("Password123");

            adultCheckbox.click();
            cocCheckbox.click();

            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='join']"));
            submitButton.click();

            // Print any validation errors
            List<WebElement> errors = driver.findElements(By.className("field-validation-error"));
            for (WebElement error : errors) {
                System.out.println("Validation error: " + error.getText());
            }

            System.out.println("Current URL after submit: " + driver.getCurrentUrl());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should see an error message stating that terms and conditions must be accepted")
    public void i_should_see_an_error_message_stating_that_terms_and_conditions_must_be_accepted() {
        try {
            WebElement errorTermsMessage = driver.findElement(By.xpath("//a[text()='Terms and Conditions']"));
            assertTrue(errorTermsMessage.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error message not found.");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private WebElement waitForVisibility(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
