package com.tieto.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tieto.base.WebDriverWrapper;
import com.tieto.pages.DashboardPage;
import com.tieto.pages.LoginPage;
import com.tieto.pages.PatientFinderPage;
import com.tieto.utilities.ExcelUtils;

public class AddPatientTest extends WebDriverWrapper {
	@DataProvider
	public Object[][] CreatePatientData() throws IOException
	{
		Object[][] main=ExcelUtils.getSheetIntoObject("Testdata/OpenEMRData.xlsx", "CreatePatientData");
				return main;
	}
	@Test
	public void createPatientTest(String username, String password, String Language,String FirstName, String LastName,String DOB,String Gender,String expectedValue) throws InterruptedException
	{
		LoginPage login =new LoginPage(driver);	
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanguageByText(Language);
		login.clickOnLogin();
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.mouseHoverOnPatientClient();
		dashboardPage.clickOnPatients();
		
		PatientFinderPage patientFinder=new PatientFinderPage(driver);
		patientFinder.switchToFrameWithFin();
		
		Thread.sleep(5000);
		driver.findElement(By.id("create_patient_btn1")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("pat");
		Thread.sleep(5000);
		driver.findElement(By.id("form_fname")).sendKeys("gugan");
		driver.findElement(By.id("form_lname")).sendKeys("gugan");
		driver.findElement(By.id("DOB")).sendKeys("2020-07-02");
		//fill the patient 
		// verify 
	}

}
