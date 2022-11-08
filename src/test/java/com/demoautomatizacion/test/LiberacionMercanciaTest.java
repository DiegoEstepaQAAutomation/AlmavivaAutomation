package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.test.utils.Listeners.TestListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utilities.GenerarReportePdf;
import utilities.MyScreenRecorder;

@Listeners({ TestListener.class })
@Epic("Liberaci�n")
@Feature("Liberaci�n Test")

public class LiberacionMercanciaTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
		return fileprops;
	}
	
	/** The recording. */
	//INSTANCIA DE MY SCREEN RECORDER(GRABACION DE PANTALLA)
	MyScreenRecorder recording;

	//METODO PARA LOGUEARSE AL PORTAL DE ALMAVIVA
	public void login2(String nameTest, String usuario, String contrasena,String Evidencia) throws Exception 
	{

		//INSTANCIA DEL METODO DE GENERAR EL REPORTE PDF
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		//INSTANCIA DE LA RUTA DONDE GUARDAMOS EL PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderG"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.setImgContador(0);

		//LLAMADO DE CREDENCIALES Y LA RUTA URL DEL PORTAL DE ALMAVIVA
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath,getProperties().getProperty("Evidencia"));
	}


	@SuppressWarnings("static-access")
	@Test(priority = 0, description = "")
	@Severity(SeverityLevel.NORMAL)
	@Description("M�dulo Liberaci�n")
	@Story("")
	public void liberacion() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderL"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
		
		recording.startRecording("grabacion de pantalla o screen recording ", folderPath);

		login2(getProperties().getProperty("nameTestLiberacion"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));
		
		
		liberacion.consultarLiberacion(folderPath,getProperties().getProperty("Evidencia"));
		
		
		liberacion.consultarLiberacion_554083(folderPath,getProperties().getProperty("Evidencia"));
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		recording.stopRecording();

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
		
		
		
	}
	
	
	
	
	
	@Test(priority = 0, description = "")
	@Severity(SeverityLevel.NORMAL)
	@Description("M�dulo Liberaci�n")
	@Story("")
	public void liberacion2() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderL"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia2"));

		login2(getProperties().getProperty("nameTestLiberacion"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia2"));
		liberacion.consultarLiberacion(folderPath,getProperties().getProperty("Evidencia2"));
		
		
		//liberacion.consultarLiberacion_554083(folderPath,getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia2"));
	}
}