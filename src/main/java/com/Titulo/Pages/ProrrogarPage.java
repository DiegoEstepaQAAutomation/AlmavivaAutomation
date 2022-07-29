package com.Titulo.Pages;

import org.openqa.selenium.WebDriver;
import com.Titulo.Maps.ProrrogarMap;
import java.io.File;
import io.qameta.allure.Step;

public class ProrrogarPage extends ProrrogarMap {

	Object[] x;
	boolean val;
	int t = 15;
	
	String Prorrogas = "546953, 546954";

	public ProrrogarPage(WebDriver driver) {
		super(driver);
	}

	@Step("proceso de prorroga")
	public ProrrogarPage prorrogas(File folderPath) throws Exception {

		scrollElementV(folderPath, NumberProrroga, "Se desplaza hacia el localizador codigo");
		String codigo = readText(NumberProrroga, folderPath, "Escritura");

		click(lblProrrogar, folderPath, "");
		writeText(txtCodigoTitulo, codigo, folderPath, "Se Escribe el titulo que se va a consultar en prorroga");
		click(lblBusquedaProrroga, folderPath, "Seleccion de numero prorroga");
		click(lblInformacionBasicaTitulo, folderPath, "Se da click en informacion basica de titulo");
		desplazarseVertical(0, 160);

		isEnabled(lblNit, folderPath, "Campo Nit No editable");
		isEnabled(lblRazonSocial, folderPath, "Campo Razon social No editable");
		isEnabled(lblDireccion, folderPath, "Campo Direccion No editable");
		isEnabled(lblCiudad, folderPath, "Campo Ciudad No editable");
		isEnabled(lblFechaExpedicion, folderPath, "Campo Fecha Expedicion No editable");
		isEnabled(lblOficinaExpedicion, folderPath, "Campo Oficina Expedicion No editable");
		isEnabled(lblTipoBodega, folderPath, "Campo Tipo de Bodega No editable");

		click(lblInformacionBasicaTitulo, folderPath, "Se da click en informacion basica de titulo");
		click(OptionDetalleMercancia, folderPath, "Se da click en informacion basica de titulo");
		desplazarseVertical(0, 140);

		isEnabled(lblValorInicial, folderPath, "Campo Valor inicial No editable");
		isEnabled(lblMercanciaInicial, folderPath, "Campo Mercancia inicial No editable");
		isEnabled(lblValorMercanciaTitulo, folderPath, "Campo Titulo de Mercancia No editable");
		isEnabled(lblSaldo, folderPath, "Campo Saldo No editable");
		isEnabled(lblrelacionCredito, folderPath, "Campo Relacion Credito No editable");
		isEnabled(lblSaldoCredito, folderPath, "Campo Saldo de credito No editable");
		isEnabled(lblSaldoTitulo, folderPath, "Campo Saldo de titulo No editable");
		isEnabled(lblLiberacionesEjecutadas, folderPath, "Campo Liberaciones Ejecutadas No editable");

		click(OptionDetalleMercancia, folderPath, "Se da click en informacion basica de titulo");
		click(CertificadoDepositoMercancia, folderPath, "Se da click en certificado deposito mercancia");
		writeRandomNum(txtplazoDeposito, 2);
		isEnabled(lblPlazoDeposito, folderPath, "Campo Plazo Deposito No editable");
		writeRandomNum(txtplazoCertificado, 2);
		isEnabled(lblNuevaFecha, folderPath, "Campo Nueva Fecha No editable");

		scrollElementV(folderPath, btnGuardarProrroga, "Se desplaza hasta el boton guardar ");
		click(btnGuardarProrroga, folderPath, "Se da click en guardar prorroga");
		click(btnCancelarProrroga, folderPath, "Click en cancelar");
		return this;
	}
	
	
	
	@Step("proceso de prorroga")
	public ProrrogarPage prorrogasHU24(File folderPath,String TituloModificarProrroga) throws Exception 
	{
		
		writeText(txtNitCargue, TituloModificarProrroga, folderPath, "Se escribe el titulo a buscar");
		
		scrollElementH(lblModificarHistorico);
		
		String codigo = readText(NumberProrrogaValida, folderPath, "Escritura");
		
		click(lblProrrogar, folderPath, "");
		
		writeText(txtCodigoTitulo, codigo, folderPath, "titulo con prorroga a buscar");
		
		click(lblBusquedaProrroga, folderPath, "Seleccion de numero prorroga");
		
		click(CertificadoDepositoMercancia, folderPath, "Click sobre bono");
		
		writeRandomNum(txtplazoDeposito, 2);
		
		writeRandomNum(txtplazoCertificado, 2);
		
		writeRandomNum(txtplazoCredito, 2);
		
		
		scrollElementV(folderPath, btnGuardarProrroga, "Se desplaza hasta el boton guardar ");
		
		
		screenshot(folderPath ,"Estos son los casos: " + Prorrogas);
		
				
		
		return this;
		
	
	
	
	
	
	}

	
	
	
	
}