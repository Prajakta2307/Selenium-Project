package Vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtil.BaseClass;
import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.PropertyFileUtil;
import CommonUtil.WebDriverUtil;

public class OrganizationTestng extends BaseClass{
	
	//public WebDriver d;
	PropertyFileUtil putil=new PropertyFileUtil();

	WebDriverUtil wutil=new WebDriverUtil();
	ExcelUtil eutil=new ExcelUtil();
	JavaUtil jutil=new JavaUtil();

		@Test
		public void organizations() throws IOException,InterruptedException {

			//to read from excel sheet
			String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
			 String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);
			
			
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
			
			wutil.handledropdown(dropdown, GROUP);	
			
			Thread.sleep(2000);
			//click on save buuton
			
			d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
			
			
			
			
		}

}
