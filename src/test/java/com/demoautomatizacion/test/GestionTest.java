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
import utilities.MyScreenRecorder;

@Listeners({ TestListener.class })
@Epic("Gestion")
@Feature("Gestion Test")

public class GestionTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Gestion.properties").getAbsolutePath()));

		return fileprops;
	}
	MyScreenRecorder recording;

	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"));

		GenerarReportePdf.setImgContador(0);

		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp(folderPath);
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath);
	}

	@Test(priority = 0, description = "Crear gestión")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Gestion")
	@Story("Creación de gestion")
	public void crearCliente() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestCrearCliente"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		//LLAMADO DE VARIOS METODOS QUE ESTAN ASOCIADOS AL SUBMODULO DE GESTION 
		gestion.obligatoriedadCamposDatosC(folderPath, getProperties().getProperty("datosContacto"))

				.obligatoriedadCamposPoliza(folderPath, getProperties().getProperty("informacionPolizas"))

				.crearCliente(folderPath, getProperties().getProperty("nitC"))

				.datosContacto(folderPath, getProperties().getProperty("datosContacto"),
						getProperties().getProperty("nombre"), getProperties().getProperty("cargo"),
						getProperties().getProperty("telefono"), getProperties().getProperty("correo"),
						getProperties().getProperty("estadoA"))

				.informacionPolizas(folderPath, getProperties().getProperty("informacionPolizas"),
						getProperties().getProperty("aseguradora"), getProperties().getProperty("nPoliza"),
						getProperties().getProperty("valor"), getProperties().getProperty("vencimiento"),
						getProperties().getProperty("estadoA"))

				.acreedores(folderPath, getProperties().getProperty("acreedores"), getProperties().getProperty("nitA"),
						getProperties().getProperty("campoNit"))

				.tipoBodega(folderPath, getProperties().getProperty("tipoBodega"))

				.anexo(folderPath, getProperties().getProperty("anexo"), getProperties().getProperty("archivo"),
						getProperties().getProperty("descripcion"));

		GenerarReportePdf.closeTemplate("");
	}

	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar gestión")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Gestion")
	@Story("Modificación de gestión")
	public void modificarCliente() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		recording.startRecording("", folderPath);
		
		login(getProperties().getProperty("nameTestModificarCliente"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		gestion  //.modificarCliente(folderPath)
		
			
			//	.datosContacto(folderPath, getProperties().getProperty("datosContacto"),
			//			getProperties().getProperty("nombre"), getProperties().getProperty("cargo"),
			//			getProperties().getProperty("telefono"), getProperties().getProperty("correo"),
			//			getProperties().getProperty("estadoA"))

			//	.anexo(folderPath, getProperties().getProperty("anexo"), getProperties().getProperty("archivo"),
				//		getProperties().getProperty("descripcion"))
				
		.ClientePoliza_547065(folderPath, 
				getProperties().getProperty("CriterioRazonSocial"),
				getProperties().getProperty("Cliente"),
				getProperties().getProperty("ModuloT"), 
				getProperties().getProperty("informacionPolizas"),
				getProperties().getProperty("SubModuloLiberacion"), 
				getProperties().getProperty("TituloConLiberacionesPendientes"), 
				getProperties().getProperty("AutoriPend"), 
				getProperties().getProperty("Anular"), 
				getProperties().getProperty("Titulouseradmin"), 
				getProperties().getProperty("tituloPorAnular"));
		
		
		
		
		login.cerrarSesion(folderPath);
		
		recording.stopRecording();
				

		GenerarReportePdf.closeTemplate("");
	}
	
	@Test(priority = 2, description = "Ver gestión")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Gestion")
	@Story("Detalle de gestión")
	public void verCliente() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestVerCliente"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		gestion.verCliente(folderPath);
		
		GenerarReportePdf.closeTemplate("");
	}
	
	@Test(priority = 3, description = "Consultar gestión")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Gestion")
	@Story("Consulta de gestión")
	public void consultarCliente() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestConsultarCliente"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		gestion.consultaCliente(folderPath, getProperties().getProperty("nom50"), getProperties().getProperty("nit"));
		
		GenerarReportePdf.closeTemplate("");
	}
}