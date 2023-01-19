package com.demo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demo.pages.Homepage;
import com.demo.pages.LoginPage;

public class Testcase_001 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHREYA VANAMPALLY\\OneDrive\\Desktop\\spring-selenium\\chromedriver.exe");
		
		WebDriver obj =new ChromeDriver();		
		obj.get("http://localhost:3000/");
		
		LoginPage login=new LoginPage(obj);
		
		login.enterUsername("shreya1234");
		login.enterPassword("123456");
		
		login.clickLogin();
		Thread.sleep(3000);
		
		Homepage home= new Homepage(obj);
		home.clickLogout();
		Thread.sleep(3000);
		
	}

}
