package com.demoautomatizacion.test;

import io.qameta.allure.*;
import utilities.GenerarReportePdf;
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
	public Properties fileprops = new Properties();
	//PROPIEDADES DEL TEST
	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Visitas.properties").getAbsolutePath()));
		return fileprops;
	}

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
	@Test(priority = 0, description = "Consultar Registro Visita")
	@Severity(SeverityLevel.NORMAL)
	@Description("M�dulo Visitas")
	@Story("Consultar registro visita")
	public void crearUsuario() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderV"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login2(getProperties().getProperty("nameTestConsultarRegistroV"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));
		//Consulta del registro de visita
		consultarRegistro.consultarRegistroV(folderPath,getProperties().getProperty("Evidencia"));
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}
}
