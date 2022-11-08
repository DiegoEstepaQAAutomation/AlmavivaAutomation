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

@Listeners({ TestListener.class })
@Epic("Prorrogas")
@Feature("Prorrogas Test")

public class ProrrogasTest extends BaseTest {
	//INSTANCIA DE PROPIEDADES Y RUTA EN DONDE SE ENCUENTRAN DETERMINADAS PROPIEDADES
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
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

	
	//METODO DE BODEGAS 
	@Test(priority = 0, description = "Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Story("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	public void AlmavivaBodegas1() throws Exception {
		//INSTANCIA DE RUTA EN DONDE SE GUARDAN LOS INFORMES PDF DE LA EJECUCION DE LA AUTOMATIZACION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderProrroga"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		//METODO DE LOGIN,MODULO Y PRORROGAS
		login2(getProperties().getProperty("nameTestProrroga"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));
		prorroga.prorrogas(folderPath,getProperties().getProperty("Evidencia"));	
		
		GenerarReportePdf.closeTemplate("Cerrar plantilla",getProperties().getProperty("Evidencia"));
	}
	
	
	
	
	@Test(priority = 0, description = "Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	@Story("Validar que Permita la creación de la información de bodegas pertenecientes a Almaviva y/o particulares autorizadas")
	public void AlmavivaProrrogas() throws Exception {
		//INSTANCIA DE RUTA EN DONDE SE GUARDAN LOS INFORMES PDF DE LA EJECUCION DE LA AUTOMATIZACION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderProrroga"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
		
		//METODO DE LOGIN,MODULO Y PRORROGAS

		login2(getProperties().getProperty("nameTestProrroga"), getProperties().getProperty("usuario"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));
		prorroga.prorrogasHU24(folderPath,getProperties().getProperty("TituloModificarProrroga"),getProperties().getProperty("Evidencia"));	
		
		GenerarReportePdf.closeTemplate("Cerrar plantilla",getProperties().getProperty("Evidencia"));
	}

	
}