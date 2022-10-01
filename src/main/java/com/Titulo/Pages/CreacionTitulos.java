package com.Titulo.Pages;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.Titulo.Maps.ExpedirMap;

import io.qameta.allure.Step;

public class CreacionTitulos extends ExpedirMap {

	public CreacionTitulos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 
	
	//ADVERTENCIA: POR MOTIVOS DE FUNCIONALIDAD DE LA PAGINA NO SE RECOMIENDA HACER USO EXCESIVO DE ESTE METODO DEBIDO A QUE SOBRECARGA LA PAGINA DE INFORMACION
	
	@Step("Ver Titulo Creacion Titulos")
	public CreacionTitulos ValidacionExpedirFormulario(File folderPath,String Empresa2, String informacionGeneralE,String Titulo,
			 String NumeroTitulo, String Plazosf, String etiquetaPoliza, String tipoMercanciaE, String mercanciasE,
			String tarifasE,String ingreso,String aplicar,String FechaDeCargue,String Evidencia) throws Exception {
		
		
		
		
		///////////////////3
		//click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
        //click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		
		//INGRESO A CREAR TITULO, SELECCION DE NOMBRE DE EMPRESA
		click(lblExpedir, folderPath, "Click en expedir",Evidencia);
		
		click(btnCrearExpedir, folderPath, "click en crear titulo",Evidencia);
		click(btnNit2, folderPath, "click en Razon",Evidencia);
		click(btnNit, folderPath, "click en Razon Social",Evidencia);
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro",Evidencia);
		click(btnSelecClaro, folderPath, "click en Claro",Evidencia);
		click(locatorVariable(btnInformacionGeneralTitulo, informacionGeneralE), folderPath, "Click en InformacionTitulo, se desplega lista ",Evidencia);
		desplazarseVertical(0,500);
		
		//String Titulo = null;
		//Titulo = driver.findElement(txtNumeroTitulo).getText();
		
		Titulo=readText(txtNumeroTitulo, folderPath, "Se toma valor de texto",Evidencia);
		//FORMULARIO COMPLETO DE CREAR TITULO
		
		click(lblOficinaResponsable1, folderPath, "click en Oficina",Evidencia);
		click(lblOficinaResponsable2, folderPath, "click en Direccion General",Evidencia);
		click(lblTipoBodega1, folderPath, "click en Tipo Bodega",Evidencia);
		click(lblTipoBodega2, folderPath, "click en Particular",Evidencia);
		click(lblBodega1, folderPath, "click en Bodega",Evidencia);
		click(lblBodega2, folderPath, "click en Manizales",Evidencia);
		desplazarseVertical(0,300);
		click(lblTipoTitulo1, folderPath, "click en Tipo de titulo",Evidencia);
		click(lblTipoTitulo2, folderPath, "click en Certificado de deposito",Evidencia);
		click(lblTipoOperacion1, folderPath, "click en Tipo Operacion",Evidencia);
		click(lblTipoOperacion2, folderPath, "click en Incentivo",Evidencia);
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso",Evidencia);
		click(lblDivisionIngreso2, folderPath, "click en si",Evidencia);
		click(Plazos, folderPath, "Click en Plazos ",Evidencia);
		desplazarseVertical(0,300);
		writeText(txtPlazoCertificadoDias, "20", folderPath, "Se escribe Plazos certificado",Evidencia);
		writeText(txtPlazoContratoDias, "20", folderPath, "Se escribe Plazos contrato",Evidencia);
		click(locatorVariable(btnPoliza, etiquetaPoliza), folderPath, "Click en Poliza ",Evidencia);
		desplazarseVertical(0,200);
		click(btnPoliza1, folderPath, "click en Poliza",Evidencia);
		click(btnPoliza2, folderPath, "click en Seguros Alfa",Evidencia);
		click(TipoMercancia, folderPath, "Click en Tipo de Mercancia ",Evidencia);
		desplazarseVertical(0,400);
		click(btnTipoMercancia1, folderPath, "click en Tipo Mercancia",Evidencia);
		click(btnTipoMercancia2, folderPath, "click en Aceite",Evidencia);
		writeText(txtDescripcionMercancia, "Aceite rojo", folderPath, "Se escribe descripcion general mercancia",Evidencia);
		writeText(txtmerma, "1", folderPath, "Se escribe Merma",Evidencia);
		click(btnAplicadaCalidad1, folderPath, "click en Aplica calidad",Evidencia);
		click(btnAplicadaCalidad2, folderPath, "click SI",Evidencia);
		click(btnMercanciaDesignada1, folderPath, "click en Mercancia Designada",Evidencia);
		click(btnMercanciaDesignada2, folderPath, "click en SI",Evidencia);
		writeText(txtObservaciones1, "Prueba", folderPath, "Se escribe Observaciones",Evidencia);
		click(Mercancia, folderPath, "Click en Poliza ",Evidencia);
		desplazarseVertical(0,300);
		click(btnTipoCargue1, folderPath, "click en Tipo de cargue",Evidencia);
		click(btnTipoCargue2, folderPath, "click en Individual",Evidencia);
		click(btnCrearMercancia, folderPath, "click en crear mercancia",Evidencia);
		//writeRandomAlp(txtDetalleMercancia1, );
		writeText(txtDetalleMercancia1, "Aceite rojo", folderPath, "Se escribe detalle mercancia",Evidencia);
		listRandom(lblUnidadMedida, folderPath, "Se selecciona valor random de la lista",Evidencia);
		listRandom(lblUnidadMedidaSuper, folderPath, "Se selecciona valor random de la lista",Evidencia);
		//ESCRITURA DE VALOR RANDOM NUMERICO
		writeRandomNum(txtValorConversion, 1);
		writeRandomNum(txtCantidad, 3);
		writeRandomNum(txtValorUnitario, 3);
		writeText(txtFechaVencimientoMercancia, datePlusYear(3));
		writeText(txtObservacionMercancia, "Aceite rojo", folderPath, "Se escribe Observaciones de la mercancia",Evidencia);
		//writeRandomAlp(txtObservacionMercancia, 100);
		click(btnGuardarMercancia, folderPath, "Click en guardar mercancia",Evidencia);
		click(btnAceptarMercancias, folderPath, "Click en aceptar mercancia",Evidencia);
		click(Tarifa, folderPath, "Click en opciones tarifas",Evidencia);
		desplazarseVertical(0,200);
		writeRandomNum(txtTarifa, 3);
		writeRandomNum(txtMinima, 2);
		click(btnMaterialSap, folderPath, "Click en Material Sap",Evidencia);
		click(btnMaterialSap2, folderPath, "Click en Material Sap luffy",Evidencia);
		click(DivisionIngreso, folderPath, "Click en Division de Ingreso",Evidencia);
		desplazarseVertical(0,400);
		writeText(btnPorcentajeEx, "50", folderPath, "Se escribe el Porcentaje Expedicion",Evidencia);
		writeText(btnPorcentajeAlm, "50", folderPath, "Se escribe el Porcentaje Almacenamiento",Evidencia);
		//ESCRITURA DE VALOR RANDOM ALFABETICO
		writeRandomAlp(btnCodigoSapExp, 20);
		writeRandomAlp(btnCodigoSapAlm, 20);
		click(btnSaveChanges, folderPath, "click en guardar cambios ",Evidencia);
		click(btnAceptar, folderPath, "click en Aceptar cambios ",Evidencia);
		
		//SI LA PAGINA NO OLVIDARA LOS VALORES TOMADOS AL CAMBIAR SE PODRIAN USAR ESTAS VARIABLES
		String Titulo2 = Titulo;
		
		///   aqui termina la creacion de titulo
		
		time(5);
		
		String fechaHoy = fechaPdf();
		
		
		
		//BUSQUEDA EN ULTIMO TITULO CREADO BUSCARLO POR FECHA ES INUTIL PORQUE LA PAGINA SOLO GUARDA AHI TITULOS APLICADOS
		click(btnCriterioTitulo, folderPath, "click en criterio de busqueda de titulo",Evidencia);
		selectElementList(btnCriterioTitulo, FechaDeCargue, folderPath, "selecciona busqueda por fecha",Evidencia);
		writeText(txtBuscarTitulo, "claro", folderPath, "escritura fecha actual, cambiar el valor de la empresa a conveniencia",Evidencia);
		
		//writeText(txtBuscarTitulo, datePlusYear(0), folderPath, "escritura fecha actual"); 
		//la pagina no toma todos los titulos de hoy solo los aplicados
		click(PaginacionNueva, folderPath, "Click en pagina--pagina cambiante revisar el xpath constantemente",Evidencia);
		
		click(btnRefreshTitulosPorfecha, folderPath, "click en refrescar al ultimo creado",Evidencia);
		click(btnRefreshTitulosPorfecha, folderPath, "click en refrescar al ultimo creado",Evidencia);
		
		//SE TOMA TEXTO DE ULTIMO TITULO VISIBLE
		String NuevoTitulo= driver.findElement(UltimoRegistroCreado).getText();;
		
		
		
		
		
		//click(btnCriterioTitulo, folderPath, "click en criterio de busqueda de titulo");
		//selectElementList(btnCriterioTitulo, "Título", folderPath, fechaHoy);
		
		//SE CONSULTA EL ULTIMO TITULO CREADO
		click(locatorVariable(lblsecciones, "Liberación"),folderPath,"click en la seccion perfil",Evidencia);
		
		//clear(txtBuscarTitulo, folderPath, "limpia de texto existente");
		writeText(TxtTituloLiberacion, NuevoTitulo, folderPath, "escritura fecha actual",Evidencia);
		
		
		//scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
		//click(btnModificar, folderPath, "Click en modificar cliente");
		
		/*
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ");
		desplazarseVertical(0,500);
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso");
		click(lblDivisionIngreso3, folderPath, "click en NO");
		click(locatorVariable(btnDivisionIngreso, ingreso), folderPath, "Click en Division de Ingreso");
		*/
		
		desplazarseVertical(0,200);
		click(btnAplicar, folderPath, "Click en Aplicar",Evidencia);
		click(btnAceptar, folderPath, "click en Aceptar cambios ",Evidencia);
		//SE VALIDA QUE EL TITULO SEA APLICADO(usar solo si es necesario aplicarlo hay que racionalizar el espacio de la aplicacion)
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
        ValidacionObjeto(alertaCreadaAplicada, "Validacion de aplicacion caso: ", folderPath,Evidencia);
		
		
	
		return this;
	}  
	


