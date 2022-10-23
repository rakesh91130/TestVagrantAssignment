package com.testVagrant.assignment.SDETAssignment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

//				driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
//				List<WebElement> el1=driver.findElements(By.xpath("//table[@class='infobox vevent']/tbody/tr"));
//				WebElement el2=driver.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[12]/td"));
//				WebElement el3=driver.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[14]/td"));
//				System.out.println(el2.getText());
//				String  pattern ="MM-dd-yyyy";
//				SimpleDateFormat d=new SimpleDateFormat(pattern);
//				@SuppressWarnings("deprecation")
//				Date dat=new Date(el2.getText());
//				String date=d.format(dat);
//				System.out.println(date);

		driver.get("https://www.imdb.com/title/tt9389998/");
		WebElement el;
		el = driver.findElement(By.xpath("//div[@class='sc-f65f65be-0 ktSkVi']/ul/li[1]/div"));
		//el = driver.findElement(By.xpath("//div[@class='sc-f65f65be-0 ktSkVi']/ul/li[2]/div"));
		System.out.println(el.getText());
		String released=el.getText();
		StringBuilder sb= new StringBuilder();
		sb.append(el.getText());
		System.out.println(sb.indexOf("("));
		int i=sb.indexOf("(");
		String a=released.substring(0, i);
		System.out.println(a);
		
		
		String  pattern ="MM-dd-yyyy";
		SimpleDateFormat d=new SimpleDateFormat(pattern);
		@SuppressWarnings("deprecation")
		Date dat=new Date(a);
		String date=d.format(dat);
		System.out.println(date);

	}

}
