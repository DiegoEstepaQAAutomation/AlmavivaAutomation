package com.Titulo.Pages;

import org.openqa.selenium.WebDriver;
import com.Titulo.Maps.LiberacionMap;
import java.io.File;
import io.qameta.allure.Step;

public class LiberacionPage extends LiberacionMap {

	Object[] x;
	boolean val;
	int t = 15;

	public LiberacionPage(WebDriver driver) {
		super(driver);
	}

	@Step("Liberacion")
	public LiberacionPage consultarLiberacion(File folderPath) throws Exception {
		
		scrollElementV(folderPath, NumberProrroga, "Se desplaza hacia el localizador codigo");
		String codigo = readText(NumberProrroga, folderPath, "Escritura");
		
		click(lblLiberacion, folderPath, "");
		writeText(txtCodigoTitulo, codigo, folderPath, "Escribe el codigo de liberacion");
		click(lblBusquedaLiberacion, folderPath, "Seleccion de numero liberación");
		
		click(locatorVariable(lblDesplegables, " Información General del Título "), folderPath, "Se ingresa a Información General del Título");

		isEnabled(lblNit, folderPath, "Campo Nit No editable");
		isEnabled(lblNombreRazonSocial, folderPath, "Campo Nombre razón social No editable");
		isEnabled(lblDireccion, folderPath, "Campo Dirección No editable");
		isEnabled(lblCiudad, folderPath, "Campo Ciudad No editable");
		isEnabled(lblFechaExpedicion, folderPath, "Campo Fecha Expedición No editable");
		isEnabled(lblOficinaExpedicion, folderPath, "Campo Oficina Expedición No editable");
		isEnabled(lblOficinaResponsable, folderPath, "Campo Oficina responsable de almacenamiento No editable");
		isEnabled(lblTipoBodega, folderPath, "Campo Tipo bodega No editable");
		
		click(locatorVariable(lblDesplegables, " Información General del Título "), folderPath, "Se ingresa a Información General del Título");

		click(locatorVariable(lblDesplegables, " Autorizaciones pendientes "), folderPath, "Se ingresa a Información General del Título");
		click(locatorVariable(lblDesplegables, " Autorizaciones pendientes "), folderPath, "Se ingresa a Información General del Título");
		
		click(locatorVariable(lblDesplegables, " Detalle de mercancía "), folderPath, "Se ingresa a Información General del Título");
		desplazarseVertical(0, 320);
		
		isEnabled(lblValorInicialCredito, folderPath, "Campo Valor inicial de credito No editable");
		isEnabled(lblCantidadInicial, folderPath, "Campo Cantidad inicial mercancia No editable");
		isEnabled(lblValorInicialMercancia, folderPath, "Campo Valor inicial mercancía del título No editable");
		isEnabled(lblValorSaldo, folderPath, "Campo Valor saldo de mercancía en título No editable");
		isEnabled(lblPorcentajeRelacionCredito, folderPath, "Campo % de Relación crédito/mercancía No editable");
		isEnabled(lblSaldoCredito, folderPath, "Campo Saldo del credíto No editable");
		isEnabled(lblSaldoTitulo, folderPath, "Campo Saldo del título No editable");
		isEnabled(lblTotalLiberaciones, folderPath, "Campo Total de liberaciones ejecutadas No editable");
		
		desplazarseVertical(0, 340);
		
		isEnabled(lblValorTitulo, folderPath, "Campo Valor Titulo No editable");
		isEnabled(lblValorLiberar, folderPath, "Campo Valor a Liberar No editable");
		isEnabled(lblSaldoFinal, folderPath, "Campo Saldo Final No editable");
		isEnabled(lblCantidadLiberar, folderPath, "Campo Cantidad Liberar No editable");
		return this;
	}
}