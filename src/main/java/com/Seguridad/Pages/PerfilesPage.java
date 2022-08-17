package com.Seguridad.Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Seguridad.Maps.PerfilesMap;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class PerfilesPage extends PerfilesMap {

	Object[] x;
	boolean val;
	int t = 15;

	public PerfilesPage(WebDriver driver) {
		super(driver);
	}

	//paso a paso para validar la obligatoriedad de los campos de perfil,descripcion de perfil y crear perfil
	@Step("Obligatoriedad de campos")
	public PerfilesPage obligatoriedadCampos(File folderPath) throws Exception {
		x = new Object[2];
		x[0] = lblNombrePerfilObligatorio;
		x[1] = lblDescripcionPerfilObligatorio;

		click(btnCrearPerfil, folderPath, "Se ingresa a crear Perfil");
		click(txtNombrePerfil, folderPath, "Obligatoriedad campo Nombre Perfil");
		click(txtDescripcionPerfil, folderPath, "Obligatoriedad campo Descripción de Perfil");
		click(txtNombrePerfil);

		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			time(1);
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados");
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
		return this;
	}

	//paso a paso de validacion de un maximo de caracteres en 2 campos
	@Step("Campos con 50 y 100 Caracteres")
	public PerfilesPage caracteres50100(File folderPath, String nombre, String descripcion, String nom50, String desc100) throws Exception {
		
		//se obtiene el atributo del maximo tamaño de cadena de texto en 2 localizadores
		String nom = driver.findElement(By.xpath("//input[contains(@id,'nombre')]")).getAttribute("maxlength");
		String desc = driver.findElement(By.xpath("//textarea[contains(@id,'descripcion')]")).getAttribute("maxlength");
		
		//Se envia las variables de maximo de tamaño de texto a ser comparados contra 2 variables de properties que contienen el valor maximo de 50 y 100 caracteres
		if (nom.equals(nom50) && desc.equals(desc100)) {
			printConsole("Los campos contienen el maximo de 50 y 100 caracteres");
		}
		else {
			printConsole("Error en la validación, los campos no contienen el maximo de 50 y 100 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 50 y 100 caracteres");
		}

		//Se escribe el nombre y la descripcion de perfil
		writeText(txtNombrePerfil, nombre, folderPath, "Se ingresa el dato Nombre con 50 Caracteres");
		writeText(txtDescripcionPerfil, descripcion, folderPath, "Se ingresa el dato Descripción de Perfil con 100 Caracteres");
		return this;
	}

	@Step("Crear perfil")
	public PerfilesPage crearPerfil(File folderPath, String nombre, String descripcion)
			throws Exception {

		//Se envia a una variable de tipo string la fecha actual en formato de horas minutos y segundos
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		String nombreR = nombre + timeStamp;

		printConsole("Nombre Rol: " + nombreR);
		etiquetas(btnCrearPerfil, folderPath, "Etiqueta Crear rol");
		click(btnCrearPerfil, folderPath, "Se ingresa a crear Rol");
		writeText(txtNombrePerfil, nombreR, folderPath, "Se ingresa el dato Nombre Rol");
		writeText(txtDescripcionPerfil, descripcion, folderPath, "Se ingresa el dato Descripción de Rol");
		click(lblAgregarRol, folderPath, "Se ingresa a agregar Rol");

		// ROL - Se agregar un ciclo para 3 roles
		cicloAgregarRol(folderPath);
		return this;
	}

	//Ciclo de agregar un rol a un perfil
	@Step("Ciclo elegir rol Perfil")
	public PerfilesPage cicloAgregarRol(File folderPath) throws Exception {

		for (int i = 0; i <= 2; i++) {
			listRandom(lblRol, folderPath, "Se toma un Rol aleatorio");
			waitInMs(500);
			click(btnAgregarRol, folderPath, "Se agrega de la lista el Rol");
			waitInMs(500);
		}
		return this;
	}

	//cancelar registro de perfil
	@Step("Cancelar registro Perfil")
	public PerfilesPage cancelarPerfil(File folderPath) throws Exception {

		click(btnCancelarPerfil, folderPath, "Se cancela el registro de Perfil");
		return this;
	}

	@Step("Guardar registro Perfil")
	public PerfilesPage guardarPerfil(File folderPath) throws Exception {

		click(btnGuardarPerfil, folderPath, "Se guarda el registro de Perfil");
		return this;
	}

	@Step("Aceptar registro Perfil")
	public PerfilesPage aceptarPerfil(File folderPath) throws Exception {

		click(btnAceptarRegistro, folderPath, "Se acepta el registro de Perfil");

		val = validarElemento(registroExitoso, t);

		if (Boolean.TRUE.equals(val)) {
			// El registro se ha guardado
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, el registro no se creo correctamente");
			Assert.fail("Error en la validación, el registro no se creo correctamente");
		}
		return this;
	}

	//Modificacion de perfil 
	@Step("Modificar perfil")
	public PerfilesPage modificarPerfil(File folderPath, String descripcion, String estado)
			throws Exception {

		//paso a paso de modificar perfil 
		scrollElementH(folderPath, btnModificarPerfil, "Se desplaza hasta la opción Modificar perfil");
		etiquetas(btnModificarPerfil, folderPath, "Etiqueta Crear perfil");
		click(btnModificarPerfil, folderPath, "Se ingresa a crear Perfil");
		isEnabled(txtNombrePerfil, folderPath, "Campo Nombre Perfil No editable");
		clear(txtDescripcionPerfil, folderPath, "");
		writeText(txtDescripcionPerfil, descripcion, folderPath, "Se ingresa el dato Descripción de Rol");
		selectElementList(lblEstado, estado, folderPath, "Se selecciona el Estado");
		click(lblAgregarRol, folderPath, "Se ingresa a agregar Rol");
		
		for (int i = 0; i <= 2; i++) {
			click(btnQuitarRol, folderPath, "Se elimina rol: " + (i + 1));
			waitInMs(500);
		}

		// ROL - Se agregar un ciclo para 3 roles
		cicloAgregarRol(folderPath);
		return this;
	}
	
	//Ver perfil
	@Step("Ver perfil")
	public PerfilesPage verPerfil(File folderPath) throws Exception {
		
		//Se valida la visualizacion de perfil 
		scrollElementH(folderPath, btnVerPerfil, "Se desplaza hasta la opción Ver perfil");
		etiquetas(btnVerPerfil, folderPath, "Etiqueta Ver perfil");
		click(btnVerPerfil, folderPath, "Se ingresa a ver perfil");
		
		//Se valida que los campos esten enabled 
		isEnabled(txtNombrePerfil, folderPath, "Campo Nombre Perfil No editable");
		isEnabled(txtDescripcionPerfil, folderPath, "Campo Descripción de Perfil No editable");
		isEnabled(lblEstado, folderPath, "Campo Estado No editable");
		return this;
	}
	
	@Step("Botones consultar perfil")
	public PerfilesPage botonesPerfil(File folderPath) throws Exception {

		x = new Object[2];
		x[0] = btnBuscar;
		x[1] = btnVerTodos;

		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			click(btnVerTodos, folderPath, "Se selecciona la opción Ver Todos");
			waitInMs(3000);
			if (lblNombrePerfilTabla == null) {
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

	//Consulta de perfil 
	@Step("Consultar perfil")
	public PerfilesPage consultaPerfil(File folderPath, String nom50, String nombrePerfil) throws Exception {

		//Se envia a una variable string un valor random y se digita
		String nombre = RandomStringUtils.randomAlphabetic(50).toLowerCase();
		String nom = driver.findElement(By.xpath("//input[contains(@formcontrolname,'terminoBusqueda')]")).getAttribute("maxlength");

		//Se valida si contiene un maximo de 50 caracteres y se escribe 
		if (nom.contains(nom50)) {
			printConsole("Los campos contienen el maximo de 50 caracteres");
			writeText(consultarPerfil, nombre, folderPath, "Se ingresa texto de 50 caracteres");
			clear(consultarPerfil, folderPath, "Se eliminar texto antes digitado");
			writeText(consultarPerfil, nombrePerfil, folderPath, "Se ingresa nombre de usuario");
			click(btnBuscar, folderPath, "Se busca el usuario digitado");
		} else {
			printConsole("Error en la validación, los campos no contienen el maximo de 50 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 50 caracteres");
		}
		return this;
	}
}