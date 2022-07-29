package com.demoautomatizacion.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class HomeMap extends BasePage {

	public HomeMap(WebDriver driver) {
		super(driver);
	}

	protected By lblModulo = By.xpath("//*[@id='sidebar']/ul/li/div/a[contains(text(),'{0}')]");
	
	protected By lblModuloB = By.xpath("//*[@id='sidebar']/ul/li/div/a[contains(text()='{0}')]");
	
	
	protected By lblSubModulo = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[contains(text(),'{0}')]");
	
	protected By lblSubmoduloS = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[(text()='{0}')]");
}
