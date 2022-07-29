package com.Seguridad.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class RolesMap extends BasePage {

	public RolesMap(WebDriver driver) {
		super(driver);
	}

	// CREAR
	protected By btnCrearRol = By.xpath("//*[@id='contenido']/roles-main/roles-home/div/div/div/a");
	protected By txtNombreRol = By.xpath("//*[@formcontrolname='roleNombre']");
	protected By txtDescripcionRol = By.xpath("//*[@formcontrolname='descripcion']");
	protected By lblEstado = By.xpath("//*[@formcontrolname='estado']");
	protected By btnGuardarRol = By.xpath("//*[@id='contenido']/roles-main/roles-crear/div/form/div/div/button[contains(text(),'Guardar')]");
	protected By btnCancelarRol = By.xpath("//*[@id='contenido']/roles-main/roles-crear/div/form/div/div/button[contains(text(),'Cancelar')]");
	protected By btnAceptarRegistro = By.xpath("//body/div/div/div/button[contains(text(),'Aceptar')]");
	protected By btnCancelarRegistro = By.xpath("//body/div/div/div/button[contains(text(),'Cancelar')]");
	protected By registroExitoso = By.xpath("//div[@id='toast-container']/div/div");
	
	// Campos obligatorios
	protected By lblNombreRolObligatorio = By.xpath("//*[@id='contenido']/roles-main/roles-crear/div/form/div[2]/div/div/span");
	protected By lblDescripcionRolObligatorio = By.xpath("//*[@id='contenido']/roles-main/roles-crear/div/form/div[3]/div/div/span");
	
	// PERMISOS
	protected By lblPermisos = By.xpath("//*[@class='accordion-toggle']/button/div[contains(text(),'{0}')]");
	protected By cbxUsuariosConsultar = By.id("usuarios-seguridad-consultar");
	
	// MODIFICAR
	protected By btnModificarRol = By.xpath("//*[@id='tbRoles']/tbody/tr[1]/td[4]/div/a[1]");
	protected By btnGuardarRolEditado = By.xpath("//*[@id='contenido']/roles-main/roles-actualizar/div/form/div/div/button[contains(text(),'Guardar')]");
	protected By btnCancelarRolEditado = By.xpath("//*[@id='contenido']/roles-main/roles-actualizar/div/form/div/div/button[contains(text(),'Guardar')]");
	
	
	//VER
	protected By btnVerRol = By.xpath("//*[@id='tbRoles']/tbody/tr[1]/td[4]/div/a[2]");
	
	// CONSULTAR
	protected By consultarRol = By.xpath("//input[contains(@formcontrolname,'terminoBusqueda')]");
	protected By lblNombreRolTabla = By.xpath("//*[@id='tbRoles']/tbody/tr[1]/td[1]");
	protected By btnBuscar = By.xpath("//*[@id='contenido']/roles-main/roles-home/div/form/button[contains(text(),'Buscar')]");
	protected By btnVerTodos = By.xpath("//*[@id='contenido']/roles-main/roles-home/div/form/button[contains(text(),'Ver Todos')]");
}
