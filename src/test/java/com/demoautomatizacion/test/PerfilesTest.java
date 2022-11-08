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
@Epic("Perfiles")
@Feature("Perfiles Tests")

public class PerfilesTest extends BaseTest {
	
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		
		//INSTANCIAS DE PROPIEDADES(ARCHIVOS PLANOS QUE CONTIENEN PROPIEDADES) 
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Perfiles.properties").getAbsolutePath()));
		
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

	@Test(priority = 0, description = "Crear perfil")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Perfiles")
	@Story("Creación de perfil")
	public void crearPerfil() throws Exception {

		//RUTA EN DONDE SE VA A GUARDAR LOS INFORMES DE PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderP"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login2(getProperties().getProperty("nameTestCrearPerfil"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloP"),getProperties().getProperty("Evidencia"));

		//EJECUCION DE METODOS ASOCIADOS A CREAR UN PERFIL EN ALMAVIVA
		perfiles.obligatoriedadCampos(folderPath,getProperties().getProperty("Evidencia"))
		
		//INSTANCIA DE METODO PARA VALIDAR UN MAXIMO DE CARACTERES
		.caracteres50100(folderPath, getProperties().getProperty("nombre50"),
						getProperties().getProperty("descripcion100"),
						getProperties().getProperty("nom50"),
						getProperties().getProperty("desc100"),getProperties().getProperty("Evidencia"))
				
				.cancelarPerfil(folderPath,getProperties().getProperty("Evidencia"))

				.crearPerfil(folderPath, getProperties().getProperty("nombre"),
						getProperties().getProperty("descripcion"),getProperties().getProperty("Evidencia"))
		 .guardarPerfil(folderPath,getProperties().getProperty("Evidencia"));
		 //.aceptarUsuario(folderPath);

		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}  
	
	//METODO PARA MODIFICAR PERFIL DE USUARIO
	@Test(priority = 1, description = "Modificar perfil")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Perfiles")
	@Story("Modificación de perfil")
	public void modificarPerfil() throws Exception {

		//RUTA EN DONDE SE VA A GUARDAR LOS INFORMES DE PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderP"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login2(getProperties().getProperty("nameTestModificarPerfil"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloP"),getProperties().getProperty("Evidencia"));

		perfiles.modificarPerfil(folderPath, getProperties().getProperty("descripcion"),
				getProperties().getProperty("estadoI"),getProperties().getProperty("Evidencia"))
		.guardarPerfil(folderPath,getProperties().getProperty("Evidencia"));
		 //.aceptarUsuario(folderPath);

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}
	
	//METODO DE VER PERFIL
	@Test(priority = 2, description = "Ver perfil")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Perfiles")
	@Story("Detalle de perfil")
	public void verPerfil() throws Exception {

		//RUTA EN DONDE SE VA A GUARDAR LOS INFORMES DE PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderP"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login2(getProperties().getProperty("nameTestVerPerfil"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloP"),getProperties().getProperty("Evidencia"));

		//METODO PARA VER PERFIL
		perfiles.verPerfil(folderPath,getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}
	
	@Test(priority = 3, description = "Consultar perfil")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Perfiles")
	@Story("Consulta de perfil")
	public void consultarUsuario() throws Exception {

		//RUTA EN DONDE SE VA A GUARDAR LOS INFORMES DE PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderP"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login2(getProperties().getProperty("nameTestConsultarPerfil"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		
		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloP"),getProperties().getProperty("Evidencia"));

		//INSTANCIA DE METODO PARA INTERACTUAR CON BOTONES DE PERFIL Y CONSULTA DE PERFIL
		perfiles.botonesPerfil(folderPath,getProperties().getProperty("Evidencia"))

		.consultaPerfil(folderPath, getProperties().getProperty("nom50"), getProperties().getProperty("nombrePerfil"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}
}
