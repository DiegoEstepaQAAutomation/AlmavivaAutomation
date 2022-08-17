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
	
	public Properties getProperties() throws Exception {
        
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        fileprops.load(new FileInputStream(new File("src/test/resources/Roles.properties").getAbsolutePath()));
        
        return fileprops;
    }
	
	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderR"),
				getProperties().getProperty("path"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"));

		GenerarReportePdf.setImgContador(0);

		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"), folderPath);
	}

	@Test(priority = 0, description = "Crear rol")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Roles")
	@Story("Creación de rol")
	public void crearRol() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderR"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestCrearRol"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloR"));

		roles.obligatoriedadCampos(folderPath)
		//EJECUCION DE CASOS DE TAMAÑO DE TEXTO O CARACTERES		
		.caracteres100(folderPath, getProperties().getProperty("nombre100"),
						getProperties().getProperty("descripcion100"),
						getProperties().getProperty("nom100"),
						getProperties().getProperty("desc100"))
				
				.cancelarRol(folderPath)

				.crearRol(folderPath, getProperties().getProperty("nombre"),
						getProperties().getProperty("descripcion"), getProperties().getProperty("estado"),
						getProperties().getProperty("permisoSeguridad"))
		 .guardarRol(folderPath);
		 //.aceptarUsuario(folderPath);

		GenerarReportePdf.closeTemplate("");
	}  
	
	@Test(priority = 1, description = "Modificar rol")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Roles")
	@Story("Modificación de rol")
	public void modificarRol() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderR"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestModificarRol"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloR"));

		roles.modificarRol(folderPath, getProperties().getProperty("nombre"),
				getProperties().getProperty("estadoI"));

		 //.aceptarUsuario(folderPath);

		GenerarReportePdf.closeTemplate("");
	}

	@Test(priority = 2, description = "Ver rol")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Roles")
	@Story("Detalle de rol")
	public void verRol() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderR"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestVerRol"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloR"));

		roles.verRol(folderPath);

		GenerarReportePdf.closeTemplate("");
	}
	
	@Test(priority = 3, description = "Consultar rol")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Roles")
	@Story("Consulta de rol")
	public void consultarUsuario() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderR"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestConsultarRol"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloR"));

		roles.botonesRol(folderPath)

		.consultaRol(folderPath, getProperties().getProperty("nom50"), getProperties().getProperty("nombreRol"));

		GenerarReportePdf.closeTemplate("");
	}
}