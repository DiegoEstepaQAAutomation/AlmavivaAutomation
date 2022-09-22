package com.demoautomatizacion.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Maps.HomeMap;

import io.qameta.allure.Step;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePage.
 */
public class HomePage extends HomeMap {

	/**
	 * Instantiates a new home page.
	 *
	 * @param driver the driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Ir portal.
	 *
	 * @param url the url
	 * @return the home page
	 */
	//ESTE COMENTARIO ES UNA REDUNDANCIA DE LO QUE DESCRIBE ABAJO ABRIR PORTAL DE ALMAVIVA
	@Step("Abrir Portal Almaviva. Url {0}")
	public HomePage irPortal(String url) {
		driver.get(url);
		return new HomePage(driver);
	}
	//Metodo para ingresar a modulo y submodulo

	
	/**
	 * Modulo.
	 *
	 * @param folderPath the folder path
	 * @param modulo the modulo
	 * @param subModulo the sub modulo
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	//Metodo para ingresar a un modulo determinado con o sin evidencia
	@Step("Ingresar al Módulo")
	public void modulo(File folderPath, String modulo, String subModulo,String Evidencia) throws Exception {
		
		
		 
		click(locatorVariable(lblModulo, modulo), folderPath, "Se ingresa al Módulo",Evidencia);
		if (subModulo != null)
			click(locatorVariable(lblSubmoduloS, subModulo), folderPath, "Se ingresa al Sub-módulo",Evidencia); 
	}
			
		
	/**
	 * Modulo 2.
	 *
	 * @param modulo the modulo
	 * @param subModulo the sub modulo
	 * @throws Exception the exception
	 */
	//Ingreso a modulo y submodulo sin evidencia(en desuso)
	@Step("Ingresar al Módulo")
	public void modulo2( String modulo, String subModulo) throws Exception {
		click(locatorVariable(lblModulo, modulo));
		if (subModulo != null)
			click(locatorVariable(lblSubmoduloS, subModulo));
	}
}
