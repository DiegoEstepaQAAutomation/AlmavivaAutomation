package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirPolizaPage extends BasePage {

	// POLIZA
	By lblPoliza = By.xpath("/html/body/app-root/div/div/div/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[3]/div/div[1]/div/div/button");
	By lblPolizaOpcion2 = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[4]/div/div[1]/div/div/button");
	By lblPolizaOpciones = By.id("polizaSelect");
	By SeleccionarPoliza = By.xpath("//*[@id=\"polizaSelect\"]/option[2]");

	public ExpedirPolizaPage(WebDriver driver) {
		super(driver);
	}

	// POLIZA
	/*@Step("Póliza")
	public ExpedirPolizaPage Poliza() {

		Utilidades.waitInMs(3000);
		click(lblPoliza);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Póliza opción 2")
	public ExpedirPolizaPage PolizaOpcion2() {

		Utilidades.waitInMs(3000);
		click(lblPolizaOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Póliza opciones")
	public ExpedirPolizaPage PolizaOpciones() {

		Utilidades.waitInMs(3000);
		click(lblPolizaOpciones);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Seleccionar Póliza")
	public ExpedirPolizaPage SeleccionarPoliza() {

		Utilidades.waitInMs(3000);
		click(SeleccionarPoliza);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}*/

}