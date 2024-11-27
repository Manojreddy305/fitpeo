package fitPeo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NavigateToHomepage {

	public static void main(String[] args) throws InterruptedException {
	// Initialize the WebDriver
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	//Maximize the browser window
	driver.manage().window().maximize();
	//intialise the action class
	Actions actions = new Actions(driver);
	JavascriptExecutor js=( JavascriptExecutor)driver;
	
	// Navigate to the FitPeo Home_page
	driver.get("https://www.fitpeo.com/");
	//navigate to the sub url the revenue -calculator
	Thread.sleep(5000);
	driver.navigate().to("https://fitpeo.com/revenue-calculator");
	//by using action class we can navigate to the revenue calculator
	//actions.moveToElement(driver.findElement(By.xpath("//a/div[text()='Revenue Calculator']"))).click().build().perform();
	//WebElement sliderCalculator = driver.findElement(By.className("MuiBox-root css-j7qwjs"));
	//actions.scrollToElement(sliderCalculator).build().perform();
	Thread.sleep(5000);
	actions.scrollByAmount(0, 400).build().perform();
	
	WebElement sliderCalculator = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary')]"));
	int sliderWidth = sliderCalculator.getSize().getWidth();
	actions.clickAndHold(sliderCalculator).moveByOffset((int) (sliderWidth * 4.7), 0).release().perform();
    /*WebElement SliderTextField = driver.findElement(By.xpath("//div[contains(@class,'MuiInputBase-root')]"));
	SliderTextField.clear();
	SliderTextField.sendKeys("560");*/
    // js.executeScript("window.scrollTo(0, 200);");
	Thread.sleep(5000);
    actions.scrollByAmount(0, 200);
    String[] cptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    
   
    for (String code : cptCodes) {
        // Find the checkbox by label text or associated attribute
        WebElement checkbox = driver.findElement(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']"));
        // Scroll to the checkbox
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);

        // Select the checkbox if not already selected
        if (!checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Selected checkbox for " + code);
        } else {
            System.out.println("Checkbox for " + code + " is already selected.");
        }
    }


		//minimize the Browser window
		driver.manage().window().minimize();
		//To Close the browser
		driver.quit();

	}
}













