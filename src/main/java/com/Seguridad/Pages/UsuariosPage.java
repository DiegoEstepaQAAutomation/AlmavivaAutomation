package com.Seguridad.Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Seguridad.Maps.UsuariosMap;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class UsuariosPage extends UsuariosMap {

	Object[] x;
	boolean val;
	int t = 15;

	//INSTANCIA DE DRIVER
	public UsuariosPage(WebDriver driver) {
		super(driver);
	}
	
	//PASO A PASO PARA VERIFICAR OBLIGATORIEDAD DE CAMPOS
	@Step("Obligatoriedad de campos")
	public UsuariosPage obligatoriedadCampos(File folderPath) throws Exception {

		x = new Object[7];
		x[0] = lblUsuarioDominioObligatorio;
		x[1] = lblNombresObligatorio;
		x[2] = lblApellidosObligatorio;
		x[3] = lblCargoObligatorio;
		x[4] = lblOficinaObligatorio;
		x[5] = lblEmailUsuarioObligatorio;
		x[6] = lblPerfilObligatorio;

		//SE VERIFICA LA OBLIGATORIEDAD DE TODOS LOS CAMPOS DE USUARIO
		click(btnCrearUsuario, folderPath, "Se ingresa a crear Usuario");
		click(txtUsuarioDominio, folderPath, "Obligatoriedad campo Usuario dominio");
		click(txtNombres, folderPath, "Obligatoriedad campo Nombres");
		click(txtApellidos, folderPath, "Obligatoriedad campo Apellidos");
		click(txtCargo, folderPath, "Obligatoriedad campo Cargo");
		click(lblOficina, folderPath, "Obligatoriedad campo Oficina");
		click(txtEmailUsuario, folderPath, "Obligatoriedad campo Usuario dominio");
		click(lblPerfil, folderPath, "Obligatoriedad campo Perfil");
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

	//CAMPOS CON 50 CARACTERES EN EL SUBMODULO DE USUARIO
	@Step("Campos con 50 Caracteres")
	public UsuariosPage caracteres50(File folderPath, String nombres, String apellidos, String cargo, String email,
			String nom50, String apell50, String car50, String mail50) throws Exception {

		//SE TOMA EL ATRIBUTO DE TAMAÑO MAXIMO DE TEXTO
		String nom = driver.findElement(By.xpath("//input[contains(@formcontrolname,'usuaNombres')]")).getAttribute("maxlength");
		String apell = driver.findElement(By.xpath("//input[contains(@formcontrolname,'usuaApellidos')]")).getAttribute("maxlength");
		String car = driver.findElement(By.xpath("//input[contains(@formcontrolname,'usuaCargo')]")).getAttribute("maxlength");
		String mail = driver.findElement(By.xpath("//input[contains(@formcontrolname,'usuaCorreo')]")).getAttribute("maxlength");

		//SE VALIDA CONTRA LAS PROPERTIES RESPECTIVAS
		if (nom.equals(nom50) && apell.equals(apell50) && car.equals(car50) && mail.equals(mail50)) {
			printConsole("Los campos contienen el maximo de 50 caracteres");
		} else {
			printConsole("Error en la validación, los campos no contienen el maximo de 50 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 50 caracteres");
		}

		//SE CREAN DOS VARIABLES RANDOM PARA EL CAMPO CORREO
		String emailUsuario = RandomStringUtils.randomAlphabetic(13).toLowerCase();
		String emailUs = RandomStringUtils.randomNumeric(13);
		//SE GUARDAN LOS VALORES NUMBERICO Y ALFABETICO EN UNA SOLA VARIABLE CONCATENADA
		String emailU = emailUsuario + emailUs + email;

		//SE ESCRIBE FINALMENTE LA VARIABLE CONCATENADA EN EMAIL USUARIO
		printConsole("Email de Usuario: " + emailU);
		scrollElementV(folderPath, txtNombres, "Se desplaza hasta la opción Nombres");
		writeText(txtNombres, nombres, folderPath, "Se ingresa el dato Nombres con 50 Caracteres");
		scrollElementV(folderPath, txtCargo, "Se desplaza hasta la opción Cargo");
		writeText(txtApellidos, apellidos, folderPath, "Se ingresa el dato Apellidos con 50 Caracteres");
		writeText(txtCargo, cargo, folderPath, "Se ingresa el dato Cargo con 50 Caracteres");
		writeText(txtEmailUsuario, emailU, folderPath, "Se ingresa el dato Email de usuario con 50 Caracteres");
		return this;
	}

	@Step("Crear usuario")
	public UsuariosPage crearUsuario(File folderPath, String usuarioDominio, String nombres, String apellidos,
			String cargo, String oficina, String email, String perfil, String estado, String busqueda, String codigo)
			throws Exception {

		//GUARDAR EN UNA VARIABLE STRING LA FECHA ACTUAL EN FORMATO HORA
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		String usuarioD = usuarioDominio + timeStamp;
		//EXPLICACION EN METODO CARACTERES50, DOS VARIABLES ALFABETICA Y NUMERICA
		String emailUsuario = RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String emailUs = RandomStringUtils.randomNumeric(4);
		String emailU = emailUsuario + emailUs + email;

		//FORMULARIO PARA CREAR USUARIO CON VARIABLE CONCATENADA AL FINAL EN EMAIL USUARIO
		printConsole("Usuario dominio: " + usuarioD + " Email de Usuario: " + emailU);
		etiquetas(btnCrearUsuario, folderPath, "Etiqueta Crear usuario");
		click(btnCrearUsuario, folderPath, "Se ingresa a crear Usuario");
		writeText(txtUsuarioDominio, usuarioD, folderPath, "Se ingresa el dato Usuario dominio");
		writeText(txtNombres, nombres, folderPath, "Se ingresa el dato Nombres");
		writeText(txtApellidos, apellidos, folderPath, "Se ingresa el dato Apellidos");
		writeText(txtCargo, cargo, folderPath, "Se ingresa el dato Cargo");
		scrollElementV(folderPath, lblOficina, "Se desplaza hasta la opción Oficina");
		selectElementList(lblOficina, oficina, folderPath, "Se selecciona la Oficina");
		writeText(txtEmailUsuario, emailU, folderPath, "Se ingresa el dato Email de usuario");
		selectElementList(lblPerfil, perfil, folderPath, "Se selecciona el Perfil");
		scrollElementV(folderPath, lblEstado, "Se desplaza hasta la opción Estado");
		selectElementList(lblEstado, estado, folderPath, "Se selecciona el Estado");

		// ASIGNAR OFICINA
		click(lblAsignarOficinas, folderPath, "Se despliega la opción Asignar Oficinas");
		click(btnCrearOficina, folderPath, "Se ingresa a crear Oficinas");
		selectElementList(lblOpcionBusqueda, busqueda, folderPath, "Se selecciona Busqueda");
		writeText(txtCodigoOficina, codigo, folderPath, "Se ingresa el dato Código Oficina");
		click(btnBuscarOficina, folderPath, "Se ingresa a Buscar Oficina");
		click(cbxAccion, folderPath, "Se selecciona el check");
		click(btnBuscarTodosOficina, folderPath, "Se ingresa a Buscar todas las Oficinas");
		cicloAgregarOficina(folderPath);
		click(btnAgregarOficina, folderPath, "Se selecciona Agregar");
		return this;
	}

	//CICLO PARA ELEGIR OFICINA DE USUARIO
	@Step("Ciclo elegir oficina Usuario")
	public UsuariosPage cicloAgregarOficina(File folderPath) throws Exception {

		for (int i = 1; i <= 3; i++) {
			click(By.xpath("//body/modal-container/div/div/app-lista-oficinas/div/div[2]/table/tbody/tr[" + i
					+ "]/td[3]/div/input"), folderPath, "Se agrega oficina: " + i);
			waitInMs(1000);
		}
		return this;
	}

	//GUARDAR USUARIO
	@Step("Guardar registro Usuario")
	public UsuariosPage guardarUsuario(File folderPath) throws Exception {

		click(btnGuardarUsuario, folderPath, "Se guarda el registro de Usuario");
		return this;
	}

	//CANCELAR REGISTRO DE USUARIO
	@Step("Cancelar registro Usuario")
	public UsuariosPage cancelarUsuario(File folderPath) throws Exception {

		click(btnCancelarUsuario, folderPath, "Se cancela el registro de Usuario");
		return this;
	}

	//ACEPTAR USUARIO
	@Step("Aceptar registro Usuario")
	public UsuariosPage aceptarUsuario(File folderPath) throws Exception {

		click(btnAceptarRegistro, folderPath, "Se acepta el registro de Usuario");

		val = validarElemento(registroExitoso, t);

		if (Boolean.TRUE.equals(val)) {
		} else {
			GenerarReportePdf.closeTemplate("Error en la validaci�n, el registro no se creo correctamente");
			Assert.fail("Error en la validaci�n, el registro no se creo correctamente");
		}
		return this;
	}

	//MODIFICAR USUARIO PASO A PASO
	@Step("Modificar usuario")
	public UsuariosPage modificarUsuario(File folderPath, String nombres, String apellidos, String cargo,
			String oficina, String email, String perfil, String estado, String busqueda, String codigo)
			throws Exception {

		//MIRAR LA EXPLICACION DE VARIABLES DEL METODO CARACTERES50
		String emailUsuario = RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String emailUs = RandomStringUtils.randomNumeric(4);
		String emailU = emailUsuario + emailUs + email;

		//FORMULARIO DE MODIFICAR USUARIO
		printConsole("Email de Usuario: " + emailU);
		scrollElementH(folderPath, btnModificarUsuario, "Se desplaza hasta la opción Modificar usuario");
		etiquetas(btnModificarUsuario, folderPath, "Etiqueta Modificar usuario");
		click(btnModificarUsuario, folderPath, "Se ingresa a modificar Usuario");
		clear(txtNombres, folderPath, "Se borra el dato anterior de Nombres");
		clear(txtApellidos, folderPath, "Se borra el dato anterior de Apellidos");
		clear(txtCargo, folderPath, "Se borra el dato anterior de Cargo");
		clear(txtEmailUsuario, folderPath, "Se borra el dato anterior de Email de usuario");
		writeText(txtNombres, nombres, folderPath, "Se ingresa el dato Nombres");
		writeText(txtApellidos, apellidos, folderPath, "Se ingresa el dato Apellidos");
		writeText(txtCargo, cargo, folderPath, "Se ingresa el dato Cargo");
		scrollElementV(folderPath, lblOficina, "Se desplaza hasta la opción Oficina");
		selectElementList(lblOficina, oficina, folderPath, "Se selecciona la Oficina");
		writeText(txtEmailUsuario, emailU, folderPath, "Se ingresa el dato Email de usuario");
		selectElementList(lblPerfil, perfil, folderPath, "Se selecciona el Perfil");
		scrollElementV(folderPath, lblEstado, "Se desplaza hasta la opción Estado");
		selectElementList(lblEstado, estado, folderPath, "Se selecciona el Estado");

		// ASIGNAR OFICINA
		click(lblAsignarOficinas, folderPath, "Se despliega la opción Asignar Oficinas");

		for (int i = 0; i <= 3; i++) {
			click(btnQuitarOficina, folderPath, "Se elimina oficina: " + (i + 1));
		}

		//CREAR OFICINA FORMULARIO COMPLETO
		waitInMs(2000);
		click(btnCrearOficina, folderPath, "Se ingresa a crear Oficinas");
		selectElementList(lblOpcionBusqueda, busqueda, folderPath, "Se selecciona Busqueda");
		writeText(txtCodigoOficina, codigo, folderPath, "Se ingresa el dato Código Oficina");
		click(btnBuscarOficina, folderPath, "Se ingresa a Buscar Oficina");
		click(cbxAccion, folderPath, "Se selecciona el check");
		click(btnBuscarTodosOficina, folderPath, "Se ingresa a Buscar todas las Oficinas");
		cicloAgregarOficina(folderPath);
		click(btnAgregarOficina, folderPath, "Se selecciona Agregar");
		return this;
	}

	@Step("Ver usuario")
	public UsuariosPage verUsuario(File folderPath) throws Exception {

		//VER USUARIO
		scrollElementH(folderPath, btnVerUsuario, "Se desplaza hasta la opción Ver usuario");
		etiquetas(btnVerUsuario, folderPath, "Etiqueta Ver usuario");
		click(btnVerUsuario, folderPath, "Se ingresa a ver Usuario");

		//VALIDACIONES DE ENABLED EN LA OPCION VER USUARIO
		isEnabled(txtUsuarioDominio, folderPath, "Campo Usuario Dominio No editable");
		isEnabled(txtNombres, folderPath, "Campo Nombres No editable");
		isEnabled(txtApellidos, folderPath, "Campo Apellidos No editable");
		isEnabled(txtCargo, folderPath, "Campo Cargo No editable");
		isEnabled(lblOficina, folderPath, "Campo Oficina No editable");
		isEnabled(txtEmailUsuario, folderPath, "Campo Email Usuario No editable");
		isEnabled(lblPerfil, folderPath, "Campo Perfil No editable");
		isEnabled(lblEstado, folderPath, "Campo Estado No editable");
		return this;
	}

	//CONSULTAR UN USUARIO EN ESPECIFICO
	@Step("Botones consultar usuario")
	public UsuariosPage botonesUsuario(File folderPath) throws Exception {

		x = new Object[3];
		x[0] = btnBuscar;
		x[1] = btnVerTodos;
		x[2] = btnDescargar;

		val = validarElementos(x, t);

		//VER USUARIO
		if (Boolean.TRUE.equals(val)) {
			click(btnVerTodos, folderPath, "Se selecciona la opción Ver Todos");
			waitInMs(3000);
			if (lblUsuarioTabla == null) {
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

	//CONSULTAR UN USUARIO EN ESPECIFICO
	@Step("Consultar usuario")
	public UsuariosPage consultaUsuario(File folderPath, String nom50, String nombres) throws Exception {

		//FORMULARIO DE CONSULTA DE UN USUARIO EN ESPECIFIO
		String nombre = RandomStringUtils.randomAlphabetic(50).toLowerCase();
		String nom = driver.findElement(By.xpath("//input[contains(@formcontrolname,'nombre')]")).getAttribute("maxlength");

		if (nom.contains(nom50)) {
			printConsole("Los campos contienen el maximo de 50 caracteres");
			writeText(consultarUsuario, nombre, folderPath, "Se ingresa texto de 50 caracteres");
			clear(consultarUsuario, folderPath, "Se eliminar texto antes digitado");
			writeText(consultarUsuario, nombres, folderPath, "Se ingresa nombre de usuario");
			click(btnBuscar, folderPath, "Se busca el usuario digitado");
		} else {
			printConsole("Error en la validación, los campos no contienen el maximo de 50 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 50 caracteres");
		}
		return this;
	}
}