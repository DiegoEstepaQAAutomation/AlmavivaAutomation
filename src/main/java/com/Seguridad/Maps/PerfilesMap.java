package com.Seguridad.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class PerfilesMap extends BasePage {

	public PerfilesMap(WebDriver driver) {
		super(driver);
	}

	// CREAR
	protected By btnCrearPerfil = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/div/div/a");
	protected By txtNombrePerfil = By.xpath("//*[@formcontrolname='nombre']");
	protected By txtDescripcionPerfil = By.xpath("//*[@formcontrolname='descripcion']");
	protected By lblEstado = By.xpath("//*[@formcontrolname='estado']");
	protected By btnGuardarPerfil = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/div/div/button[contains(text(),'Guardar')]");
	protected By btnCancelarPerfil = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/div/div/button[contains(text(),'Cancelar')]");
	protected By btnAceptarRegistro = By.xpath("//body/div/div/div/button[contains(text(),'Aceptar')]");
	protected By btnCancelarRegistro = By.xpath("//body/div/div/div/button[contains(text(),'Cancelar')]");
	protected By registroExitoso = By.xpath("//div[@id='toast-container']/div/div");
	
	// Campos obligatorios
	protected By lblNombrePerfilObligatorio = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/div[2]/div/div");
	protected By lblDescripcionPerfilObligatorio = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/div[3]/div/div");
	
	// ROL
	protected By lblAgregarRol = By.xpath("//*[@class='accordion-toggle']/button/div[contains(text(),'Agregar rol')]");
	protected By lblRol = By.id("rol");
	protected By btnAgregarRol = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/accordion/accordion-group/div/div/div/div/div/button");
	
	// MODIFICAR
	protected By btnModificarPerfil = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/div[3]/table/tbody/tr[1]/td[4]/div/a[1]");
	protected By btnQuitarRol = By.xpath("//*[@class='panel-collapse collapse in show']/div/div/div/table/tbody/tr[1]/td[3]/button");
	//VER
	protected By btnVerPerfil = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/div[3]/table/tbody/tr[1]/td[4]/div/a[2]");
	
	// CONSULTAR
	protected By consultarPerfil = By.xpath("//input[contains(@formcontrolname,'terminoBusqueda')]");
	protected By lblNombrePerfilTabla = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/div[3]/table/tbody/tr[1]/td[1]");
	protected By btnBuscar = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/div/button[contains(text(),'Buscar')]");
	protected By btnVerTodos = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/div/button[contains(text(),'Ver Todos')]");
}
