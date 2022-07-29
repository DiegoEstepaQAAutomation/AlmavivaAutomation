package com.Parametrizacion.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class UmedidaMap extends BasePage {

	public UmedidaMap(WebDriver driver) {
		super(driver);
	}
	
	protected By Modulo = By.xpath("//body/app-root/div/div/div/unidades-medida-main/unidades-medida-crear/div/div/div/h5");
	protected By Parametrizacion = By.xpath("//*[@id='sidebar']/ul/li[2]/div/a");
	protected By UnidadMedida = By.xpath("//*[@id='sidebar']/ul/li[2]/div/ul/li[2]/div/a");
	protected By Modulo1 = By.xpath("//*[@id='contenido']/unidades-medida-main/unidades-medida-crear/div/form");
	protected By CrearUnidad = By.xpath("//body/app-root/div/div/div/unidades-medida-main/unidades-medida-home/div/div[2]/div/a");
	protected By Inputtext = By.xpath("//*[@id='codigo']");
	protected By Name = By.xpath("//*[@id='nombre']");
	protected By Department = By.xpath("//*[@id='nomdepartamento']");
	protected By NomPais = By.xpath("//*[@id='nompais']");
	protected By NomOficina = By.xpath("//*[@id='nomoficina']");
	protected By Des = By.xpath("//*[@id='descripcion']");
	protected By Selection = By.xpath("//*[@id='estado']");
	protected By SelectionActivo  = By.xpath("//*[@id='estado']/option[1]");
	protected By BtnCancelar = By.xpath("//*[@id='contenido']/unidades-medida-main/unidades-medida-crear/div/form/div[5]/div/button[2]");
	protected By SelectionInactivo  = By.xpath("//*[@id='estado']/option[2]");
	protected By save = By.xpath("//*[@id='contenido']/unidades-medida-main/unidades-medida-crear/div/form/div[5]/div/button[1]");
	protected By Confirm = By.xpath("/html/body/div[2]/div/div[3]/button[1]");
	protected By obligatorio1 = By.xpath("//*[@id='contenido']/unidades-medida-main/unidades-medida-crear/div/form/div[2]/div/div");
	protected By obligatorio2 = By.xpath("//body/app-root/div/div/div/unidades-medida-main/unidades-medida-crear/div/form/div[3]/div/div");
	protected By FaltanDatos = By.xpath("//body/div[2]/div/div[3]/button[1]");
	protected By btn1 = By.xpath("//*[@id='contenido']/unidades-medida-main/unidades-medida-crear/div/form/div[5]/div/button[2]");
	protected By Element = By.xpath("(//button[@type='button'])[9]");
	protected By frue = By.xpath("(//button[@type='button'])[8]");
	protected By Obligatorio1 = By.xpath("//*[@id='contenido']/unidades-medida-main/unidades-medida-crear/div/form/div[2]/div/div");
	protected By Obligatorio2 = By.xpath("//*[@id='contenido']/unidades-medida-main/unidades-medida-crear/div/form/div[3]/div/div");
	protected By Adicionar = By.xpath("//a[@ngbtooltip ='Crear unidad de medida']");
	
	//Busqueda
	protected By Element1 = By.xpath("//*[@formcontrolname='termino']");
	protected By Element2 = By.xpath("//body/app-root/div/div/div/unidades-medida-main/unidades-medida-home/div/form/button[1]");
	protected By cantidadregistros = By.xpath("//*[@id='contenido']/unidades-medida-main/unidades-medida-home/div/tabla-paginacion/div/div/div/span");
	protected By cancelar = By.xpath("//*[@id='contenido']/unidades-medida-main/unidades-medida-actualizar/div/form/div[5]/div/button[2]");
	protected By btnModificar = By.xpath("//body/app-root/div/div/div/unidades-medida-main/unidades-medida-home/div/form[2]/table/tbody/tr[1]/td[5]/div/a");
}
