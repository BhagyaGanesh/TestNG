package testScript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

    public class Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void browserInitialization() {
		
		 //driver = new ChromeDriver();
		driver = new EdgeDriver();
		driver.get("https://selenium.qabible.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
    public void driverQuit() {
		
				driver.quit();
		
	}


}
