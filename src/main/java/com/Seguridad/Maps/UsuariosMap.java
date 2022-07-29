package com.Seguridad.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class UsuariosMap extends BasePage {

	public UsuariosMap(WebDriver driver) {
		super(driver);
	}

	// CREAR
	protected By btnCrearUsuario = By.xpath("//*[@id='contenido']/app-main/app-home/div/div/div/a");
	protected By txtUsuarioDominio = By.xpath("//*[@formcontrolname='usuaUsuario']");
	protected By txtNombres = By.xpath("//*[@formcontrolname='usuaNombres']");
	protected By txtApellidos = By.xpath("//*[@formcontrolname='usuaApellidos']");
	protected By txtCargo = By.xpath("//*[@formcontrolname='usuaCargo']");
	protected By lblOficina = By.xpath("//*[@formcontrolname='usuaOficinaId']");
	protected By txtEmailUsuario = By.xpath("//*[@formcontrolname='usuaCorreo']");
	protected By lblPerfil = By.xpath("//*[@formcontrolname='usuaPerfil']");
	protected By lblEstado = By.xpath("//*[@formcontrolname='usuaEstado']");
	protected By btnGuardar = By.xpath("//*[@class='btn float-right col-2 botones-rojo ng-star-inserted']");
	protected By btnCancelar = By.xpath("//*[@class='btn btn-secondary float-right col-2 mr-2']");
	
	// Campos obligatorios
	protected By lblUsuarioDominioObligatorio = By.xpath("//*[@id='contenido']/app-main/ng-component/div/form/div[2]/div/div/span");
	protected By lblNombresObligatorio = By.xpath("//*[@id='contenido']/app-main/ng-component/div/form/div[3]/div/div/span");
	protected By lblApellidosObligatorio = By.xpath("//*[@id='contenido']/app-main/ng-component/div/form/div[4]/div/div/span");
	protected By lblCargoObligatorio = By.xpath("//*[@id='contenido']/app-main/ng-component/div/form/div[5]/div/div/span");
	protected By lblOficinaObligatorio = By.xpath("//*[@id='contenido']/app-main/ng-component/div/form/div[6]/div/div/span");
	protected By lblEmailUsuarioObligatorio = By.xpath("//*[@id='contenido']/app-main/ng-component/div/form/div[7]/div/div/span");
	protected By lblPerfilObligatorio = By.xpath("//*[@id='contenido']/app-main/ng-component/div/form/div[8]/div/div/span");
	
	
	protected By lblAsignarOficinas = By.xpath("//*[@class='btn btn-link ng-star-inserted']");
	protected By btnCrearOficina = By.xpath("//*[@class='btn rounded-circle botones-rojo']");
	protected By lblOpcionBusqueda = By.xpath("//*[@formcontrolname='tipo']");
	protected By txtCodigoOficina = By.xpath("//*[@formcontrolname='termino']");
	protected By btnBuscarOficina = By.xpath("//*[@class='container']/form/div/button[contains(text(),'Buscar')]");
	protected By btnBuscarTodosOficina = By.xpath("//*[@class='container']/form/div/button[contains(text(),'Todos')]");
	
	protected By cbxAccion = By.xpath("//body/modal-container/div/div/app-lista-oficinas/div/div[2]/table/tbody/tr/td[3]/div/input");
	protected By btnAgregarOficina = By.xpath("//*[@class='modal-footer']/button[contains(text(),'Agregar')]");
	protected By btnCancelarOficina = By.xpath("//*[@class='modal-footer']/button[contains(text(),'Cancelar')]");
	
	protected By btnGuardarUsuario = By.xpath("//*[@class='btn float-right col-2 botones-rojo ng-star-inserted']");
	protected By btnCancelarUsuario = By.xpath("//*[@class='btn btn-secondary float-right col-2 mr-2']");
	
	protected By btnAceptarRegistro = By.xpath("//body/div/div/div/button[contains(text(),'Aceptar')]");
	protected By btnCancelarRegistro = By.xpath("//body/div/div/div/button[contains(text(),'Cancelar')]");
	protected By registroExitoso = By.xpath("//div[@id='toast-container']/div/div");
	
	// OPCIONES
	protected By btnConsultar = By.xpath("//*[@class='btn col-2 mr-3 botones-rojo']");
	protected By btnBuscarTodos = By.xpath("//*[@class='btn col-2 botones-rojo']");
	
	// MODIFICAR
	protected By btnModificarUsuario = By.xpath("//*[@id='contenido']/app-main/app-home/div/div[3]/table/tbody/tr[1]/td[7]/div/a");
	protected By btnQuitarOficina = By.xpath("//*[@class='panel-body card-block card-body']/table/tbody/tr[1]/td[3]/button");
	
	// VER
	protected By btnVerUsuario = By.xpath("//*[@id='contenido']/app-main/app-home/div/div[3]/table/tbody/tr[1]/td[7]/div/div/a");
	
	// CONSULTAR
	protected By consultarUsuario = By.xpath("//input[contains(@formcontrolname,'nombre')]");
	protected By lblUsuarioTabla = By.xpath("//*[@id='contenido']/app-main/app-home/div/div[3]/table/tbody/tr[1]/td[1]");
	protected By btnBuscar = By.xpath("//*[@id='contenido']/app-main/app-home/div/form/button[contains(text(),'Buscar')]");
	protected By btnVerTodos = By.xpath("//*[@id='contenido']/app-main/app-home/div/form/button[contains(text(),'Ver todos')]");
	protected By btnDescargar = By.xpath("//*[@id='contenido']/app-main/app-home/div/div/button[contains(text(),'Descargar')]");
}
