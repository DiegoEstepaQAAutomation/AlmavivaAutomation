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

	//INSTANCIA DEL DRIVER
	public ProrrogarPage(WebDriver driver) {
		super(driver);
	}

	//PASO A PASO DEL FORMULARIO DE PRORROGA
	@Step("proceso de prorroga")
	public ProrrogarPage prorrogas(File folderPath,String Evidencia) throws Exception {

		//SE INGRESA AL FORMULARIO DE PRORROGA Y SE VALIDAN COMO HABILITADOS LOS CAMPOS DEL FORMULARIO
		scrollElementV(folderPath, NumberProrroga, "Se desplaza hacia el localizador codigo",Evidencia);
		String codigo = readText(NumberProrroga, folderPath, "Escritura",Evidencia);

		click(lblProrrogar, folderPath, "click en elemento",Evidencia);
		writeText(txtCodigoTitulo, codigo, folderPath, "Se Escribe el titulo que se va a consultar en prorroga",Evidencia);
		click(lblBusquedaProrroga, folderPath, "Seleccion de numero prorroga",Evidencia);
		click(lblInformacionBasicaTitulo, folderPath, "Se da click en informacion basica de titulo",Evidencia);
		desplazarseVertical(0, 160);

		isEnabled(lblNit, folderPath, "Campo Nit No editable",Evidencia);
		isEnabled(lblRazonSocial, folderPath, "Campo Razon social No editable",Evidencia);
		isEnabled(lblDireccion, folderPath, "Campo Direccion No editable",Evidencia);
		isEnabled(lblCiudad, folderPath, "Campo Ciudad No editable",Evidencia);
		isEnabled(lblFechaExpedicion, folderPath, "Campo Fecha Expedicion No editable",Evidencia);
		isEnabled(lblOficinaExpedicion, folderPath, "Campo Oficina Expedicion No editable",Evidencia);
		isEnabled(lblTipoBodega, folderPath, "Campo Tipo de Bodega No editable",Evidencia);

		click(lblInformacionBasicaTitulo, folderPath, "Se da click en informacion basica de titulo",Evidencia);
		click(OptionDetalleMercancia, folderPath, "Se da click en informacion basica de titulo",Evidencia);
		desplazarseVertical(0, 140);

		//VALIDACIONES DE CAMPOS HABILITADOS
		isEnabled(lblValorInicial, folderPath, "Campo Valor inicial No editable",Evidencia);
		isEnabled(lblMercanciaInicial, folderPath, "Campo Mercancia inicial No editable",Evidencia);
		isEnabled(lblValorMercanciaTitulo, folderPath, "Campo Titulo de Mercancia No editable",Evidencia);
		isEnabled(lblSaldo, folderPath, "Campo Saldo No editable",Evidencia);
		isEnabled(lblrelacionCredito, folderPath, "Campo Relacion Credito No editable",Evidencia);
		isEnabled(lblSaldoCredito, folderPath, "Campo Saldo de credito No editable",Evidencia);
		isEnabled(lblSaldoTitulo, folderPath, "Campo Saldo de titulo No editable",Evidencia);
		isEnabled(lblLiberacionesEjecutadas, folderPath, "Campo Liberaciones Ejecutadas No editable",Evidencia);

		click(OptionDetalleMercancia, folderPath, "Se da click en informacion basica de titulo",Evidencia);
		click(CertificadoDepositoMercancia, folderPath, "Se da click en certificado deposito mercancia",Evidencia);
		writeRandomNum(txtplazoDeposito, 2);
		isEnabled(lblPlazoDeposito, folderPath, "Campo Plazo Deposito No editable",Evidencia);
		writeRandomNum(txtplazoCertificado, 2);
		isEnabled(lblNuevaFecha, folderPath, "Campo Nueva Fecha No editable",Evidencia);

		scrollElementV(folderPath, btnGuardarProrroga, "Se desplaza hasta el boton guardar ",Evidencia);
		click(btnGuardarProrroga, folderPath, "Se da click en guardar prorroga",Evidencia);
		click(btnCancelarProrroga, folderPath, "Click en cancelar",Evidencia);
		return this;
	}
	
	
	
	//EJECUCION DEL HU24 DE PRORROGAS(2 CASOS)
	@Step("proceso de prorroga")
	public ProrrogarPage prorrogasHU24(File folderPath,String TituloModificarProrroga,String Evidencia) throws Exception 
	{
		
		//PASO A PASO DE PRORROGAS DE UN TITULO
		writeText(txtNitCargue, TituloModificarProrroga, folderPath, "Se escribe el titulo a buscar",Evidencia);
		
		scrollElementH(lblModificarHistorico);
		
		String codigo = readText(NumberProrrogaValida, folderPath, "Escritura",Evidencia);
		
		click(lblProrrogar, folderPath, "click en prorrogar",Evidencia);
		
		writeText(txtCodigoTitulo, codigo, folderPath, "titulo con prorroga a buscar",Evidencia);
		
		click(lblBusquedaProrroga, folderPath, "Seleccion de numero prorroga",Evidencia);
		
		click(CertificadoDepositoMercancia, folderPath, "Click sobre bono",Evidencia);
		
		//VALORES NUMERICOS RANDOM EN PLAZOS
		
		writeRandomNum(txtplazoDeposito, 2);
		
		writeRandomNum(txtplazoCertificado, 2);
		
		writeRandomNum(txtplazoCredito, 2);
		
		
		scrollElementV(folderPath, btnGuardarProrroga, "Se desplaza hasta el boton guardar ",Evidencia);
		
		//ESTE PASO CREA UN MENSAJE CON LOS CASOS EJECUTADOS EN EL INFORME FINAL
		screenshot(folderPath ,"Estos son los casos: " + Prorrogas);
		
				
		
		return this;
		
	
	
	
	
	
	}

	
	
	
	
}