package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import utilities.GenerarReportePdf;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.test.utils.Listeners.TestListener;

@Listeners({ TestListener.class })
@Epic("Roles")
@Feature("Roles Test")

public class RolesTest extends BaseTest{
	
	public Properties fileprops = new Properties();
	
	//INSTANCIA DE LAS PROPIEDADES(ARCHIVO PLANO)
	public Properties getProperties() throws Exception {
        
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        fileprops.load(new FileInputStream(new File("src/test/resources/Roles.properties").getAbsolutePath()));
        
        return fileprops;
    }
	
	
	//METODO PARA LOGUEO A PORTAL DE ALMAVIVA
	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		//INSTANCIAS DE METODOS DE GENERAR REPORTE
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		//INSTANCIA DE RUTA DONDE GUARDAMOS EL INFORME PDF DE LA EJECUCION 
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderR"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.setImgContador(0);

		//INSTANCIAS DE CREDENCIALES Y URLs
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), 
				getProperties().getProperty("password"), folderPath,getProperties().getProperty("Evidencia"));
	}
	
	
    //METODO DE CREACION DE ROL
	@Test(priority = 0, description = "Crear rol")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Roles")
	@Story("Creación de rol")
	public void crearRol() throws Exception {

		//INSTANCIA DE RUTA DONDE GUARDAMOS EL INFORME PDF DE LA EJECUCION 
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderR"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login(getProperties().getProperty("nameTestCrearRol"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloR"),getProperties().getProperty("Evidencia"));

		roles.obligatoriedadCampos(folderPath,getProperties().getProperty("Evidencia"))
		//EJECUCION DE CASOS DE TAMAÑO DE TEXTO O CARACTERES		
		.caracteres100(folderPath, getProperties().getProperty("nombre100"),
						getProperties().getProperty("descripcion100"),
						getProperties().getProperty("nom100"),
						getProperties().getProperty("desc100"),
						getProperties().getProperty("Evidencia"))
				
				.cancelarRol(folderPath,getProperties().getProperty("Evidencia"))

				.crearRol(folderPath, getProperties().getProperty("nombre"),
						getProperties().getProperty("descripcion"), getProperties().getProperty("estado"),
						getProperties().getProperty("permisoSeguridad"),getProperties().getProperty("Evidencia"))
		 .guardarRol(folderPath,getProperties().getProperty("Evidencia"));
		 //.aceptarUsuario(folderPath);

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}  
	
	@Test(priority = 1, description = "Modificar rol")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Roles")
	@Story("Modificación de rol")
	public void modificarRol() throws Exception {

		
		//INSTANCIA DE RUTA DONDE GUARDAMOS EL INFORME PDF DE LA EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderR"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login(getProperties().getProperty("nameTestModificarRol"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		//METODO PARA INGRESAR A  MODULO Y SUBMODULO
		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloR"),getProperties().getProperty("Evidencia"));

		//METODO PARA MODIFICAR ROL
		roles.modificarRol(folderPath, getProperties().getProperty("nombre"),
				getProperties().getProperty("estadoI"),getProperties().getProperty("Evidencia"));

		 //.aceptarUsuario(folderPath);

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}

	@Test(priority = 2, description = "Ver rol")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Roles")
	@Story("Detalle de rol")
	public void verRol() throws Exception {

		//INSTANCIA DE RUTA DONDE GUARDAMOS EL INFORME PDF DE LA EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderR"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		//METODO DE LOGIN
		login(getProperties().getProperty("nameTestVerRol"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		//METODO DE INGRESAR A MODULO Y SUBMODULO
		home.modulo(folderPath, getProperties().getProperty("Modulo"),
				getProperties().getProperty("SubModuloR"),getProperties().getProperty("Evidencia"));

		
		roles.verRol(folderPath,getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}
	
	@Test(priority = 3, description = "Consultar rol")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Roles")
	@Story("Consulta de rol")
	public void consultarUsuario() throws Exception {
		

		//INSTANCIA DE RUTA DONDE GUARDAMOS EL INFORME PDF DE LA EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderR"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		//METODO DE LOGIN A PORTAL DE ALMAVIVA
		login(getProperties().getProperty("nameTestConsultarRol"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		//METODO DE INGRESO A MODULOS Y BOTONES DE ROL
		home.modulo(folderPath, getProperties().getProperty("Modulo"), 
				getProperties().getProperty("SubModuloR"),getProperties().getProperty("Evidencia"));

		roles.botonesRol(folderPath,getProperties().getProperty("Evidencia"))

		.consultaRol(folderPath, getProperties().getProperty("nom50"), getProperties().getProperty("nombreRol"),getProperties().getProperty("Evidencia"));

		//CIERRE DE PLANTILLA
		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}
}