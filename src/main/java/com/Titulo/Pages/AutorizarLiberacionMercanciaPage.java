package com.Titulo.Pages;

import org.openqa.selenium.WebDriver;
import com.Titulo.Maps.AutorizarLiberacionMercanciaMap;
import java.io.File;
import io.qameta.allure.Step;

public class AutorizarLiberacionMercanciaPage extends AutorizarLiberacionMercanciaMap {

	Object[] x;
	boolean val;
	int t = 15;

	public AutorizarLiberacionMercanciaPage(WebDriver driver) {
		super(driver);
	}

	@Step("")
	public AutorizarLiberacionMercanciaPage a(File folderPath) throws Exception {

		return this;
	}
}