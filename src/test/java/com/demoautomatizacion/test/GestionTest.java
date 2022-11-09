package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.test.utils.Listeners.TestListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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


    //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();
	private static final Logger log = LogManager.getLogger(GestionTest.class.getName());
	
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Gestion.properties").getAbsolutePath()));

		return fileprops;
	}
	MyScreenRecorder recording;

	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		//INSTANCIAS DE INFORME PDF
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.setImgContador(0);

		//METODO PARA INGRESO A PORTAL DE ALMAVIVA ASI COMO URL DE ALMAVIVA
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"),
				folderPath,getProperties().getProperty("Evidencia"));
	}

	//METODO PARA LA CREACION DE CLIENTE
	@Test(priority = 0, description = "Crear gestión")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Gestion")
	@Story("Creación de gestion")
	public void crearCliente() throws Exception {

		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);

		//INSTANCIA DE LA RUTA DONDE QUEDA NUESTRO INFORME DE PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		//METODO PARA LOGUEARSE A LA PAGINA DE ALMAVIVA Y INGRESO A MODULO
		login(getProperties().getProperty("nameTestCrearCliente"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"),
				getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));

		//LLAMADO DE VARIOS METODOS QUE ESTAN ASOCIADOS AL SUBMODULO DE GESTION,RELACIONADO A TEMAS DE POLIZA,DATOS DE CONTACTO ETC 
		gestion.obligatoriedadCamposDatosC(folderPath, 
				getProperties().getProperty("datosContacto"),getProperties().getProperty("Evidencia"))

				.obligatoriedadCamposPoliza(folderPath, 
						getProperties().getProperty("informacionPolizas"),
						getProperties().getProperty("Evidencia"))

				.crearCliente(folderPath, getProperties().getProperty("nitC"),
						getProperties().getProperty("Evidencia"))

				//solo ejecutar estos metodos si se cuenta con un titulo en estado aplicado
				.datosContacto(folderPath, getProperties().getProperty("datosContacto"),
						getProperties().getProperty("nombre"), getProperties().getProperty("cargo"),
						getProperties().getProperty("telefono"), getProperties().getProperty("correo"),
						getProperties().getProperty("estadoA"),getProperties().getProperty("Evidencia"))
				//polizas 
				.informacionPolizas(folderPath, getProperties().getProperty("informacionPolizas"),
						getProperties().getProperty("aseguradora"), getProperties().getProperty("nPoliza"),
						getProperties().getProperty("valor"), getProperties().getProperty("vencimiento"),
						getProperties().getProperty("estadoA"),getProperties().getProperty("Evidencia"))
				//acreedores
				.acreedores(folderPath, getProperties().getProperty("acreedores"), getProperties().getProperty("nitA"),
						getProperties().getProperty("campoNit"),getProperties().getProperty("Evidencia"))

				.tipoBodega(folderPath, getProperties().getProperty("tipoBodega"),getProperties().getProperty("Evidencia"))

				.anexo(folderPath, getProperties().getProperty("anexo"), getProperties().getProperty("archivo"),
						getProperties().getProperty("descripcion"),getProperties().getProperty("Evidencia"));
		
		//CIERRE DE PLANTILLA
		GenerarReportePdf.closeTemplate("cierre de plantilla",getProperties().getProperty("Evidencia"));
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}

	//METODOS PARA MODIFICAR LOS DATOS DE UN CLIENTE YA EXISTENTE
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar gestión")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Gestion")
	@Story("Modificación de gestión")
	public void modificarCliente() throws Exception {

		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);

		//INSTANCIA DE RUTA DONDE QUEDARA EL INFORME
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		//INSTANCIA DE METODO DE GRABAR VIDEO
		recording.startRecording("", folderPath);
		
		//METODO LOGIN
		login(getProperties().getProperty("nameTestModificarCliente"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		//INSTANCIA DE METODOS RELACIONADOS A MODIFICACION DE DATOS COMO ANEXOS, DATOS DE CONTACTO,POLIZAS Y CLIENTE
		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));

		gestion  .modificarCliente(folderPath,getProperties().getProperty("Evidencia"))
		
			
				.datosContacto(folderPath, getProperties().getProperty("datosContacto"),
						getProperties().getProperty("nombre"), getProperties().getProperty("cargo"),
						getProperties().getProperty("telefono"), getProperties().getProperty("correo"),
						getProperties().getProperty("estadoA"),getProperties().getProperty("Evidencia"))

				.anexo(folderPath, getProperties().getProperty("anexo"), getProperties().getProperty("archivo"),
						getProperties().getProperty("descripcion"),getProperties().getProperty("Evidencia"))
				
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
				getProperties().getProperty("tituloPorAnular"),
				getProperties().getProperty("Evidencia"));
		
		
		//INTANCIA DE METODO DE CERRAR SESION
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		//INSTANCIA DE METODO DE PARAR GRABACION 
		recording.stopRecording();
				
		//cierre de plantilla
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
	
	//METODO PARA VISUALIZAR DATOS DE CLIENTE
	@Test(priority = 2, description = "Ver gestión")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Gestion")
	@Story("Detalle de gestión")
	public void verCliente() throws Exception {

		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);

		//INSTANCIA DE RUTA DONDE QUEDARA GUARDADO EL INFORME DE PDF
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		//METODO DE LOGIN A PAGINA DE ALMAVIVA
		login(getProperties().getProperty("nameTestVerCliente"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		//METODO DE INGRESO A MODULO
		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));

		//METODO DE VER A CLIENTE
		gestion.verCliente(folderPath,getProperties().getProperty("Evidencia"));
		
		//CIERRE DE PLANTILLA
		GenerarReportePdf.closeTemplate("cierre de plantilla",getProperties().getProperty("Evidencia"));
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
	
	//METODO PARA CONSULTAR A UN CLIENTE
	@Test(priority = 3, description = "Consultar gestión")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Gestion")
	@Story("Consulta de gestión")
	public void consultarCliente() throws Exception {

		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);

		//INSTANCIA DE RUTA DONDE QUEDA  GUARDADO NUESTRO INFORME
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderC"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
		//INSTANCIA DE METODO QUE NOS LOGUEA A LA PAGINA DE ALMAVIVA
		login(getProperties().getProperty("nameTestConsultarCliente"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));
		//INGRESO A MODULOS DE ALMAVIVA
		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));

		//METODO PARA CONSULTAR A CLIENTE
		gestion.consultaCliente(folderPath, getProperties().getProperty("nom50"), getProperties().getProperty("nit"),getProperties().getProperty("Evidencia"));
		
		//CIERRE DE PLANTILLA PDF
		GenerarReportePdf.closeTemplate("cierre de plantilla pdf",getProperties().getProperty("Evidencia"));
		
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
}