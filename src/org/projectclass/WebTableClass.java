package org.projectclass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableClass {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\SeleniumCalss\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		// Locate the webTable 
		
		WebElement table = driver.findElement(By.id("//table[@id='customers']"));
		
		// Find the no of Rows in the WebTable
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		System.out.println("no of Rows in the Webtable is"+ rows.size());
		
		for (int i = 0; i < rows.size(); i++) {
			
			WebElement row = rows.get(i);
			
			//i=0   tr[1]
			//i=1   tr[2]
			//System.out.println(row.getText());
			
			List<WebElement> datas = row.findElements(By.tagName("td"));
			
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(j);
				System.out.println(data.getText());
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
