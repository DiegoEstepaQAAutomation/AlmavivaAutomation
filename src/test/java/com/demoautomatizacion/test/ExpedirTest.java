/*
 * 
 */

package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
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


// TODO: Auto-generated Javadoc
/**
 * The Class ExpedirTest.
 */
@Listeners({ TestListener.class })
@Epic("Expedir")
@Feature("Expedir Test")

public class ExpedirTest extends BaseTest {
	
	/** The fileprops. */
	public Properties fileprops = new Properties();

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 * @throws Exception the exception
	 */
	//RUTAS DE LAS PROPIEDADES Y SU ASOCIACION AL FILEINPUTSTREAM
	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Gestion.properties").getAbsolutePath()));
		return fileprops;
	}
	
	/** The recording. */
	//INSTANCIA DE MY SCREEN RECORDER(GRABACION DE PANTALLA)
	MyScreenRecorder recording;


	
	
	/**
	 * Login.
	 *
	 * @param nameTest the name test
	 * @param usuario the usuario
	 * @param contrasena the contrasena
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	//METODO UNIVERSAL DE LOGIN (APLICA PARA TODOS LOS TEST SIN IMPORTAR CUAL)
	public void login(String nameTest, String usuario, String contrasena,String Evidencia) throws Exception {
		
		//INSTANCIA DE GENERACION DE PDF
		//CONDICIONAL DE GENERACION DE EVIDENCIA
		 
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.createTemplate(folderPath, nameTest, getProperties().getProperty("analista"),
				getProperties().getProperty("urlPrivada"),getProperties().getProperty("Evidencia"));

		GenerarReportePdf.setImgContador(0);
		
		
		//LLAMADO DE LA URL DE PAGINA
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("url"));
		login.privacidadIp();
		home.irPortal(getProperties().getProperty("urlPrivada"));
		login.ingresarCredenciales(getProperties().getProperty("usuario2"), getProperties().getProperty("password"), folderPath,
				getProperties().getProperty("Evidencia"));
		
	
		 
	}
	
	//Creacion de titulo con las areas como poliza o bono 

	/**
	 * Crear expedir.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 0, description = "Crear expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Creación de expedir")
	public void crearExpedir() throws Exception {
		
		String Evidencia = getProperties().getProperty("Evidencia");
		
		
		//SE EXPLICA UNA SOLA VEZ ESTO PORQUE SE REPITE HASTA LA SACIEDAD, ESTAS LINEAS DE CODIGO LLAMAN LA RUTA EN DONDE SE VA A ALMACENAR LA EVIDENCIA
		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
		
		//LO MISMO ESTA LINEA LLAMA AL METODO DE INICIAR GRABACION DE PANTALLA
		recording.startRecording("grabacion de pantalla o screen recording ", folderPath);
		
		//ESTE LOGIN IGUAL EN TODO TEST SE REPETIRA HASTA LA SACIEDAD EL LOGIN SE ENCARGA DE ENVIARLE LAS CREDENCIALES DE ACCESO DESDE EL PROPERTIES A LA PAGINA 
		login(getProperties().getProperty("nameTestCrearExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		//IGUAL ESTE MECANISMO DE HOME LO QUE HACE ES LLAMAR EL MODULO Y SUBMODULO DE LA PAGINA QUE VAMOS A UTILIZAR 
		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"),getProperties().getProperty("Evidencia"));

		//
		//LLamado del objeto o instancia del pags objet con los metodos en este caso el de crear expedir,bono, poliza etc
		expedir 		
		
		.crearExpedir(folderPath, null, null, null, getProperties().getProperty("informacionGeneralE"),getProperties().getProperty("Evidencia"))

		
		.bono(folderPath, getProperties().getProperty("bono"), getProperties().getProperty("nitB"), getProperties().getProperty("nitBono"),
		getProperties().getProperty("diasPlazo"),getProperties().getProperty("Evidencia"))
		
		/*.certificado(folderPath, getProperties().getProperty("certificado"),
				getProperties().getProperty("nitCertificado"), getProperties().getProperty("nitCerti"),
				getProperties().getProperty("tipoEndosoP"))*/

		
		//EJECUCION DE CASOS		
		.poliza_547049(folderPath, getProperties().getProperty("polizaE"),getProperties().getProperty("Evidencia"))
		
		
		.plazos(folderPath, 
				getProperties().getProperty("plazosE"), 
				getProperties().getProperty("diasPlazo"), 
				getProperties().getProperty("diasPlazo"),
				getProperties().getProperty("Evidencia"))

		
		.tipoMercancia(folderPath, 
				getProperties().getProperty("tipoMercanciaE"),
				getProperties().getProperty("Evidencia"))
		
		.mercanciasIndividual(folderPath, getProperties().getProperty("mercanciasE"), getProperties().getProperty("cargueI"),getProperties().getProperty("Evidencia"))
		
		.tarifas(folderPath, getProperties().getProperty("tarifasE"),getProperties().getProperty("Evidencia"))
		
		.guardarExpedir(folderPath,getProperties().getProperty("Evidencia"));

		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		recording.stopRecording();
		
		//AL IGUAL QUE EN LOS DEMAS TEST ESTE CIERRA EL PDF O REPORTE 
				
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}
	
	/**
	 * Lpn dtlnum 1.
	 *
	 * @throws Exception the exception
	 */
	//Ejecucion de test con base de datos
	@Test(priority = 1, description = "BaseDatos")
    @Severity(SeverityLevel.NORMAL)
    @Description("BaseDatos")
    @Story("BaseDatos")
    public void LpnDtlnum1() throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
		
        //CONSULTA DE BASE DE DATOS GENERADA EN UN ARRAY LIST
        ArrayList<Object> consultaPruebaBD = consultaBD("SELECT "
                +getProperties().getProperty("campoIv.lodnum")+","
                +getProperties().getProperty("campoIh.dtlnum")+","
                +getProperties().getProperty("campoIv.prtnum")+","
                +getProperties().getProperty("campoIv.untqty")
                +" FROM "+getProperties().getProperty("tablaInvhld")
                +" INNER JOIN "+getProperties().getProperty("tablaInventory_view")+" on "+getProperties().getProperty("tablaIh.dtlnum")
                +" = "+getProperties().getProperty("campoIv.dtlnum")
                +" INNER JOIN "+getProperties().getProperty("tablaClient_grp_client")+" on "+getProperties().getProperty("tablaIv.prt_client_id")
                +" = "+getProperties().getProperty("campoCgc.client_id")
                +" WHERE "+getProperties().getProperty("campoIh.wh_id")+" = '"+getProperties().getProperty("num1")+"'"
                +" AND "+getProperties().getProperty("campoIh.hldnum")+" = '"+getProperties().getProperty("num2")+"'"
                +" AND "+getProperties().getProperty("campoCgc.client_grp")+" = '"+getProperties().getProperty("num3")+"'"
                           
				);
		
        //SE GUARDAN LOS RESULADOS EN UNA VARIABLE DE TIPO STRING Y SE CONVIERTE A STRING MEDIANTE EL TO STRING 
		String dataBDD = consultaPruebaBD.toString();
		 
		System.out.print(dataBDD);
		
		
		
		/*
		ArrayList<Object> consultaPruebaBD2 = consultaBD2("SELECT "
				+" FROM "+getProperties().getProperty("tbl_Mercancias_wms")
				+" WHERE "+getProperties().getProperty("campoMwms_id_titulo")+" = '"+getProperties().getProperty("num4")+"'"
				
				);
		
		String dataBDD2 = consultaPruebaBD2.toString();
		
		System.out.print(dataBDD2);
		*/
		

        login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
                getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));
        //METODO DE INGRESO A MODULO Y SUBMODULO
        home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));
        //EJECUCION DE CASOS
        expedir.LpnDtlnumCoincidan1(folderPath, getProperties().getProperty("TipoDeBodega"), getProperties().getProperty("estadoA"),
        		getProperties().getProperty("Mercancias"),getProperties().getProperty("Lista"),getProperties().getProperty("Lpm"),dataBDD + " Datos LPN de la base de datos",
        		getProperties().getProperty("SubModuloExpedir"),//dataBDD2 + " Datos LPN de la base de datos",
        		getProperties().getProperty("Lista1"),getProperties().getProperty("Evidencia"));
        
       

        GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));

	}
	
	
	
	
	/**
	 * Modificar expedir.
	 *
	 * @throws Exception the exception
	 */
	//Ejecucion del metodo mercancia generica
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void modificarExpedir() throws Exception {

		//INSTANCIA DE LA RUTA DONDE SE GUARDA LA EVIDENCIA
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		//METODO DE LOGIN DE LA PAGINA
		login(getProperties().getProperty("nameTestModificarExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));

		expedir.modificarExpedir(folderPath, getProperties().getProperty("tituloEditar"), 
				getProperties().getProperty("polizaE"), getProperties().getProperty("tipoMercanciaE"),getProperties().getProperty("Evidencia"))  
		
		//Ejecucion de caso
		.MercanciaGenerica(folderPath, getProperties().getProperty("nitExpedir"),
				getProperties().getProperty("descripcion"), getProperties().getProperty("tipoMercanciaE"), 
				getProperties().getProperty("SubModuloExpedir"), getProperties().getProperty("Titulobonoprenda"),
				getProperties().getProperty("Evidencia"));
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}
	
	/**
	 * Cargue bodega.
	 *
	 * @throws Exception the exception
	 */
	//Se ejecuta el metodo de bodega de cargue 
	@Test(priority = 1, description = "Validacion")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir,cargue de archivo")
	@Story("Modificación de expedir")
	public void CargueBodega() throws Exception {
		
		//INSTANCIA DE LA RUTA DONDE SE GUARDA LA EVIDENCIA
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));


		login(getProperties().getProperty("CargueBodegaPropio"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloC"), getProperties().getProperty("SubmoduloC"),getProperties().getProperty("Evidencia"));
		
		//Ejecucion de caso
		expedir.BodegaCargue(folderPath, getProperties().getProperty("NitClienteAsociado"),getProperties().getProperty("Mercancias"),
				getProperties().getProperty("Evidencia"));
		
		
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
		
	}
	
	  
	
	/**
	 * Cargue validacion.
	 *
	 * @param Video the video
	 * @param Evidencia the evidencia
	 * @throws Exception the exception
	 */
	//Ejecucion de la validacion de expedicion
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir,validacion de cargue de archivos")
	@Story("Modificación de expedir")
	public void CargueValidacion(String Video,String Evidencia) throws Exception {
		
		
		//Evidencia
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		
			
		{	
		
		
		//LO MISMO ESTA LINEA LLAMA AL METODO DE INICIAR GRABACION DE PANTALLA
				//Traer el if de evidencia y video
				//CONDICIONAL DE CREAR VIDEO
				if(Video.equals("SI"))
				{
				recording.startRecording("", folderPath);
				} else 
				
		
		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloC"), getProperties().getProperty("SeccionG"),getProperties().getProperty("Evidencia"));
		
		//SE DEBE ENTENDER QUE LO QUE SE HACE ES LLAMAR LA INSTANCIA DE EXPEDIR Y SE LLAMA EL METODO EN ESTE CASO VALIDACION EXPEDICION
		expedir.ValidacionExpedicion_542372(folderPath, getProperties().getProperty("NitClienteAsociado"),getProperties().getProperty("TipoDato"),
				getProperties().getProperty("InformacionGeneral"), getProperties().getProperty("DetalleMercancia"), getProperties().getProperty("Plazo"), 
				getProperties().getProperty("Poliza"), getProperties().getProperty("TipodeMercancia"),
				getProperties().getProperty("Mercancias"),
				getProperties().getProperty("Route"),getProperties().getProperty("RouteA"),getProperties().getProperty("RouteB"), 
				getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("TipoBodega"),
				getProperties().getProperty("ValorBuscado"),getProperties().getProperty("RouteC"),getProperties().getProperty("Evidencia"));
		
		//Evidencia
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));

		}

		
				
	
			
			
			
				
	}
	
	


	
	//recording.startRecording("", folderPath);
	//recording.stopRecording();
	//login.cerrarSesion(folderPath);
	
	
	
	//VALIDACIONES DE SEGUNDA HISTORIA DE USUARIO SOBRE LIBERACIONES Y EXPEDICIONES
	
	/**
	 * Validacion cancelado.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Validacion de titulos cancelados")
	public void ValidacionCancelado() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		recording.startRecording("", folderPath);
		
		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));
		
		expedir
		
		//EJECUCION DE CANCELAR EXPEDIR
		.ExpedirCancelar(folderPath, getProperties().getProperty("TituloCancelado"), 
				getProperties().getProperty("Mercancias"),getProperties().getProperty("EstadoC"), 
				getProperties().getProperty("CantInicial"),getProperties().getProperty("CantActual"),getProperties().getProperty("Evidencia"))
		
		//EJECUCIONES DE LOS METODOS OPERACION DE TITULO Y AUTORIZACION LIBERACION
		.OperacionTitulo_552036(folderPath, getProperties().getProperty("TituloGrabado"), 
		getProperties().getProperty("informacionGeneralE"), getProperties().getProperty("PersonaJuridica"),
		getProperties().getProperty("informacionG"),getProperties().getProperty("TituloHistorico"),getProperties().getProperty("Evidencia"))
		
		//Ejecucion de caso
		.AutorizacionLiberacion_548143(folderPath, 
				getProperties().getProperty("TituloConLiberacionesPendientes"), 
				getProperties().getProperty("informacionGeneralE"),
				getProperties().getProperty("PersonaJuridica"), 
				getProperties().getProperty("informacionG"), 
				getProperties().getProperty("SubModuloAutorizar"),
				getProperties().getProperty("AutoriPend"),
				getProperties().getProperty("DetalleMercancia")
				,getProperties().getProperty("Evidencia"));
		
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}
	
	
	
	/**
	 * Validacion liberado.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Validacion de liberacion")
	public void ValidacionLiberado() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));


		recording.startRecording("", folderPath);
		
		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloLiberacion"),getProperties().getProperty("Evidencia"));
	
		
		
		//VALIDACION DE LIBERACION/EJEUCION DE CASO
		expedir.ValidacionLiberacion_543826(folderPath, getProperties().getProperty("TituloLiberacion"), 
				getProperties().getProperty("Detalle"),getProperties().getProperty("EstadoC"), 
				getProperties().getProperty("CantInicial"), getProperties().getProperty("CantActual"),
				getProperties().getProperty("LiberarCantidad"),getProperties().getProperty("Sinicial"),getProperties().getProperty("TituloHistorico"),
				getProperties().getProperty("TituloLiberacionInicial"),getProperties().getProperty("Mercancias"),getProperties().getProperty("Evidencia"));
		
		
				expedir.ValidacionExpedirDivisionIngresos_554006(folderPath, getProperties().getProperty("TituloLiberacion"), 
						getProperties().getProperty("Detalle"),getProperties().getProperty("EstadoC"), 
						getProperties().getProperty("CantInicial"), getProperties().getProperty("CantActual"),
						getProperties().getProperty("LiberarCantidad"),getProperties().getProperty("Sinicial"),getProperties().getProperty("TituloHistorico"));
				
				
				
				
				expedir.ValidacionExpedirDivisionIngresos_571351(folderPath, getProperties().getProperty("TituloLiberacion"), 
						getProperties().getProperty("Detalle"),getProperties().getProperty("EstadoC"), 
						getProperties().getProperty("CantInicial"), getProperties().getProperty("CantActual"),
						getProperties().getProperty("LiberarCantidad"),getProperties().getProperty("Sinicial"),getProperties().getProperty("TituloHistorico"));
				
				
				expedir.ValidacionExpedirDivisionIngresos_571360(folderPath, getProperties().getProperty("TituloLiberacion"), 
						getProperties().getProperty("Detalle"),getProperties().getProperty("EstadoC"), 
						getProperties().getProperty("CantInicial"), getProperties().getProperty("CantActual"),
						getProperties().getProperty("LiberarCantidad"),getProperties().getProperty("Sinicial"),getProperties().getProperty("TituloHistorico"));
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}
	
	
	
	
	
	/**
	 * Validacion liberado.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Validacion de liberacion")
	public void ValidacionLiberadoScav() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia2"));


		recording.startRecording("", folderPath);
		
		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia2"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloLiberacion"),getProperties().getProperty("Evidencia2"));
	
		
		
		//VALIDACION DE LIBERACION/EJEUCION DE CASO
		expedir.LiberacionesScav_571785(folderPath, 
				getProperties().getProperty("TituloScav"),
				getProperties().getProperty("FicheroLiberaciones"),
				getProperties().getProperty("ValorGrillaCupo"), 
				getProperties().getProperty("valorGrillaCupo2"),
				getProperties().getProperty("valorGrillaCupo3"), 
				getProperties().getProperty("valorGrillaCupo7"), 
				getProperties().getProperty("ValorGrillaTipoTitulo"), 
				getProperties().getProperty("ValorGrillaNumeroTitulo"),
				getProperties().getProperty("ValorGrillaLiberacion1"), 
				getProperties().getProperty("ValorGrillaLiberacion2"), 
				getProperties().getProperty("Evidencia2"));
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia2"));
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia2"));
	}

	
	
	
	
	
	
	
	
	/**
	 * Validacion mercancia liberada.
	 *
	 * @throws Exception the exception
	 */
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validacion de mercancias liberadas")
	@Story("Validacion de mercancias liberadas")
	public void ValidacionMercanciaLiberada() throws Exception {
		
		//Instancia de ruta de carpeta
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		//login a almaviva
		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		//Ingreso a modulo y submodulo
		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloLiberacion"),getProperties().getProperty("Evidencia"));
		
		//Ejecucion de caso
		expedir.ObjetoPresente(folderPath, getProperties().getProperty("TituloaLiberar"), 
				getProperties().getProperty("Detalle"),getProperties().getProperty("Evidencia"));
		

		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
		
	}
	

	
	/**
	 * Validacion titulo liberado.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validaciones de un titulo liberado")
	@Story("Validaciones de un titulo liberado")
	public void ValidacionTituloLiberado() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		recording.startRecording("", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));

		//Ejecucion de caso
		expedir.ValidacionMercanciaLiberada(folderPath, getProperties().getProperty("TituloLiberado"), 
				getProperties().getProperty("Detalle"),getProperties().getProperty("CantInicial"),
				getProperties().getProperty("CantActual"),getProperties().getProperty("TituloCancelado"),
				getProperties().getProperty("Evidencia"))
		
		//Ejecucion de caso
		.UsuarioAplicador_554763(folderPath, 
				getProperties().getProperty("usuario2"), getProperties().getProperty("ModuloT"), 
				getProperties().getProperty("SubModuloExpedir"), getProperties().getProperty("titulograbado"), getProperties().getProperty("infogeneraltitulo"), 
				getProperties().getProperty("lblbonoprenda"), getProperties().getProperty("LapsoTiempo"), getProperties().getProperty("TituloNoEditable"), 
				getProperties().getProperty("aplicador"), getProperties().getProperty("SeccionPerfil"), getProperties().getProperty("UsuarioAplicador"),
				getProperties().getProperty("Evidencia"));
		
		//
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
		
	}
	
	
	
	
	
	
	
	/**
	 * Busqueda expedir.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 2, description = "Consultar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Consulta de expedir")
	public void busquedaExpedir() throws Exception {

		//Instancia de metodo de crear carpeta o folder de destino de evidencias
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
		
		//Instancia de metodo de grabar video
		recording.startRecording("", folderPath);

		//Login a la pagina de almaviva
		login(getProperties().getProperty("nameTestConsultarExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		//Instancia de metodo para interactuar con modulos
		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));
		
		//Instancia de metodo scav
		expedir.ValidacionScav_571761(folderPath, getProperties().getProperty("valorGrillaCupo2"), getProperties().getProperty("ValorGrillaCupo3"), 
				getProperties().getProperty("ValorGrillaCupo7"), getProperties().getProperty("ValorGrillaTipoTitulo"), getProperties().getProperty("ValorGrillaCupo8"), 
				getProperties().getProperty("Evidencia"));
		
		//cierre de sesion y video y informe
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		
		recording.stopRecording();
		//Ejecucion de caso
		//expedir.imprimir(folderPath, getProperties().getProperty("tituloBuscar"),getProperties().getProperty("Evidencia"));
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}
	
	/**
	 * Ver expedir.
	 * para ejecucion de prueba
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 3, description = "Ver expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Detalle de expedir")
	public void verExpedir() throws Exception {

		
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));
		
		//Instancia de metodo de grabar video
		recording.startRecording("", folderPath);

		login(getProperties().getProperty("nameTestVerExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),
				getProperties().getProperty("Evidencia"));

		//Ejecucion de caso
		expedir.verExpedir(folderPath,getProperties().getProperty("Evidencia"));
		
		//cierre de sesion y video y informe
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
				
				
		recording.stopRecording();
		// Validaciones de historico de liberaciones 
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}
	
	
	
	/**
	 * Ver expedir.
	 * para ejecucion de prueba
	 * @throws Exception the exception
	 */
	@Test(priority = 3, description = "Ver expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Detalle de expedir")
	public void ProrrogaScav() throws Exception {

		
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		login(getProperties().getProperty("nameTestVerExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("Prorroga"),
				getProperties().getProperty("Evidencia"));

		//Ejecucion de caso
		expedir.ProrrogaScav_573824(folderPath, getProperties().getProperty("TituloScav"), getProperties().getProperty("FicheroUnico"), 
				getProperties().getProperty("ValorGrillaCupo"), getProperties().getProperty("valorGrillaCupo2"), getProperties().getProperty("valorGrillaCupo3"),
				getProperties().getProperty("valorGrillaCupo7"), getProperties().getProperty("ValorGrillaTipoTitulo"), getProperties().getProperty("ValorGrillaNumeroTitulo")
				,getProperties().getProperty("Evidencia"));
		
		
		
	
		
		// Validaciones de historico de liberaciones 
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}

	
	
	
	/**
	 * Validacion histortico liberacion.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionHistorticoLiberacion() throws Exception {
		
		
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		
		recording.startRecording("Inicia grabacion de pantalla", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),
				getProperties().getProperty("Evidencia"));
		
		//Ejecucion de caso
		expedir.ValidacionHistorico_546943(folderPath, getProperties().getProperty("TituloHistorico"),getProperties().getProperty("DetalleMercancia"),getProperties().getProperty("EstadoC"),
				getProperties().getProperty("Mercancias"),
				getProperties().getProperty("ValidarVisualizacionLiberacion"),
				getProperties().getProperty("etiquetaPoliza"),
				getProperties().getProperty("poliza"), getProperties().getProperty("TituloEjemplo"),
				getProperties().getProperty("TituloIncompleto"),
				getProperties().getProperty("CantInicial"),
				getProperties().getProperty("CantActual"),
				getProperties().getProperty("LiberarCantidad"),
				getProperties().getProperty("Sinicial"),
				getProperties().getProperty("TituloCancelado"), 
				getProperties().getProperty("Producto"),
				getProperties().getProperty("Evidencia"));

		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		
		
		recording.stopRecording();
		GenerarReportePdf.closeTemplate("Cierre reporte pdf",getProperties().getProperty("Evidencia"));
	}
	
	
	//recording.startRecording("", folderPath);
		//recording.stopRecording();
		//login.cerrarSesion(folderPath);
		
	
	
	//HU_24
	

	/**
	 * Validacion modificacion prorroga.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de prorroga y validacion")
	public void ValidacionModificacionProrroga() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		
		recording.startRecording("", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), 
				getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));
		
		//Ejecucion de caso
		expedir.ProrrogasModificacion_546952(folderPath, getProperties().getProperty("TituloModificarProrroga"),
				getProperties().getProperty("SeccionP"),
				getProperties().getProperty("estadoA"),getProperties().getProperty("ValorProrroga"),getProperties().getProperty("Evidencia"));
		
		//estadoA
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}
	
	
	
	
	
	/**
	 * Reversiondetitulos.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void Reversiondetitulos() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		
		recording.startRecording("", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloReversarLiberacion"),getProperties().getProperty("Evidencia"));
		
		
		//Generador de titulos automatico
		
		
		creaciontitulos.ValidacionExpedirFormulario(folderPath, 
				getProperties().getProperty("Empresa2"),
				getProperties().getProperty("informacionGeneralE"),
				getProperties().getProperty("Titulo"),
				getProperties().getProperty("NumeroTitulo"),
				getProperties().getProperty("Plazos"), 
				getProperties().getProperty("etiquetaPoliza"),
				getProperties().getProperty("Tipomerca"), 
				getProperties().getProperty("Mercancias"), 
				getProperties().getProperty("tarifas"), 
				getProperties().getProperty("ingreso"), 
				getProperties().getProperty("aplicar"),
				getProperties().getProperty("FechaDeCargue"), 
				getProperties().getProperty("Evidencia"));
		
		
		
		creaciontitulos.ValidacionExpedirFormulario_554762(folderPath, 
				getProperties().getProperty("Empresa2"),
				getProperties().getProperty("informacionGeneralE"),
				getProperties().getProperty("Titulo"),
				getProperties().getProperty("NumeroTitulo"),
				getProperties().getProperty("Plazos"), 
				getProperties().getProperty("etiquetaPoliza"),
				getProperties().getProperty("Tipomerca"), 
				getProperties().getProperty("Mercancias"), 
				getProperties().getProperty("tarifas"), 
				getProperties().getProperty("ingreso"), 
				getProperties().getProperty("aplicar"),
				getProperties().getProperty("FechaDeCargue"), 
				getProperties().getProperty("Evidencia"));
		
		
		
		
		
		creaciontitulos.ValidacionExpedirFormulario_556552(folderPath, 
				getProperties().getProperty("Empresa2"),
				getProperties().getProperty("informacionGeneralE"),
				getProperties().getProperty("Titulo"),
				getProperties().getProperty("NumeroTitulo"),
				getProperties().getProperty("Plazos"), 
				getProperties().getProperty("etiquetaPoliza"),
				getProperties().getProperty("Tipomerca"), 
				getProperties().getProperty("Mercancias"), 
				getProperties().getProperty("tarifas"), 
				getProperties().getProperty("ingreso"), 
				getProperties().getProperty("aplicar"),
				getProperties().getProperty("FechaDeCargue"), 
				getProperties().getProperty("Evidencia"));
		
		//Ejecucion de caso
		
		expedir.ReversarLiberacion_558597(folderPath, 
				getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"), 
				getProperties().getProperty("estadoA"), getProperties().getProperty("infogeneraltitulo"),
				getProperties().getProperty("Evidencia"));
		
		
		
		
		//estadoA
		
		login.cerrarSesion(folderPath,getProperties().getProperty("Evidencia"));
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}


	
	
	//HU25
	
	/**
	 * Validacion HU 25.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionHU25() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		
		recording.startRecording("", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("Evidencia"));
		
		//Ejecucion de caso
		expedir.UsuarioAdmin(folderPath, getProperties().getProperty("etiquetaPoliza"), getProperties().getProperty("poliza"),
				getProperties().getProperty("TituloHistorico"),getProperties().getProperty("SeccionA"),
				getProperties().getProperty("usuario2"),getProperties().getProperty("TituloEjemplo"),getProperties().getProperty("TituloIncompleto"),
				getProperties().getProperty("Mercancias"),getProperties().getProperty("ModuloS"),getProperties().getProperty("Evidencia"));
		
		
		//login.cerrarSesion(folderPath);
		
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}

	
	

	
	/**
	 * Validacion modificacionusuarioadmin.
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionModificacionusuarioadmin() throws Exception {
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));

		recording.startRecording("", folderPath);
		
		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloS"), getProperties().getProperty("SeccionA"),getProperties().getProperty("Evidencia"));
		
		//EJECUCION DE USUARIO ADMINISTRADOR
		expedir.UsuarioEditarAdmin_545511(folderPath, getProperties().getProperty("usuario2"), getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),
				getProperties().getProperty("Titulobonoprenda"), getProperties().getProperty("infogeneraltitulo"), getProperties().getProperty("lblbonoprenda"), 
				getProperties().getProperty("LapsoTiempo"),getProperties().getProperty("TituloNoEditable"),
				getProperties().getProperty("TituloEstadoAnulado"), getProperties().getProperty("Mercancias"),
				getProperties().getProperty("tipoUser"),getProperties().getProperty("Evidencia"));
		
		
		//login.cerrarSesion(folderPath);
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}

	
	
	/**
	 * Run CP 05.
	 *
	 * @throws Exception the exception
	 */
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void RunCP05() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));


		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloS"), getProperties().getProperty("SeccionA"),getProperties().getProperty("Evidencia"));
		
		//EJECUCION DE HU05
		expedir.CP05(folderPath, getProperties().getProperty("usuario2"), getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),
				getProperties().getProperty("Titulobonoprenda"), getProperties().getProperty("infogeneraltitulo"), getProperties().getProperty("lblbonoprenda"), 
				getProperties().getProperty("LapsoTiempo"),getProperties().getProperty("Titulouseradmin"),getProperties().getProperty("Evidencia"));
		
		
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}

	/**
	 * Run CP 08.
	 *
	 * @throws Exception the exception
	 */
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void RunCP08() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"),getProperties().getProperty("Evidencia"));


		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"),getProperties().getProperty("Evidencia"));

		home.modulo(folderPath, getProperties().getProperty("ModuloS"), getProperties().getProperty("SeccionA"),getProperties().getProperty("Evidencia"));
		
		//EJECUCION DE HU08
		expedir.CP08(folderPath, getProperties().getProperty("usuario2"), 
				getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"), 
				getProperties().getProperty("TituloNoEditable"), getProperties().getProperty("Prorroga"),
				getProperties().getProperty("lblbonoprenda"), getProperties().getProperty("LapsoTiempo"),
				getProperties().getProperty("infogeneraltitulo"),getProperties().getProperty("Mercancias"),
				getProperties().getProperty("Evidencia") );  
		
		
		GenerarReportePdf.closeTemplate("",getProperties().getProperty("Evidencia"));
	}


	
	
	
	
	
	
	
	
	
}