package casualShirts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;



public class LowestPriceShirt {
	
	public static void main(String[] args) {
		
		
	WebDriver driver = new ChromeDriver();

	 try {
         
         driver.get("https://www.myntra.com");
         driver.manage().window().maximize();

         
         Actions actions = new Actions(driver);
         WebElement menMenu = driver.findElement(By.xpath("//a[text()='Men']"));
         actions.moveToElement(menMenu).perform();

         
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement casualShirts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Casual Shirts']")));
         casualShirts.click();

         
         WebElement roadsterCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Roadster')]")));
         roadsterCheckbox.click();

         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-base"))); 
         List<WebElement> shirts = driver.findElements(By.className("product-base"));
       
         WebElement cheapestShirt = null;
         double lowestPrice = Double.MAX_VALUE;

         for (WebElement shirt : shirts) {
             String priceText = shirt.findElement(By.className("product-price")).getText();
          

             
             
             
             String parts = priceText.split("Rs. ")[1].split("\\(")[0].trim(); 
             
        
             
             try {
                 double price = Double.parseDouble(parts.replace(",", "").trim());
           
                 if (price < lowestPrice) {
                     lowestPrice = price;
                     cheapestShirt = shirt;
                 }
             } catch (NumberFormatException e) {
                 System.out.println("Could not parse price: " + priceText);
             }
         }

         
         if (cheapestShirt != null) {
             cheapestShirt.click();
         }

     } catch (Exception e) {
         e.printStackTrace();
     } finally {
    
     }
	}
	
	
	

}
