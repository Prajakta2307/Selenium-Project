package Vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonUtil.BaseClass;
import CommonUtil.ExcelUtil;
import CommonUtil.PropertyFileUtil;
import CommonUtil.WebDriverUtil;

public class ContactsTestng extends BaseClass {
	
	WebDriverUtil wutil=new WebDriverUtil();
	PropertyFileUtil putil=new PropertyFileUtil();
	ExcelUtil eutil=new ExcelUtil();
	WebDriver d;
	@Test
	public void ContactTest() throws IOException, InterruptedException {
		
		//to launch empty browser
//		WebDriver d=new ChromeDriver();
//		
//		//to maximize the browser window
//		wutil.Maximize(d);
//		
//		//to apply implicit wait for findelement
//		wutil.implicitwait(d);
//		
//		Thread.sleep(2000);
//		
//		//to read data from property file
//		String URL = putil.getDataFromPropertyFile("Url");
//		String USERNAME = putil.getDataFromPropertyFile("Username");
//		 String PASSWORD = putil.getDataFromPropertyFile("Password");
		 
		
		
		//Thread.sleep(2000);
		//to read data from excel file
		String FIRSTNAME = eutil.getDataFromExcel("Contacts", 0, 1);
		String LASTNAME =eutil.getDataFromExcel("Contacts", 1, 1);
		String GROUP=eutil.getDataFromExcel("Contacts", 2, 1);
		String ORGNAME = eutil.getDataFromExcel("Contacts", 3, 1);
		
		//to launch application
			//	d.get(URL);
				
		Thread.sleep(2000);
		//to login to application
//		d.findElement(By.name("user_name")).sendKeys(USERNAME);
//		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		d.findElement(By.id("submitButton")).click();
//		Thread.sleep(2000);
		
		//to click on contact
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(2000);
		
		//to click on create contacts...(+)
		d.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		Thread.sleep(2000);
		
		//enter firstname
		d.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		
		//enter last name
		d.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//To fail the testscript
//		WebElement NotifyCheckbox = d.findElement(By.name("notify_owner")).click();
//		Assert.assertTrue(NotifyCheckbox.isSelected());
//		
		String actualurl = d.getCurrentUrl();
		String expectedurl="http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		
		Assert.assertEquals(actualurl, expectedurl);
		
		//click on group radio buuton
		d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//in dropdown select teamselling
		Thread.sleep(2000);
		WebElement dropdown = d.findElement(By.name("assigned_group_id"));
		wutil.handledropdown(dropdown, GROUP);
		
		//click on select(+) in organization name text field
		d.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		Thread.sleep(2000);
		
		//transfer the driver control from parent window to child window
		 wutil.switchwindow(d, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		 
		 //to enter organization name in searchtf
		 d.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		 Thread.sleep(2000);
		 
		 //click on search now button
		 d.findElement(By.name("search")).click();
		 
		 //click on organization name
		 d.findElement(By.xpath("//a[text()='Qspiders Deccan6']")).click();
		 Thread.sleep(2000);
		 
		 //To transfer control from child  window to parent window
		 wutil.switchwindow(d, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		   
		//click on save button
		 d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		 Thread.sleep(2000);
		 
		 //to take screenshot of contact
		// wutil.scareenshot(d, "Contact");
		 
		 
		 //mousehover on image
//		  WebElement image =d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//		 wutil.mouseHover(d, image);
//		 
//		 //click on signout
//		 d.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		
		
		
		
	}
}
