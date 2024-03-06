package Vtigercrm;

import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.ListenerImplementation;
import CommonUtil.PropertyFileUtil;
import CommonUtil.WebDriverUtil;


@Listeners(ListenerImplementation.class)
public class Organization {
	
	
PropertyFileUtil putil=new PropertyFileUtil();

WebDriverUtil wutil=new WebDriverUtil();
ExcelUtil eutil=new ExcelUtil();
JavaUtil jutil=new JavaUtil();

	@Test
	public void organizations() throws IOException,InterruptedException {
		WebDriver d=new ChromeDriver();
		//to maximize the window
		//wutil.Maximize(d);
		
		//to apply wait for findelement method
		//wutil.implicitwait(d);
		
		//to read data from property file
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME= putil.getDataFromPropertyFile("Username");
		String PASSWORD= putil.getDataFromPropertyFile("Password");
		//to read from excel sheet
		Thread.sleep(2000);
		
		String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
		 String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);
		
		//to launch the Application
		d.get(URL);
	
		//to login to Application
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		
		Thread.sleep(2000);
		//click on organization
		d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		Thread.sleep(2000);
		//click on create organization..(+)
		d.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		Thread.sleep(2000);
		//enter organization name
		d.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
		
		Thread.sleep(2000);
		//in asignedto click on group
		d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		Thread.sleep(2000);
		//In the dropdown select support group
		
		WebElement dropdown = d.findElement(By.name("assigned_group_id"));
//		Select s=new Select(dropdown);
//		s.selectByVisibleText("Support Group");
//		s.selectByVisibleText(GROUP);

		wutil.handledropdown(dropdown, GROUP);	
		
		Thread.sleep(2000);
		//click on save buuton
		
		d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Thread.sleep(2000);
		
		//mousehover on image signout
		WebElement image = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mouseHover(d, image);
		
		//click on signout
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
