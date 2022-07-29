package com.Reportes.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class GenerarReporteMap extends BasePage {

	public GenerarReporteMap(WebDriver driver) {
		super(driver);
	}

	// REPORTES
	protected By lblTipoReporte = By.name("tipo");
	protected By lblFechaInicio = By.id("fecIni");
	protected By lblFechaFin = By.xpath("//input[contains(@formcontrolname,'fecFin')]");
	protected By btnDescargar = By.xpath("//*[@id='contenido']/app-generar-reporte/div/div/div/button[contains(text(),'Descargar')]");
	protected By reporteExitoso = By.xpath("//div[@id='toast-container']/div/div");
	
	protected By AlertaExitoso = By.xpath("//*[@id='toast-container']");
	
	
}
