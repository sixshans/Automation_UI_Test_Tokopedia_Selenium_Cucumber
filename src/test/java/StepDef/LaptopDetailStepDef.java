package StepDef;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaptopDetailStepDef {

    private WebDriver driver;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Given("User on Tokopedia website home page")
    public void user_on_tokopedia_website_home_page() {
        driver.get("https://www.tokopedia.com/");
        //Assert Homepage
        WebElement searchBarLocator = driver.findElement(By.xpath("//input[@type='search']"));
        Assert.assertTrue(searchBarLocator.isDisplayed());
    }

    @And("User search Laptop MSI on search bar")
    public void user_search_laptop_msi_on_search_bar() {
        // Input text on search bar
        WebElement searchBarLocator = driver.findElement(By.xpath("//input[@type='search']"));
        searchBarLocator.sendKeys("Laptop MSI");
        searchBarLocator.sendKeys(Keys.ENTER);
    }

    @And("User directed into list of laptop MSI")
    public void user_directed_into_list_of_laptop_msi() {
        //Wait for "Produk" tab to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ProductPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Produk']")));
        Assert.assertTrue(ProductPage.isDisplayed());

    }

    @When("User click product")
    public void user_click_product() {
        //Scroll down 500 pixels to see product
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        //Click the product
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement ProductSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='css-jza1fo'])[6]")));
//        ProductSection.click();
        driver.findElement(By.xpath("//div[@class='css-jza1fo'])[6]"));
    }

    @Then("User directed to product detail page")
    public void user_directed_to_product_detail_page() {
        //Wait before "Detail" to be visible and verify
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ProductDetail = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//p[text()='Detail']"))));
        Assert.assertTrue(ProductDetail.isDisplayed());

        //Wait before Product Label to be visible and verify
        WebElement ProductLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-testid='lblPDPDetailProductName'")));
        Assert.assertTrue((ProductLabel.isDisplayed()));

    }
    @After
    public void Close(){
        if(driver!= null){
            driver.close();
        }
    }

}
