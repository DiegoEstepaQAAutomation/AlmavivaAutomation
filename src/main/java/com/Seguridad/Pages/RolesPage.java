package com.Seguridad.Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Seguridad.Maps.RolesMap;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class RolesPage extends RolesMap {
	
	Object[] x;
	boolean val;
	int t = 15;

	public RolesPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Obligatoriedad de campos")
	public RolesPage obligatoriedadCampos(File folderPath) throws Exception {
		
		x = new Object[2];
		x[0] = lblNombreRolObligatorio;
		x[1] = lblDescripcionRolObligatorio;
		
		click(btnCrearRol, folderPath, "Se ingresa a crear Rol");
		click(txtNombreRol, folderPath, "Obligatoriedad campo Nombre Rol");
		click(txtDescripcionRol, folderPath, "Obligatoriedad campo Descripción de Rol");
		click(lblEstado, folderPath, "Obligatoriedad campo Estado");

		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			time(1);
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados");
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
		return this;
	}
	
	@Step("Campos con 100 Caracteres")
	public RolesPage caracteres100(File folderPath, String nombre, String descripcion, String nom100, String desc100) throws Exception {

		String nom = driver.findElement(By.xpath("//input[contains(@formcontrolname,'roleNombre')]")).getAttribute("maxlength");
		String desc = driver.findElement(By.xpath("//textarea[contains(@formcontrolname,'descripcion')]")).getAttribute("maxlength");
		
		if (nom.contains(nom100) && desc.contains(desc100)) {
			printConsole("Los campos contienen el maximo de 100 caracteres");
		}
		else {
			printConsole("Error en la validación, los campos no contienen el maximo de 100 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 100 caracteres");
		}
		
		writeText(txtNombreRol, nombre, folderPath, "Se ingresa el dato Nombre con 100 Caracteres");
		writeText(txtDescripcionRol, descripcion, folderPath, "Se ingresa el dato Descripción de Rol con 100 Caracteres");
		return this;
	}
	
	@Step("Crear rol")
	public RolesPage crearRol(File folderPath, String nombre, String descripcion, String estado, String permiso) throws Exception {
		
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		String nombreR = nombre + timeStamp;

		printConsole("Nombre Rol: " + nombreR);
		etiquetas(btnCrearRol, folderPath, "Etiqueta Crear rol");
		click(btnCrearRol, folderPath, "Se ingresa a crear Rol");
		writeText(txtNombreRol, nombreR, folderPath, "Se ingresa el dato Nombre Rol");
		writeText(txtDescripcionRol, descripcion, folderPath, "Se ingresa el dato Descripción de Rol");
		selectElementList(lblEstado, estado, folderPath, "Se selecciona el Estado");
		
		// PERMISOS
		click(locatorVariable(lblPermisos, permiso), folderPath, "Se ingresa a la opción Permisos");
		click(cbxUsuariosConsultar, folderPath, "Selecciona el checkbox de Usuario consultar");
		return this;
	}
	
	@Step("Cancelar registro Rol")
	public RolesPage cancelarRol(File folderPath) throws Exception {

		click(btnCancelarRol, folderPath, "Se cancela el registro de Rol");
		return this;
	}
	
	@Step("Guardar registro Rol")
	public RolesPage guardarRol(File folderPath) throws Exception {

		click(btnGuardarRol, folderPath, "Se guarda el registro de Rol");
		return this;
	}
	
	@Step("Aceptar registro Rol")
	public RolesPage aceptarRol(File folderPath) throws Exception {
		
		click(btnAceptarRegistro, folderPath, "Se acepta el registro de Rol");

		val = validarElemento(registroExitoso, t);

		if (Boolean.TRUE.equals(val)) {
			// El registro se ha guardado
		} else {
			GenerarReportePdf.closeTemplate("Error en la validaci�n, el registro no se creo correctamente");
			Assert.fail("Error en la validaci�n, el registro no se creo correctamente");
		}
		return this;
	}
	
	@Step("Modificar Rol")
	public RolesPage modificarRol(File folderPath, String descripcion, String estado) throws Exception {

		scrollElementH(folderPath, btnModificarRol, "Se desplaza hasta la opción Modificar rol");
		etiquetas(btnModificarRol, folderPath, "Etiqueta Modificar rol");
		click(btnModificarRol, folderPath, "Se ingresa a modificar Rol");
		isEnabled(txtNombreRol, folderPath, "Campo Nombre Rol No editable");
		clear(txtDescripcionRol, folderPath, "Se borra el dato anterior de Descripción de Rol");
		writeText(txtDescripcionRol, descripcion, folderPath, "Se ingresa el dato Descripción de Rol");
		selectElementList(lblEstado, estado, folderPath, "Se selecciona el Estado");
		click(btnGuardarRolEditado, folderPath, "Se guarda el registro de Rol");
		return this;
	}
	
	@Step("Ver rol")
	public RolesPage verRol(File folderPath) throws Exception {
		
		scrollElementH(folderPath, btnVerRol, "Se desplaza hasta la opción Ver rol");
		etiquetas(btnVerRol, folderPath, "Etiqueta Ver rol");
		click(btnVerRol, folderPath, "Se ingresa a ver rol");
		
		isEnabled(txtNombreRol, folderPath, "Campo Nombre Rol No editable");
		isEnabled(txtDescripcionRol, folderPath, "Campo Descripción de Rol No editable");
		isEnabled(lblEstado, folderPath, "Campo Estado No editable");
		return this;
	}
	
	@Step("Botones consultar rol")
	public RolesPage botonesRol(File folderPath) throws Exception {

		x = new Object[2];
		x[0] = btnBuscar;
		x[1] = btnVerTodos;

		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			click(btnVerTodos, folderPath, "Se selecciona la opción Ver Todos");
			waitInMs(3000);
			if (lblNombreRolTabla == null) {
				GenerarReportePdf.closeTemplate("No se trajo la información correctamente");
				Assert.fail("No se trajo la información correctamente");
			} else {
				printConsole("Se trajo la información correctamente");
			}
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados");
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
		return this;
	}

	@Step("Consultar rol")
	public RolesPage consultaRol(File folderPath, String nom50, String nombreRol) throws Exception {

		String nombre = RandomStringUtils.randomAlphabetic(50).toLowerCase();
		String nom = driver.findElement(By.xpath("//input[contains(@formcontrolname,'terminoBusqueda')]")).getAttribute("maxlength");

		if (nom.contains(nom50)) {
			printConsole("Los campos contienen el maximo de 50 caracteres");
			writeText(consultarRol, nombre, folderPath, "Se ingresa texto de 50 caracteres");
			clear(consultarRol, folderPath, "Se eliminar texto antes digitado");
			writeText(consultarRol, nombreRol, folderPath, "Se ingresa nombre de usuario");
			click(btnBuscar, folderPath, "Se busca el usuario digitado");
		} else {
			printConsole("Error en la validación, los campos no contienen el maximo de 50 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 50 caracteres");
		}
		return this;
	}
}