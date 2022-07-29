package com.Parametrizacion.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class TipoMercanciaMap extends BasePage {

	public TipoMercanciaMap(WebDriver driver) 
	{
		super(driver);
	}
	
	protected By lblRolPerfil = By.id("dropdown04");
	protected By lblParametrizacion = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/div/a");
	protected By lblTiposDeMercancias = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/div/ul/li[3]/div/a");
	protected By lblConsecutivo = By.cssSelector(".form-group:nth-child(1) > .col-form-label");
	protected By lblCodigoDeMercancia = By.cssSelector(".form-group:nth-child(2) > .col-form-label");
	protected By lblNombreDeMercancia = By.cssSelector(".form-group:nth-child(3) > .col-form-label");
	protected By lblEstado = By.cssSelector(".form-group:nth-child(4) > .col-form-label");
	protected By lblEncabezadoCrearTiposDeMercancia = By.xpath("/html/body/app-root/div/div/div/tipos-mercancia-main/tipos-mercancia-crear/div/div/div/h5");
	protected By lblConsecutivoBuscar = By.xpath("//*[@id='tbTiposMercancia']/tbody/tr[1]/td[1]");
	protected By lblConsecutivoCampoObligatorio = By.id("consecutivo");
	protected By lblCodigoDeMercanciaObligatorio = By.cssSelector(".form-group:nth-child(2) .invalid-tooltip");
	protected By lblNombreDeMercanciaObligatorio = By.cssSelector(".form-group:nth-child(3) .invalid-tooltip");
	protected By lblCodigoDeMercanciaCrear = By.id("consecutivo");
	protected By lblNombreDeMercanciaCrear = By.id("nombre");
	protected By lblEstadoActivoCrear = By.xpath("//*[@id=\"estado\"]/option[1]");
	protected By lblEstadoInactivoCrear = By.xpath("//*[@id=\"estado\"]/option[2]");
	protected By lblBotonCancelarCrear = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-crear/div/form/div[5]/div/button[2]");
	protected By lblBotonGuardarCrear = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-crear/div/form/div[5]/div/button[1]");
	protected By lblAlertaGuardarRegistro = By.xpath("//*[@id=\"swal2-title\"]");
	protected By lblBotonAceptarRegistro = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	protected By lblBotonCancelarRegistro = By.xpath("/html/body/div[2]/div/div[3]/button[2]");
	protected By lblTiposDeMercanciasBuscar = By.cssSelector(".row > .col > .ng-tns-c10-4");
	protected By lblCampoBuscarCincuentaCaracteres = By.id("termino");
	protected By lblCampoBuscarTercerCaracter = By.id("termino");
	protected By lblCampoBuscarMayusculasMinusculas = By.id("termino");
	protected By lblConsecutivoGrilla = By.xpath("//*[@id=\"tbTiposMercancia\"]/thead/tr/th[1]/div/span");
	protected By lblCodigoDeMercanciaGrilla = By.xpath("//*[@id=\"tbTiposMercancia\"]/thead/tr/th[2]/div/span");
	protected By lblNombreDeMercanciaGrilla = By.xpath("//*[@id=\"tbTiposMercancia\"]/thead/tr/th[3]/div/span");
	protected By lblEstadoGrilla = By.xpath("//*[@id=\"tbTiposMercancia\"]/thead/tr/th[4]/div/span");
	protected By lblAccionGrilla = By.xpath("//*[@id=\"tbTiposMercancia\"]/thead/tr/th[5]");
	protected By lblResultadoConsecutivoGrilla = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr[3]/td[1]");
	protected By lblResultadoCodigoDeMercanciaGrilla = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr[3]/td[2]");
	protected By lblResultadoNombreDeMercanciaGrilla = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr[3]/td[3]");
	protected By lblResultadoEstadoGrilla = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr[4]/td[4]");
	protected By lblEncabezdoModificarTipoDeMercancia = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-actualizar/div/div/div/h5");
	protected By lblConsecutivoNoEditable = By.id("consecutivo");
	protected By lblCodigoDeMercanciaNoEditable = By.id("codigo");
	protected By lblEstadoEditableInactivo = By.id("estado");
	protected By lblBotonCancelarModificar = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-actualizar/div/form/div[5]/div/button[2]");
	protected By lblBotonGuardarModificar = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-actualizar/div/form/div[5]/div/button[1]");
	protected By lblAlertaEstaSeguroDeGuardarElRegistroModificar = By.xpath("//*[@id=\"swal2-title\"]");
	protected By lblCampoAlfanumerico = By.id("nombre");
	protected By lblBotonCancelarPrimeraOpcion = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-actualizar/div/form/div[5]/div/button[2]");
	protected By lblFaltanDatosDeEntradaCrear = By.xpath("//*[@id=\"swal2-title\"]");
	protected By lblCampoConsecutivoBuscar = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr/td[1]");
	protected By lblCampoNombreBuscar = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr/td[3]");
	protected By lblCampoCodigoBuscar = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr/td[2]");
	protected By lblCampoNoExistenteBuscar = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-home/div/form/div[2]/div");
	protected By lblCincuentaCaracteresBuscar = By.id("termino");
	protected By lblMenorConsecutivo = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr/td[1]");
	protected By lblMayorEstado = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr/td[4]");
	protected By lblTotalRegistrosBuscar = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-home/div/div[3]/div/div/span/strong");
	protected By lblCampoAlfanumerico2 = By.id("nombre");
	protected By lblIniciarTercerCaracter = By.id("termino");
	protected By lblCampoLongitud25 = By.id("nombre");
	protected By lblMayorConsecutivo = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr[1]/td[1]");
	protected By lblMenorEstado = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr[1]/td[4]");
	protected By lblTipoDeMercanciaYaCreado = By.xpath("//*[@id=\"swal2-content\"]");
	protected By lblRegistroGuardadoModificar = By.cssSelector(".toast-message");
	protected By lblRegistroGuardadoCrear = By.cssSelector(".toast-message");
	
	// TIPOS DE MERCANCIA
	protected By btnParametrizacion = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/div/a");
	protected By btnTiposDeMercancias = By.xpath("//*[@id=\"sidebar\"]/ul/li[2]/div/ul/li[3]/div/a");
	protected By lblOpcionesTiposDeMercancia = By.xpath("");
	protected By lblCodigo = By.xpath("//*[@id=\"criterio\"]/option[1]");
	protected By lblNombre = By.xpath("//*[@id=\"criterio\"]/option[2]");
	protected By txtCampoBuscar = By.id("termino");
		
	protected By btnCrearTipoDeMercancia = By.xpath("//*[@id='contenido']/tipos-mercancia-main/tipos-mercancia-home/div/div[2]/div/a");
	protected By btnCancelarCrearPrimeraOpcion = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-crear/div/form/div[5]/div/button[2]");
	protected By btnGuardarCrear = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-crear/div/form/div[5]/div/button[1]");
	protected By btnAceptarCrear = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	protected By btnCancelarCrearSegundaOpcion = By.xpath("/html/body/div[2]/div/div[3]/button[2]");
	protected By txtCodigoDeMercanciaCrear = By.id("codigo");
	protected By txtNombreDeMercancia = By.id("nombre");
	protected By lblEstadoCrear = By.xpath("//*[@formcontrolname='estado']");
	
	
	protected By btnOkCrear = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	protected By btnModificar = By.xpath("//*[@id=\"tbTiposMercancia\"]/tbody/tr[1]/td[5]/div/a[1]");
	protected By btnOkCreado = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
		
	// MODIFICAR
	protected By lblEstadoModificar = By.id("estado");
	protected By lblEstadoActivoModificar = By.xpath("//*[@id=\"estado\"]/option[1]");
	protected By lblEstadoInactivoModificar = By.id("estado");
	protected By btnGuardarModificar = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-actualizar/div/form/div[5]/div/button[1]");
	protected By btnAceptarModificar = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	protected By btnCancelarModificar = By.xpath("//*[@id=\"contenido\"]/tipos-mercancia-main/tipos-mercancia-actualizar/div/form/div[5]/div/button[2]");
	protected By btnCancelarModificarOpcion2 = By.xpath("/html/body/div[3]/div/div[3]/button[2]");
		
	// ORDENAR
	protected By ordenarConsecutivo = By.xpath("//*[@id=\"tbTiposMercancia\"]/thead/tr/th[1]/div/i");
	protected By ordenarEstado = By.xpath("//*[@id=\"tbTiposMercancia\"]/thead/tr/th[4]/div/i");
	protected By ordenarCodigoMercancia = By.xpath("//*[@id=\"tbTiposMercancia\"]/thead/tr/th[2]/div/i");
	protected By ordenarNombreMercancia = By.xpath("//*[@id=\"tbTiposMercancia\"]/thead/tr/th[3]/div/i");

	// BUSQUEDA
	protected By lblOpcionBusqueda = By.id("criterio");
	protected By btnBuscar = By.xpath("//*[@id='contenido']/tipos-mercancia-main/tipos-mercancia-home/div/form/button[(text() = ' Buscar ')]");

}
