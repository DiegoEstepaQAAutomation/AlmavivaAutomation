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
@Epic("Notificaciones")
@Feature("Notificaciones Test")

public class NotificacionesTest extends BaseTest {
	public Properties fileprops = new Properties();

	//INSTANCIAS DE PROPIEDADES(ARCHIVOS PLANOS)
	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Notificaciones.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Gestion.properties").getAbsolutePath()));
		
		
		
		return fileprops;
	}
	
	//METODO PARA LOGIN A PORTAL DE ALMAVIVA
	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		//INSTANCIA DE RUTA DONDE GUARDAMOS NUESTRO INFORME
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		//LLAMADO DE LOS METODOS DE CREAR INFORME PDF
		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"));

		GenerarReportePdf.setImgContador(0);

		//LLAMADO DE CREDENCIALES Y URL DE ALMAVIVA
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath,getProperties().getProperty("Evidencia"));
		
		
		
	}

	
	
	MyScreenRecorder recording;

	//METODO QUE VALIDA NOTIFICACIONES DEL HU25
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionHU25() throws Exception {
		
		//INSTANCIA DE RUTA DE LA CARPETA DONDE GUARDAMOS EL INFORME PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));
		
		//INSTANCIA DEL METODO GRABAR PANTALLA Y DE LOGIN
		recording.startRecording("inicio de grabacion", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloN"), getProperties().getProperty("submoduloN"),getProperties().getProperty("Evidencia"));
		
		
		//INSTANCIA DE METODO DE NOTIFICACION
		notificacionespage.Notificacion_557159(folderPath, getProperties().getProperty("DatoFaltante"), getProperties().getProperty("ModuloCliente"), 
				getProperties().getProperty("Submodulo"), getProperties().getProperty("FechaDeCargue"), getProperties().getProperty("estadoA"), 
				getProperties().getProperty("Encabezado"),getProperties().getProperty("Evidencia"));
		
		
		
		//INSTANCIAS DE CERRAR SESION Y PARAR GRABACION
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("Cierre de plantilla");
	}

	
}