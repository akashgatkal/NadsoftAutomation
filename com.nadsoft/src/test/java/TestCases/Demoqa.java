package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Nadsoft.Base.BaseClass;
public class Demoqa  extends BaseClass{

	    @Test
	    public void testScript() throws InterruptedException {
	        driver.get("https://demoqa.com/");

	       
	        WebElement forms = driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[2]"));
	        forms.click();

	        //practice form
	        driver.findElement(By.xpath("//span[text()='Practice Form']")).click();

	        // fill form
	        driver.findElement(By.id("firstName")).sendKeys("Akash");
	        driver.findElement(By.id("lastName")).sendKeys("Gatkal");
	        driver.findElement(By.id("userEmail")).sendKeys("akashgatkal123@gmail.com");
	        driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();
	        driver.findElement(By.id("userNumber")).sendKeys("9657004387");
	        driver.findElement(By.id("dateOfBirthInput")).click();
	        driver.findElement(By.cssSelector(".react-datepicker__year-select")).sendKeys("2001");
	        driver.findElement(By.cssSelector(".react-datepicker__month-select")).sendKeys("Dec");
	        driver.findElement(By.cssSelector(".react-datepicker__day--026")).click();
	        driver.findElement(By.id("subjectsInput")).sendKeys("Maths");
	        driver.findElement(By.xpath("(//label[@class='custom-control-label'])[4]")).click();
	        
	        driver.findElement(By.id("uploadPicture")).sendKeys("/home/akash/Pictures/Akash photos/IMG_20210110_201535.jpg");
	        driver.findElement(By.id("currentAddress")).sendKeys("karve Nagar");
	        WebElement state = driver.findElement(By.xpath("//div[@id='state']"));
	        Select sel=new Select(state);
	        sel.selectByIndex(0);
	        
	        WebElement city = driver.findElement(By.xpath("//div[@id='city']"));
	        Select sel1=new Select(city);
	        sel1.selectByIndex(1);
	        
	        WebElement submitBtn = driver.findElement(By.id("submit"));
	        
	        new Actions(driver).scrollToElement(submitBtn).perform();
	        submitBtn.click();

	       
	        WebElement modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg"));
	        Assert.assertTrue(modalTitle.getText().contains("Thanks"), "Form not submitted successfully");

	   
	        driver.findElement(By.id("closeLargeModal")).click();

	        // Navigate to Book Store
	        driver.get("https://demoqa.com/books");

	        // Find book by Marijn Haverbeke
	        WebElement bookLink = driver.findElement(By.xpath("//a[text()='Eloquent JavaScript']"));
	        bookLink.click();

	        // Validate URL
	        String currentUrl = driver.getCurrentUrl();
	        Assert.assertTrue(currentUrl.contains("eloquent-javascript"), "Book URL is not correct for Eloquent JavaScript");
	    }
	}

	
	
	
}