	@Step("Ver Titulo Creacion Titulos")
	public CreacionTitulos ValidacionExpedirFormulario_556552(File folderPath,String Empresa2, String informacionGeneralE,String Titulo,
			 String NumeroTitulo, String Plazosf, String etiquetaPoliza, String tipoMercanciaE, String mercanciasE,
			String tarifasE,String ingreso,String aplicar,String FechaDeCargue,String Evidencia) throws Exception {
		
		
		
		
		///////////////////3
		//click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
        //click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		
		//INGRESO A CREAR TITULO, SELECCION DE NOMBRE DE EMPRESA
		click(lblExpedir, folderPath, "Click en expedir",Evidencia);
		
		click(btnCrearExpedir, folderPath, "click en crear titulo",Evidencia);
		click(btnNit2, folderPath, "click en Razon",Evidencia);
		click(btnNit, folderPath, "click en Razon Social",Evidencia);
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro",Evidencia);
		click(btnSelecClaro, folderPath, "click en Claro",Evidencia);
		click(locatorVariable(btnInformacionGeneralTitulo, informacionGeneralE), folderPath, "Click en InformacionTitulo, se desplega lista ",Evidencia);
		desplazarseVertical(0,500);
		
		//String Titulo = null;
		//Titulo = driver.findElement(txtNumeroTitulo).getText();
		
		Titulo=readText(txtNumeroTitulo, folderPath, "Se toma valor de texto",Evidencia);
		//FORMULARIO COMPLETO DE CREAR TITULO
		
		click(lblOficinaResponsable1, folderPath, "click en Oficina",Evidencia);
		click(lblOficinaResponsable2, folderPath, "click en Direccion General",Evidencia);
		click(lblTipoBodega1, folderPath, "click en Tipo Bodega",Evidencia);
		click(lblTipoBodega2, folderPath, "click en Particular",Evidencia);
		click(lblBodega1, folderPath, "click en Bodega",Evidencia);
		click(lblBodega2, folderPath, "click en Manizales",Evidencia);
		desplazarseVertical(0,300);
		click(lblTipoTitulo1, folderPath, "click en Tipo de titulo",Evidencia);
		click(lblTipoTitulo2, folderPath, "click en Certificado de deposito",Evidencia);
		click(lblTipoOperacion1, folderPath, "click en Tipo Operacion",Evidencia);
		click(lblTipoOperacion2, folderPath, "click en Incentivo",Evidencia);
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso",Evidencia);
		click(lblDivisionIngreso2, folderPath, "click en si",Evidencia);
		click(Plazos, folderPath, "Click en Plazos ",Evidencia);
		desplazarseVertical(0,300);
		writeText(txtPlazoCertificadoDias, "20", folderPath, "Se escribe Plazos certificado",Evidencia);
		writeText(txtPlazoContratoDias, "20", folderPath, "Se escribe Plazos contrato",Evidencia);
		click(locatorVariable(btnPoliza, etiquetaPoliza), folderPath, "Click en Poliza ",Evidencia);
		desplazarseVertical(0,200);
		click(btnPoliza1, folderPath, "click en Poliza",Evidencia);
		click(btnPoliza2, folderPath, "click en Seguros Alfa",Evidencia);
		click(TipoMercancia, folderPath, "Click en Tipo de Mercancia ",Evidencia);
		desplazarseVertical(0,400);
		click(btnTipoMercancia1, folderPath, "click en Tipo Mercancia",Evidencia);
		click(btnTipoMercancia2, folderPath, "click en Aceite",Evidencia);
		writeText(txtDescripcionMercancia, "Aceite rojo", folderPath, "Se escribe descripcion general mercancia",Evidencia);
		writeText(txtmerma, "1", folderPath, "Se escribe Merma",Evidencia);
		click(btnAplicadaCalidad1, folderPath, "click en Aplica calidad",Evidencia);
		click(btnAplicadaCalidad2, folderPath, "click SI",Evidencia);
		click(btnMercanciaDesignada1, folderPath, "click en Mercancia Designada",Evidencia);
		click(btnMercanciaDesignada2, folderPath, "click en SI",Evidencia);
		writeText(txtObservaciones1, "Prueba", folderPath, "Se escribe Observaciones",Evidencia);
		click(Mercancia, folderPath, "Click en Poliza ",Evidencia);
		desplazarseVertical(0,300);
		click(btnTipoCargue1, folderPath, "click en Tipo de cargue",Evidencia);
		click(btnTipoCargue2, folderPath, "click en Individual",Evidencia);
		click(btnCrearMercancia, folderPath, "click en crear mercancia",Evidencia);
		//writeRandomAlp(txtDetalleMercancia1, );
		writeText(txtDetalleMercancia1, "Aceite rojo", folderPath, "Se escribe detalle mercancia",Evidencia);
		listRandom(lblUnidadMedida, folderPath, "Se selecciona valor random de la lista",Evidencia);
		listRandom(lblUnidadMedidaSuper, folderPath, "Se selecciona valor random de la lista",Evidencia);
		//ESCRITURA DE VALOR RANDOM NUMERICO
		writeRandomNum(txtValorConversion, 1);
		writeRandomNum(txtCantidad, 3);
		writeRandomNum(txtValorUnitario, 3);
		writeText(txtFechaVencimientoMercancia, datePlusYear(3));
		writeText(txtObservacionMercancia, "Aceite rojo", folderPath, "Se escribe Observaciones de la mercancia",Evidencia);
		//writeRandomAlp(txtObservacionMercancia, 100);
		click(btnGuardarMercancia, folderPath, "Click en guardar mercancia",Evidencia);
		click(btnAceptarMercancias, folderPath, "Click en aceptar mercancia",Evidencia);
		click(Tarifa, folderPath, "Click en opciones tarifas",Evidencia);
		desplazarseVertical(0,200);
		writeRandomNum(txtTarifa, 3);
		writeRandomNum(txtMinima, 2);
		click(btnMaterialSap, folderPath, "Click en Material Sap",Evidencia);
		click(btnMaterialSap2, folderPath, "Click en Material Sap luffy",Evidencia);
		click(DivisionIngreso, folderPath, "Click en Division de Ingreso",Evidencia);
		desplazarseVertical(0,400);
		writeText(btnPorcentajeEx, "50", folderPath, "Se escribe el Porcentaje Expedicion",Evidencia);
		writeText(btnPorcentajeAlm, "50", folderPath, "Se escribe el Porcentaje Almacenamiento",Evidencia);
		//ESCRITURA DE VALOR RANDOM ALFABETICO
		writeRandomAlp(btnCodigoSapExp, 20);
		writeRandomAlp(btnCodigoSapAlm, 20);
		click(btnSaveChanges, folderPath, "click en guardar cambios ",Evidencia);
		click(btnAceptar, folderPath, "click en Aceptar cambios ",Evidencia);
		
		//SI LA PAGINA NO OLVIDARA LOS VALORES TOMADOS AL CAMBIAR SE PODRIAN USAR ESTAS VARIABLES
		String Titulo2 = Titulo;
		
		///   aqui termina la creacion de titulo
		
		time(5);
		
		String fechaHoy = fechaPdf();
		
		
		
		//BUSQUEDA EN ULTIMO TITULO CREADO BUSCARLO POR FECHA ES INUTIL PORQUE LA PAGINA SOLO GUARDA AHI TITULOS APLICADOS
		click(btnCriterioTitulo, folderPath, "click en criterio de busqueda de titulo",Evidencia);
		selectElementList(btnCriterioTitulo, FechaDeCargue, folderPath, "selecciona busqueda por fecha",Evidencia);
		writeText(txtBuscarTitulo, "claro", folderPath, "escritura fecha actual, cambiar el valor de la empresa a conveniencia",Evidencia);
		
		//writeText(txtBuscarTitulo, datePlusYear(0), folderPath, "escritura fecha actual"); 
		//la pagina no toma todos los titulos de hoy solo los aplicados
		click(PaginacionNueva, folderPath, "Click en pagina--pagina cambiante revisar el xpath constantemente",Evidencia);
		
		click(btnRefreshTitulosPorfecha, folderPath, "click en refrescar al ultimo creado",Evidencia);
		click(btnRefreshTitulosPorfecha, folderPath, "click en refrescar al ultimo creado",Evidencia);
		
		//SE TOMA TEXTO DE ULTIMO TITULO VISIBLE
		String NuevoTitulo= driver.findElement(UltimoRegistroCreado).getText();;
		
		
		
		
		
		//click(btnCriterioTitulo, folderPath, "click en criterio de busqueda de titulo");
		//selectElementList(btnCriterioTitulo, "Título", folderPath, fechaHoy);
		
		//SE CONSULTA EL ULTIMO TITULO CREADO
		click(locatorVariable(lblsecciones, "Liberación"),folderPath,"click en la seccion perfil",Evidencia);
		
		//clear(txtBuscarTitulo, folderPath, "limpia de texto existente");
		writeText(TxtTituloLiberacion, NuevoTitulo, folderPath, "escritura fecha actual",Evidencia);
		
		
		//scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
		//click(btnModificar, folderPath, "Click en modificar cliente");
		
		/*
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ");
		desplazarseVertical(0,500);
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso");
		click(lblDivisionIngreso3, folderPath, "click en NO");
		click(locatorVariable(btnDivisionIngreso, ingreso), folderPath, "Click en Division de Ingreso");
		*/
		
		desplazarseVertical(0,200);
		click(btnAplicar, folderPath, "Click en Aplicar",Evidencia);
		click(btnAceptar, folderPath, "click en Aceptar cambios, 556550, 556551,556552, 556553,556554,556555,556556,556557,556558,556559 ",Evidencia);
		//SE VALIDA QUE EL TITULO SEA APLICADO(usar solo si es necesario aplicarlo hay que racionalizar el espacio de la aplicacion)
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
        ValidacionObjeto(alertaCreadaAplicada, "Validacion de aplicacion caso: ", folderPath,Evidencia);
		
		
	
		return this;
	}  
	


	@Step("Ver Titulo Creacion Titulos")
	public CreacionTitulos ValidacionExpedirFormulario_554762(File folderPath,String Empresa2, String informacionGeneralE,String Titulo,
			 String NumeroTitulo, String Plazosf, String etiquetaPoliza, String tipoMercanciaE, String mercanciasE,
			String tarifasE,String ingreso,String aplicar,String FechaDeCargue,String Evidencia) throws Exception 
	{
		
		ValidacionExpedirFormulario(folderPath, Evidencia, Evidencia, Evidencia, Evidencia, Evidencia, Evidencia, Evidencia, Evidencia, Evidencia, Evidencia, Evidencia, Evidencia, Evidencia);
		
		screenshot(folderPath, "Casos exitosos CP01,CP02,CP03.");
		
		return this;
		
	}


}
	 


	
	
	
	






 


