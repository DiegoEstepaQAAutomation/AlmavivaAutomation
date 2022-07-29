package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirPlazosPage extends BasePage {

	// PLAZOS
	By lblPlazos = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[3]/div/div[1]/div/div/button");
	By lblPlazosOpcion2 = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By txtPlazoCertificadoDepositoDias = By.id("plazoCertificadoDeposito");
	By txtPlazoContratoDepositoDias = By.id("plazoContratoDeposito");

	public ExpedirPlazosPage(WebDriver driver) {
		super(driver);
	}

	// PLAZOS
	/*@Step("Plazos")
	public ExpedirPlazosPage Plazos() {

		Utilidades.waitInMs(3000);
		click(lblPlazos);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Plazos opción 2")
	public ExpedirPlazosPage PlazosOpcion2() {

		Utilidades.waitInMs(3000);
		click(lblPlazosOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Plazo Certificado Depósito días")
	public ExpedirPlazosPage PlazoCertificadoDepositoDias(String plazoCertificadoDepositoDias) {

		Utilidades.waitInMs(3000);
		writeText(txtPlazoCertificadoDepositoDias, plazoCertificadoDepositoDias);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Plazo Contrato Depósito días")
	public ExpedirPlazosPage PlazoContratoDepositoDias(String plazoContratoDepositoDias) {

		Utilidades.waitInMs(3000);
		writeText(txtPlazoContratoDepositoDias, plazoContratoDepositoDias);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Plazo Contrato Depósito días")
	public ExpedirPlazosPage ClearPlazoContratoDepositoDias() {

		Utilidades.waitInMs(3000);
		clear(txtPlazoContratoDepositoDias);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}*/

}