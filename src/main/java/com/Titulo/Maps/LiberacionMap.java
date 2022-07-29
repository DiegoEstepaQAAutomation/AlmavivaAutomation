package com.Titulo.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class LiberacionMap extends BasePage {

	public LiberacionMap(WebDriver driver) {
		super(driver);
	}
	
	
	protected By NumberProrroga = By.xpath("//*[@id='tbClientes']/tbody/tr[10]/td[1]");
	protected By txtCodigoTitulo = By.id("titulo");
	
	protected By lblLiberacion = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[(text() = 'Liberación')]");
	protected By lblBusquedaLiberacion = By.xpath("//div/div/ngb-typeahead-window/button");
	protected By lblDesplegables = By.xpath("//*[@id='contenido']/main-titulos/app-liberacion-mercancia/div/accordion/accordion-group/div/div/div/div/button[contains(text(),'{0}')]");

	protected By lblNit = By.id("nit");
	protected By lblNombreRazonSocial = By.id("nombreRazonSocial");
	protected By lblDireccion = By.id("direccion");
	protected By lblCiudad = By.id("ciudad");
	protected By lblFechaExpedicion = By.id("fechaExpedicion");
	protected By lblOficinaExpedicion = By.id("oficinaExpedicion");
	protected By lblOficinaResponsable = By.id("oficinaResponsable");
	protected By lblTipoBodega = By.id("tipoBodega");
	
	protected By lblValorInicialCredito = By.id("valorInicialCredito");
	protected By lblCantidadInicial = By.id("mercanciaInicial");
	protected By lblValorInicialMercancia = By.id("valorInicialMercancia");
	protected By lblValorSaldo = By.id("valorSaldoMercancia");
	protected By lblPorcentajeRelacionCredito = By.id("relacionCreditoMercancia");
	protected By lblSaldoCredito = By.id("saldoCredito");
	protected By lblSaldoTitulo = By.id("saldoTitulo");
	protected By lblTotalLiberaciones = By.id("totalLiberacionesEjecutadas");
	
	protected By lblValorTitulo = By.id("valorTitulo");
	protected By lblValorLiberar = By.id("valorLiberar");
	protected By lblSaldoFinal = By.xpath("//accordion-group[3]/div/div[2]/div/form/div[3]/input");
	protected By lblCantidadLiberar = By.xpath("//accordion-group[3]/div/div[2]/div/form/div[4]/input");
}
