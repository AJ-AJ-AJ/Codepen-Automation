package io.codepen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ChangeViewTest {

	//This test verifies that a user can change views
	@Test
	public void changeViewTest () {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url= "https://codepen.io/CalendlyQA/full/KKPQLmV";
		driver.get(url);
				
		//click on the menu
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("view-switcher-button")));
		WebElement menu = driver.findElement(By.id("view-switcher-button"));
		menu.click();
		
		
		//change to details view
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("details-link")));
		WebElement detailsView = driver.findElement(By.id("details-link"));
		detailsView.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/aside/dl/div[1]/dd")));
		WebElement createdDate = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/aside/dl/div[1]/dd"));
		createdDate.isDisplayed();
		
		WebElement menu2 = driver.findElement(By.id("view-switcher-button"));
		menu2.click();
		
		//change to editor view
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pen-link")));
		WebElement editorView = driver.findElement(By.id("pen-link"));
		editorView.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("settings-pane-html")));
		WebElement htmlSettings = driver.findElement(By.id("settings-pane-html"));
		htmlSettings.isDisplayed();
		
		driver.quit();
		
	}
	
}
