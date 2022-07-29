package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirBodegaClientePage extends BasePage {

	// BODEGAS
	By lblParametrizacion = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/div/a");
	By btnBodegas = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/div/ul/li[1]/div/a");
	By lblListaBodega = By.xpath("//*[@id=\"contenido\"]/app-main/app-home/div/form/div[1]/select");
	By lblCodigoBodega = By.xpath("//*[@id=\"contenido\"]/app-main/app-home/div/form/div[1]/select/option[2]");
	By lblConsecutivo = By.xpath("//*[@id=\"contenido\"]/app-main/app-home/div/form/div[1]/select/option[3]");
	By txtBodegaBuscar = By.id("termino");
	By btnModificarBodegas = By.xpath("//*[@id=\"contenido\"]/app-main/app-home/div/div[3]/table/tbody/tr/td[13]/div/a[1]");
	By btnVerBodegas = By.xpath("//*[@id=\"contenido\"]/app-main/app-home/div/div[3]/table/tbody/tr/td[13]/div/a[2]");
	By btnBuscarBodega = By.xpath("//*[@id=\"contenido\"]/app-main/app-home/div/form/button[1]");
	By lblOficina = By.id("nomoficina");
	By txtNombre = By.id("nombre");
	By txtDireccionBodega = By.id("direccion");
	By btnGuardarModificarBodega = By.xpath("//*[@id=\"contenido\"]/app-main/bodega-actualizar/div/form/div[13]/div/button[1]");
	By btnAceptarModificarBodega = By.xpath("/html/body/div[2]/div/div[3]/button[1]");

	// CLIENTES
	By lblClientes = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/div/a");
	By btnGestion = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/div/ul/li[1]/div/a");
	By btnCupos = By.xpath("//*[@id=\"sidebar\"]/ul/li[3]/div/ul/li[2]/div/a");
	By txtBuscarClientes = By.id("termino");
	By btnModificarClientes = By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/div[1]/a");
	By lblInformacionPolizas = By.xpath("//*[@id=\"contenido\"]/app-main/app-formulario/div/form/accordion/accordion-group[2]/div/div[1]/div/div/button");
	By lblTipoBodega = By.xpath("//*[@id=\"contenido\"]/app-main/app-formulario/div/form/accordion/accordion-group[4]/div/div[1]/div/div/button");
	By btnCrearCliente = By.xpath("//*[@id=\"contenido\"]/app-main/clientes-home/div/div[2]/div/a");
	By txtNitCrearCliente = By.id("termino");
	By lblSeleccionarNitCliente = By.cssSelector(".ngb-highlight");
	
	public ExpedirBodegaClientePage(WebDriver driver) {
		super(driver);
	}

	// BODEGAS
	/*@Step("Parametrización")
	public ExpedirBodegaClientePage Parametrizacion() {

		Utilidades.waitInMs(3000);
		click(lblParametrizacion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Bodegas")
	public ExpedirBodegaClientePage Bodegas() {

		Utilidades.waitInMs(3000);
		click(btnBodegas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Codigo")
	public ExpedirBodegaClientePage Codigo() {

		Utilidades.waitInMs(3000);
		click(lblCodigoBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Consecutivo")
	public ExpedirBodegaClientePage Consecutivo() {

		Utilidades.waitInMs(3000);
		click(lblConsecutivo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Bodegas texto buscar")
	public ExpedirBodegaClientePage BodegasBuscar(String bodega) {

		Utilidades.waitInMs(3000);
		writeText(txtBodegaBuscar, bodega);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Scroll horizontal derecha Bodegas")
	public ExpedirBodegaClientePage ScrollDerechaBodegas() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(
		By.xpath("//*[@id=\"contenido\"]/app-main/app-home/div/div[3]/table/tbody/tr/td[13]/div/a[2]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		return this;
	}

	@Step("Bodegas opción Modificar")
	public ExpedirBodegaClientePage BodegasModificar() {

		Utilidades.waitInMs(3000);
		click(btnModificarBodegas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Bodegas opción Ver")
	public ExpedirBodegaClientePage BodegasVer() {

		Utilidades.waitInMs(3000);
		click(btnVerBodegas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Botón buscar Bodega")
	public ExpedirBodegaClientePage BotonBuscarBodega() {

		Utilidades.waitInMs(3000);
		click(btnBuscarBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Lista Oficina")
	public ExpedirBodegaClientePage ListaOficina() {

		Utilidades.waitInMs(3000);
		click(lblOficina);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Eliminar Tipo de Bodega")
	public ExpedirBodegaClientePage ClearNombreBodega() {

		Utilidades.waitInMs(3000);
		clear(txtNombre);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Nombre de Bodega")
	public ExpedirBodegaClientePage NombreBodega(String nombre) {

		Utilidades.waitInMs(3000);
		writeText(txtNombre, nombre);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Eliminar Dirección de Bodega")
	public ExpedirBodegaClientePage ClearDireccionBodega() {

		Utilidades.waitInMs(3000);
		clear(txtDireccionBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Dirección de Bodega")
	public ExpedirBodegaClientePage DireccionBodega(String direccion) {

		Utilidades.waitInMs(3000);
		writeText(txtDireccionBodega, direccion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Aleatorio Ciudad Bodega")
	public ExpedirBodegaClientePage AleatorioCiudadBodega() {

		Utilidades.waitInMs(3000);

		WebElement Drplistdown = driver.findElement(By.id("nomciudad"));
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

	@Step("Guardar modificar Bodega")
	public ExpedirBodegaClientePage GuardarModificarBodega() {

		Utilidades.waitInMs(3000);
		click(btnGuardarModificarBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Aceptar modificar Bodega")
	public ExpedirBodegaClientePage AceptarModificarBodega() {

		Utilidades.waitInMs(3000);
		click(btnAceptarModificarBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	// CLIENTES
	@Step("Clientes")
	public ExpedirBodegaClientePage Clientes() {

		Utilidades.waitInMs(3000);
		click(lblClientes);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Clientes Gestión")
	public ExpedirBodegaClientePage ClientesGestion() {

		Utilidades.waitInMs(3000);
		click(btnGestion);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Clientes Gestión")
	public ExpedirBodegaClientePage ClientesCupo() {

		Utilidades.waitInMs(3000);
		click(btnCupos);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Crear Cliente")
	public ExpedirBodegaClientePage CrearCliente() {

		Utilidades.waitInMs(3000);
		click(btnCrearCliente);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("NIT Crear Cliente")
	public ExpedirBodegaClientePage NitCrearCliente(String nit) {

		Utilidades.waitInMs(3000);
		writeText(txtNitCrearCliente, nit);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Seleccionar NIT")
	public ExpedirBodegaClientePage SeleccionarNIT() {

		Utilidades.waitInMs(3000);
		click(lblSeleccionarNitCliente);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Clientes opción Buscar")
	public ExpedirBodegaClientePage ClientesBuscar(String nit) {

		Utilidades.waitInMs(3000);
		writeText(txtBuscarClientes, nit);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Scroll horizontal derecha Clientes")
	public ExpedirBodegaClientePage ScrollDerechaClientes() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/div[2]/a"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		return this;
	}

	@Step("Clientes opción Modificar")
	public ExpedirBodegaClientePage ClientesModificar() {

		Utilidades.waitInMs(3000);
		click(btnModificarClientes);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}
	
	@Step("Información de Pólizas")
	public ExpedirBodegaClientePage InformacionPolizas() {

		Utilidades.waitInMs(3000);
		click(lblInformacionPolizas);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Tipo de Bodega")
	public ExpedirBodegaClientePage TipoBodega() {

		Utilidades.waitInMs(3000);
		click(lblTipoBodega);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}*/
}