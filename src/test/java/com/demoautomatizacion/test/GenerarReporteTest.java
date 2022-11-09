package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
@Epic("Generar Reporte")
@Feature("Generar Reporte Test")

public class GenerarReporteTest extends BaseTest {

    //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();

	private static final Logger log = LogManager.getLogger(GenerarReporteTest.class.getName());

	public Properties fileprops = new Properties();

	//INSTANCIA DE PROPIEDADES(ARCHIVO PLANO CONTENIENDO PROPIEDADES UTILIZADAS)
	public Properties getProperties() throws Exception {

		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/GenerarReporte.properties").getAbsolutePath()));
		return fileprops;
	}
	
	//INSTANCIA DE LA CLASE GRABAR PANTALLA
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
	@Test(priority = 0, description = "Reportes")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Reportes")
	@Story("Opciones reportes")
	public void generarReporte() throws Exception {

		System.setProperty("testname", nomClass.replace(".java", ""));
		log.info("INICIA LA EJECUCION DE LA CLASE "+nomClass);
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);

		//INSTANCIA DE LA RUTA DONDE GUARDAMOS EL PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderG"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
		
		//INSTANCIA DE GRABAR PANTALLA(INICIA GRABACION)
		recording.startRecording("inicio de grabacion", folderPath);

		//METODO DE LOGIN(CREDENCIALES)
		login2(getProperties().getProperty("nameTestGenerarReporte"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"), getProperties().getProperty("Evidencia"));

		//INGRESO A MODULO Y SUBMODULO 
		home.modulo(folderPath, getProperties().getProperty("Modulo"), 
				getProperties().getProperty("SubModuloG"),getProperties().getProperty("Evidencia"));
		
		//INSTANCIA DE METODOS DE GENERAR REPORTE EN ALMAVIVA
		generarReporte
		
		//.reportes(folderPath, getProperties().getProperty("FechaI"),
			//	getProperties().getProperty("FechaF"),getProperties().getProperty("Evidencia")) 
		
		
		.reportesCP05(folderPath, getProperties().getProperty("fechaI"), 
						getProperties().getProperty("fechaF"), 
						getProperties().getProperty("TipoReporte1"), 
						getProperties().getProperty("TipoReporte2"), 
						getProperties().getProperty("TipoReporte3"),
						getProperties().getProperty("Evidencia")) ;
		
		// CERRAR SESION,PLANTILLA Y PARAR GRABACION
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		GenerarReportePdf.closeTemplate("Cierra la plantilla",getProperties().getProperty("Evidencia2"));
		
		recording.stopRecording();
		
		//COMENTARIAR ESTA LINEA DEPENDIENDO SI NECESITA EJECUTAR TODOS AL TIEMPO

		//GenerarReportePdf.closeTemplate("Cierra la plantilla",getProperties().getProperty("Evidencia"));

		log.info("FINALIZA LA EJECUCION DEL TEST");
		
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test(priority = 0, description = "Reportes")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Reportes")
	@Story("Opciones reportes")
	public void generarReporte2() throws Exception 
	{

		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		
		//INSTANCIA DE LA RUTA DONDE GUARDAMOS EL PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderG"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia2"));
		
		//INSTANCIA DE GRABAR PANTALLA(INICIA GRABACION)
		//recording.startRecording("inicio de grabacion", folderPath);

		//METODO DE LOGIN(CREDENCIALES)
		login2(getProperties().getProperty("nameTestGenerarReporte"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia2"));

		//INGRESO A MODULO Y SUBMODULO 
		home.modulo(folderPath, getProperties().getProperty("Modulo"), 
				getProperties().getProperty("SubModuloG"),getProperties().getProperty("Evidencia2"));
		
		//INSTANCIA DE METODOS DE GENERAR REPORTE EN ALMAVIVA
		generarReporte
		
		.reportes(folderPath, getProperties().getProperty("FechaI"),
				getProperties().getProperty("FechaF"),getProperties().getProperty("Evidencia2")); 
		
		/*
		.reportesCP05(folderPath, getProperties().getProperty("fechaI"), 
						getProperties().getProperty("fechaF"), 
						getProperties().getProperty("TipoReporte1"), 
						getProperties().getProperty("TipoReporte2"), 
						getProperties().getProperty("TipoReporte3"),
						getProperties().getProperty("Evidencia2")) ;
		*/
		// CERRAR SESION,PLANTILLA Y PARAR GRABACION
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia2"));
		
		//recording.stopRecording();
		

		GenerarReportePdf.closeTemplate("Cierra la plantilla",getProperties().getProperty("Evidencia2"));

		log.info("FINALIZA LA EJECUCION DEL TEST");
		
	}
}
