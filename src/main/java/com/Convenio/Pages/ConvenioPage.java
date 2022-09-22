package com.Convenio.Pages;

import org.openqa.selenium.WebDriver;

import java.io.File;

import org.openqa.selenium.By;

import com.ConvenioMap.java.ConvenioMap;
import com.Seguridad.Pages.UsuariosPage;
import com.demoautomatizacion.Pages.BasePage;

import io.qameta.allure.Step;

public class ConvenioPage extends ConvenioMap{

    
	
		public ConvenioPage(WebDriver driver) 
		{
		super(driver);
	}
	
	
		//PASO A PASO PARA VERIFICAR OBLIGATORIEDAD DE CAMPOS,INTERACCION CON CONVENIOS
		@Step("Obligatoriedad de campos")
		public ConvenioPage ConveniosConsulta_570452(File folderPath,String NitBusqueda,
				String ValorTabla,String ValorTabla2,String ValorTabla3,String EstadoLiquidacion,String Evidencia) throws Exception 
		{
			time(5);
			 //Se establece variable boolean de un localizador
		    boolean validarModulo = validarElemento(lblModuloC, 10);
		     //Se valida variable booleana
			ValidacionObjeto(validarModulo, "Caso 570373", folderPath,Evidencia);
			writeText(txtxpathRazonsocial, NitBusqueda, folderPath, "Busqueda de nit", Evidencia);
			time(5);
			
			 //Se establece variable boolean de un localizador
		    boolean validarAlertaSugerencia = validarElemento(FirstSugerency, 10);
		     //Se valida variable booleana
			ValidacionObjeto(validarAlertaSugerencia, "Caso 570421,570422,570422,570423", folderPath,Evidencia);
			click(FirstSugerency, folderPath, "Click en la primera sugerencia", Evidencia);
			
			 //Se establece variable boolean de un localizador
		    boolean validarAlertaConsulta = validarElemento(AlertaConsulta, 10);
		     //Se valida variable booleana
			ValidacionObjeto(validarAlertaConsulta, "Caso 570421,570373,570424", folderPath,Evidencia);
			//SELECCION DE ELEMENTOS NECESITADOS EN TABLA O GRILLA
			searchElementGrid(GridLiquidacion, ValorTabla, folderPath, "Caso 570438,570424,570425,570436,570437", Evidencia);
			searchElementGrid(GridLiquidacion, ValorTabla2, folderPath, "Caso 570438,570424,570425,570436,570437", Evidencia);
			searchElementGrid(GridLiquidacion, ValorTabla3, folderPath, "Caso 570438,570424,570425,570436,570437", Evidencia);
			click(btnLiquidacion, folderPath, "Click en boton de liquidacion,Caso 570433", Evidencia);
			time(5);
			//scrollElementH(folderPath, gridNecesario, "scroll necesario", Evidencia);
			searchElementGrid(gridLiquidacionTable, EstadoLiquidacion, folderPath, "Caso 570421,570424,570426,570443", Evidencia);
			click(gridLiquidacionTable, folderPath, "Click en grilla,", Evidencia);
			time(5);
			
			scrollElementV(folderPath, btnProcesar, "Scroll hasta boton procesar", Evidencia);
			//desplazarseVertical(0, 600);
			//time(5);
			click(btnProcesar, folderPath, "Click en grilla,", Evidencia);
			 //Se establece variable boolean de un localizador
		    boolean validarAlertaConsulta1 = validarElemento(AlertaConsulta, 10);
		     //Se valida variable booleana
			ValidacionObjeto(validarAlertaConsulta1, "Caso 570421,570373,570435,Caso 570434", folderPath,Evidencia);
			time(5);
			searchElementGrid(gridDetalle, "Servicios a Liquidar", folderPath, "Caso 570421,570424,570427,570429,570430,570454,570455", Evidencia);
			time(5);
			scrollElementH(folderPath, btnVisualizarLiquidacion, "Nos situamos en visualizar liberacion", Evidencia);
			click(btnVisualizarLiquidacion, folderPath, "click en visualizar", Evidencia);
			searchElementGrid(gridAgrupacion, "Título", folderPath, "Caso 570421,570424,570428,570439,570440,570444,570445,570446,570450,570451", Evidencia);
			click(btnCerrar, folderPath, "click en cerrar visualizacion", Evidencia);
			//Se establece variable boolean de un localizador
		    boolean btn1 = validarElemento(btnProcesar, 10);
		    boolean btn2 = validarElemento(btnRegresar, 10);
			
		    ValidacionObjetos(btn1, btn2, "Caso 570432", folderPath, Evidencia);
		    writeRandomAlp(GrillaObservaciones, 4);
		    boolean CuadroObservacion = validarElemento(GrillaObservaciones, 10);
			  //Se valida variable booleana
			ValidacionObjeto(CuadroObservacion, "Caso 570421,570373,570431,570452", folderPath,Evidencia);
			click(btnRegresar, folderPath, "click en cerrar visualizacion", Evidencia);
			click(btnCargarServicios, folderPath, "click en servicios adicionales,Caso 570441", Evidencia);
		   
			boolean AdicionarNuevo = validarElemento(btnAdicionar, 10);
			  //Se valida variable booleana
			ValidacionObjeto(AdicionarNuevo, "Caso 570421,570373", folderPath,Evidencia);
			
			click(btnAdicionar, folderPath, "comentario,Caso 570441", Evidencia);
			click(btnGuardar, folderPath, "Safings", Evidencia);
			
			 //Se establece variable boolean de un localizador
		    boolean validarAlertaGuardar = validarElemento(AlertaConsulta, 10);
		     //Se valida variable booleana
			ValidacionObjeto(validarAlertaGuardar, "Caso 570421,570373", folderPath,Evidencia);
			click(btnCerrarVentanaAdicional, folderPath, "Cerrar ventana adicional", Evidencia);
			click(btnSubModuloParametro, folderPath, "click en parametros", Evidencia);
			writeText(txtxpathRazonsocial, NitBusqueda, folderPath, "Busqueda de nit", Evidencia);
			click(btnModificarConvenio, folderPath, "click en modificar", Evidencia);
			time(5);
			click(btnCobroAlmacenamiento, folderPath, EstadoLiquidacion, Evidencia);
			
			 //Se establece variable boolean de un localizador
		    boolean validarTarifa = validarElemento(txtTarifa, 10);
		     //Se valida variable booleana
			ValidacionObjeto(validarTarifa, "Caso 570447,570448,570449,570453", folderPath,Evidencia);
			
			
			
			return this;
			
			
			
			
			
		}
		
