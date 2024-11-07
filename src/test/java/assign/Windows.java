package assign;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://the-internet.herokuapp.com/windows");
			
			//click the click button
			driver.findElement(By.linkText("Click Here")).click();
			
			  // Step 4: Switch to the newly opened window
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds (1000));
			
			//wait for particular title
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
			
			
			String pageTitle =driver.findElement(By.tagName("h3")).getText();
			
			//validation of new window is opened
			if(pageTitle.equals("New Window ")) {
				
				System.out.println("New Window Opened");
			}else {
				System.out.println("New window not presented");
				
			}
			driver.close();
			
			//verify the Orginal window
			driver.switchTo().window(tabs.get(0));
			
			if(driver.getTitle().equals("the-internet")) {
				System.out.println("Opening a new window");
			}else {
				System.out.println("Not Opening a orginal window");
			}
			
			
			}finally {
			driver.quit();
			
		}

	}

}
