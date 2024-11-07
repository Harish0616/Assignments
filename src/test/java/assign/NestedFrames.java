package assign;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NestedFrames {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Open the URL
            driver.get("http://the-internet.herokuapp.com/nested_frames");

            // Step 2: Switch to the top frame
            driver.switchTo().frame("frame-top");

            // Step 3: Verify that there are three frames on the page
            int numberOfFrames = driver.findElements(By.tagName("frame")).size();
            if (numberOfFrames == 3) {
                System.out.println("Verification successful: There are three frames.");
            } else {
                System.out.println("Verification failed: There are not three frames.");
            }

            // Step 4: Switch to the left frame
            driver.switchTo().frame("frame-left");
            
            // Step 5: Verify that the left frame has text "LEFT"
            String leftFrameText = driver.findElement(By.cssSelector("body")).getText();
            if (leftFrameText.equals("LEFT")) {
                System.out.println("Verification successful: Left frame contains 'LEFT'.");
            } else {
                System.out.println("Verification failed: Left frame does not contain 'LEFT'.");
            }

            // Step 6: Switch back to the top frame
            driver.switchTo().parentFrame();

            // Step 7: Switch to the middle frame
            driver.switchTo().frame("frame-middle");
            
            // Step 8: Verify that the middle frame has text "MIDDLE"
            String middleFrameText = driver.findElement(By.cssSelector("body")).getText();
            if (middleFrameText.equals("MIDDLE")) {
                System.out.println("Verification successful: Middle frame contains 'MIDDLE'.");
            } else {
                System.out.println("Verification failed: Middle frame does not contain 'MIDDLE'.");
            }

            // Step 9: Switch back to the top frame
            driver.switchTo().parentFrame();

            // Step 10: Switch to the right frame
            driver.switchTo().frame("frame-right");
            
            // Step 11: Verify that the right frame has text "RIGHT"
            String rightFrameText = driver.findElement(By.cssSelector("body")).getText();
            if (rightFrameText.equals("RIGHT")) {
                System.out.println("Verification successful: Right frame contains 'RIGHT'.");
            } else {
                System.out.println("Verification failed: Right frame does not contain 'RIGHT'.");
            }

            // Step 12: Switch back to the top frame
            driver.switchTo().parentFrame();

            // Step 13: Switch to the bottom frame
            driver.switchTo().frame("frame-bottom");
            
            // Step 14: Verify that the bottom frame has text "BOTTOM"
            String bottomFrameText = driver.findElement(By.cssSelector("body")).getText();
            if (bottomFrameText.equals("BOTTOM")) {
                System.out.println("Verification successful: Bottom frame contains 'BOTTOM'.");
            } else {
                System.out.println("Verification failed: Bottom frame does not contain 'BOTTOM'.");
            }

        } finally {
            // Switch back to the top frame before closing
            driver.switchTo().defaultContent();
            
            // Close the browser instance
            driver.quit();
        }
    }
}