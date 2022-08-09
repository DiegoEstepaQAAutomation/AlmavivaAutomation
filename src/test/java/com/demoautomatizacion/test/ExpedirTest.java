
package com.demoautomatizacion.test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Titulo.Pages.CreacionTitulos;
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
@Epic("Expedir")
@Feature("Expedir Test")

public class ExpedirTest extends BaseTest {
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Titulo.properties").getAbsolutePath()));
		fileprops.load(new FileInputStream(new File("src/test/resources/Gestion.properties").getAbsolutePath()));
		return fileprops;
	}
	
	MyScreenRecorder recording;


	
	

	public void login(String nameTest, String usuario, String contrasena) throws Exception {

		GenerarReportePdf.setRutaImagen(getProperties().getProperty("routeImageReport"));
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
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

	@SuppressWarnings("static-access")
	@Test(priority = 0, description = "Crear expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Creación de expedir")
	public void crearExpedir() throws Exception {
		
		

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		recording.startRecording("", folderPath);
		
		login(getProperties().getProperty("nameTestCrearExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("Modulo"), getProperties().getProperty("SubModuloC"));

		expedir 		
		
		.crearExpedir(folderPath, null, null, null, getProperties().getProperty("informacionGeneralE"))

		
		.bono(folderPath, getProperties().getProperty("bono"), getProperties().getProperty("nitB"), getProperties().getProperty("nitBono"),
		getProperties().getProperty("diasPlazo"))
		
		/*.certificado(folderPath, getProperties().getProperty("certificado"),
				getProperties().getProperty("nitCertificado"), getProperties().getProperty("nitCerti"),
				getProperties().getProperty("tipoEndosoP"))*/

		
				
		.poliza_547049(folderPath, getProperties().getProperty("polizaE"))
		
		
		.plazos(folderPath, getProperties().getProperty("plazosE"), getProperties().getProperty("diasPlazo"), getProperties().getProperty("diasPlazo"))

		
		.tipoMercancia(folderPath, getProperties().getProperty("tipoMercanciaE"))
		
		.mercanciasIndividual(folderPath, getProperties().getProperty("mercanciasE"), getProperties().getProperty("cargueI"))
		
		.tarifas(folderPath, getProperties().getProperty("tarifasE"))
		
		.guardarExpedir(folderPath);

		login.cerrarSesion(folderPath);
		
		recording.stopRecording();
				
		GenerarReportePdf.closeTemplate("");
	}
	
	
	
	
	
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void modificarExpedir() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestModificarExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));

		expedir.modificarExpedir(folderPath, getProperties().getProperty("tituloEditar"), 
				getProperties().getProperty("polizaE"), getProperties().getProperty("tipoMercanciaE"))  
		
		
		.MercanciaGenerica(folderPath, getProperties().getProperty("nitExpedir"),
				getProperties().getProperty("descripcion"), getProperties().getProperty("tipoMercanciaE"), 
				getProperties().getProperty("SubModuloExpedir"), getProperties().getProperty("Titulobonoprenda"));
		
		GenerarReportePdf.closeTemplate("");
	}
	
	
	@Test(priority = 1, description = "Validacion")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void CargueBodega() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("CargueBodegaPropio"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloC"), getProperties().getProperty("SubmoduloC"));
		
		
		expedir.BodegaCargue(folderPath, getProperties().getProperty("NitClienteAsociado"),getProperties().getProperty("Mercancias"));
		
		
		
		login.cerrarSesion(folderPath);
		
		GenerarReportePdf.closeTemplate("");
		
	}
	
	
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void CargueValidacion() throws Exception {
		
		
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));
		
		recording.startRecording("", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloC"), getProperties().getProperty("SeccionG"));
		

		expedir.ValidacionExpedicion_542372(folderPath, getProperties().getProperty("NitClienteAsociado"),getProperties().getProperty("TipoDato"),
				getProperties().getProperty("InformacionGeneral"), getProperties().getProperty("DetalleMercancia"), getProperties().getProperty("Plazo"), 
				getProperties().getProperty("Poliza"), getProperties().getProperty("TipodeMercancia"),
				getProperties().getProperty("Mercancias"),
				getProperties().getProperty("Route"),getProperties().getProperty("RouteA"),getProperties().getProperty("RouteB"), 
				getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),getProperties().getProperty("TipoBodega"),
				getProperties().getProperty("ValorBuscado"),getProperties().getProperty("RouteC"));
		
		login.cerrarSesion(folderPath);
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("");
		
	}

	
	//recording.startRecording("", folderPath);
	//recording.stopRecording();
	//login.cerrarSesion(folderPath);
	
	
	
	//VALIDACIONES DE SEGUNDA HISTORIA DE USUARIO SOBRE LIBERACIONES Y EXPEDICIONES
	
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionCancelado() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		recording.startRecording("", folderPath);
		
		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));
		
		expedir
		
		.ExpedirCancelar(folderPath, getProperties().getProperty("TituloCancelado"), 
				getProperties().getProperty("Mercancias"),getProperties().getProperty("EstadoC"), 
				getProperties().getProperty("CantInicial"),getProperties().getProperty("CantActual"))
		
		.OperacionTitulo_552036(folderPath, getProperties().getProperty("TituloGrabado"), 
		getProperties().getProperty("informacionGeneralE"), getProperties().getProperty("PersonaJuridica"),
		getProperties().getProperty("informacionG"),getProperties().getProperty("TituloHistorico"))
		
		
		.AutorizacionLiberacion_548143(folderPath, 
				getProperties().getProperty("TituloConLiberacionesPendientes"), 
				getProperties().getProperty("informacionGeneralE"),
				getProperties().getProperty("PersonaJuridica"), 
				getProperties().getProperty("informacionG"), 
				getProperties().getProperty("SubModuloAutorizar"),
				getProperties().getProperty("AutoriPend"),
				getProperties().getProperty("DetalleMercancia"));
		
		
		login.cerrarSesion(folderPath);
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("");
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionLiberado() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		recording.startRecording("", folderPath);
		
		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloLiberacion"));
	
		expedir.ValidacionLiberacion_543826(folderPath, getProperties().getProperty("TituloLiberacion"), 
				getProperties().getProperty("Detalle"),getProperties().getProperty("EstadoC"), 
				getProperties().getProperty("CantInicial"), getProperties().getProperty("CantActual"),
				getProperties().getProperty("LiberarCantidad"),getProperties().getProperty("Sinicial"),getProperties().getProperty("TituloHistorico"),
				getProperties().getProperty("TituloLiberacionInicial"),getProperties().getProperty("Mercancias"));
		
		login.cerrarSesion(folderPath);
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("");
	}
	
	
	
	
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionMercanciaLiberada() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloLiberacion"));
		
		expedir.ObjetoPresente(folderPath, getProperties().getProperty("TituloaLiberar"), getProperties().getProperty("Detalle"));
		

		GenerarReportePdf.closeTemplate("");
		
	}
	

	
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionTituloLiberado() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));

		
		expedir.ValidacionMercanciaLiberada(folderPath, getProperties().getProperty("TituloLiberado"), 
				getProperties().getProperty("Detalle"),getProperties().getProperty("CantInicial"),
				getProperties().getProperty("CantActual"),getProperties().getProperty("TituloCancelado"));
		
		//
		
		GenerarReportePdf.closeTemplate("");
		
	}
	
	
	
	
	
	
	
	@Test(priority = 2, description = "Consultar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Consulta de expedir")
	public void busquedaExpedir() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestConsultarExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));

		expedir.imprimir(folderPath, getProperties().getProperty("tituloBuscar"));
		
		GenerarReportePdf.closeTemplate("");
	}
	
	@Test(priority = 3, description = "Ver expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Detalle de expedir")
	public void verExpedir() throws Exception {

		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("nameTestVerExpedir"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));

		expedir.verExpedir(folderPath);
		
		// Validaciones de historico de liberaciones 
		
		GenerarReportePdf.closeTemplate("");
	}
	
	
	
	
	
	
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionHistorticoLiberacion() throws Exception {
		
		
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));
		
		recording.startRecording("", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));
		
		
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
				getProperties().getProperty("Producto"));

		login.cerrarSesion(folderPath);
		
		
		
		recording.stopRecording();
		GenerarReportePdf.closeTemplate("");
	}
	
	
	//recording.startRecording("", folderPath);
		//recording.stopRecording();
		//login.cerrarSesion(folderPath);
		
	
	
	//HU_24
	

	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionModificacionProrroga() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));
		
		recording.startRecording("", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));
		
		
		expedir.ProrrogasModificacion_546952(folderPath, getProperties().getProperty("TituloModificarProrroga"),
				getProperties().getProperty("SeccionP"),getProperties().getProperty("estadoA"),getProperties().getProperty("ValorProrroga"));
		
		//estadoA
		
		login.cerrarSesion(folderPath);
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("");
	}

	
	
	//HU25
	
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionHU25() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));
		
		recording.startRecording("", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));
		
		
		expedir.UsuarioAdmin(folderPath, getProperties().getProperty("etiquetaPoliza"), getProperties().getProperty("poliza"),
				getProperties().getProperty("TituloHistorico"),getProperties().getProperty("SeccionA"),
				getProperties().getProperty("usuario2"),getProperties().getProperty("TituloEjemplo"),getProperties().getProperty("TituloIncompleto"),
				getProperties().getProperty("Mercancias"),getProperties().getProperty("ModuloS"));
		
		
		//login.cerrarSesion(folderPath);
		
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("");
	}

	
	

	
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionModificacionusuarioadmin() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));
		
		recording.startRecording("", folderPath);
		
		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloS"), getProperties().getProperty("SeccionA"));
		
		
		expedir.UsuarioEditarAdmin_545511(folderPath, getProperties().getProperty("usuario2"), getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),
				getProperties().getProperty("Titulobonoprenda"), getProperties().getProperty("infogeneraltitulo"), getProperties().getProperty("lblbonoprenda"), 
				getProperties().getProperty("LapsoTiempo"),getProperties().getProperty("TituloNoEditable"),
				getProperties().getProperty("TituloEstadoAnulado"), getProperties().getProperty("Mercancias"),
				getProperties().getProperty("tipoUser"));
		
		
		//login.cerrarSesion(folderPath);
		
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("");
	}

	
	
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void RunCP05() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloS"), getProperties().getProperty("SeccionA"));
		
		
		expedir.CP05(folderPath, getProperties().getProperty("usuario2"), getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"),
				getProperties().getProperty("Titulobonoprenda"), getProperties().getProperty("infogeneraltitulo"), getProperties().getProperty("lblbonoprenda"), 
				getProperties().getProperty("LapsoTiempo"),getProperties().getProperty("Titulouseradmin"));
		
		
		
		GenerarReportePdf.closeTemplate("");
	}

	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void RunCP08() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloS"), getProperties().getProperty("SeccionA"));
		
		
		expedir.CP08(folderPath, getProperties().getProperty("usuario2"), 
				getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"), 
				getProperties().getProperty("TituloNoEditable"), getProperties().getProperty("Prorroga"),
				getProperties().getProperty("lblbonoprenda"), getProperties().getProperty("LapsoTiempo"),
				getProperties().getProperty("infogeneraltitulo"),getProperties().getProperty("Mercancias"));  
		
		
		GenerarReportePdf.closeTemplate("");
	}
	/////HU16
	
	@Test(priority = 1, description = "Coincidir")
    @Severity(SeverityLevel.NORMAL)
    @Description("Coincidir")
    @Story("Coincidir")
    public void LpnDtlnum() throws Exception {

        File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
                getProperties().getProperty("path"));

        login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
                getProperties().getProperty("password"));

        home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));

        expedir.LpnDtlnumCoincidan(folderPath, getProperties().getProperty("TipoDeBodega"), getProperties().getProperty("estadoA"),
        		getProperties().getProperty("Mercancias"));
        

        GenerarReportePdf.closeTemplate("");

    }
	
	/////HU16 continuacion
	
	@Test(priority = 1, description = "BaseDatos")
    @Severity(SeverityLevel.NORMAL)
    @Description("BaseDatos")
    @Story("BaseDatos")
    public void LpnDtlnum1() throws Exception {

        File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
                getProperties().getProperty("path"));
        
        
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
                getProperties().getProperty("password"));

        home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));

        expedir.LpnDtlnumCoincidan1(folderPath, getProperties().getProperty("TipoDeBodega"), getProperties().getProperty("estadoA"),
        		getProperties().getProperty("Mercancias"),getProperties().getProperty("Lista"),getProperties().getProperty("Lpm"),dataBDD + " Datos LPN de la base de datos",
        		getProperties().getProperty("SubModuloExpedir"),//dataBDD2 + " Datos LPN de la base de datos",
        		getProperties().getProperty("Lista1"));
        
       

        GenerarReportePdf.closeTemplate("");

    }
	

	@Test(priority = 1, description = "BaseDatos")
    @Severity(SeverityLevel.NORMAL)
    @Description("BaseDatos")
    @Story("BaseDatos")
    public void PruebaBaseDatos(String nameTest) throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
                getProperties().getProperty("path"));
		
		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
	               getProperties().getProperty("password"));

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
		
		String Prueba = consultaPruebaBD.toString();
		 
		System.out.print(Prueba);
		
		GenerarReportePdf.closeTemplate("");
    }
	
	/*
	select
	iv.lodnum,
	        ih.dtlnum,
	        iv.prtnum,
	        iv.untqty
	   from invhld ih
	  inner join inventory_view iv on ih.dtlnum = iv.dtlnum
	  inner join client_grp_client cgc on iv.prt_client_id = cgc.client_id
	  where ih.wh_id = '1507101'
	    and ih.hldnum = '1726'
	    and cgc.client_grp = '9004625119';
       */
	
	
	@SuppressWarnings("static-access")
	@Test(priority = 1, description = "Modificar expedir")
	@Severity(SeverityLevel.NORMAL)
	@Description("Módulo Expedir")
	@Story("Modificación de expedir")
	public void ValidacionHU07() throws Exception {
		
		File folderPath = BasePage.createFolder(getProperties().getProperty("nameFolderE"),
				getProperties().getProperty("path"));
		
		recording.startRecording("", folderPath);

		login(getProperties().getProperty("TestCargue"), getProperties().getProperty("usuario2"),
				getProperties().getProperty("password"));

		home.modulo(folderPath, getProperties().getProperty("ModuloT"), getProperties().getProperty("SubModuloExpedir"));
		
	     
		expedir.ValidacionExpedirFormulario1_556552(folderPath, getProperties().getProperty("Empresa2"), 
				getProperties().getProperty("InfGTitulo"), getProperties().getProperty("NumeroTitulo"),
				getProperties().getProperty("SubModuloExpedir"));
				
				
		creaciontitulos.ValidacionExpedirFormulario(folderPath, getProperties().getProperty("Empresa2"), 
				getProperties().getProperty("InfGTitulo"),getProperties().getProperty("Titulo"),
				getProperties().getProperty("NumeroTitulo"),
				getProperties().getProperty("Plazo"), getProperties().getProperty("Poliza"),
				getProperties().getProperty("Tipomerca"), getProperties().getProperty("Mercancias"),
				getProperties().getProperty("tarifas"),getProperties().getProperty("ingreso"),
				getProperties().getProperty("OficnaExpedicion"),getProperties().getProperty("oficinaAlmacenamiento"),
				getProperties().getProperty("CodigoSapExp"),getProperties().getProperty("CodigoSapAlm"),
				getProperties().getProperty("aplicar"),getProperties().getProperty("SubModuloExpedir"));
				
		 	
		
		expedir.ValidacionExpedirDivisionIngresos(folderPath, getProperties().getProperty("InfGTitulo"), 
				getProperties().getProperty("ingreso"), getProperties().getProperty("aplicar"),
				getProperties().getProperty("SubModuloExpedir"), getProperties().getProperty("OficnaExpedicion"),
				getProperties().getProperty("oficinaAlmacenamiento"),getProperties().getProperty("estadoA"));
	    
		recording.stopRecording();
		
		GenerarReportePdf.closeTemplate("");
      }	
}