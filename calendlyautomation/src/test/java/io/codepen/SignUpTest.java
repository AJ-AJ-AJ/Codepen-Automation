package io.codepen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SignUpTest {
	
	//This test verifies that a user can sign up with an existing github account
	
	@Test
	public void githubSignUpTest () {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url= "https://codepen.io/CalendlyQA/full/KKPQLmV";
		driver.get(url);
		
		//waiting for elements to load
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div/a[1]")));
		
		WebElement signUpButton = driver.findElement(By.xpath("/html/body/header/div/a[1]"));
		signUpButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-with-github")));
		WebElement githubAuthButton = driver.findElement(By.id("login-with-github"));
		githubAuthButton.click();
		
		WebElement githubSignIn = driver.findElement(By.xpath("/html/body/div[3]/main/div/form/div[3]/div/p/strong[1]"));
		githubSignIn.isDisplayed();
		
		driver.quit();
		
	}

}
