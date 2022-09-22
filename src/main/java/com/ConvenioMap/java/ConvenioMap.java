package com.ConvenioMap.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class ConvenioMap extends BasePage{
	
	
	

	public ConvenioMap(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	// CONVENIOS
		protected By btnConvenio = By.xpath("//*[@id=\"sidebar\"]/ul/li[5]/div/a");
		protected By btnGestion = By.xpath("//*[@id=\"sidebar\"]/ul/li[5]/div/ul/li/div/a");
		 
		//Liquidaciones	
		protected By lblModuloC = By.xpath("//*[@id='sidebar']/ul/li[5]/div/a");
		
		protected By btnCancelarAccion = By.xpath("//*[@id='contenido']/app-main/app-convenios/div/form/div[2]/div/button[2]");
		protected By btnAceptarAccion = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
		protected By GridServiciosAdicionales = By.xpath("//*[@id='contenido']/app-main/app-convenios/div/form/div[1]/div/accordion/accordion-group[3]/div/div[2]/div/div[2]/div[2]/table/thead/tr");
		protected By AlertaConsulta = By.xpath("//*[@id='toast-container']");
		protected By GridLiquidacion = By.xpath("//*[@id='tbClientes']/thead/tr");
		protected By btnLiquidacion = By.xpath("//*[@id='tbClientes']/tbody/tr[2]/td[3]/div/a[1]");
		protected By gridLiquidacionTable = By.xpath("//*[@id='tbClientes']/tbody/tr[1]");
		protected By btnProcesar = By.xpath("//*[@id='contenido']/app-main/app-liquidacion/div/app-liquidacion-info-general-mensual/app-liquidacion-info-detalle-mensual/div[2]/div/button");
		protected By btnCriterioCliente = By.xpath("//*[@id='criterio']");
		protected By btnRazonSocial = By.xpath("//*[@id='criterio']/option[2]");
		
		protected By btnVisualizarClienteConvenio = By.xpath("//*[@id='tbClientes']/tbody/tr/td[3]/div/a[2]");
		protected By btnAdicionarConvenio = By.xpath("//*[@id='contenido']/app-main/app-home/div/div[2]/div/a");
		protected By txtLimiteInferior = By.xpath("//*[@id='minimaCobro']");
		protected By txtLimiteSuperior = By.xpath("//body/app-root/div/div/div/app-main/app-convenios/div/form/div[1]/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/div[3]/table/tbody/tr[1]/td[3]/input");
		
		
		protected By btnScav = By.xpath("//*[@id='contenido']/app-main/bodega-actualizar/div/form/div[12]/accordion/app-integracion-scav/accordion-group/div/div[1]/div/div/button");
		
		protected By btnCancelar = By.xpath("//*[@id='contenido']/app-main/app-convenios/div/form/div[2]/div/button[2]");
		protected By btnModificarClienteConvenio = By.xpath("//*[@id='tbClientes']/tbody/tr/td[3]/div/a[1]");
		protected By GridBusquedaCliente= By.xpath("//*[@id='tbClientes']/tbody/tr");
		//*[@id="contenido"]/app-main/app-liquidacion/div/app-liquidacion-info-general-mensual/app-liquidacion-info-detalle-mensual/div[2]/div/button
		protected By txtTarif = By.xpath("//*[@id='tarifaSimple']");
		protected By txtTarifCobro = By.xpath("//*[@id='minimaCobro']");
		
		protected By BuscarPorNit = By.xpath("//*[@id='criterio']/option[1]");
		protected By btnRegresar = By.xpath("//*[@id='contenido']/app-main/app-liquidacion/div/app-liquidacion-info-general-mensual/div[3]/div/button");
		protected By gridDetalle = By.xpath("//*[@id='contenido']/app-main/app-liquidacion/div/app-liquidacion-info-general-mensual/app-liquidacion-info-detalle-mensual/div[1]/table/thead/tr[2]");
		protected By btnVisualizarLiquidacion = By.xpath("//*[@id='contenido']/app-main/app-liquidacion/div/app-liquidacion-info-general-mensual/app-liquidacion-info-detalle-mensual/div[1]/table/tbody/tr[1]/td[13]/a");
		protected By gridAgrupacion = By.xpath("//body/modal-container/div/div/app-agrupacion-titulos/div/div[2]/div[1]/table/thead/tr");
		protected By btnCerrar = By.xpath("//body/modal-container/div/div/app-agrupacion-titulos/div/div[2]/div[2]/button");
		protected By GrillaObservaciones = By.xpath("//*[@id='observaciones']");
		protected By btnCargarServicios = By.xpath("//*[@id='contenido']/app-main/app-liquidacion/div/div[4]/div/button");
		protected By btnAdicionar = By.xpath("//*[@id='contenido']/app-main/app-liquidacion/div/app-servicio-adicional-liquidacion/div[1]/div/a");
		protected By btnGuardar = By.xpath("//button[@class='btn float-right col-2 botones-rojo']");
		protected By txtTarifa = By.xpath("//*[@id='tarifaSimple']");
		protected By btnCobroAlmacenamiento = By.xpath("//*[@id='contenido']/app-main/app-convenios/div/form/div[1]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
		protected By btnSubModuloParametro = By.xpath("//*[@id='sidebar']/ul/li[5]/div/ul/li[1]/div/a");
		protected By btnModificarConvenio = By.xpath("//*[@id='tbClientes']/tbody/tr[2]/td[3]/div/a[1]");
		protected By gridNecesario = By.xpath("//*[@id='tbClientes']/tbody/tr[1]/td[7]");
		
		protected By btnInfoGeneralConvenio = By.xpath("//*[@id='contenido']/app-main/app-convenios/div/form/div[1]/div/accordion/accordion-group[1]/div/div[1]/div/div/button");
		
		protected By btnCerrarVentanaAdicional = By.xpath("//body/modal-container/div/div/app-servicio-adicional-liquidacion-crear/div/div[2]/div[2]/button[1]");
		///////////////////////////////----------------------------------------
		
		
		
		protected By lblNit = By.xpath("//*[@id='tipo']/option[1]");
		protected By lblNombreRazonSocial = By.xpath("//*[@id='tipo']/option[2]");
		protected By txtIngreseNit = By.id("termino");
		protected By txtIngreseRazonSocial = By.id("termino");
		 
		 //CREAR CONVENIO
		protected By btnCrearConvenio = By.xpath("//*[@id=\"contenido\"]/convenios/convenios-home/div/div[2]/div/a");
		protected By lblNitCrearConvenio = By.xpath("//*[@id=\"criterio\"]/option[1]");
		protected By lblRazonSocialCrearConvenio = By.xpath("//*[@id=\"criterio\"]/option[2]");
		protected By txtNit = By.id("termino");
		protected By txtRazonSocial = By.id("termino");
		//Xpath que se repite en casi toda barra de busqueda
		protected By txtxpathRazonsocial = By.xpath("//*[@id='termino']");
		protected By FirstSugerency = By.xpath("//*[@id='ngb-typeahead-0-0']");
		
		protected By btnSeleccionarNitRazonSocial = By.cssSelector(".ngb-highlight");
		 
		
		protected By lblParametrizacion = By.xpath("//*[@id='sidebar']/ul/li[5]/div/ul/li[1]/div/a");
		protected By btnBuscar = By.xpath("//*[@id='contenido']/convenios/app-convenio/div/busqueda-cliente/form/button");
		 
		protected By txtValorImpresion= By.id("convValorprendario");
		protected By btnSeleccionarAplicaCobroPorModalidad= By.id("convCobroxmodalida");
		protected By btnSeleccionarAplicaCobroPorModalidadSi = By.xpath("//*[@id=\"convCobroxmodalida\"]/option[1]");
		protected By btnSeleccionarAplicaCobroPorModalidadNo = By.xpath("//*[@id=\"convCobroxmodalida\"]/option[2]");
		 
		protected By lblParticularArrendada = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[1]/div/div[1]/div/div/button");	
		protected By lblPropia= By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[2]/div/div[1]/div/div/button");
		protected By lblTransito = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[3]/div/div[1]/div/div/button");
		protected By lblParticular = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[4]/div/div[1]/div/div/button");
		 
		protected By txtFijaPorcentaje1= By.id("coboValor");
		protected By txtFijaPorcentaje2= By.id("coboValor");
		 
		protected By btnAplicaMinima = By.id("convAplicaminima");
		protected By btnAplicaMinimaSi = By.xpath("//*[@id=\"convAplicaminima\"]/option[1]");
		protected By btnAplicaMinimaNo = By.xpath("//*[@id=\"convAplicaminima\"]/option[2]");
		protected By txtValorMinima = By.id("convValor");
		protected By btnGuardarCrearConvenio = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[2]/div/button[1]");
		protected By btnCancelarCrearConvenio = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[2]/div/button[2]");
		 
		protected By lblGuardarRegistro = By.xpath("//*[@id=\"swal2-title\"]");
		protected By btnAlertaCrearConvenioAceptar = By.xpath("/html/body/div[3]/div/div[3]/button[1]");
		protected By btnAlertaCrearConvenioCancelar = By.xpath("/html/body/div[3]/div/div[3]/button[2]");
		
		 // FORMA DE COBRO TODAS LAS BODEGAS
		protected By lblFormaDeCobroParticularArrendada = By.id("coboFija_0");
		protected By lblFormaDeCobroPropia = By.id("coboFija_1");
		protected By lblFormaDeCobroTransito = By.id("coboFija_2");
		protected By lblFormaDeCobroParticular = By.id("coboFija_3");
		
		 //FIJA / ESCALONADA
		protected By lblFormaDeCobroFijaParticularArrendada = By.xpath("//*[@id=\"coboFija_0\"]/option[1]");
		protected By lblFormaDeCobroFijaPropia = By.xpath("//*[@id=\"coboFija_1\"]/option[1]");
		protected By lblFormaDeCobroFijaTransito = By.xpath("//*[@id=\"coboFija_2\"]/option[1]");
		protected By lblFormaDeCobroFijaParticular = By.xpath("//*[@id=\"coboFija_3\"]/option[1]");
		
		protected By lblFormaDeCobroEscalonadaParticularArrendada = By.xpath("//*[@id=\"coboFija_0\"]/option[2]");
		protected By lblFormaDeCobroEscalonadaPropia = By.xpath("//*[@id=\"coboFija_1\"]/option[2]");
		protected By lblFormaDeCobroEscalonadaTransito = By.xpath("//*[@id=\"coboFija_2\"]/option[2]");
		protected By lblFormaDeCobroEscalonadaParticular = By.xpath("//*[@id=\"coboFija_3\"]/option[2]");
		
		protected By txtFijaParticularArrendada = By.id("coboValor_0");
		protected By txtFijaPropia = By.id("coboValor_1");
		protected By txtFijaTransito = By.id("coboValor_2");
		protected By txtFijaParticular = By.id("coboValor_3");
		
		protected By btnAgregarRango = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[1]/div/div[2]/div/div/div[3]/app-cobro-escalonado/div/div[2]/div/a");
		protected By btnEliminarRango = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[5]/app-modalidades/accordion/accordion-group[1]/div/div[2]/div/div/div[3]/app-cobro-escalonado/div/table/tbody/tr[3]/td[5]/button");
		protected By txtR1LI = By.id("cbraLi_0");
		protected By txtR1LF = By.id("cbraLf_0");
		protected By txtR1Valor = By.id("cbraValor_0");
		protected By txtR2LI = By.id("cbraLi_1");
		protected By txtR2LF = By.id("cbraLf_1");
		protected By txtR2Valor = By.id("cbraValor_1");
	 
		 // MODIFICAR
		protected By btnModificar = By.xpath("//table[@id='tbConvenios']/tbody/tr/td[3]/div/a/i");
		protected By btnModificar2 = By.xpath("//table[@id='tbConvenios']/tbody/tr[2]/td[3]/div/a/i");
		protected By btnModificar3 = By.xpath("//table[@id='tbConvenios']/tbody/tr[3]/td[3]/div/a");
		protected By btnGuardarModificar = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[2]/div/button[1]");
		protected By btnCancelarModificar = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[2]/div/button[2]");
		
		 // VER DETALLE
		protected By txtNITConsultar = By.id("convNit");
		protected By txtNombreRazonSocialConsultar = By.id("convRazonSocial");
		protected By txtValorImpresionBuscarConsultar = By.id("convValorprendario");
		protected By btnSeleccionarAplicaCobroPorModalidadConsultar = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[1]/div[4]/input");
		protected By btnVerDetalle = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[1]/td[3]/div/a[2]");
		protected By btnVerDetalle2 = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[2]/td[3]/div/a[2]");
		protected By btnVerDetalle3 = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[3]/td[3]/div/a[2]");
		protected By btnVerDetalle4 = By.xpath("//*[@id=\"tbConvenios\"]/tbody/tr[4]/td[3]/div/a[2]");
		protected By btnRegresarVerDetalle = By.xpath("//*[@id=\"contenido\"]/convenios/app-convenio/div/div[2]/div/form/div[2]/div/button");
		 
		protected By txtValorImpresionBuscar = By.id("convValorprendario");
		protected By btnOrdenarNit = By.xpath("//*[@id=\"tbConvenios\"]/thead/tr/th[1]/div/i");
		protected By btnOrdenarRazonSocial = By.xpath("//*[@id=\"tbConvenios\"]/thead/tr/th[2]/div/i");

		//Roles y perfiles de aprobador de convenios
		
		protected By lblModuloSeg = By.xpath("//*[@id='sidebar']/ul/li[1]/div/a"); 
		protected By lblSubModuloRol = By.xpath("//*[@id='sidebar']/ul/li[1]/div/ul/li[2]/div/a");
		protected By GridRoles = By.xpath("//*[@id='tbRoles']/tbody/tr[1]");
		protected By lblSubModuloPerfil = By.xpath("//*[@id='sidebar']/ul/li[1]/div/ul/li[3]/div/a");
		protected By btnEditarPerfil = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/div[3]/table/tbody/tr[1]/td[4]/div/a[1]");
		protected By btnAgregarRol = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/accordion/accordion-group/div/div[1]/div/div/button");
		protected By btnEraseFirstRol = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/accordion/accordion-group/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[3]/button");
		protected By btnMenuPerfil = By.xpath("//*[@id='rol']");
		protected By btnAprovadorConvenio = By.xpath("//*[@id='rol']/option[5]");
		protected By btnAgregar = By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/accordion/accordion-group/div/div[2]/div/div[1]/div[2]/button");
		protected By btnGuardarCambiosPerfil= By.xpath("//*[@id='contenido']/perfiles-perfiles/ng-component/div/form/div[5]/div/button[1]");
		protected By btnAceptar = By.xpath("//body/div[2]/div/div[3]/button[1]");
		protected By btnServiciosAdicionales = By.xpath("//*[@id='contenido']/app-main/app-convenios/div/form/div[1]/div/accordion/accordion-group[3]/div/div[1]/div/div/button");
		protected By btnAutorizacion = By.xpath("//*[@id='contenido']/app-main/app-convenios/div/form/div[1]/div/accordion/accordion-group[4]/div/div[1]/div/div/button");
		protected By btnAdicionarServicio = By.xpath("//*[@id='contenido']/app-main/app-convenios/div/form/div[1]/div/accordion/accordion-group[3]/div/div[2]/div/div[2]/div[2]/table/tbody/tr/td[5]/div/a[2]");
		protected By txtValidacionInfoGeneral = By.xpath("//*[@id='juegoPrendario']");
		
		
		protected By btnCancelarAdicServicio = By.xpath("//body/modal-container/div/div/app-detalle-servicio-adicional/div/form/div[2]/button[1]");
		
		
}
