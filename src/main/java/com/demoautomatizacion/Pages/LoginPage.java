package com.demoautomatizacion.Pages;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.demoautomatizacion.Maps.LoginMap;

import io.qameta.allure.Step;
import utilities.GenerarReportePdf;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginPage.
 */
public class LoginPage extends LoginMap {

	/** The x. */
	Object[] x;
	
	/** The val. */
	boolean val;
	
	/** The t. */
	int t = 5;

	/**
	 * Instantiates a new login page.
	 *
	 * @param driver the driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Privacidad ip.
	 *
	 * @param folderPath the folder path
	 * @param Evidencia the evidencia
	 * @return the login page
	 * @throws Exception the exception
	 */
	//CONEXION A RED PRIVADA
	@Step("Conexión no privada")
	public LoginPage privacidadIp() throws Exception {
		 
		try {
			waitInMs(2000);
			click(btnAvanzado);
			click(lblContinuarNoSeguro);
		}catch (Exception e) {
			printConsole("Ya NO esta la Conexión de no privacidad");
		}
		return this; 
		} 
	
	
	/**
	 * Privacidad ip 2.
	 *
	 * @return the login page
	 * @throws Exception the exception
	 */
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

	/**
	 * Ingresar credenciales.
	 *
	 * @param usuario2 the usuario 2
	 * @param password the password
	 * @param folderPath the folder path
	 * @param Evidencia the evidencia
	 * @return the login page
	 * @throws Exception the exception
	 */
	//SE INGRESAN LAS CREDENCIALES DE ACCESO Y CLICK EN LOGIN
	@Step("Ingresar Credenciales de Acceso")
	public LoginPage ingresarCredenciales(String usuario2, String password, File folderPath,String Evidencia) throws Exception {

		
		waitInMs(1000);
		writeText(txtusuario, usuario2, folderPath, "Se escribe usuario",Evidencia);
		waitInMs(2000);
		writeText(txtpassword, password, folderPath, "Se escribe una contraseña",Evidencia);
		click(btnLogin, folderPath, "Se da click en el elemento",Evidencia);

		try {
			waitInMs(1000);
			getElement(Home).isDisplayed();
		} catch (Exception e) {
			waitInMs(500);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"document.querySelector(\"body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled\").click()");
		}



		click(Titulo, folderPath, "se valida el titulo de almaviva",Evidencia);
		return this; 
			}
	//CIERRE DE SESION
	
	/**
	 * Ingresar credenciales 2.
	 *
	 * @param usuario2 the usuario 2
	 * @param password the password
	 * @return the login page
	 * @throws Exception the exception
	 */
	//SE INGRESAN LAS CREDENCIALES DE ACCESO Y CLICK EN LOGIN SIN EVIDENCIA
		@Step("Ingresar Credenciales de Acceso")
		public LoginPage ingresarCredenciales2(String usuario2, String password,String Evidencia) throws Exception {

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
				GenerarReportePdf.closeTemplate("Error en la validación: No se encontró el mensaje del elemento " + Titulo,Evidencia);
				Assert.fail("Error en la validación: No se encontró el mensaje del elemento " + Titulo);
			}

			click(Titulo);
			return this;
		}


	/**
	 * Cerrar sesion.
	 *
	 * @param folderPath the folder path
	 * @param Evidencia the evidencia
	 * @return the login page
	 * @throws Exception the exception
	 */
	@Step("cerrando sesion")
	public LoginPage cerrarSesion(File folderPath,String Evidencia) throws Exception {
		
		waitInMs(2000);
		click(Label, folderPath, "Se da click en usuario",Evidencia);
		click(btncerrarSesion, folderPath, "Se da click en cerrar session",Evidencia);
		return this;
	}
	
	
	/**
	 * Cerrar sesion 2.
	 *
	 * @return the login page
	 * @throws Exception the exception
	 */
	@Step("cerrando sesion")
	public LoginPage cerrarSesion2() throws Exception {

		waitInMs(2000);
		click(Label);
		click(btncerrarSesion);
		return this;
	}
}




