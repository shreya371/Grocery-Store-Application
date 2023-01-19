package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super();
		this.driver=driver;
	}
//	By user=By.xpath(null);
//	By username=By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div[1]/input");
//	By password=By.xpath("//*[@id=\"query2\"]");
//	By login=By.xpath("//*[@id=\\\"login-button\\\"]");
//	By login1=
	
	public void enterUsername(String user) {
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/div[1]/input")).sendKeys(user);	
		
	}
	public void enterPassword(String password) {
		driver.findElement(By.xpath("//*[@id=\"query2\"]")).sendKeys(password);	
		
	}
	public void clickLogin() {
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();	
		
	}
	

}
