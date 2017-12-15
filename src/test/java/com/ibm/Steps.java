package com.ibm;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	public static WebDriver driver = null;
	public static WebDriver driver1 = null;
	
	@Given("^Client will launch the add user demo site (.*)$")
	public void clientWillLaunchTheAddUserDemoSiteHttpThedemositeCoUkAddauserPhp(String URL) throws Exception {
		System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
		driver = new FirefoxDriver();
		System.out.println("New instant of firefox created.");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//passing the url to the driver.
		driver.get(URL);
		driver.manage().window().maximize();

		System.out.println("Demo home page is displayed");
	}

	@When("^Enter username (.*) and Enter password (.*) and Click on Save button$")
	public void enterUsernameNageshAndEnterPasswordPasswordAndClickOnSaveButton(String UN, String PW) throws Exception {
		//find the username text box and send data2
		driver.findElement(By.name("username")).sendKeys(UN);
		System.out.println("username is entered");
		
		//find the password textbox and send password
		driver.findElement(By.name("password")).sendKeys(PW);
		System.out.println("password is entered");
		
		//Click on the save button
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.name("FormsButton2")).click();
		System.out.println("Click on the save button.");
	}

	@Then("^Validate username is (.*) & password is (.*)$")
	public void validateUsernameIsNageshPasswordIsPassword(String UN, String PW) throws Exception {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		System.out.println("UserName from feature file :"+UN);
		System.out.println("Password from feature file :"+PW);
		String A="The username: "+UN;
		String B="The password: "+PW;
		String ExpectedResult =A+"\n"+B; 
		String ActialResult=driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote")).getText();
		System.out.println("ExpectedResult from feature file :\n"+ExpectedResult);
		System.out.println("Actual result from Demo Site :\n"+ActialResult);
		assertEquals(ActialResult, ExpectedResult);
	}

	@And("^Close the add user window$")
	public void closeTheAddUserWindow() throws Exception {
		//Close the driver
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.quit();
		System.out.println("firefox add user window is closed.");

	}
	
	@Given("^Client will launch the login demo site (.*)$")
	public void client_will_launch_the_login_user_demo_site(String URL) throws Throwable {
		
			System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
			driver1 = new FirefoxDriver();
			System.out.println("New instant of firefox created.");
			driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//passing the url to the driver.
			driver1.get(URL);
			driver1.manage().window().maximize();

			System.out.println("Demo login page is displayed");
		
	}
	
	@When("^Enter username (.*) and Enter password (.*) and Click on Test Login button$")
	public void enter_Username_Password_Click_Login(String UN, String PW) throws Throwable {
			//find the username text box and send data2
			driver1.findElement(By.name("username")).sendKeys(UN);
			System.out.println("Login username is entered");
			
			//find the password textbox and send password
			driver1.findElement(By.name("password")).sendKeys(PW);
			System.out.println("Login password is entered");
			
			//Click on the save button
			driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver1.findElement(By.name("FormsButton2")).click();
			System.out.println("Click on the Login button.");
	}
			
			
			
	@Then("^Validate message (.*) (.*)$")
	public void validate_login_message(String msg1, String msg2) throws Throwable {
					driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					String A=msg1;
					String B=msg2;
					String ExpectedResult =A+" "+B; 
					String ActialResult=driver1.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText();
					System.out.println("Expected login Result from feature file :\n"+ExpectedResult);
					System.out.println("Actual login result from Demo Site :\n"+ActialResult);
					ActialResult.equals(ExpectedResult);
					assertEquals(ActialResult, ExpectedResult);
	}
		

	@And("^Close the login window$")
	public void close_the_login_window() throws Throwable {
					//Close the driver
					driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					driver1.quit();
					System.out.println("firefox login window is closed.");

	}


}
