package com.Titulo.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.Titulo.Maps.ExpedirMap;

import io.qameta.allure.Step;

public class CreacionTitulos extends ExpedirMap {

	public CreacionTitulos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@Step("Ver Titulo Creacion Titulos")
	public CreacionTitulos ValidacionExpedirFormulario(File folderPath,String Empresa2, String InfGTitulo,
			String Titulo, String NumeroTitulo, String Plazo, String Poliza, String Tipomerca, String Mercancias,
			String tarifas,String ingreso,String OficnaExpedicion,String oficinaAlmacenamiento,String CodigoSapExp,
			String CodigoSapAlm,String aplicar,String SubModuloExpedir) throws Exception {
		
		///////////////////3
		//click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
        //click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		
		click(btnCrearExpedir, folderPath, "click en crear titulo");
		click(btnNit2, folderPath, "click en Razon");
		click(btnNit, folderPath, "click en Razon Social");
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		click(btnSelecClaro, folderPath, "click en Claro");
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ");
		desplazarseVertical(0,500);
		Titulo = driver.findElement(txtNumeroTitulo).getText();
		click(lblOficinaResponsable1, folderPath, "click en Oficina");
		click(lblOficinaResponsable2, folderPath, "click en Direccion General");
		click(lblTipoBodega1, folderPath, "click en Tipo Bodega");
		click(lblTipoBodega2, folderPath, "click en Particular");
		click(lblBodega1, folderPath, "click en Bodega");
		click(lblBodega2, folderPath, "click en Manizales");
		desplazarseVertical(0,300);
		click(lblTipoTitulo1, folderPath, "click en Tipo de titulo");
		click(lblTipoTitulo2, folderPath, "click en Certificado de deposito");
		click(lblTipoOperacion1, folderPath, "click en Tipo Operacion");
		click(lblTipoOperacion2, folderPath, "click en Incentivo");
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso");
		click(lblDivisionIngreso2, folderPath, "click en si");
		click(locatorVariable(btnPlazo, Plazo), folderPath, "Click en Plazos ");
		desplazarseVertical(0,300);
		writeText(txtPlazoCertificadoDias, "20", folderPath, "Se escribe Plazos certificado");
		writeText(txtPlazoContratoDias, "20", folderPath, "Se escribe Plazos contrato");
		click(locatorVariable(btnPoliza, Poliza), folderPath, "Click en Poliza ");
		desplazarseVertical(0,200);
		click(btnPoliza1, folderPath, "click en Poliza");
		click(btnPoliza2, folderPath, "click en Seguros Alfa");
		click(locatorVariable(btnTipoMercancia, Tipomerca), folderPath, "Click en Tipo de Mercancia ");
		desplazarseVertical(0,400);
		click(btnTipoMercancia1, folderPath, "click en Tipo Mercancia");
		click(btnTipoMercancia2, folderPath, "click en Aceite");
		writeText(txtDescripcionMercancia, "Aceite rojo", folderPath, "Se escribe descripcion general mercancia");
		writeText(txtmerma, "1", folderPath, "Se escribe Merma");
		click(btnAplicadaCalidad1, folderPath, "click en Aplica calidad");
		click(btnAplicadaCalidad2, folderPath, "click SI");
		click(btnMercanciaDesignada1, folderPath, "click en Mercancia Designada");
		click(btnMercanciaDesignada2, folderPath, "click en SI");
		writeText(txtObservaciones1, "Prueba", folderPath, "Se escribe Observaciones");
		click(locatorVariable(btnMercancias, Mercancias), folderPath, "Click en Poliza ");
		desplazarseVertical(0,300);
		click(btnTipoCargue1, folderPath, "click en Tipo de cargue");
		click(btnTipoCargue2, folderPath, "click en Individual");
		click(btnCrearMercancia, folderPath, "click en crear mercancia");
		//writeRandomAlp(txtDetalleMercancia1, );
		writeText(txtDetalleMercancia1, "Aceite rojo", folderPath, "Se escribe detalle mercancia");
		listRandom(lblUnidadMedida, folderPath, "Se selecciona valor random de la lista");
		listRandom(lblUnidadMedidaSuper, folderPath, "Se selecciona valor random de la lista");
		writeRandomNum(txtValorConversion, 1);
		writeRandomNum(txtCantidad, 3);
		writeRandomNum(txtValorUnitario, 3);
		writeText(txtFechaVencimientoMercancia, datePlusYear(3));
		writeText(txtObservacionMercancia, "Aceite rojo", folderPath, "Se escribe Observaciones de la mercancia");
		//writeRandomAlp(txtObservacionMercancia, 100);
		click(btnGuardarMercancia, folderPath, "Click en guardar mercancia");
		click(btnAceptarMercancias, folderPath, "Click en aceptar mercancia");
		click(locatorVariable(btnTarifas, tarifas), folderPath, "Click en opciones tarifas");
		desplazarseVertical(0,200);
		writeRandomNum(txtTarifa, 3);
		writeRandomNum(txtMinima, 2);
		click(btnMaterialSap, folderPath, "Click en Material Sap");
		click(btnMaterialSap2, folderPath, "Click en Material Sap luffy");
		click(locatorVariable(btnDivisionIngreso, ingreso), folderPath, "Click en Division de Ingreso");
		desplazarseVertical(0,400);
		searchElementGrid(txtOficinaExpedicion, OficnaExpedicion, folderPath, "556553,556558,Se valida Oficina Expedicion");
		searchElementGrid(txtOficinaAlmacenamiento, oficinaAlmacenamiento, folderPath, "556553,556558,Se valida Oficina Responsable");
		searchElementGrid(btnCodigoSapExp, CodigoSapExp, folderPath, "556558,556559, Se valida Codigo Sap Oficina Expedicion");
		searchElementGrid(btnCodigoSapAlm, CodigoSapAlm, folderPath, "556558,556559, Se valida Codigo Sap Oficina Almacenamiento");
		boolean txtPorcentajeExp = validarElemento(lblPorcentajeExp, 10);
		boolean txtPorcentajeAlm = validarElemento(lblPorcentajeAlm, 10);
		ValidacionObjetos(txtPorcentajeExp, txtPorcentajeAlm ,"caso exitoso 556559 se valida Porcentaje Ingreso Expedicion,Porcentaje Ingreso Almacenamiento",folderPath);
		writeText(btnPorcentajeEx, "50", folderPath, "Se escribe el Porcentaje Expedicion");
		writeText(btnPorcentajeAlm, "50", folderPath, "Se escribe el Porcentaje Almacenamiento");
		//searchElementGrid(lblPorcentajeExp , PorcentajeExp, folderPath, "556559,Se valida Porcentaje Ingreso Expedicion");
		//searchElementGrid(lblPorcentajeAlm, PorcentajeAlm, folderPath, "556559,Se valida Porcentaje Ingreso Almacenamiento");
		writeRandomAlp(btnCodigoSapExp, 20);
		writeRandomAlp(btnCodigoSapAlm, 20);
		click(btnSaveChanges, folderPath, "click en guardar cambios ");
		click(btnAceptar, folderPath, "click en Aceptar cambios ");
		
		///   aqui termina la creacion de titulo
		
		writeText(txtNitCargue, "1795");
		scrollElementV(folderPath, lblModificarHistorico, "scroll hacia estado de titulo");
		click(btnModificar, folderPath, "Click en modificar cliente");
		click(locatorVariable(btnInformacionGeneralTitulo, InfGTitulo), folderPath, "Click en InformacionTitulo, se desplega lista ");
		desplazarseVertical(0,600);
		click(lblDivisionIngreso1, folderPath, "click en Division Ingreso");
		click(lblDivisionIngreso3, folderPath, "click en NO");
		click(locatorVariable(btnDivisionIngreso, ingreso), folderPath, "Click en Division de Ingreso");
		desplazarseVertical(0,300);
		click(locatorVariable(btnAplicar, aplicar), folderPath, "Click en Aplicar");
		click(btnAceptar, folderPath, "click en Aceptar cambios ");
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
        ValidacionObjeto(alertaCreadaAplicada, "Validacion de aplicacion caso 556552 ", folderPath);
        click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
	
		return this;
	}

}
