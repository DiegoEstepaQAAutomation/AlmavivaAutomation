package com.demoautomatizacion.Pages;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.demoautomatizacion.Maps.LoginMap;

import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

public class LoginPage extends LoginMap {

	Object[] x;
	boolean val;
	int t = 5;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//CONEXION A RED PRIVADA
	@Step("Conexión no privada")
	public LoginPage privacidadIp(File folderPath) throws Exception {
		
		try {
			waitInMs(2000);
			click(btnAvanzado);
			click(lblContinuarNoSeguro);
		}catch (Exception e) {
			printConsole("Ya NO esta la Conexión de no privacidad");
		}
		return this;
	}
	
	//CONEXION A RED PRIVADA
		@Step("Conexión no privada")
		public LoginPage privacidadIp2() throws Exception {
			
			try {
				waitInMs(2000);
				click(btnAvanzado);
				click(lblContinuarNoSeguro);
			}catch (Exception e) {
				printConsole("Ya NO esta la Conexión de no privacidad");
			}
			return this;
		}

	//SE INGRESAN LAS CREDENCIALES DE ACCESO Y CLICK EN LOGIN
	@Step("Ingresar Credenciales de Acceso")
	public LoginPage ingresarCredenciales(String usuario2, String password, File folderPath) throws Exception {

		waitInMs(1000);
		writeText(txtusuario, usuario2, folderPath, "Se escribe usuario");
		writeText(txtpassword, password, folderPath, "Se escribe una contraseña");
		click(btnLogin, folderPath, "Se da click en el elemento");

		try {
			waitInMs(1000);
			getElement(Home).isDisplayed();
		} catch (Exception e) {
			waitInMs(500);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"document.querySelector(\"body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled\").click()");
		}

		val = validarElemento(Titulo, t);

		if (Boolean.FALSE.equals(val)) {
			GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento " + Titulo);
			Assert.fail("Error en la validación: No se encontró el mensaje del elemento " + Titulo);
		}

		click(Titulo, folderPath, "se valida el titulo de almaviva");
		return this;
	}
	//CIERRE DE SESION
	
	//SE INGRESAN LAS CREDENCIALES DE ACCESO Y CLICK EN LOGIN SIN EVIDENCIA
		@Step("Ingresar Credenciales de Acceso")
		public LoginPage ingresarCredenciales2(String usuario2, String password) throws Exception {

			waitInMs(1000);
			writeText(txtusuario, usuario2);
			writeText(txtpassword, password);
			click(btnLogin);

			try {
				waitInMs(1000);
				getElement(Home).isDisplayed();
			} catch (Exception e) {
				waitInMs(500);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(
						"document.querySelector(\"body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled\").click()");
			}

			val = validarElemento(Titulo, t);

			if (Boolean.FALSE.equals(val)) {
				GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento " + Titulo);
				Assert.fail("Error en la validación: No se encontró el mensaje del elemento " + Titulo);
			}

			click(Titulo);
			return this;
		}


	@Step("cerrando sesion")
	public LoginPage cerrarSesion(File folderPath) throws Exception {

		waitInMs(2000);
		click(Label, folderPath, "Se da click en usuario");
		click(btncerrarSesion, folderPath, "Se da click en cerrar session");
		return this;
	}
	
	
	@Step("cerrando sesion")
	public LoginPage cerrarSesion2() throws Exception {

		waitInMs(2000);
		click(Label);
		click(btncerrarSesion);
		return this;
	}
}




