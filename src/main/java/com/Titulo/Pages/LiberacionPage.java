package com.Titulo.Pages;

import org.openqa.selenium.WebDriver;
import com.Titulo.Maps.LiberacionMap;
import java.io.File;
import io.qameta.allure.Step;

public class LiberacionPage extends LiberacionMap {

	Object[] x;
	boolean val;
	int t = 15;

	//INSTANCIA DE DRIVER 
	public LiberacionPage(WebDriver driver) {
		super(driver);
	}

	//PASO A PASO PARA VALIDAR UNA LIBERACION DE TITULO
	@Step("Liberacion")
	public LiberacionPage consultarLiberacion(File folderPath,String Evidencia) throws Exception {
		
		//FORMULARIO DE CONSULTAR UNA LIBERACION
		scrollElementV(folderPath, NumberProrroga, "Se desplaza hacia el localizador codigo",Evidencia);
		String codigo = readText(NumberProrroga, folderPath, "Escritura",Evidencia);
		
		click(lblLiberacion, folderPath, "click en liberacion",Evidencia);
		writeText(txtCodigoTitulo, codigo, folderPath, "Escribe el codigo de liberacion",Evidencia);
		click(lblBusquedaLiberacion, folderPath, "Seleccion de numero liberaci�n",Evidencia);
		
		click(locatorVariable(lblDesplegables, " Informaci�n General del T�tulo "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);

		//SE VERIFICA SI LOS CAMPOS DEL FORMULARIO DE CONSULTAR LIBERACION ESTAN HABILITADOS O ENABLED
		isEnabled(lblNit, folderPath, "Campo Nit No editable",Evidencia);
		isEnabled(lblNombreRazonSocial, folderPath, "Campo Nombre raz�n social No editable",Evidencia);
		isEnabled(lblDireccion, folderPath, "Campo Direcci�n No editable",Evidencia);
		isEnabled(lblCiudad, folderPath, "Campo Ciudad No editable",Evidencia);
		isEnabled(lblFechaExpedicion, folderPath, "Campo Fecha Expedici�n No editable",Evidencia);
		isEnabled(lblOficinaExpedicion, folderPath, "Campo Oficina Expedici�n No editable",Evidencia);
		isEnabled(lblOficinaResponsable, folderPath, "Campo Oficina responsable de almacenamiento No editable",Evidencia);
		isEnabled(lblTipoBodega, folderPath, "Campo Tipo bodega No editable",Evidencia);
		
		//SECCIONES DEL TIULO COMO AUTORIZACIONES E INFORMACION GENERAL
		click(locatorVariable(lblDesplegables, " Informaci�n General del T�tulo "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);

		click(locatorVariable(lblDesplegables, " Autorizaciones pendientes "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);
		click(locatorVariable(lblDesplegables, " Autorizaciones pendientes "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);
		
		click(locatorVariable(lblDesplegables, " Detalle de mercanc�a "), folderPath, "Se ingresa a Informaci�n General del T�tulo",Evidencia);
		desplazarseVertical(0, 320);
		
		//SE VALIDAN CAMPOS DE DETALLE MERCANCIA
		isEnabled(lblValorInicialCredito, folderPath, "Campo Valor inicial de credito No editable",Evidencia);
		isEnabled(lblCantidadInicial, folderPath, "Campo Cantidad inicial mercancia No editable",Evidencia);
		isEnabled(lblValorInicialMercancia, folderPath, "Campo Valor inicial mercanc�a del t�tulo No editable",Evidencia);
		isEnabled(lblValorSaldo, folderPath, "Campo Valor saldo de mercanc�a en t�tulo No editable",Evidencia);
		isEnabled(lblPorcentajeRelacionCredito, folderPath, "Campo % de Relaci�n cr�dito/mercanc�a No editable",Evidencia);
		isEnabled(lblSaldoCredito, folderPath, "Campo Saldo del cred�to No editable",Evidencia);
		isEnabled(lblSaldoTitulo, folderPath, "Campo Saldo del t�tulo No editable",Evidencia);
		isEnabled(lblTotalLiberaciones, folderPath, "Campo Total de liberaciones ejecutadas No editable",Evidencia);
		
		desplazarseVertical(0, 340);
		
		isEnabled(lblValorTitulo, folderPath, "Campo Valor Titulo No editable",Evidencia);
		isEnabled(lblValorLiberar, folderPath, "Campo Valor a Liberar No editable",Evidencia);
		isEnabled(lblSaldoFinal, folderPath, "Campo Saldo Final No editable",Evidencia);
		isEnabled(lblCantidadLiberar, folderPath, "Campo Cantidad Liberar No editable",Evidencia);
		return this;
	}
}