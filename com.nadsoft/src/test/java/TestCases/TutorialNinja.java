package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Nadsoft.Base.BaseClass;

import java.util.List;
public class TutorialNinja extends BaseClass{
	    private final String baseUrl = "https://tutorialsninja.com/demo/index.php?route=common/home";

	    @Test
	    public void validateShoppingCartFlow() {
	        driver.get(baseUrl);

	        //adding macbook
	        driver.findElement(By.name("search")).sendKeys("MacBook");
	        driver.findElement(By.cssSelector("button.btn-default")).click();

	        List<WebElement> products = driver.findElements(By.xpath("//div[@class='caption']//a[contains(text(),'MacBook')]"));
	        Assert.assertTrue(products.size() >= 1, "MacBook product not found");

	        for (int i = 0; i < 2; i++) {
	            driver.findElement(By.xpath("//span[text()='Add to Cart']/..")).click();

	            // validate alert
	            WebElement success = driver.findElement(By.cssSelector(".alert-success"));
	            Assert.assertTrue(success.getText().contains("Success"), "Success message not displayed");

	            driver.navigate().refresh(); 
	        }

	        // Open Shopping Cart
	        driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();

	        // Validation of URL
	        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=checkout/cart";
	        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Cart URL does not match");

	        // Validate prices
	        WebElement unitPriceEl = driver.findElement(By.cssSelector("td[class='text-right']:nth-of-type(3)"));
	        WebElement totalPriceEl = driver.findElement(By.cssSelector("td[class='text-right']:nth-of-type(4)"));

	        String unitText = unitPriceEl.getText().replace("$", "").trim();
	        String totalText = totalPriceEl.getText().replace("$", "").trim();

	        double unitPrice = Double.parseDouble(unitText);
	        double totalPrice = Double.parseDouble(totalText);

	        //  Validate price
	        Assert.assertEquals(totalPrice, unitPrice * 2, "Total price doesn't match unit price x quantity");
	    }
	

	
	
	
}
