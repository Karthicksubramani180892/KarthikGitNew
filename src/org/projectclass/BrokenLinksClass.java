package org.projectclass;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksClass {
	
	public static void main(String[] args) throws IOException {
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\SeleniumCalss\\Driver\\chromedriver.exe" );
		
		WebDriver driver = new ChromeDriver();
		
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	
	//to find the total no of links
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println(links.size());
		
		int count = 0;
		
		for (int i = 0; i < links.size(); i++) {
		WebElement individuallink = links.get(i);
		String attribute = individuallink.getAttribute("href");
		
		//Url - pre defined class
		//url - Argument Based Constructor
		
		URL u = new URL(attribute);
		
		//create an connection for the converted url
		//Urlconnection - pre definedclass - higher order DataType
		//httpUrlconnection - pre definedclass - lower order DataType
		
		URLConnection openConnection = u.openConnection();
		
          //LowerOrder ref =(LowerOrder)higherorderref;
		//javascriptExecutor js = (Javascriptexecutor)driver;
		
		HttpURLConnection hc = (HttpURLConnection)openConnection;
		
		int responseCode = hc.getResponseCode();
		
		if(responseCode!=200) {
			
			System.out.println(attribute);
			count++;
		}
		
		
		}
		
		System.out.println("Total no of brokenlinks Count"+count);
	}
}
