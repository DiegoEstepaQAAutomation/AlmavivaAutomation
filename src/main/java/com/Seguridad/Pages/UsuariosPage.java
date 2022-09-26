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
	public UsuariosPage obligatoriedadCampos(File folderPath,String Evidencia) throws Exception {

		x = new Object[7];
		x[0] = lblUsuarioDominioObligatorio;
		x[1] = lblNombresObligatorio;
		x[2] = lblApellidosObligatorio;
		x[3] = lblCargoObligatorio;
		x[4] = lblOficinaObligatorio;
		x[5] = lblEmailUsuarioObligatorio;
		x[6] = lblPerfilObligatorio;

		//SE VERIFICA LA OBLIGATORIEDAD DE TODOS LOS CAMPOS DE USUARIO
		click(btnCrearUsuario, folderPath, "Se ingresa a crear Usuario",Evidencia);
		click(txtUsuarioDominio, folderPath, "Obligatoriedad campo Usuario dominio",Evidencia);
		click(txtNombres, folderPath, "Obligatoriedad campo Nombres",Evidencia);
		click(txtApellidos, folderPath, "Obligatoriedad campo Apellidos",Evidencia);
		click(txtCargo, folderPath, "Obligatoriedad campo Cargo",Evidencia);
		click(lblOficina, folderPath, "Obligatoriedad campo Oficina",Evidencia);
		click(txtEmailUsuario, folderPath, "Obligatoriedad campo Usuario dominio",Evidencia);
		click(lblPerfil, folderPath, "Obligatoriedad campo Perfil",Evidencia);
		click(lblEstado, folderPath, "Obligatoriedad campo Estado",Evidencia);

		val = validarElementos(x, t);

		if (Boolean.TRUE.equals(val)) {
			time(1);
		} else {
			GenerarReportePdf.closeTemplate("Error en la validación, alguno de los elementos no fueron encontrados",Evidencia);
			Assert.fail("Error en la validación, alguno de los elementos no fueron encontrados");
		}
		return this;
	}

	//CAMPOS CON 50 CARACTERES EN EL SUBMODULO DE USUARIO
	@Step("Campos con 50 Caracteres")
	public UsuariosPage caracteres50(File folderPath, String nombres, String apellidos, String cargo, String email,
			String nom50, String apell50, String car50, String mail50,String Evidencia) throws Exception {

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
		scrollElementV(folderPath, txtNombres, "Se desplaza hasta la opción Nombres",Evidencia);
		writeText(txtNombres, nombres, folderPath, "Se ingresa el dato Nombres con 50 Caracteres",Evidencia);
		scrollElementV(folderPath, txtCargo, "Se desplaza hasta la opción Cargo",Evidencia);
		writeText(txtApellidos, apellidos, folderPath, "Se ingresa el dato Apellidos con 50 Caracteres",Evidencia);
		writeText(txtCargo, cargo, folderPath, "Se ingresa el dato Cargo con 50 Caracteres",Evidencia);
		writeText(txtEmailUsuario, emailU, folderPath, "Se ingresa el dato Email de usuario con 50 Caracteres",Evidencia);
		return this;
	}

	@Step("Crear usuario")
	public UsuariosPage crearUsuario(File folderPath, String usuarioDominio, String nombres, String apellidos,
			String cargo, String oficina, String email, String perfil, String estado, String busqueda, String codigo,String Evidencia)
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
		etiquetas(btnCrearUsuario, folderPath, "Etiqueta Crear usuario",Evidencia);
		click(btnCrearUsuario, folderPath, "Se ingresa a crear Usuario",Evidencia);
		writeText(txtUsuarioDominio, usuarioD, folderPath, "Se ingresa el dato Usuario dominio",Evidencia);
		writeText(txtNombres, nombres, folderPath, "Se ingresa el dato Nombres",Evidencia);
		writeText(txtApellidos, apellidos, folderPath, "Se ingresa el dato Apellidos",Evidencia);
		writeText(txtCargo, cargo, folderPath, "Se ingresa el dato Cargo",Evidencia);
		scrollElementV(folderPath, lblOficina, "Se desplaza hasta la opción Oficina",Evidencia);
		selectElementList(lblOficina, oficina, folderPath, "Se selecciona la Oficina",Evidencia);
		writeText(txtEmailUsuario, emailU, folderPath, "Se ingresa el dato Email de usuario",Evidencia);
		selectElementList(lblPerfil, perfil, folderPath, "Se selecciona el Perfil",Evidencia);
		scrollElementV(folderPath, lblEstado, "Se desplaza hasta la opción Estado",Evidencia);
		selectElementList(lblEstado, estado, folderPath, "Se selecciona el Estado",Evidencia);

		// ASIGNAR OFICINA
		click(lblAsignarOficinas, folderPath, "Se despliega la opción Asignar Oficinas",Evidencia);
		click(btnCrearOficina, folderPath, "Se ingresa a crear Oficinas",Evidencia);
		selectElementList(lblOpcionBusqueda, busqueda, folderPath, "Se selecciona Busqueda",Evidencia);
		writeText(txtCodigoOficina, codigo, folderPath, "Se ingresa el dato Código Oficina",Evidencia);
		click(btnBuscarOficina, folderPath, "Se ingresa a Buscar Oficina",Evidencia);
		click(cbxAccion, folderPath, "Se selecciona el check",Evidencia);
		click(btnBuscarTodosOficina, folderPath, "Se ingresa a Buscar todas las Oficinas",Evidencia);
		cicloAgregarOficina(folderPath,Evidencia);
		click(btnAgregarOficina, folderPath, "Se selecciona Agregar",Evidencia);
		return this;
	}

	//CICLO PARA ELEGIR OFICINA DE USUARIO
	@Step("Ciclo elegir oficina Usuario")
	public UsuariosPage cicloAgregarOficina(File folderPath,String Evidencia) throws Exception {

		//Ciclo que agrega la oficina deacuerdo a un xpath diferente para lo que cada ciclo mueve una casilla del xpath
		for (int i = 1; i <= 3; i++) {
			click(By.xpath("//body/modal-container/div/div/app-lista-oficinas/div/div[2]/table/tbody/tr[" + i
					+ "]/td[3]/div/input"), folderPath, "Se agrega oficina: " + i,Evidencia);
			waitInMs(1000);
		}
		return this;
	}

	//GUARDAR USUARIO
	@Step("Guardar registro Usuario")
	public UsuariosPage guardarUsuario(File folderPath,String Evidencia) throws Exception {

		click(btnGuardarUsuario, folderPath, "Se guarda el registro de Usuario",Evidencia);
		return this;
	}

	//CANCELAR REGISTRO DE USUARIO
	@Step("Cancelar registro Usuario")
	public UsuariosPage cancelarUsuario(File folderPath,String Evidencia) throws Exception {

		click(btnCancelarUsuario, folderPath, "Se cancela el registro de Usuario",Evidencia);
		return this;
	}

	//ACEPTAR USUARIO
	@Step("Aceptar registro Usuario")
	public UsuariosPage aceptarUsuario(File folderPath,String Evidencia) throws Exception {

		click(btnAceptarRegistro, folderPath, "Se acepta el registro de Usuario",Evidencia);

		val = validarElemento(registroExitoso, t);

		if (Boolean.TRUE.equals(val)) {
		} else {
			GenerarReportePdf.closeTemplate("Error en la validaci�n, el registro no se creo correctamente",Evidencia);
			Assert.fail("Error en la validaci�n, el registro no se creo correctamente");
		}
		return this;
	}

	//MODIFICAR USUARIO PASO A PASO
	@Step("Modificar usuario")
	public UsuariosPage modificarUsuario(File folderPath, String nombres, String apellidos, String cargo,
			String oficina, String email, String perfil, String estado, String busqueda, String codigo,String Evidencia)
			throws Exception {

		//MIRAR LA EXPLICACION DE VARIABLES DEL METODO CARACTERES50
		String emailUsuario = RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String emailUs = RandomStringUtils.randomNumeric(4);
		String emailU = emailUsuario + emailUs + email;

		//FORMULARIO DE MODIFICAR USUARIO
		printConsole("Email de Usuario: " + emailU);
		scrollElementH(folderPath, btnModificarUsuario, "Se desplaza hasta la opción Modificar usuario",Evidencia);
		etiquetas(btnModificarUsuario, folderPath, "Etiqueta Modificar usuario",Evidencia);
		click(btnModificarUsuario, folderPath, "Se ingresa a modificar Usuario",Evidencia);
		clear(txtNombres, folderPath, "Se borra el dato anterior de Nombres",Evidencia);
		clear(txtApellidos, folderPath, "Se borra el dato anterior de Apellidos",Evidencia);
		clear(txtCargo, folderPath, "Se borra el dato anterior de Cargo",Evidencia);
		clear(txtEmailUsuario, folderPath, "Se borra el dato anterior de Email de usuario",Evidencia);
		writeText(txtNombres, nombres, folderPath, "Se ingresa el dato Nombres",Evidencia);
		writeText(txtApellidos, apellidos, folderPath, "Se ingresa el dato Apellidos",Evidencia);
		writeText(txtCargo, cargo, folderPath, "Se ingresa el dato Cargo",Evidencia);
		scrollElementV(folderPath, lblOficina, "Se desplaza hasta la opción Oficina",Evidencia);
		selectElementList(lblOficina, oficina, folderPath, "Se selecciona la Oficina",Evidencia);
		writeText(txtEmailUsuario, emailU, folderPath, "Se ingresa el dato Email de usuario",Evidencia);
		selectElementList(lblPerfil, perfil, folderPath, "Se selecciona el Perfil",Evidencia);
		scrollElementV(folderPath, lblEstado, "Se desplaza hasta la opción Estado",Evidencia);
		selectElementList(lblEstado, estado, folderPath, "Se selecciona el Estado",Evidencia);

		// ASIGNAR OFICINA
		click(lblAsignarOficinas, folderPath, "Se despliega la opción Asignar Oficinas",Evidencia);

		for (int i = 0; i <= 3; i++) {
			click(btnQuitarOficina, folderPath, "Se elimina oficina: " + (i + 1),Evidencia);
		}

		//CREAR OFICINA FORMULARIO COMPLETO
		waitInMs(2000);
		click(btnCrearOficina, folderPath, "Se ingresa a crear Oficinas",Evidencia);
		selectElementList(lblOpcionBusqueda, busqueda, folderPath, "Se selecciona Busqueda",Evidencia);
		writeText(txtCodigoOficina, codigo, folderPath, "Se ingresa el dato Código Oficina",Evidencia);
		click(btnBuscarOficina, folderPath, "Se ingresa a Buscar Oficina",Evidencia);
		click(cbxAccion, folderPath, "Se selecciona el check",Evidencia);
		click(btnBuscarTodosOficina, folderPath, "Se ingresa a Buscar todas las Oficinas",Evidencia);
		cicloAgregarOficina(folderPath,Evidencia);
		click(btnAgregarOficina, folderPath, "Se selecciona Agregar",Evidencia);
		return this;
	}

	@Step("Ver usuario")
	public UsuariosPage verUsuario(File folderPath,String Evidencia) throws Exception {

		//VER USUARIO
		scrollElementH(folderPath, btnVerUsuario, "Se desplaza hasta la opción Ver usuario",Evidencia);
		etiquetas(btnVerUsuario, folderPath, "Etiqueta Ver usuario",Evidencia);
		click(btnVerUsuario, folderPath, "Se ingresa a ver Usuario",Evidencia);

		//VALIDACIONES DE ENABLED EN LA OPCION VER USUARIO
		isEnabled(txtUsuarioDominio, folderPath, "Campo Usuario Dominio No editable",Evidencia);
		isEnabled(txtNombres, folderPath, "Campo Nombres No editable",Evidencia);
		isEnabled(txtApellidos, folderPath, "Campo Apellidos No editable",Evidencia);
		isEnabled(txtCargo, folderPath, "Campo Cargo No editable",Evidencia);
		isEnabled(lblOficina, folderPath, "Campo Oficina No editable",Evidencia);
		isEnabled(txtEmailUsuario, folderPath, "Campo Email Usuario No editable",Evidencia);
		isEnabled(lblPerfil, folderPath, "Campo Perfil No editable",Evidencia);
		isEnabled(lblEstado, folderPath, "Campo Estado No editable",Evidencia);
		return this;
	}

	//CONSULTAR UN USUARIO EN ESPECIFICO
	@Step("Botones consultar usuario")
	public UsuariosPage botonesUsuario(File folderPath,String Evidencia) throws Exception {

		x = new Object[3];
		x[0] = btnBuscar;
		x[1] = btnVerTodos;
		x[2] = btnDescargar;

		val = validarElementos(x, t);

		//VER USUARIO
		if (Boolean.TRUE.equals(val)) {
			click(btnVerTodos, folderPath, "Se selecciona la opción Ver Todos",Evidencia);
			waitInMs(3000);
			if (lblUsuarioTabla == null) {
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

	//CONSULTAR UN USUARIO EN ESPECIFICO
	@Step("Consultar usuario")
	public UsuariosPage consultaUsuario(File folderPath, String nom50, String nombres,String Evidencia) throws Exception {

		//FORMULARIO DE CONSULTA DE UN USUARIO EN ESPECIFIO
		String nombre = RandomStringUtils.randomAlphabetic(50).toLowerCase();
		String nom = driver.findElement(By.xpath("//input[contains(@formcontrolname,'nombre')]")).getAttribute("maxlength");

		if (nom.contains(nom50)) {
			printConsole("Los campos contienen el maximo de 50 caracteres");
			writeText(consultarUsuario, nombre, folderPath, "Se ingresa texto de 50 caracteres",Evidencia);
			clear(consultarUsuario, folderPath, "Se eliminar texto antes digitado",Evidencia);
			writeText(consultarUsuario, nombres, folderPath, "Se ingresa nombre de usuario",Evidencia);
			click(btnBuscar, folderPath, "Se busca el usuario digitado",Evidencia);
		} else {
			printConsole("Error en la validación, los campos no contienen el maximo de 50 caracteres");
			Assert.fail("Error en la validación, los campos no contienen el maximo de 50 caracteres");
		}
		return this;
	}
}