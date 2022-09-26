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
@Epic("Usuarios")
@Feature("Usuarios Test")

public class UsuariosTest extends BaseTest {

	//INSANCIAS DE PROPIEDADES UTILIZADAS
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {

		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Usuario.properties").getAbsolutePath()));
		return fileprops;
	}

	//METODO LOGIN A LA PAGINA DE ALMAVIVA
	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		
		//INSTANCIA DE RUTA DE DONDE SE GUARDA LOS INFORMES DE EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderU"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		//INSTANCIAS METODOS  DE GENERAR PDF 
		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.setImgContador(0);

		//INSTANCIA DE URL Y CREDENCIALES
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath,getProperties().getProperty("Evidencia"));
	}

	@Test(priority = 0, description = "Crear usuario")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Usuarios")
	@Story("Creación de usuario")
	public void crearUsuario() throws Exception {

		//INSTANCIA DE RUTA DE DONDE SE GUARDA LOS INFORMES DE EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderU"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login(getProperties().getProperty("nameTestCrearUsuario"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"),
				getProperties().getProperty("SubModuloU"),getProperties().getProperty("Evidencia"));

		//EJECUCION DE CASOS
		usuarios.obligatoriedadCampos(folderPath,getProperties().getProperty("Evidencia"))

				.caracteres50(folderPath, getProperties().getProperty("nombres50"),
						getProperties().getProperty("apellidos50"), getProperties().getProperty("cargo50"),
						getProperties().getProperty("email"), getProperties().getProperty("nom50"),
						getProperties().getProperty("apell50"), getProperties().getProperty("car50"),
						getProperties().getProperty("mail50"),getProperties().getProperty("Evidencia"))

				.cancelarUsuario(folderPath,getProperties().getProperty("Evidencia"))

				.crearUsuario(folderPath, getProperties().getProperty("usuarioDominio"),
						getProperties().getProperty("nombres"), getProperties().getProperty("apellidos"),
						getProperties().getProperty("cargo"), getProperties().getProperty("oficina"),
						getProperties().getProperty("email"), getProperties().getProperty("perfil"),
						getProperties().getProperty("estado"), getProperties().getProperty("busqueda"),
						getProperties().getProperty("codigo"),getProperties().getProperty("Evidencia"))
				.guardarUsuario(folderPath,getProperties().getProperty("Evidencia"));
		// .aceptarUsuario(folderPath);

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}

	@Test(priority = 1, description = "Modificar usuario")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Usuarios")
	@Story("Modificación de usuario")
	public void modificarUsuario() throws Exception {

		//INSTANCIA DE RUTA DE DONDE SE GUARDA LOS INFORMES DE EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderU"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login(getProperties().getProperty("nameTestModificarUsuario"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"),
				getProperties().getProperty("SubModuloU"),getProperties().getProperty("Evidencia"));

		//EJECUCION DE CASOS
		usuarios.modificarUsuario(folderPath, getProperties().getProperty("nombres"),
				getProperties().getProperty("apellidos"), getProperties().getProperty("cargo"),
				getProperties().getProperty("oficina"), getProperties().getProperty("email"),
				getProperties().getProperty("perfil"), getProperties().getProperty("estado"),
				getProperties().getProperty("busqueda"), getProperties().getProperty("codigo"),
				getProperties().getProperty("Evidencia"))

				.guardarUsuario(folderPath,getProperties().getProperty("Evidencia"));
		// .aceptarUsuario(folderPath);

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}

	@Test(priority = 2, description = "Ver usuario")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Usuarios")
	@Story("Detalle de usuario")
	public void verUsuario() throws Exception {

		//INSTANCIA DE RUTA DE DONDE SE GUARDA LOS INFORMES DE EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderU"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login(getProperties().getProperty("nameTestVerUsuario"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"),
				getProperties().getProperty("SubModuloU"),getProperties().getProperty("Evidencia"));

		//EJECUCION DE CASO
		usuarios.verUsuario(folderPath,getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}

	@Test(priority = 3, description = "Consultar usuario")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Usuarios")
	@Story("Consulta de usuario")
	public void consultarUsuario() throws Exception {

		//INSTANCIA DE RUTA DE DONDE SE GUARDA LOS INFORMES DE EJECUCION
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderU"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login(getProperties().getProperty("nameTestConsultarUsuario"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"),
				getProperties().getProperty("SubModuloU"),getProperties().getProperty("Evidencia"));

		//EJECUCION DE CASOS
		usuarios.botonesUsuario(folderPath,getProperties().getProperty("Evidencia"))

		.consultaUsuario(folderPath, getProperties().getProperty("nom50"),
				getProperties().getProperty("nombres"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.closeTemplate("Cierre de plantilla",getProperties().getProperty("Evidencia"));
	}
}
