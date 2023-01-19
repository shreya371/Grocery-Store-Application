package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver) {
		super();
		this.driver=driver;
	}
	
	public void clickLogout() {
		driver.findElement(By.xpath("/html/body/div/div/div/div/header/div/div/div/nav/div/ul[2]/li[4]/a")).click();	
		
	}

}
