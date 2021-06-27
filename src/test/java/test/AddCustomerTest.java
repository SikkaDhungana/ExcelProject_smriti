package test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\excelProject_TestData.xlsx");
	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String Password = exlread.getCellData("LoginInfo", "Password", 2);
	
	String fullName = exlread.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlread.getCellData("AddContactInfo", "Email", 2);
	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	String state = exlread.getCellData("AddContactInfo", "State", 2);
	String zip = exlread.getCellData("AddContactInfo", "Zip", 2);
	@Test
	public void validUserShouldBeAbleToCreateCustomer() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(Password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	//	dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomersButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class); 	
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompany(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.clickSaveButtonOnAddContact();
		
		addCustomerPage.verifySummaryPage();
		dashboardPage.clickListCustomersButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
		addCustomerPage.deleteConformOk();
		
		
		
	//	BrowserFactory.tearDown();
		

		
		
		
	}
	
}