		@Step("Obligatoriedad de campos")
		public ConvenioPage ParametrizacionConvenios_567529(File folderPath,String NitBusqueda,String Evidencia,
				String ValorBusqueda,String ValorGrilla,
				String ValorBusqueda2,String ValorBusqueda3,String ValorValidar) throws Exception
		{
			
			
			
			click(lblParametrizacion, folderPath, "click en submodulo de parametrizacion", Evidencia);
			writeText(txtxpathRazonsocial, NitBusqueda, folderPath, "Busqueda de nit", Evidencia);
			click(btnCriterioCliente, folderPath, "click en submodulo de parametrizacion", Evidencia);
			click(btnRazonSocial, folderPath, "click en submodulo de parametrizacion", Evidencia);
			clear(txtxpathRazonsocial, folderPath, "Limpiamos el registro previo", Evidencia);
			writeText(txtxpathRazonsocial, ValorBusqueda, folderPath, "Busqueda de razon social ", Evidencia);
			searchElementGrid1(GridBusquedaCliente, ValorGrilla, "Caso 567515 exitoso");
			
			
			boolean btnModificar = validarElemento(btnVisualizarClienteConvenio, 5);
			boolean btnVisualizar = validarElemento(btnModificarClienteConvenio, 5);
			ValidacionObjetos(btnModificar, btnVisualizar, "Caso 567516,567518 exitoso", folderPath, Evidencia);
			
			clear(txtxpathRazonsocial, folderPath, "Limpiamos el registro previo", Evidencia);
			click(btnCriterioCliente, folderPath, "click en submodulo de parametrizacion", Evidencia);
			click(BuscarPorNit, folderPath, "click en submodulo de parametrizacion", Evidencia);
			//lblNit
			writeText(txtxpathRazonsocial, "8888", folderPath, "Busqueda de razon social ", Evidencia);
			click(btnModificarClienteConvenio, folderPath, "click en modificar convenio,Caso 567529,567530", Evidencia);
			
			
			//validacion de campos de convenios
			
			boolean btnInfoGeneral = validarElemento(btnInfoGeneralConvenio, 5);
			boolean btnAlmacenamiento = validarElemento(btnCobroAlmacenamiento, 5);
			ValidacionObjetos(btnAlmacenamiento, btnInfoGeneral, "Caso 567517 exitoso", folderPath, Evidencia);
			
			boolean btnAdicionales = validarElemento(btnServiciosAdicionales, 5);
			boolean btnAutorizacionConvenio = validarElemento(btnAutorizacion, 5);
			ValidacionObjetos(btnAdicionales, btnAutorizacionConvenio, "Caso 567517 exitoso", folderPath, Evidencia);
			
			
			click(btnInfoGeneralConvenio, folderPath, "click en informacion general de titulo ", Evidencia);
			time(5);
			
			 //Se establece variable boolean de un localizador
		    boolean validarInfoGeneralTitulo = validarElemento(btnInfoGeneralConvenio, 10);
		     //Se valida variable booleana
			ValidacionObjeto(validarInfoGeneralTitulo, "Caso 567519 exitoso", folderPath,Evidencia);
			//txtValidacionInfoGeneral
			click(btnInfoGeneralConvenio, folderPath, "click en informacion general de titulo,Caso exitoso 567519", Evidencia);
			click(btnCobroAlmacenamiento, folderPath, "Cobro de almacenamiento", Evidencia);
			isEnabled(txtTarif, folderPath, "Caso exitoso 567520", Evidencia);
			isEnabled(txtTarifCobro, folderPath, "Caso exitoso 567520", Evidencia);
			time(5);
			click(btnCobroAlmacenamiento, folderPath, "Cobro de almacenamiento", Evidencia);
			click(btnCancelarAccion, folderPath, "click en cancelar", Evidencia);
			click(btnAceptarAccion, folderPath, "Click en aceptar", Evidencia);
			
			writeText(txtxpathRazonsocial, ValorBusqueda2, folderPath, "Busqueda de nit", Evidencia);
			click(btnModificarClienteConvenio, folderPath, "click en modificar convenio,Caso 567529,567530", Evidencia);
			click(btnInfoGeneralConvenio, folderPath, "click en informacion general de titulo,Caso exitoso 567519", Evidencia);
			click(btnCobroAlmacenamiento, folderPath, "Cobro de almacenamiento", Evidencia);
			isEnabled(txtTarif, folderPath, "Caso exitoso 567521", Evidencia);
			isEnabled(txtTarifCobro, folderPath, "Caso exitoso 567521", Evidencia);
			time(5);
			click(btnCobroAlmacenamiento, folderPath, "Cobro de almacenamiento", Evidencia);
			click(btnCancelarAccion, folderPath, "click en cancelar", Evidencia);
			click(btnAceptarAccion, folderPath, "Click en aceptar", Evidencia);
			
			
			writeText(txtxpathRazonsocial, ValorBusqueda3, folderPath, "Busqueda de nit", Evidencia);
			click(btnModificarClienteConvenio, folderPath, "click en modificar convenio,Caso 567529,567530", Evidencia);
			click(btnInfoGeneralConvenio, folderPath, "click en informacion general de titulo,Caso exitoso 567519", Evidencia);
			click(btnCobroAlmacenamiento, folderPath, "Cobro de almacenamiento", Evidencia);
			isEnabled(txtLimiteInferior, folderPath, "Caso exitoso 567522,567520,567531", Evidencia);
			time(5);
			click(btnCobroAlmacenamiento, folderPath, "Cobro de almacenamiento", Evidencia);
			click(btnCancelarAccion, folderPath, "click en cancelar", Evidencia);
			click(btnAceptarAccion, folderPath, "Click en aceptar", Evidencia);
			
			
			click(btnCriterioCliente, folderPath, "click en submodulo de parametrizacion", Evidencia);
			click(btnRazonSocial, folderPath, "click en submodulo de parametrizacion", Evidencia);
			writeText(txtxpathRazonsocial, ValorBusqueda, folderPath, "Busqueda de nit", Evidencia);
			click(btnModificarClienteConvenio, folderPath, "click en modificar convenio,Caso 567529,567530", Evidencia);
			click(btnServiciosAdicionales, folderPath, "Servicios adicionales caso exitoso 567524", Evidencia);
			time(5);
			searchElementGrid(GridServiciosAdicionales, ValorValidar, folderPath, "Busqueda de valor validacion", Evidencia);
			click(btnAdicionarServicio, folderPath, "Click en modificar servicio", Evidencia);
			click(btnCancelarAdicServicio, folderPath, "Caso ", Evidencia);
			click(btnServiciosAdicionales, folderPath, "Servicios adicionales caso exitoso 567524", Evidencia);
			click(btnAutorizacion, folderPath, "Click en autorizar", Evidencia);
			click(btnAutorizacion, folderPath, "Click en autorizar", Evidencia);
			
			
			return this;
			
		}
		
		
		//INTERACCION CON CONVENIOS Y PERFILES
				@Step("Obligatoriedad de campos")
				public ConvenioPage PerfilesRolConvenio_567514(File folderPath,String RolAprovador,String Evidencia) throws Exception
				{
					
					
					
					time(5);
					 //Se establece variable boolean de un localizador
				    boolean validarModulo = validarElemento(lblModuloC, 10);
				     //Se valida variable booleana
					ValidacionObjeto(validarModulo, "Caso 567512", folderPath,Evidencia);
					
					//Ingreso a modulo de seguridad, validacion de la existencia de rol aprovador y click en aceptar
					click(lblModuloSeg, folderPath, "click en modulo de seguridad", Evidencia);
					click(lblSubModuloRol, folderPath, "click en roles", Evidencia);
					searchElementGrid(GridRoles, RolAprovador, folderPath, "Busqueda de Rol Aprobador convenio,Caso exitoso 567513", Evidencia);
					click(lblSubModuloPerfil, folderPath, "ingresa a submodulo perfil", Evidencia);
					click(btnEditarPerfil, folderPath, "Editar perfil", Evidencia);
					click(btnAgregarRol, folderPath, "click en agregar rol", Evidencia);
					click(btnEraseFirstRol, folderPath, "click en agregar rol", Evidencia);
					click(btnMenuPerfil, folderPath, "click en menu perfil", Evidencia);
					click(btnAprovadorConvenio, folderPath, "click en menu perfil", Evidencia);
					click(btnAgregar, folderPath, "Click en agregar", Evidencia);
					click(btnGuardarCambiosPerfil, folderPath, "Click en guardar", Evidencia);
					click(btnAceptar, folderPath, "Click en agregar", Evidencia);
					
					 //Se establece variable boolean de un localizador
				    boolean validarAlertaGuardar = validarElemento(AlertaConsulta, 10);
				     //Se valida variable booleana
					ValidacionObjeto(validarAlertaGuardar, "Caso 567514", folderPath,Evidencia);
					
					return this;
					
				}
}
