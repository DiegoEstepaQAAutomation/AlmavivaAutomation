package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirInformacionGeneralTituloPage extends BasePage {

	// INFORMACION GENERAL DEL TITULO
	By lblInformacionGeneralDelTitulo = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[1]/div/div[1]/div/div/button");
	By lblOficinaResponsableDeAlmacenamiento = By.id("oficinaResponsableSelect");
	By OficinaResponsableDeAlmacenamientoPereira = By.xpath("//*[@id=\"oficinaResponsableSelect\"]/option[13]");
	By lblTipoDeBodega = By.id("tipoBodega");
	By lblPropia = By.xpath("//*[@id=\"tipoBodega\"]/option[2]");
	By lblParticular = By.xpath("//*[@id=\"tipoBodega\"]/option[3]");
	By lblParticularArrendada = By.xpath("//*[@id=\"tipoBodega\"]/option[4]");
	By lblTransito = By.xpath("//*[@id=\"tipoBodega\"]/option[5]");
	By lblBodega = By.id("bodegaSelect");
	By lblBodegaOpcion1 = By.xpath("//*[@id=\"bodegaSelect\"]/option[2]");
	By txtDireccion = By.id("bodeDireccion");
	By lblTipoDeTitulo = By.id("tipoTituloSelect");
	By bonoPrenda = By.id("//*[@id=\"tipoTituloSelect\"]/option[3]");
	By cbxMercanciaEnTransito = By.id("mercanciaTransito");
	By txtDesde = By.id("desde");
	By txtHasta = By.id("hasta");
	By btnGuardarTitulo = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[3]/div/button[1]");
	By btnCancelarTitulo = By.xpath("/html/body/div[3]/div/div[3]/button[2]");
	By btnAceptarTitulo = By.xpath("/html/body/div[3]/div/div[3]/button[1]");
	By btnCancelarTituloOpcion2 = By.xpath("/html/body/div[3]/div/div[3]/button[2]");
	

	// TIPO DE TITULO VER CERTIFICADO DE DEPOSITO DE MERCANCIA
	By SeleccionarCertificado = By.xpath("//*[@id=\"tipoTituloSelect\"]/option[2]");
	By lblVerCertificado = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By CrearCertificado = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[1]/div/a");
	By ListaNitNombreRazonSocialCertificado = By.id("tipo");
	By lblNitCertificado = By.xpath("//*[@id=\"tipo\"]/option[1]");
	By lblNombreRazonSocialCertificado = By.xpath("//*[@id=\"tipo\"]/option[2]");
	By txtNitNombreRazonSocialCertificado = By.xpath("//*[@id=\"termino\"]");
	By SeleccionarNitNombreRazonSocial = By.cssSelector(".ngb-highlight");
	By ListaTipoEndoso = By.id("tipointeres");
	By lblPropiedad = By.xpath("//*[@id=\"tipointeres\"]/option[2]");
	By lblGarantia = By.xpath("//*[@id=\"tipointeres\"]/option[3]");
	By txtFechaEndoso = By.id("fendoso");
	By bntGuardarCertificado = By.xpath("/html/body/modal-container/div/div/app-depositomencancia/div/form/div[2]/button[2]");
	By btnCancelarCertificado = By.xpath("/html/body/modal-container/div/div/app-depositomencancia/div/form/div[2]/button[1]");
	By btnAceptarCertificado = By.xpath("");
	By btnCancelarCertificadoOpcion2 = By.xpath("");
	
	// VER BONO DE PRENDA
	By SeleccionarBonoDePrenda = By.xpath("//*[@id=\"tipoTituloSelect\"]/option[3]");
	By lblVerBonoDePrenda = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By CrearBono = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[1]/div/a");
	By ListaNitNombreRazonSocialBono = By.id("tipo");
	By lblNitBono = By.xpath("//*[@id=\"tipo\"]/option[1]");
	By lblNombreRazonSocialBono = By.xpath("//*[@id=\"tipo\"]/option[2]");
	By txtNitNombreRazonSocialBono = By.xpath("/html/body/modal-container/div/div/app-bonoprenda/div/app-fitro-acreedor/div/div/div/form/div[2]/input");
	By SeleccionarNitNombreRazonSocialBono = By.cssSelector(".ngb-highlight");
	By txtCapitalInicialCreditoBono = By.id("capital");
	By txtDiasDePlazoBono = By.id("diasplazo");
	By txtTipoInteresBono = By.id("tipointeres");
	By txtValorInteresBono = By.id("valorinteres");
	By txtFrecuenciaBono = By.id("frecuencia");
	By bntGuardarBono = By.xpath("/html/body/modal-container/div/div/app-bonoprenda/div/form/div[2]/button[2]");
	By btnCancelarBono = By.xpath("/html/body/modal-container/div/div/app-bonoprenda/div/form/div[2]/button[1]");
	By btnAceptar = By.xpath("/html/body/div[3]/div/div[3]/button[1]");
	By btnCancelarBonoOpcion2 = By.xpath("/html/body/div[3]/div/div[3]/button[2]");
	By btnEliminarBono = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[12]/button");
	By btnEliminarCertificado = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/table/tbody/tr/td[9]/button");
	
	
	public ExpedirInformacionGeneralTituloPage(WebDriver driver) {
		super(driver);
	}

	// INFORMACION GENERAL DEL TITULO
	/*@Step("Información General del Título")
	public ExpedirInformacionGeneralTituloPage InformaciónGeneralDelTítulo() {

		Utilidades.waitInMs(3000);
		click(lblInformacionGeneralDelTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Oficina Responsable de Almacenamiento")
	public ExpedirInformacionGeneralTituloPage SeleccionarOficinaResponsableDeAlmacenamiento() {

		Utilidades.waitInMs(3000);
		click(lblOficinaResponsableDeAlmacenamiento);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Oficina Responsable de Almacenamiento Pereira")
	public ExpedirInformacionGeneralTituloPage OficinaResponsableDeAlmacenamientoPereira() {

		Utilidades.waitInMs(3000);
		click(OficinaResponsableDeAlmacenamientoPereira);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Aleatorio Oficina Responsable de Almacenamiento")
	public ExpedirInformacionGeneralTituloPage AleatorioOficinaResponsableDeAlmacenamiento() {

		Utilidades.waitInMs(3000);

		WebElement Drplistdown = driver.findElement(By.id("oficinaResponsableSelect"));
		Select objSel = new Select(Drplistdown);
		List<WebElement> weblist = objSel.getOptions();
		int iCnt = weblist.size();
		Random num = new Random();
		int iSelect = num.nextInt(iCnt);
		objSel.selectByIndex(iSelect);
		System.out.println(Drplistdown.getAttribute("value"));

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Lista Tipo de Bodega")
	public ExpedirInformacionGeneralTituloPage ListaTipoDeBodega() {

		Utilidades.waitInMs(3000);
		click(lblTipoDeBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Tipo de Bodega Propia")
	public ExpedirInformacionGeneralTituloPage SeleccionarTipoDeBodegaPropia() {

		Utilidades.waitInMs(3000);
		click(lblPropia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Tipo de Bodega Particular")
	public ExpedirInformacionGeneralTituloPage SeleccionarTipoDeBodegaParticular() {

		Utilidades.waitInMs(3000);
		click(lblParticular);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Tipo de Bodega Particular Arrendada")
	public ExpedirInformacionGeneralTituloPage SeleccionarTipoDeBodegaParticularArrendada() {

		Utilidades.waitInMs(3000);
		click(lblParticularArrendada);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Tipo de Bodega Transito")
	public ExpedirInformacionGeneralTituloPage SeleccionarTipoDeBodegaTransito() {

		Utilidades.waitInMs(3000);
		click(lblTransito);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Lista Bodega")
	public ExpedirInformacionGeneralTituloPage ListaBodega() {

		Utilidades.waitInMs(3000);
		click(lblBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Lista Bodega opción 1")
	public ExpedirInformacionGeneralTituloPage ListaBodegaOpcion1() {

		Utilidades.waitInMs(3000);
		click(lblBodegaOpcion1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Aleatorio Bodega")
	public ExpedirInformacionGeneralTituloPage AleatorioBodega() {

		Utilidades.waitInMs(3000);

		WebElement Drplistdown = driver.findElement(By.id("bodegaSelect"));
		Select objSel = new Select(Drplistdown);
		List<WebElement> weblist = objSel.getOptions();
		int iCnt = weblist.size();
		Random num = new Random();
		int iSelect = num.nextInt(iCnt);
		objSel.selectByIndex(iSelect);
		System.out.println(Drplistdown.getAttribute("value"));

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Dirección")
	public ExpedirInformacionGeneralTituloPage Direccion(String direccion) {

		Utilidades.waitInMs(3000);
		writeText(txtDireccion, direccion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(2000);

		return this;
	}

	@Step("Lista Tipo De Titulo")
	public ExpedirInformacionGeneralTituloPage ListaTipoDeTitulo() {

		Utilidades.waitInMs(3000);
		click(lblTipoDeTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Lista Tipo De Titulo")
	public ExpedirInformacionGeneralTituloPage TipoDeTitulo() {

		Utilidades.waitInMs(1500);
		click(bonoPrenda);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Mercancia en transito")
	public ExpedirInformacionGeneralTituloPage SeleccionarMercanciaEnTransito() {

		Utilidades.waitInMs(3000);
		click(cbxMercanciaEnTransito);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Mercancia Transito Desde")
	public ExpedirInformacionGeneralTituloPage MercanciaTransitoDesde(String desde) {

		Utilidades.waitInMs(3000);
		writeText(txtDesde, desde);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Mercancia Transito Desde")
	public ExpedirInformacionGeneralTituloPage ClearMercanciaTransitoDesde() {

		Utilidades.waitInMs(3000);
		clear(txtDesde);
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Mercancia Transito Hasta")
	public ExpedirInformacionGeneralTituloPage MercanciaTransitoHasta(String hasta) {

		Utilidades.waitInMs(3000);
		writeText(txtHasta, hasta);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Mercancia Transito Hasta")
	public ExpedirInformacionGeneralTituloPage ClearMercanciaTransitoHasta() {

		Utilidades.waitInMs(3000);
		clear(txtHasta);
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Guardar Titulo")
	public ExpedirInformacionGeneralTituloPage GuardarTitulo() {

		Utilidades.waitInMs(3000);
		click(btnGuardarTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Cancelar Titulo")
	public ExpedirInformacionGeneralTituloPage CancelarTitulo() {

		Utilidades.waitInMs(3000);
		click(btnCancelarTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar Titulo")
	public ExpedirInformacionGeneralTituloPage AceptarTitulo() {

		Utilidades.waitInMs(3000);
		click(btnAceptarTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Cancelar Titulo opción 2")
	public ExpedirInformacionGeneralTituloPage CancelarTituloOpcion2() {

		Utilidades.waitInMs(3000);
		click(btnCancelarTituloOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	// CERTIFICADO DE DEPOSITO MERCANCIA
	@Step("Etiqueta crear Certificado")
	public ExpedirInformacionGeneralTituloPage EtiquetaCrearCertificado() {

		Utilidades.waitInMs(3000);

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[1]/div/a"));
		action.moveToElement(element).perform();

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Certificado de Depósito de Mercancía")
	public ExpedirInformacionGeneralTituloPage SeleccionarCertificado() {

		Utilidades.waitInMs(3000);
		click(SeleccionarCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Ver Certificado de Depósito de Mercancía")
	public ExpedirInformacionGeneralTituloPage VerCertificado() {

		Utilidades.waitInMs(3000);
		click(lblVerCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Crear Certificado de Depósito de Mercancía")
	public ExpedirInformacionGeneralTituloPage CrearCertificado() {

		Utilidades.waitInMs(3000);
		click(CrearCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Lista Certificado de Depósito Mercancía")
	public ExpedirInformacionGeneralTituloPage ListaCertificado() {

		Utilidades.waitInMs(3000);
		click(ListaNitNombreRazonSocialCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Nit Certificado de Depósito Mercancía")
	public ExpedirInformacionGeneralTituloPage NitCertificado() {

		Utilidades.waitInMs(3000);
		click(lblNitCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Nombre / Razón Social Certificado de Depósito Mercancía")
	public ExpedirInformacionGeneralTituloPage NombreRazonSocialCertificado() {

		Utilidades.waitInMs(3000);
		click(lblNombreRazonSocialCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Texto Nit - Nombre / Razón Social Certificado de Depósito Mercancía")
	public ExpedirInformacionGeneralTituloPage TextoNitNombreRazonSocialCertificado(String nit) {

		Utilidades.waitInMs(3000);
		writeText(txtNitNombreRazonSocialCertificado, nit);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Texto Nit - Nombre / Razón Social Certificado de Depósito Mercancía")
	public ExpedirInformacionGeneralTituloPage ClearTextoNitNombreRazonSocialCertificado() {

		Utilidades.waitInMs(3000);
		clear(txtNitNombreRazonSocialCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Nit - Nombre / Razón Social Certificado de Depósito Mercancía")
	public ExpedirInformacionGeneralTituloPage SeleccionarNitNombreRazonSocialCertificado() {

		Utilidades.waitInMs(3000);
		click(SeleccionarNitNombreRazonSocial);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Lista Tipo endoso")
	public ExpedirInformacionGeneralTituloPage ListaTipoEndoso() {

		Utilidades.waitInMs(3000);
		click(ListaTipoEndoso);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Propiedad Tipo endoso")
	public ExpedirInformacionGeneralTituloPage PropiedadTipoEndoso() {

		Utilidades.waitInMs(3000);
		click(lblPropiedad);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Garantia Tipo endoso")
	public ExpedirInformacionGeneralTituloPage GarantiaTipoEndoso() {

		Utilidades.waitInMs(3000);
		click(lblGarantia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Fecha Endoso")
	public ExpedirInformacionGeneralTituloPage FechaEndoso(String fechaEndoso) {

		Utilidades.waitInMs(3000);
		writeText(txtFechaEndoso, fechaEndoso);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Fecha Endoso")
	public ExpedirInformacionGeneralTituloPage ClearFechaEndoso() {

		Utilidades.waitInMs(3000);
		clear(txtFechaEndoso);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Cancelar Certificado")
	public ExpedirInformacionGeneralTituloPage CancelarCertificado() {

		Utilidades.waitInMs(3000);
		click(btnCancelarCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Guardar Certificado")
	public ExpedirInformacionGeneralTituloPage GuardarCertificado() {

		Utilidades.waitInMs(3000);
		click(bntGuardarCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar Certificado")
	public ExpedirInformacionGeneralTituloPage AceptarCertificado() {

		Utilidades.waitInMs(3000);
		click(btnAceptarCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Cancelar Certificado")
	public ExpedirInformacionGeneralTituloPage CancelarCertificadoOpcion2() {

		Utilidades.waitInMs(3000);
		click(btnCancelarCertificadoOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Scroll horizontal derecha Certificado")
	public ExpedirInformacionGeneralTituloPage ScrollDerechaCertificado() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/table/tbody/tr/td[9]/button"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		return this;
	}
	
	@Step("Scroll horizontal derecha Certificado")
	public ExpedirInformacionGeneralTituloPage ScrollDerechaCertificado2() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/table/tbody/tr/td[8]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		return this;
	}
	
	@Step("Eliminar Certificado")
	public ExpedirInformacionGeneralTituloPage EliminarCertificado() {

		Utilidades.waitInMs(3000);
		click(btnEliminarCertificado);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	// BONO DE PRENDA
	@Step("Etiqueta crear Bono")
	public ExpedirInformacionGeneralTituloPage EtiquetaCrearBono() {

		Utilidades.waitInMs(3000);

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[1]/div/a"));
		action.moveToElement(element).perform();

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Bono de Depósito de Mercancía")
	public ExpedirInformacionGeneralTituloPage SeleccionarBono() {

		Utilidades.waitInMs(3000);
		click(SeleccionarBonoDePrenda);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Ver Bono de Prenda")
	public ExpedirInformacionGeneralTituloPage VerBono() {

		Utilidades.waitInMs(3000);
		click(lblVerBonoDePrenda);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Crear Bono de Prenda")
	public ExpedirInformacionGeneralTituloPage CrearBono() {

		Utilidades.waitInMs(3000);
		click(CrearBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Lista Bono de Prenda")
	public ExpedirInformacionGeneralTituloPage ListaBono() {

		Utilidades.waitInMs(3000);
		click(ListaNitNombreRazonSocialBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Nit Bono de Prenda")
	public ExpedirInformacionGeneralTituloPage NitBbono() {

		Utilidades.waitInMs(3000);
		click(lblNitBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Nombre / Razón Social Bono de Prenda")
	public ExpedirInformacionGeneralTituloPage NombreRazonSocialBono() {

		Utilidades.waitInMs(3000);
		click(lblNombreRazonSocialBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Texto Nit - Nombre / Razón Social Bono de Prenda")
	public ExpedirInformacionGeneralTituloPage TextoNitNombreRazonSocialBono(String nit) {

		Utilidades.waitInMs(3000);
		writeText(txtNitNombreRazonSocialBono, nit);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Clear Texto Nit - Nombre / Razón Social Bono de Prenda")
	public ExpedirInformacionGeneralTituloPage ClearTextoNitNombreRazonSocialBono() {

		Utilidades.waitInMs(3000);
		clear(txtNitNombreRazonSocialBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Nit - Nombre / Razón Social Bono de Prenda")
	public ExpedirInformacionGeneralTituloPage SeleccionarNitNombreRazonSocialBono() {

		Utilidades.waitInMs(3000);
		click(SeleccionarNitNombreRazonSocialBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Capital Inicial Crédito")
	public ExpedirInformacionGeneralTituloPage CapitalIinicialCredito(String capital) {

		Utilidades.waitInMs(3000);
		writeText(txtCapitalInicialCreditoBono, capital);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Clear Capital Inicial Crédito")
	public ExpedirInformacionGeneralTituloPage ClearCapitalIinicialCredito() {

		Utilidades.waitInMs(3000);
		clear(txtCapitalInicialCreditoBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Días De Plazo")
	public ExpedirInformacionGeneralTituloPage DiasDePlazo(String dias) {

		Utilidades.waitInMs(3000);
		writeText(txtDiasDePlazoBono, dias);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Clear Días De Plazo")
	public ExpedirInformacionGeneralTituloPage ClearDiasDePlazo() {

		Utilidades.waitInMs(3000);
		clear(txtDiasDePlazoBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Tipo Interés")
	public ExpedirInformacionGeneralTituloPage TipoInteres(String tipoInteres) {

		Utilidades.waitInMs(3000);
		writeText(txtTipoInteresBono, tipoInteres);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Clear Tipo Interés")
	public ExpedirInformacionGeneralTituloPage ClearTipoInteres() {

		Utilidades.waitInMs(3000);
		clear(txtTipoInteresBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Valor Interés")
	public ExpedirInformacionGeneralTituloPage ValorInteres(String valorInteres) {

		Utilidades.waitInMs(3000);
		writeText(txtValorInteresBono, valorInteres);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Valor Interés")
	public ExpedirInformacionGeneralTituloPage ClearValorInteres() {

		Utilidades.waitInMs(3000);
		clear(txtValorInteresBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Frecuencia")
	public ExpedirInformacionGeneralTituloPage Frecuencia(String frecuencia) {

		Utilidades.waitInMs(3000);
		writeText(txtFrecuenciaBono, frecuencia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Frecuencia")
	public ExpedirInformacionGeneralTituloPage ClearFrecuencia() {

		Utilidades.waitInMs(3000);
		clear(txtFrecuenciaBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Cancelar Bono")
	public ExpedirInformacionGeneralTituloPage CancelarBono() {

		Utilidades.waitInMs(3000);
		click(btnCancelarBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Guardar Bono")
	public ExpedirInformacionGeneralTituloPage GuardarBono() {

		Utilidades.waitInMs(3000);
		click(bntGuardarBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar Bono")
	public ExpedirInformacionGeneralTituloPage AceptarBono() {

		Utilidades.waitInMs(3000);
		click(btnAceptar);
		Utilidades.screenshot();
		Utilidades.waitInMs(500);

		return this;
	}
	
	@Step("Cancelar Bono opción 2")
	public ExpedirInformacionGeneralTituloPage CancelarBonoOpcion2() {

		Utilidades.waitInMs(3000);
		click(btnCancelarBonoOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Eliminar Bono")
	public ExpedirInformacionGeneralTituloPage EliminarBono() {

		Utilidades.waitInMs(3000);
		click(btnEliminarBono);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Scroll horizontal derecha Bono")
	public ExpedirInformacionGeneralTituloPage ScrollDerechaBono() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[2]/div/div[2]/div/div[2]/table/tbody/tr/td[12]/button"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		return this;
	}*/
}