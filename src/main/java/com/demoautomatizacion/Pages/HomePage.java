package com.demoautomatizacion.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Maps.HomeMap;

import io.qameta.allure.Step;

public class HomePage extends HomeMap {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	//ESTE COMENTARIO ES UNA REDUNDANCIA DE LO QUE DESCRIBE ABAJO ABRIR PORTAL DE ALMAVIVA
	@Step("Abrir Portal Almaviva. Url {0}")
	public HomePage irPortal(String url) {
		driver.get(url);
		return new HomePage(driver);
	}
	//Metodo para ingresar a modulo y submodulo

	@Step("Ingresar al Módulo")
	public void modulo(File folderPath, String modulo, String subModulo,String Evidencia) throws Exception {
		click(locatorVariable(lblModulo, modulo), folderPath, "Se ingresa al Módulo",Evidencia);
		if (subModulo != null)
			click(locatorVariable(lblSubmoduloS, subModulo), folderPath, "Se ingresa al Sub-módulo",Evidencia);
	}
	
	@Step("Ingresar al Módulo")
	public void modulo2( String modulo, String subModulo) throws Exception {
		click(locatorVariable(lblModulo, modulo));
		if (subModulo != null)
			click(locatorVariable(lblSubmoduloS, subModulo));
	}
}
