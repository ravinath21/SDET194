package selenium;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.edge.EdgeDriver;

public class HelloWorld {

	public static void main(String[] args) {
		// Initialize the WebDriver
		WebDriver driver = new EdgeDriver();
		
		// Navigate to a website
		driver.get("C:\\Users\\poona\\Downloads\\edgedriver_win64");
		//driver.get("https://amazon.com");
		// Close the browser - Try again
		//driver.quit();

	}

}
