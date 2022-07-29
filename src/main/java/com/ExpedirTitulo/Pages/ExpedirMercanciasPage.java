package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirMercanciasPage extends BasePage {

	// MERCANCIAS
	By lblMercancias = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[5]/div/div[1]/div/div/button");
	By lblMercanciasOpcion2 = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[1]/div/div/button");
	By lblTipoDeCargue = By.id("tipoCargue");

	// MASIVO
	By lblCargueMasivo = By.xpath("//*[@id=\"tipoCargue\"]/option[2]");
	By lblPlantillaCargueMasivo = By.xpath("//*[@id=\"tipoCargue\"]/option[2]");
	By lblPlantilla = By.id("tipoFormato");
	By SeleccionarExcel = By.xpath("//*[@id=\"tipoFormato\"]/option[2]");
	By SeleccionarValoresSeparados = By.xpath("//*[@id=\"tipoFormato\"]/option[3]");
	By btnDescargar = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[2]/div/div[2]/div[2]/button");
	By SeleccionarArchivo = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[2]/div/div[2]/div[3]/input");

	// MANUAL
	By lblCargueIndividual = By.xpath("//*[@id=\"tipoCargue\"]/option[3]");
	By btnCrearMercancia = By.cssSelector(".mb-sm-12 .fa");
	By txtDetalleMercancia = By.id("detalleMercancia");
	By lblUnidadMedida = By.id("unidadMedida");
	By lblAceitesTon = By.xpath("//*[@id=\"unidadMedidaSuper\"]/option[2]");
	By lblElectrodomesticos = By.xpath("//*[@id=\"unidadMedidaSuper\"]/option[41]");
	By lblUnidadDeMedidaSuper = By.id("unidadMedidaSuper");
	By txtValorConversion = By.id("valorConversion");
	By txtCantidad = By.id("cantidad");
	By txtValorUnitario = By.id("valorUnitario");
	By txtFechaDeVencimiento = By.cssSelector(".col-md-5 > #fechaVencimiento");
	By txtObservacionDeLaMercancia = By.cssSelector(".col-md-5 > #observaciones");
	By btnAccionEliminar = By.xpath("//*[@id=\"tbMercancia\"]/tbody/tr/td[8]/button");
	By btnCancelarMercanciaIndividualOpcion2 = By.cssSelector(".swal2-cancel");
	By btnCancelarMercanciaIndividual = By.xpath("/html/body/modal-container/div/div/mercancia-titulos/div/form/div[2]/div/button[2]");
	By btnGuardarMercanciaIndividual = By.xpath("/html/body/modal-container/div/div/mercancia-titulos/div/form/div[2]/div/button[1]");
	By btnOkFaltanDatosEntrada = By.xpath("/html/body/div[3]/div/div[3]/button[1]"); 
	By btnOkFaltanDatosEmtrada1 = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	By btnAceptarGuardarMercanciaIndividual = By.cssSelector(".swal2-confirm");
	
	public ExpedirMercanciasPage(WebDriver driver) {
		super(driver);
	}

	// MERCANCIAS
	/*@Step("Mercancías")
	public ExpedirMercanciasPage Mercancia() {

		Utilidades.waitInMs(3000);
		click(lblMercancias);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Mercancías opción 2")
	public ExpedirMercanciasPage MercanciaOpcion2() {

		Utilidades.waitInMs(3000);
		click(lblMercanciasOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Lista Tipo de Cargue")
	public ExpedirMercanciasPage ListaTipoCargue() {

		Utilidades.waitInMs(3000);
		click(lblTipoDeCargue);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	// CARGUE MASIVO
	@Step("Seleccionar Cargue Masivo")
	public ExpedirMercanciasPage CargueMasivo() {

		Utilidades.waitInMs(3000);
		click(lblCargueMasivo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Llista Plantilla Cargue Masivo")
	public ExpedirMercanciasPage ListaPlantillaCargueMasivo() {

		Utilidades.waitInMs(3000);
		click(lblPlantillaCargueMasivo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Libro de Microsoft Excel 2007 y posterior")
	public ExpedirMercanciasPage Excel2007() {

		Utilidades.waitInMs(3000);
		click(SeleccionarExcel);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Valores separados por comas")
	public ExpedirMercanciasPage ValoresSeparados() {

		Utilidades.waitInMs(3000);
		click(SeleccionarValoresSeparados);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Botón Descargar")
	public ExpedirMercanciasPage BotonDescargar() {

		Utilidades.waitInMs(3000);
		click(btnDescargar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar Archivo")
	public ExpedirMercanciasPage SubirArchivo(String archivo) {

		File file = new File(archivo);
		Utilidades.waitInMs(2000);

		WebElement ruta = driver.findElement(SeleccionarArchivo);
		ruta.sendKeys(file.getAbsolutePath());

		Utilidades.waitInMs(1000);
		Utilidades.screenshot();

		return this;
	}
	
	// CARGUE INDIVIDUAL
	@Step("Seleccionar Cargue Individual")
	public ExpedirMercanciasPage CargueIndividual() {

		Utilidades.waitInMs(3000);
		click(lblCargueIndividual);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Etiqueta Crear Mercancía")
	public ExpedirMercanciasPage EtiquetaCrearMercancia() {

		Utilidades.waitInMs(3000);

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector(".mb-sm-12 .fa"));
		action.moveToElement(element).perform();

		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Crear Mercancía")
	public ExpedirMercanciasPage CrearMercancia() {

		Utilidades.waitInMs(3000);
		click(btnCrearMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Detalle Mercancía")
	public ExpedirMercanciasPage DetalleMercancia(String detalleMercancia) {

		Utilidades.waitInMs(3000);
		writeText(txtDetalleMercancia, detalleMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Lista Unidad de Medida")
	public ExpedirMercanciasPage ListaUnidadMedida() {

		Utilidades.waitInMs(3000);
		click(lblUnidadMedida);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aleatorio Unidad de Medida")
	public ExpedirMercanciasPage AleatorioUnidadMedida() {

		Utilidades.waitInMs(3000);

		WebElement Drplistdown = driver.findElement(By.id("unidadMedida"));
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
	
	@Step("Lista Unidad de Medida 'ACEITES - TON'")
	public ExpedirMercanciasPage UnidadMedidaAceitesTon() {

		Utilidades.waitInMs(3000);
		click(lblAceitesTon);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Lista Unidad de Medida 'ELECTRODOMÉSTICOS - UND'")
	public ExpedirMercanciasPage UnidadMedidaElectrodomesticosUnd() {

		Utilidades.waitInMs(3000);
		click(lblElectrodomesticos);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Lista Unidad de Medida Super")
	public ExpedirMercanciasPage ListaUnidadMedidaSuper() {

		Utilidades.waitInMs(3000);
		click(lblUnidadDeMedidaSuper);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aleatorio Unidad de Medida Super")
	public ExpedirMercanciasPage AleatorioUnidadMedidaSuper() {

		Utilidades.waitInMs(3000);

		WebElement Drplistdown = driver.findElement(By.id("unidadMedidaSuper"));
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
	
	@Step("Valor conversión")
	public ExpedirMercanciasPage ValorConversion(String valorConversion) {

		Utilidades.waitInMs(3000);
		writeText(txtValorConversion, valorConversion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Cantidad")
	public ExpedirMercanciasPage Cantidad(String cantidad) {

		Utilidades.waitInMs(3000);
		writeText(txtCantidad, cantidad);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Cantidad")
	public ExpedirMercanciasPage ClearCantidad() {

		Utilidades.waitInMs(3000);
		clear(txtCantidad);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Valor unitatio")
	public ExpedirMercanciasPage ValorUnitario(String valorUnitario) {

		Utilidades.waitInMs(3000);
		writeText(txtValorUnitario, valorUnitario);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Fecha de vencimiento")
	public ExpedirMercanciasPage FechaVencimiento(String fechaVencimiento) {

		Utilidades.waitInMs(3000);
		writeText(txtFechaDeVencimiento, fechaVencimiento);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Fecha de vencimiento")
	public ExpedirMercanciasPage ClearFechaVencimiento() {

		Utilidades.waitInMs(3000);
		clear(txtFechaDeVencimiento);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Observación de la mercancía")
	public ExpedirMercanciasPage ObservacionMercancia(String observacionMercancia) {

		Utilidades.waitInMs(3000);
		writeText(txtObservacionDeLaMercancia, observacionMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clear Observación de la mercancía")
	public ExpedirMercanciasPage ClearObservacionMercancia() {

		Utilidades.waitInMs(3000);
		clear(txtObservacionDeLaMercancia);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Acción Eliminar")
	public ExpedirMercanciasPage Eliminar() {

		Utilidades.waitInMs(3000);
		click(btnAccionEliminar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Cancelar mercancía")
	public ExpedirMercanciasPage Cancelar() {

		Utilidades.waitInMs(3000);
		click(btnCancelarMercanciaIndividual);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Cancelar mercancía")
	public ExpedirMercanciasPage CancelarOpcion2() {

		Utilidades.waitInMs(3000);
		click(btnCancelarMercanciaIndividualOpcion2);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Guardar mercancía")
	public ExpedirMercanciasPage Guardar() {

		Utilidades.waitInMs(3000);
		click(btnGuardarMercanciaIndividual);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Aceptar guardar mercancía")
	public ExpedirMercanciasPage Aceptar() {

		Utilidades.waitInMs(3000);
		click(btnAceptarGuardarMercanciaIndividual);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Ok faltan datos de entrada")
	public ExpedirMercanciasPage Ok() {

		Utilidades.waitInMs(3000);
		click(btnOkFaltanDatosEntrada);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);
		
		return this;
	}
	
	@Step("Ok faltan datos de entrada opción 2")
	public ExpedirMercanciasPage Ok2() {

		Utilidades.waitInMs(3000);
		click(btnOkFaltanDatosEmtrada1);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);
		
		return this;
	}
	
	@Step("Scroll Mercancía cargue manual")
	public ExpedirMercanciasPage ScrollMercanciaCargueIndividual( ) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(
		By.xpath("//*[@id=\"tbMercancia\"]/tbody/tr/td[8]/button"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		return this;
	}
	
	@Step("Scroll Mercancía cargue masivo")
	public ExpedirMercanciasPage ScrollMercanciaCargueMasivo( ) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(
		By.xpath("//*[@id=\"tbMercancia\"]/tbody/tr/td[8]/button"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		return this;
	}
	
	By lblFila20 = By.xpath("//*[@id=\"contenido\"]/main-titulos/app-titulo/div/form/div[2]/div/accordion/accordion-group[6]/div/div[2]/div/div[3]/div[2]/div/div/select/option[2]");
	@Step("Paginacion Fila 20 ")
	public ExpedirMercanciasPage PaginacionFila20() {

		Utilidades.waitInMs(3000);
		click(lblFila20);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);
		
		return this;
	}*/
}