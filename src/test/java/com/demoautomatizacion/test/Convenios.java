package com.demoautomatizacion.test;

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

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

@Listeners({ TestListener.class })
@Epic("Consultar Registro Visita")
@Feature("Consultar Registro Visita Test")
public class Convenios extends BaseTest 
{

	/** The fileprops. */
	public Properties fileprops = new Properties();

	
	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 * @throws Exception the exception
	 */
	//RUTAS DE LAS PROPIEDADES Y SU ASOCIACION AL FILEINPUTSTREAM
	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Gestion.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Convenio.properties").getAbsolutePath()));
		return fileprops; 
		
		
	}
	
	/** The recording. */
	//INSTANCIA DE MY SCREEN RECORDER(GRABACION DE PANTALLA)
	MyScreenRecorder recording;


	
	/**
	 * Login.
	 *
	 * @param nameTest the name test
	 * @param usuario the usuario
	 * @param contrasena the contrasena
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
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
	@Test(priority = 0, description = "Convenios")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Convenios")
	@Story("Creación de expedir")
	  public void Ejecucion() throws Exception 
	{
		
		//INSTANCIA DE LA RUTA DONDE SE GUARDA LA EVIDENCIA
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		//LO MISMO ESTA LINEA LLAMA AL METODO DE INICIAR GRABACION DE PANTALLA
		recording.startRecording("", folderPath);
		
		//METODO DE LOGIN DE LA PAGINA
		login2(getProperties().getProperty("nameTestModificarExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		//INGRESO A MODULO Y SUBMODULO EN ALMAVIVA
		home.modulo(folderPath, 
				getProperties().getProperty("Moduloc"), getProperties().getProperty("SubmoduloLiquidaciones"),
				getProperties().getProperty("Evidencia"));

		
		
		
		//LLAMADO DE LOS METODOS DE AUTOMATIZACION DE CONVENIOS
		convenios.ConveniosConsulta_570452(folderPath, 
			getProperties().getProperty("NitBusqueda"), 
				getProperties().getProperty("ValorTabla"),
				getProperties().getProperty("ValorTabla2"),
				getProperties().getProperty("ValorTabla3"),
				getProperties().getProperty("EstadoLiquidacion"),
				getProperties().getProperty("Evidencia"));
		
		
		//convenios.PerfilesRolConvenio_567514(folderPath, 
		//		getProperties().getProperty("RolAprovador"),
		//		getProperties().getProperty("Evidencia"));
		
		
		convenios.ParametrizacionConvenios_567529(folderPath, getProperties().getProperty("NitBusqueda"), 
				getProperties().getProperty("Evidencia"),
				getProperties().getProperty("ValorBusqueda"), 
				getProperties().getProperty("ValorGrilla"), 
				getProperties().getProperty("ValorBusqueda2"),
				getProperties().getProperty("ValorBusqueda3"), 
				getProperties().getProperty("ValorValidar"));
		
		
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
		
		
	}



}
