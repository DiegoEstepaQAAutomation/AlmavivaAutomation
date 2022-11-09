package com.demoautomatizacion.test;

import io.qameta.allure.*;
import utilities.GenerarReportePdf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.test.utils.Listeners.TestListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Listeners({ TestListener.class })
@Epic("Consultar Registro Visita")
@Feature("Consultar Registro Visita Test")

public class ConsultarRegistroVisitaTest extends BaseTest {

    //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();

	private static final Logger log = LogManager.getLogger(ConsultarRegistroVisitaTest.class.getName());
	
	public Properties fileprops = new Properties();
	//PROPIEDADES DEL TEST
	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Visitas.properties").getAbsolutePath()));
		return fileprops;
	}
	//LOGIN CON INICIO DE GENERACION DE REPORTE
	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderV"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.setImgContador(0);
		//ESTE METODO SE ENCARGA DEL LOGIN DE LAS URL DE ALMAVIVA Y LAS CREDENCIALES DE ACCESO
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath,getProperties().getProperty("Evidencia"));
	}

	@Test(priority = 0, description = "Consultar Registro Visita")
	@Severity(SeverityLevel.NORMAL)
	@Description("M�dulo Visitas")
	@Story("Consultar registro visita")
	public void crearUsuario() throws Exception {

		System.setProperty("testname", nomClass);

		log.info("INICIA LA EJECUCION DE LA CLASE "+nomClass);
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderV"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login(getProperties().getProperty("nameTestConsultarRegistroV"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));
		//Consulta del registro de visita
		consultarRegistro.consultarRegistroV(folderPath,getProperties().getProperty("Evidencia"));
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
}
