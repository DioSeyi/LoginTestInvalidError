package pages;
// we are building the keywords

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Utilities.Utility; // type directly if there is no option to import
import baseContainer.TestBase2;

public class loginPage extends TestBase2{ 
	Utility utils = new Utility();
	
	String homePageAvatarIcon = OR.getProperty("avatarIcon");
	String emailField = OR.getProperty("emailField");
	String passwordField = OR.getProperty("passwordField");
	String submitloginButton = OR.getProperty("submitloginButton");
	
	public loginPage(WebDriver driver) {
		TestBase2.driver = driver;
		PageFactory.initElements(TestBase2.driver, this);
	}
	
	public void clickAvatarIcon() {
		driver.findElement(By.cssSelector(homePageAvatarIcon)).click();
		}
	
	public void clickEmail() {
		driver.findElement(By.id(emailField)).click();
		}
	
	public void typeInEmailField(String key) throws Exception {
		System.out.println(emailField);
		driver.findElement(By.id(emailField)).sendKeys(utils.dataFetcher("key"));
		}
	
	public void clearEmailField() {
		driver.findElement(By.id(emailField)).clear();
		}
	public void clickPassword() {
		driver.findElement(By.id(passwordField)).click();
		}
	
	public void typeInPasswordField(String key) throws Exception {
		driver.findElement(By.id(passwordField)).sendKeys(utils.dataFetcher("key"));
		}
	
	public void clearPasswordField() {
		driver.findElement(By.id(passwordField)).clear();
		}
	public void clicksubmitloginButton() {
		driver.findElement(By.id(submitloginButton)).click();
		}
}
