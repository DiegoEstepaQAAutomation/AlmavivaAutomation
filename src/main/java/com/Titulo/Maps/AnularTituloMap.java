package com.Titulo.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class AnularTituloMap extends BasePage {

	public AnularTituloMap(WebDriver driver) {
		super(driver);
	}

	// CREAR
	protected By txtBuscarTitulo = By.id("titulo");
	protected By seleccionarTituloBuscar = By.xpath("//app-filtrotitulo/form/div/div/ngb-typeahead-window/button[1]");
	protected By btnAnularTitulo = By.xpath("//*[@id='contenido']/ng-component/div/form/div/div/button[contains(text(),'Anular Titulo')]");
	protected By lblRazonAnulacion = By.name("my_html_select_box"); // xpath   //*[@name='my_html_select_box']
	protected By btnGuardarRazonAnulacion = By.xpath("//ng-component/div/form/div/button[contains(text(),'Guardar')]");
	protected By btnAceptarRazonAnulacion = By.xpath("}//div/div/div/button[contains(text(),'Aceptar')]");



}
