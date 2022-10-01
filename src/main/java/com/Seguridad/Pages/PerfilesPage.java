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
	public PerfilesPage obligatoriedadCampos(File folderPath,String Evidencia) throws Exception {
		x = new Object[2];
		x[0] = lblNombrePerfilObligatorio;
		x[1] = lblDescripcionPerfilObligatorio;
		
		//Pasos para ingresar al perfil personal de usuario
		click(btnCrearPerfil, folderPath, "Se ingresa a crear Perfil",Evidencia);
		click(txtNombrePerfil, folderPath, "Obligatoriedad campo Nombre Perfil",Evidencia);
		click(txtDescripcionPerfil, folderPath, "Obligatoriedad campo Descripción de Perfil",Evidencia);
		click(txtNombrePerfil);

		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			time(1);
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados",Evidencia);
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
		return this;
	}

	//paso a paso de validacion de un maximo de caracteres en 2 campos
	@Step("Campos con 50 y 100 Caracteres")
	public PerfilesPage caracteres50100(File folderPath, String nombre, String descripcion, String nom50, String desc100,String Evidencia) throws Exception {
		
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
		writeText(txtNombrePerfil, nombre, folderPath, "Se ingresa el dato Nombre con 50 Caracteres",Evidencia);
		writeText(txtDescripcionPerfil, descripcion, folderPath, "Se ingresa el dato Descripción de Perfil con 100 Caracteres",Evidencia);
		return this;
	}

	@Step("Crear perfil")
	public PerfilesPage crearPerfil(File folderPath, String nombre, String descripcion,String Evidencia)
			throws Exception {

		//Se envia a una variable de tipo string la fecha actual en formato de horas minutos y segundos
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		String nombreR = nombre + timeStamp;

		printConsole("Nombre Rol: " + nombreR);
		etiquetas(btnCrearPerfil, folderPath, "Etiqueta Crear rol",Evidencia);
		click(btnCrearPerfil, folderPath, "Se ingresa a crear Rol",Evidencia);
		writeText(txtNombrePerfil, nombreR, folderPath, "Se ingresa el dato Nombre Rol",Evidencia);
		writeText(txtDescripcionPerfil, descripcion, folderPath, "Se ingresa el dato Descripción de Rol",Evidencia);
		click(lblAgregarRol, folderPath, "Se ingresa a agregar Rol",Evidencia);

		// ROL - Se agregar un ciclo para 3 roles
		cicloAgregarRol(folderPath,Evidencia);
		return this;
	}

	//Ciclo de agregar un rol a un perfil
	@Step("Ciclo elegir rol Perfil")
	public PerfilesPage cicloAgregarRol(File folderPath,String Evidencia) throws Exception {

		for (int i = 0; i <= 2; i++) {
			listRandom(lblRol, folderPath, "Se toma un Rol aleatorio",Evidencia);
			waitInMs(500);
			click(btnAgregarRol, folderPath, "Se agrega de la lista el Rol",Evidencia);
			waitInMs(500);
		}
		return this;
	}

	//cancelar registro de perfil
	@Step("Cancelar registro Perfil")
	public PerfilesPage cancelarPerfil(File folderPath,String Evidencia) throws Exception {

		click(btnCancelarPerfil, folderPath, "Se cancela el registro de Perfil",Evidencia);
		return this;
	}

	@Step("Guardar registro Perfil")
	public PerfilesPage guardarPerfil(File folderPath,String Evidencia) throws Exception {

		click(btnGuardarPerfil, folderPath, "Se guarda el registro de Perfil",Evidencia);
		return this;
	}

	@Step("Aceptar registro Perfil")
	public PerfilesPage aceptarPerfil(File folderPath,String Evidencia) throws Exception {

		click(btnAceptarRegistro, folderPath, "Se acepta el registro de Perfil",Evidencia);

		val = validarElemento(registroExitoso, t);

		if (Boolean.TRUE.equals(val)) {
			// El registro se ha guardado
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, el registro no se creo correctamente",Evidencia);
			Assert.fail("Error en la validación, el registro no se creo correctamente");
		}
		return this;
	}

	//Modificacion de perfil 
	@Step("Modificar perfil")
	public PerfilesPage modificarPerfil(File folderPath, String descripcion, String estado,String Evidencia)
			throws Exception {

		//paso a paso de modificar perfil 
		scrollElementH(folderPath, btnModificarPerfil, "Se desplaza hasta la opción Modificar perfil",Evidencia);
		etiquetas(btnModificarPerfil, folderPath, "Etiqueta Crear perfil",Evidencia);
		click(btnModificarPerfil, folderPath, "Se ingresa a crear Perfil",Evidencia);
		isEnabled(txtNombrePerfil, folderPath, "Campo Nombre Perfil No editable",Evidencia);
		clear(txtDescripcionPerfil, folderPath, "Limpia el campo especificado",Evidencia);
		writeText(txtDescripcionPerfil, descripcion, folderPath, "Se ingresa el dato Descripción de Rol",Evidencia);
		selectElementList(lblEstado, estado, folderPath, "Se selecciona el Estado",Evidencia);
		click(lblAgregarRol, folderPath, "Se ingresa a agregar Rol",Evidencia);
		
		for (int i = 0; i <= 2; i++) {
			click(btnQuitarRol, folderPath, "Se elimina rol: " + (i + 1),Evidencia);
			waitInMs(500);
		}

		// ROL - Se agregar un ciclo para 3 roles
		cicloAgregarRol(folderPath,Evidencia);
		return this;
	}
	
	//Ver perfil
	@Step("Ver perfil")
	public PerfilesPage verPerfil(File folderPath,String Evidencia) throws Exception {
		
		//Se valida la visualizacion de perfil 
		scrollElementH(folderPath, btnVerPerfil, "Se desplaza hasta la opción Ver perfil",Evidencia);
		etiquetas(btnVerPerfil, folderPath, "Etiqueta Ver perfil",Evidencia);
		click(btnVerPerfil, folderPath, "Se ingresa a ver perfil",Evidencia);
		
		//Se valida que los campos esten enabled 
		isEnabled(txtNombrePerfil, folderPath, "Campo Nombre Perfil No editable",Evidencia);
		isEnabled(txtDescripcionPerfil, folderPath, "Campo Descripción de Perfil No editable",Evidencia);
		isEnabled(lblEstado, folderPath, "Campo Estado No editable",Evidencia);
		return this;
	}
	
	
	
	
	//Ver perfil
		@Step("Ver perfil")
		public PerfilesPage verPerfil_554763(File folderPath,String Evidencia) throws Exception {
			
			//Se valida la visualizacion de perfil 
			scrollElementH(folderPath, btnVerPerfil, "Se desplaza hasta la opción Ver perfil",Evidencia);
			etiquetas(btnVerPerfil, folderPath, "Etiqueta Ver perfil",Evidencia);
			click(btnVerPerfil, folderPath, "Se ingresa a ver perfil",Evidencia);
			
			//Se valida que los campos esten enabled 
			isEnabled(txtNombrePerfil, folderPath, "Campo Nombre Perfil No editable,Caso exitoso 554748,554749,554750,554751",Evidencia);
			isEnabled(txtDescripcionPerfil, folderPath, "Campo Descripción de Perfil No editable",Evidencia);
			isEnabled(lblEstado, folderPath, "Campo Estado No editable",Evidencia);
			return this;
		}
	
	
	@Step("Botones consultar perfil")
	public PerfilesPage botonesPerfil(File folderPath,String Evidencia) throws Exception {

		x = new Object[2];
		x[0] = btnBuscar;
		x[1] = btnVerTodos;

		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			click(btnVerTodos, folderPath, "Se selecciona la opción Ver Todos",Evidencia);
			waitInMs(3000);
			if (lblNombrePerfilTabla == null) {
				GenerarReportePdf.closeTemplate("No se trajo la información correctamente",Evidencia);
				Assert.fail("No se trajo la información correctamente");
			} else {
				printConsole("Se trajo la información correctamente");
			}
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados",Evidencia);
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
		return this;
	}

	//Consulta de perfil 
	@Step("Consultar perfil")
	public PerfilesPage consultaPerfil(File folderPath, String nom50, String nombrePerfil,String Evidencia) throws Exception {

		//Se envia a una variable string un valor random y se digita
		String nombre = RandomStringUtils.randomAlphabetic(50).toLowerCase();
		String nom = driver.findElement(By.xpath("//input[contains(@formcontrolname,'terminoBusqueda')]")).getAttribute("maxlength");

		//Se valida si contiene un maximo de 50 caracteres y se escribe 
		if (nom.contains(nom50)) {
			printConsole("Los campos contienen el maximo de 50 caracteres");
			writeText(consultarPerfil, nombre, folderPath, "Se ingresa texto de 50 caracteres",Evidencia);
			clear(consultarPerfil, folderPath, "Se eliminar texto antes digitado",Evidencia);
			writeText(consultarPerfil, nombrePerfil, folderPath, "Se ingresa nombre de usuario",Evidencia);
			click(btnBuscar, folderPath, "Se busca el usuario digitado",Evidencia);
		} else {
			printConsole("Error en la validación, los campos no contienen el maximo de 50 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 50 caracteres");
		}
		return this;
	}
}