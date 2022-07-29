package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirTarifasPage extends BasePage {

	// TARIFAS
	By lblTarifas = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[7]/div/div[1]/div/div/button");

	public ExpedirTarifasPage(WebDriver driver) {
		super(driver);
	}

	// TARIFAS
	@Step("Tarifas")
	public ExpedirTarifasPage Tarifas() {

		Utilidades.waitInMs(3000);
		//click(lblTarifas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

}