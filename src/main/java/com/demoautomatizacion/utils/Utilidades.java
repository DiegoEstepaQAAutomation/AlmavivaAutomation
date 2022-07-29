package com.demoautomatizacion.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Attachment;

import java.io.File;
import java.io.File.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.Properties;
import org.openqa.selenium.support.ui.Select;

import com.demoautomatizacion.Pages.BasePage;

public class Utilidades extends BasePage {
	//private static WebDriver driver;
	
	public Utilidades(WebDriver driver) {
		super(driver);
		
		}

    public static void waitInMs(Integer milliseconds)  {
        try {
           Thread.sleep(milliseconds);
        } catch (Exception e) {}
    }
    
    public static void seleccionarKeyBoard(WebElement field) {
		field.sendKeys(Keys.UP);	
	    field.click();
		field.sendKeys(Keys.ENTER);
		
	}
    public static void Selected(By elementLocation,int a) {
    	Select Select = new Select(driver.findElement(elementLocation));
    	Select.selectByIndex(a);
	}
    public static void Selecionar(By elementLocation,String a) {
    	Select Select = new Select(driver.findElement(elementLocation));
    	Select.selectByValue(a);
    }
    
   public static void takeSnapShot(WebDriver webdriver, String nombrePantalla) throws IOException {
	   try {
    	Calendar calendario = Calendar.getInstance();
    	int  hora, minutos, segundos;
    	hora =calendario.get(Calendar.HOUR_OF_DAY);
    	minutos = calendario.get(Calendar.MINUTE);
    	segundos = calendario.get(Calendar.SECOND);
    	
    	File screenshotFile =((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
    	File f= new File("C:\\Users\\505GT\\eclipse-workspace\\shopperAllure\\allure-results\\"+nombrePantalla+hora+minutos+segundos+".png");
    	com.google.common.io.Files.copy(screenshotFile, f);
    
	    
           } catch (Exception e) {}
	   }
   @Attachment(value = "Screenshot", type = "image/png")
   public static byte[] screenshot() {
       return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
   }
   

   public static void ByPixelA() {

       JavascriptExecutor js = (JavascriptExecutor) driver;
       driver.manage().window().maximize();
       js.executeScript("window.scrollBy(0,-1500)");
   }

}
