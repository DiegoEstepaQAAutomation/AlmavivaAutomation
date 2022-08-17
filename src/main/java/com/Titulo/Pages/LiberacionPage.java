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
	public LiberacionPage consultarLiberacion(File folderPath) throws Exception {
		
		//FORMULARIO DE CONSULTAR UNA LIBERACION
		scrollElementV(folderPath, NumberProrroga, "Se desplaza hacia el localizador codigo");
		String codigo = readText(NumberProrroga, folderPath, "Escritura");
		
		click(lblLiberacion, folderPath, "");
		writeText(txtCodigoTitulo, codigo, folderPath, "Escribe el codigo de liberacion");
		click(lblBusquedaLiberacion, folderPath, "Seleccion de numero liberaci�n");
		
		click(locatorVariable(lblDesplegables, " Informaci�n General del T�tulo "), folderPath, "Se ingresa a Informaci�n General del T�tulo");

		//SE VERIFICA SI LOS CAMPOS DEL FORMULARIO DE CONSULTAR LIBERACION ESTAN HABILITADOS O ENABLED
		isEnabled(lblNit, folderPath, "Campo Nit No editable");
		isEnabled(lblNombreRazonSocial, folderPath, "Campo Nombre raz�n social No editable");
		isEnabled(lblDireccion, folderPath, "Campo Direcci�n No editable");
		isEnabled(lblCiudad, folderPath, "Campo Ciudad No editable");
		isEnabled(lblFechaExpedicion, folderPath, "Campo Fecha Expedici�n No editable");
		isEnabled(lblOficinaExpedicion, folderPath, "Campo Oficina Expedici�n No editable");
		isEnabled(lblOficinaResponsable, folderPath, "Campo Oficina responsable de almacenamiento No editable");
		isEnabled(lblTipoBodega, folderPath, "Campo Tipo bodega No editable");
		
		//SECCIONES DEL TIULO COMO AUTORIZACIONES E INFORMACION GENERAL
		click(locatorVariable(lblDesplegables, " Informaci�n General del T�tulo "), folderPath, "Se ingresa a Informaci�n General del T�tulo");

		click(locatorVariable(lblDesplegables, " Autorizaciones pendientes "), folderPath, "Se ingresa a Informaci�n General del T�tulo");
		click(locatorVariable(lblDesplegables, " Autorizaciones pendientes "), folderPath, "Se ingresa a Informaci�n General del T�tulo");
		
		click(locatorVariable(lblDesplegables, " Detalle de mercanc�a "), folderPath, "Se ingresa a Informaci�n General del T�tulo");
		desplazarseVertical(0, 320);
		
		//SE VALIDAN CAMPOS DE DETALLE MERCANCIA
		isEnabled(lblValorInicialCredito, folderPath, "Campo Valor inicial de credito No editable");
		isEnabled(lblCantidadInicial, folderPath, "Campo Cantidad inicial mercancia No editable");
		isEnabled(lblValorInicialMercancia, folderPath, "Campo Valor inicial mercanc�a del t�tulo No editable");
		isEnabled(lblValorSaldo, folderPath, "Campo Valor saldo de mercanc�a en t�tulo No editable");
		isEnabled(lblPorcentajeRelacionCredito, folderPath, "Campo % de Relaci�n cr�dito/mercanc�a No editable");
		isEnabled(lblSaldoCredito, folderPath, "Campo Saldo del cred�to No editable");
		isEnabled(lblSaldoTitulo, folderPath, "Campo Saldo del t�tulo No editable");
		isEnabled(lblTotalLiberaciones, folderPath, "Campo Total de liberaciones ejecutadas No editable");
		
		desplazarseVertical(0, 340);
		
		isEnabled(lblValorTitulo, folderPath, "Campo Valor Titulo No editable");
		isEnabled(lblValorLiberar, folderPath, "Campo Valor a Liberar No editable");
		isEnabled(lblSaldoFinal, folderPath, "Campo Saldo Final No editable");
		isEnabled(lblCantidadLiberar, folderPath, "Campo Cantidad Liberar No editable");
		return this;
	}
}