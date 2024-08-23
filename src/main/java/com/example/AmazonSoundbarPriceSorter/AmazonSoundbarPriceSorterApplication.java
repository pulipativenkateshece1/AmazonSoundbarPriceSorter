package com.example.AmazonSoundbarPriceSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmazonSoundbarPriceSorterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AmazonSoundbarPriceSorterApplication.class, args);
	}
	@Override
	
	public void run(String... args)
	{
		//System.setProperty("webdriver.chrome.driver", "path/to/"C:\Users\hp\Downloads\ChromeSetup(1).exe"");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

		
		
		WebDriver driver   = new ChromeDriver();
		
		try 
		{
			driver.get("https://www.amazon.in/");
			
			WebElement searchBox   = driver.findElement(By.id("twotabsearchtextbox"));
			
			searchBox.sendKeys("lg soundbar");
			
			searchBox.submit();
			List<WebElement> products = driver.findElements(By.cssSelector(".s-main-slot .s-result-item"));
			
			Map<String, Integer> productMap = new HashMap<String, Integer>();
			
			for(WebElement product : products)
			{
				try 
				{
					String brandName = product.findElement(By.cssSelector(".s-line-clamp-1 span")).getText();
					
					String productName  = product.findElement(By.cssSelector(".a-size-medium.a-text-normal")).getText();
					
					String priceString = product.findElement(By.cssSelector(".a-price-whole")).getText().replace(",", "");
					
					int price = Integer.parseInt(priceString);
					
					String fullProductName = brandName + " "+ productName;
					productMap.put(fullProductName, price);
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			List<Map.Entry<String, Integer>> sortedProducts = new ArrayList<Map.Entry<String,Integer>>();
			Collections.sort(sortedProducts, Map.Entry.comparingByKey());
			
			for(Map.Entry<String, Integer> entry : sortedProducts)
			{
				System.out.println(entry.getKey()+ " "+ entry.getValue());
			}
			
		} 
		finally {
			// TODO: handle finally clause
			
			driver.quit();
		}
		
		

		
		
	}

}
