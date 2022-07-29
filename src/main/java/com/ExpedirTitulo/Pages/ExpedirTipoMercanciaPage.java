package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirTipoMercanciaPage extends BasePage {

	// TIPO DE MERCANCIA
	By lblTipoDeMercancia = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[4]/div/div[1]/div/div/button");
	By lblTipoDeMercanciaOpcion2 = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[5]/div/div[1]/div/div/button");
	By SeleccionarTipoDeMercancia = By.id("tipoMercancia");
	By txtDescripcionGeneralDeMercancia = By.id("timeDescripcion");
	By txtMerma = By.id("merma");
	By lblAplicaCondicionDeCalidad = By.id("aplicaCondicionCalidad");
	By lblAplicaCondicionDeCalidadSI = By.xpath("//*[@id=\"aplicaCondicionCalidad\"]/option[1]");
	By lblAplicaCondicionDeCalidadNO = By.xpath("//*[@id=\"aplicaCondicionCalidad\"]/option[2]");
	By txtObservaciones = By.id("observaciones");

	public ExpedirTipoMercanciaPage(WebDriver driver) {
		super(driver);
	}

	// TIPO DE MERCANCIA
	/*@Step("Tipo de Mercancia")
	public ExpedirTipoMercanciaPage TipoDeMercancia() {

		Utilidades.waitInMs(3000);
		click(lblTipoDeMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Tipo de Mercancia opción 2")
	public ExpedirTipoMercanciaPage TipoDeMercanciaOpcion2() {

		Utilidades.waitInMs(3000);
		click(lblTipoDeMercanciaOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Lista Tipo de Mercancia")
	public ExpedirTipoMercanciaPage ListaTipoDeMercancia() {

		Utilidades.waitInMs(3000);
		click(SeleccionarTipoDeMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aleatorio Lista Tipo de Mercancia")
	public ExpedirTipoMercanciaPage AleatorioTipoDeMercancia() {

		Utilidades.waitInMs(3000);
		
		WebElement Drplistdown = driver.findElement(By.id("tipoMercancia"));
		Select objSel = new Select(Drplistdown);
		List<WebElement> weblist = objSel.getOptions();
		int iCnt = weblist.size();
		Random num = new Random();
		int iSelect = num.nextInt(iCnt);
		objSel.selectByIndex(iSelect);
		System.out.println(Drplistdown.getAttribute("value"));

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Descripción general de mercancía")
	public ExpedirTipoMercanciaPage DescripcionGeneralDeMercancia(String descipcionGeneralMercancia) {

		Utilidades.waitInMs(3000);
		writeText(txtDescripcionGeneralDeMercancia, descipcionGeneralMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Eliminar Descripción general de mercancía")
	public ExpedirTipoMercanciaPage ClearDescripcionGeneralDeMercancia() {

		Utilidades.waitInMs(3000);
		clear(txtDescripcionGeneralDeMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Merma")
	public ExpedirTipoMercanciaPage Merma(String merma) {

		Utilidades.waitInMs(3000);
		writeText(txtMerma, merma);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Eliminar Merma")
	public ExpedirTipoMercanciaPage ClearMerma() {

		Utilidades.waitInMs(3000);
		clear(txtMerma);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Lista Aplica condición de calidad")
	public ExpedirTipoMercanciaPage AplicaCondicionDeCalidad() {

		Utilidades.waitInMs(3000);
		click(lblAplicaCondicionDeCalidad);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aplica condición de calidad opción SI")
	public ExpedirTipoMercanciaPage ListaTipoDeMercanciaSI() {

		Utilidades.waitInMs(3000);
		click(lblAplicaCondicionDeCalidadSI);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aplica condición de calidad opción NO")
	public ExpedirTipoMercanciaPage ListaTipoDeMercanciaNO() {

		Utilidades.waitInMs(3000);
		click(lblAplicaCondicionDeCalidadNO);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Observaciones")
	public ExpedirTipoMercanciaPage Observaciones(String observaciones) {

		Utilidades.waitInMs(3000);
		writeText(txtObservaciones, observaciones);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Eliminar Observaciones")
	public ExpedirTipoMercanciaPage ClearObservaciones() {

		Utilidades.waitInMs(3000);
		clear(txtObservaciones);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}*/

}