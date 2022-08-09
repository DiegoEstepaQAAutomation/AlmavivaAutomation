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
			String tarifasE,String ingreso,String aplicar,String FechaDeCargue) throws Exception {
		
		
		
		
		///////////////////3
		//click(locatorVariable(lblModulos, ModuloT),folderPath,"click en el modulo titulos");
        //click(locatorVariable(lblsecciones, SubModuloExpedir),folderPath,"click en la seccion expedir");
		
		click(lblExpedir, folderPath, "Click en expedir");
		
		click(btnCrearExpedir, folderPath, "click en crear titulo");
		click(btnNit2, folderPath, "click en Razon");
		click(btnNit, folderPath, "click en Razon Social");
		writeText(txtConsultarNit, Empresa2, folderPath, "Se escribe claro");
		click(btnSelecClaro, folderPath, "click en Claro");
		click(locatorVariable(btnInformacionGeneralTitulo, informacionGeneralE), folderPath, "Click en InformacionTitulo, se desplega lista ");
		desplazarseVertical(0,500);
		
		//String Titulo = null;
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
		click(Plazos, folderPath, "Click en Plazos ");
		desplazarseVertical(0,300);
		writeText(txtPlazoCertificadoDias, "20", folderPath, "Se escribe Plazos certificado");
		writeText(txtPlazoContratoDias, "20", folderPath, "Se escribe Plazos contrato");
		click(locatorVariable(btnPoliza, etiquetaPoliza), folderPath, "Click en Poliza ");
		desplazarseVertical(0,200);
		click(btnPoliza1, folderPath, "click en Poliza");
		click(btnPoliza2, folderPath, "click en Seguros Alfa");
		click(TipoMercancia, folderPath, "Click en Tipo de Mercancia ");
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
		click(Mercancia, folderPath, "Click en Poliza ");
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
		click(Tarifa, folderPath, "Click en opciones tarifas");
		desplazarseVertical(0,200);
		writeRandomNum(txtTarifa, 3);
		writeRandomNum(txtMinima, 2);
		click(btnMaterialSap, folderPath, "Click en Material Sap");
		click(btnMaterialSap2, folderPath, "Click en Material Sap luffy");
		click(DivisionIngreso, folderPath, "Click en Division de Ingreso");
		desplazarseVertical(0,400);
		writeText(btnPorcentajeEx, "50", folderPath, "Se escribe el Porcentaje Expedicion");
		writeText(btnPorcentajeAlm, "50", folderPath, "Se escribe el Porcentaje Almacenamiento");
		writeRandomAlp(btnCodigoSapExp, 20);
		writeRandomAlp(btnCodigoSapAlm, 20);
		click(btnSaveChanges, folderPath, "click en guardar cambios ");
		click(btnAceptar, folderPath, "click en Aceptar cambios ");
		
		String Titulo2 = Titulo;
		
		///   aqui termina la creacion de titulo
		
		time(5);
		
		String fechaHoy = fechaPdf();
		
		
		
		click(btnCriterioTitulo, folderPath, "click en criterio de busqueda de titulo");
		selectElementList(btnCriterioTitulo, FechaDeCargue, folderPath, "selecciona busqueda por fecha");
		writeText(txtBuscarTitulo, "claro", folderPath, "escritura fecha actual, cambiar el valor de la empresa a conveniencia");
		
		//writeText(txtBuscarTitulo, datePlusYear(0), folderPath, "escritura fecha actual"); la pagina no toma todos los titulos de hoy solo los aplicados
		click(PaginacionNueva, folderPath, "Click en pagina--pagina cambiante revisar el xpath constantemente");
		
		click(btnRefreshTitulosPorfecha, folderPath, "click en refrescar al ultimo creado");
		click(btnRefreshTitulosPorfecha, folderPath, "click en refrescar al ultimo creado");
		
		String NuevoTitulo= driver.findElement(UltimoRegistroCreado).getText();;
		
		
		
		
		
		//click(btnCriterioTitulo, folderPath, "click en criterio de busqueda de titulo");
		//selectElementList(btnCriterioTitulo, "Título", folderPath, fechaHoy);
		
		click(locatorVariable(lblsecciones, "Liberación"),folderPath,"click en la seccion perfil");
		
		//clear(txtBuscarTitulo, folderPath, "limpia de texto existente");
		writeText(TxtTituloLiberacion, NuevoTitulo, folderPath, "escritura fecha actual");
		
		
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
		click(btnAplicar, folderPath, "Click en Aplicar");
		click(btnAceptar, folderPath, "click en Aceptar cambios ");
		boolean alertaCreadaAplicada = validarElemento(alertaLiberacion, 10);
        ValidacionObjeto(alertaCreadaAplicada, "Validacion de aplicacion caso: ", folderPath);
		
		
	
		return this;
	}  
	






}
	 


	
	
	
	






 


