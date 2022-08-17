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

	//INSTANCIA DEL NAVEGADOR
	public RolesPage(WebDriver driver) {
		super(driver);
	}
	
	//PASO A PASO DE VALIDACION DE CAMPOS DE ROLES
	@Step("Obligatoriedad de campos")
	public RolesPage obligatoriedadCampos(File folderPath) throws Exception {
		
		x = new Object[2];
		x[0] = lblNombreRolObligatorio;
		x[1] = lblDescripcionRolObligatorio;
		
		//SE CREA UN ROL CON UN ESTADO
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
	
	//PASO A PASO DE VALIDACIONES DE CAMPOS DE HASTA 100 CARACTERES 
	@Step("Campos con 100 Caracteres")
	public RolesPage caracteres100(File folderPath, String nombre, String descripcion, String nom100, String desc100) throws Exception {

		//SE ENVIA A VARIABLES TIPO STRING EL TAMAÑO MAXIMO DE 2 LOCALIZADORES DE CAMPO
		String nom = driver.findElement(By.xpath("//input[contains(@formcontrolname,'roleNombre')]")).getAttribute("maxlength");
		String desc = driver.findElement(By.xpath("//textarea[contains(@formcontrolname,'descripcion')]")).getAttribute("maxlength");
		
		//SE VALIDAN CONTRA DOS PROPERTIES QUE TIENEN EL NUMERO 100 POR TANTO SI EL MAXLENGTH ES MAYOR A 100 LA VALIDACION FALLARA
		if (nom.contains(nom100) && desc.contains(desc100)) {
			printConsole("Los campos contienen el maximo de 100 caracteres");
		}
		else {
			printConsole("Error en la validación, los campos no contienen el maximo de 100 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 100 caracteres");
		}
		
		//SE ESCRIBE UN ROL Y UNA DESCRIPCION
		writeText(txtNombreRol, nombre, folderPath, "Se ingresa el dato Nombre con 100 Caracteres");
		writeText(txtDescripcionRol, descripcion, folderPath, "Se ingresa el dato Descripción de Rol con 100 Caracteres");
		return this;
	}
	
	//PASO A PASO DE CREAR UN ROL
	@Step("Crear rol")
	public RolesPage crearRol(File folderPath, String nombre, String descripcion, String estado, String permiso) throws Exception {
		
		// SE CREA VARIABLE TIPO STRING DE LA FECHA ACTUAL EN FORMATO DE HORA/SEGUNDO
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		String nombreR = nombre + timeStamp;

		//SE DIGITAN LOS CAMPOS DE ROL Y SE LE ASIGNA UN ESTADO
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
	
	//CANCELA REGISTRO ROL
	@Step("Cancelar registro Rol")
	public RolesPage cancelarRol(File folderPath) throws Exception {

		click(btnCancelarRol, folderPath, "Se cancela el registro de Rol");
		return this;
	}
	
	//GUARDA REGISTRO ROL
	@Step("Guardar registro Rol")
	public RolesPage guardarRol(File folderPath) throws Exception {

		click(btnGuardarRol, folderPath, "Se guarda el registro de Rol");
		return this;
	}
	
	//ACEPTA REGISTRO ROL
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
	
	//PASO A PASO DE MODIFICAR UN ROL
	@Step("Modificar Rol")
	public RolesPage modificarRol(File folderPath, String descripcion, String estado) throws Exception {

		//SE INGRESA A MODIFICAR ROL SE CAMBIAN LOS REGISTROS Y SE GUARDA 
		scrollElementH(folderPath, btnModificarRol, "Se desplaza hasta la opción Modificar rol");
		etiquetas(btnModificarRol, folderPath, "Etiqueta Modificar rol");
		click(btnModificarRol, folderPath, "Se ingresa a modificar Rol");
		//SE VERIFICA QUE EL CAMPO NOMBRE DE ROL ESTE ENABLED O HABILITADO
		isEnabled(txtNombreRol, folderPath, "Campo Nombre Rol No editable");
		clear(txtDescripcionRol, folderPath, "Se borra el dato anterior de Descripción de Rol");
		writeText(txtDescripcionRol, descripcion, folderPath, "Se ingresa el dato Descripción de Rol");
		selectElementList(lblEstado, estado, folderPath, "Se selecciona el Estado");
		click(btnGuardarRolEditado, folderPath, "Se guarda el registro de Rol");
		return this;
	}
	
	//PASO A PASO PARA VISUALIZAR UN ROL
	@Step("Ver rol")
	public RolesPage verRol(File folderPath) throws Exception {
		
		//SE DA CLICK EN VISUALIZAR ROL
		scrollElementH(folderPath, btnVerRol, "Se desplaza hasta la opción Ver rol");
		etiquetas(btnVerRol, folderPath, "Etiqueta Ver rol");
		click(btnVerRol, folderPath, "Se ingresa a ver rol");
		
		//SE UTILIZA ISENABLED PARA VERIFICAR QUE LOS CAMPOS ESTEN HABILITADOS,EL METODO ISENABLED RETORNA UN ENABLED 
		isEnabled(txtNombreRol, folderPath, "Campo Nombre Rol No editable");
		isEnabled(txtDescripcionRol, folderPath, "Campo Descripción de Rol No editable");
		isEnabled(lblEstado, folderPath, "Campo Estado No editable");
		return this;
	}
	
	//BOTON DE CONSULTAR TOL
	@Step("Botones consultar rol")
	public RolesPage botonesRol(File folderPath) throws Exception {

		x = new Object[2];
		x[0] = btnBuscar;
		x[1] = btnVerTodos;

		val = validarElementos(x, t);

		//CLICK EN BOTON DE VER TODOS JUNTO A UNA VALIDACION, SI TRAE LA INFORMACION CORRECTA IMPRIMIRA UN MENSAJE
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

	//PASO A PASO DE CONSULTAR UN ROL
	@Step("Consultar rol")
	public RolesPage consultaRol(File folderPath, String nom50, String nombreRol) throws Exception {

		//SE BUSCA UN VALOR ALFABETICO RANDOM
		String nombre = RandomStringUtils.randomAlphabetic(50).toLowerCase();
		String nom = driver.findElement(By.xpath("//input[contains(@formcontrolname,'terminoBusqueda')]")).getAttribute("maxlength");
		//SE CONSULTA UN ROL DEL VALOR RANDOM CREADO
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