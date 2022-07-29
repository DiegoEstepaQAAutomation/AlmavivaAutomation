package com.ExpedirTitulo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.utils.Utilidades;
import io.qameta.allure.Step;

public class ExpedirConsultarPage extends BasePage {

	By lblListaConsultar = By.id("criterio");
	By lblNIT = By.xpath("/html/body/app-root/div/div/div/main-titulos/titulos-home/div/form/div[1]/select/option[1]");
	By lblNombreRazonSocial = By.xpath("/html/body/app-root/div/div/div/main-titulos/titulos-home/div/form/div[1]/select/option[2]");
	By lblTitulo = By.xpath("/html/body/app-root/div/div/div/main-titulos/titulos-home/div/form/div[1]/select/option[3]");
	By lblFecha = By.xpath("//*[@id=\"criterio\"]/option[4]");
	By txtBuscar = By.id("termino");
	By btnBuscar = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/form/button[1]");
	By btnPaginadorDerechaUnaOpcion = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[10]/a");
	By btnPaginadorDerechaUltimaOpcion = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[11]/a");
	By btnPaginadorIzquierdaUnaOpcion = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[2]");
	By btnPaginadorIzquierdaUltimaOpcion = By.xpath("//*[@id=\"contenido\"]/main-titulos/titulos-home/div/div[4]/div/div/ngb-pagination/ul/li[1]");

	public ExpedirConsultarPage(WebDriver driver) {
		super(driver);
	}

	// CONSULTAR
	/*@Step("Lista consultar")
	public ExpedirConsultarPage ListaConsultar() {

		Utilidades.waitInMs(3000);
		click(lblListaConsultar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Consulta NIT")
	public ExpedirConsultarPage ConsultaNit() {

		Utilidades.waitInMs(3000);
		click(lblNIT);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Consulta Nombre / Razón Social")
	public ExpedirConsultarPage ConsultaNombreRazonSocial() {

		Utilidades.waitInMs(3000);
		click(lblNombreRazonSocial);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Consulta Titulo")
	public ExpedirConsultarPage ConsultaTitulo() {

		Utilidades.waitInMs(3000);
		click(lblTitulo);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Consulta Fecha")
	public ExpedirConsultarPage ConsultaFecha() {

		Utilidades.waitInMs(3000);
		click(lblFecha);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Texto buscar")
	public ExpedirConsultarPage TextoBuscar(String buscar) {

		Utilidades.waitInMs(3000);
		writeText(txtBuscar, buscar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Clear buscar")
	public ExpedirConsultarPage ClearBuscar() {

		Utilidades.waitInMs(3000);
		clear(txtBuscar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Botón buscar")
	public ExpedirConsultarPage BotonBuscar() {

		Utilidades.waitInMs(3000);
		click(btnBuscar);
		Utilidades.waitInMs(2000);
		Utilidades.screenshot();
		Utilidades.waitInMs(3000);

		return this;
	}

	@Step("Scroll horizontal derecha")
	public ExpedirConsultarPage ScrollDerecha() {

		Utilidades.waitInMs(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"tbClientes\"]/tbody/tr/td[9]/div/a[2]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Evidencia")
	public ExpedirConsultarPage Evidencia() {

		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Paginador")
	public ExpedirConsultarPage PaginadorDerechaUnaOpcion() {

		Utilidades.waitInMs(1000);
		click(btnPaginadorDerechaUnaOpcion);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Paginador")
	public ExpedirConsultarPage PaginadorDerechaUltimaOpcion() {

		Utilidades.waitInMs(1000);
		click(btnPaginadorDerechaUltimaOpcion);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Paginador")
	public ExpedirConsultarPage PaginadorIzquierdaUnaOpcion() {

		Utilidades.waitInMs(1000);
		click(btnPaginadorIzquierdaUnaOpcion);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);

		return this;
	}
	
	@Step("Paginador")
	public ExpedirConsultarPage PaginadorIzquierdaUltimaOpcion() {

		Utilidades.waitInMs(1000);
		click(btnPaginadorIzquierdaUltimaOpcion);
		Utilidades.waitInMs(1000);
		Utilidades.screenshot();
		Utilidades.waitInMs(1000);
		
		return this;
	}*/
}