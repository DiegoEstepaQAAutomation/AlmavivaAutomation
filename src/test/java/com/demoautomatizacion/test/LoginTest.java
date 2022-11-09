package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import io.qameta.allure.*;
import utilities.GenerarReportePdf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.test.utils.Listeners.TestListener;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginTest.
 */
@Listeners({ TestListener.class })
@Epic("Login")
@Feature("Login Tests")

public class LoginTest extends BaseTest {

    //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();

	private static final Logger log = LogManager.getLogger(LoginTest.class.getName());

	/** The fileprops. */
	public Properties fileprops = new Properties();
	
	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 * @throws Exception the exception
	 */
	//LLAMADO DE LAS PROPIEDADES DE LOGIN
	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		return fileprops;
	}

	/**
	 * Ingresar portal almaviva.
	 *
	 * @throws Exception the exception
	 */
	//ESTE METODO LLAMA LAS PROPIEDADES QUE PERMITEN EL LOGUEO EN ALMAVIVA
	@Test(priority = 0, description = "Login Portal Almaviva")
	@Severity(SeverityLevel.NORMAL)
	@Description("Ingresar Portal Almaviva")
	@Story("Login")
	public void ingresarPortalAlmaviva() throws Exception { 


		System.setProperty("testname", nomClass.replace(".java", ""));
		log.info("INICIA LA EJECUCION DE LA CLASE "+nomClass);
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		String Evidencia = getProperties().getProperty("Evidencia");
		
		if(Evidencia.equals("SI")) 
		{
		log.info("SE EMPIEZA A GENERAR EVIDENCIA");
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolder"),
		        getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
		GenerarReportePdf.createTemplate(folderPath,
		        getProperties().getProperty("nameTest"),
		        getProperties().getProperty("analista"),
		        getProperties().getProperty("url"),
		        getProperties().getProperty("Evidencia"));
		GenerarReportePdf.setImgContador(0);
				
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),folderPath, getProperties().getProperty("Evidencia"))
	    .cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
		log.info("FINALIZA LA EJECUCION DEL TEST");
		
		}else { 
			
			File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolder"),
			        getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
			
			home.irPortal(getProperties().getProperty("urlPrivada"));
			login.privacidadIp();
			home.irPortal(getProperties().getProperty("url"));
			login.privacidadIp();
			home.irPortal(getProperties().getProperty("urlPrivada"));
			login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),folderPath, getProperties().getProperty("Evidencia"))
		    .cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));	

			log.info("FINALIZA LA EJECUCION DEL TEST");
		}
	
	
}
	
} 
	

	

			
		
	
