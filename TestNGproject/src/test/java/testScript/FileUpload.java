package testScript;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUpload extends Base{
	
	
	@Test
	public void fileUploadUsingSendKeys() {
		
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		WebElement choose = driver.findElement(By.xpath("//input[@id='file-upload']"));
		choose.sendKeys("C:\\Users\\user\\Desktop\\java\\array1.PNG");
		WebElement upload = driver.findElement(By.xpath("//input[@id='file-submit']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(upload));
		upload.click();
		
	}
	
	@Test
	public void fileUploadUsingRobotClass() throws AWTException {
		
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		WebElement selectfile = driver.findElement(By.xpath("//span[text()='Select PDF file']"));
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
				fluentWait.until(ExpectedConditions.elementToBeClickable(selectfile));
		selectfile.click();
		
		StringSelection sc = new StringSelection("C:\\Users\\user\\Downloads\\Business Analysis Task (1) (1).pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);
		Robot obj = new Robot();
		obj.delay(2500);
		obj.keyPress(KeyEvent.VK_CONTROL);
		obj.keyPress(KeyEvent.VK_V);
		obj.keyRelease(KeyEvent.VK_CONTROL);
		obj.keyRelease(KeyEvent.VK_V);
		obj.keyPress(KeyEvent.VK_ENTER);
		obj.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
	}

}
