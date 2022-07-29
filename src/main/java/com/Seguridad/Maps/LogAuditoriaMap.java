package com.Seguridad.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class LogAuditoriaMap extends BasePage {

	public LogAuditoriaMap(WebDriver driver) {
		super(driver);
	}

	protected By txtIngreseNombre = By.id("nombre");
	protected By TblListaUsuarios = By.xpath("//*[@id='contenido']/app-main/app-home/div/div[3]/table/tbody/tr/td[1]");
	protected By lblTablaLogAuditoria = By.xpath("//body/modal-container/div/div/app-lista-usuarios/div/div/table/tbody");
	protected By btnBuscarUsuario = By.xpath("//*[@id='contenido']/app-main/logauditoria-home/div/form/div/div/div/div/div");
	protected By lblLogAuditoria = By.xpath("//*[@id='sidebar']/ul/li/div/ul/li/div/a[contains(text(),'Log Auditoría')]");
	protected By btnBuscar = By.xpath("//body/modal-container/div/div/app-lista-usuarios/div/div/div/div/div/form/div/button[contains(text(),'Buscar')]");
	protected By txtBuscarUsuarioLog = By.xpath("//*[@formcontrolname='buscar']");
	protected By lblNombreUsuarioLog = By.xpath("//body/modal-container/div/div/app-lista-usuarios/div/div/table/tbody/tr[1]/td[1]");
	
	protected By calendarioFechaDesde = By.xpath("//*[@class='form-row align-items-left']/div[1]/div/div/button");
	protected By calendarioFechaHasta = By.xpath("//*[@class='form-row align-items-left']/div[2]/div/div/button");
	protected By lblMesFecha = By.xpath("//*[@title='Select month']");
	protected By lblAnualFecha = By.xpath("//*[@title='Select year']");
	protected By lblDiaFecha = By.xpath("//*[@id='contenido']//div/div/div[(text() = '{0}')]");
	protected By btnBuscarLog = By.xpath("//*[@id='contenido']/app-main/logauditoria-home/div/form/button[contains(text(),'Buscar')]");
	protected By btnVerTodos = By.xpath("//*[@id='contenido']/app-main/logauditoria-home/div/form/button[contains(text(),'Ver Todos')]");
	protected By btnDescargar = By.xpath("//*[@id='contenido']/app-main/logauditoria-home/div/div/button[contains(text(),'Descargar')]");
	protected By lblUsuarioValidar = By.xpath("//*[@id='tbLogAuditoria']/tbody/tr[1]/td[1]");
}
