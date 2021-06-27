package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\excelProject_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String Password = exlread.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		
		driver = BrowserFactory.init();
				 
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(Password);
		loginPage.clickSigninButton();		 

	//	DashboardPage dashBoard = PageFactory.initElements(driver, DashboardPage.class);
	//	dashBoard.verifyDashboardPage();
		
		BrowserFactory.tearDown();	 
	}
}
