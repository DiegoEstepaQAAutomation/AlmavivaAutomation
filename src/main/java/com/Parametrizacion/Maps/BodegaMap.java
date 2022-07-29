package com.Parametrizacion.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class BodegaMap extends BasePage {

	public BodegaMap(WebDriver driver) {
		super(driver);
	}

	protected By crearBodega = By.xpath("//*[@id='contenido']/app-main/app-home/div/div[2]/div/a");  //va una a
	protected By CodigoB = By.xpath("//*[@formcontrolname='codigo']");

	protected By Obligatorio1 = By.xpath("//*[@id='contenido']/app-main/bodega-crear/div/form/div[2]/div/div");
	protected By Obligatorio2 = By.xpath("//*[@id='contenido']/app-main/bodega-crear/div/form/div[3]/div/div");
	protected By Obligatorio3 = By.xpath("//*[@id='contenido']/app-main/bodega-crear/div/form/div[4]/div/div");
	protected By Obligatorio4 = By.xpath("//*[@id='contenido']/app-main/bodega-crear/div/form/div[5]/div/div");
	protected By Obligatorio5 = By.xpath("//*[@id='contenido']/app-main/bodega-crear/div/form/div[6]/div/div");
	protected By Obligatorio6 = By.xpath("//*[@id='contenido']/app-main/bodega-crear/div/form/div[7]/div/div");
	protected By Obligatorio7 = By.xpath("//*[@id='contenido']/app-main/bodega-crear/div/form/div[8]/div/div");
	protected By Obligatorio8 = By.xpath("//*[@id='contenido']/app-main/bodega-crear/div/form/div[9]/div/div");

	protected By Oficina = By.xpath("//*[@formcontrolname='nomoficina']");
	protected By Pais = By.xpath("//*[@formcontrolname='nompais']");
	protected By Departamento = By.xpath("//*[@formcontrolname='nomdepartamento']");
	protected By Ciudad = By.xpath("//*[@formcontrolname='nomciudad']");
	protected By Nombre = By.xpath("//*[@formcontrolname='nombre']");
	protected By Direccion = By.id("direccion");
	protected By Telefono = By.id("telefono");
	protected By TipoBodega = By.id("bodeTipo");
	
	
	
	protected By lblTipoBodega = By.id("bodeTipo");
	
	
	protected By cbxDLX = By.xpath("//*[@class='col-6']/div[1]/input");
	protected By cbxJDA = By.xpath("//*[@class='col-6']/div[2]/input");
	protected By Guardar = By.xpath("//*[@id='contenido']/app-main/bodega-crear/div/form/div[12]/div/button[1]");
	protected By Guardar1 = By.xpath("//*[@id='contenido']/app-main/bodega-actualizar/div/form/div[13]/div/button[1]");
	protected By Guardar2 = By.xpath("//body/app-root/div/div/div/app-main/bodega-crear/div/form/div[13]/div/button[1]");
	protected By Cancelar = By.xpath("//*[@id='contenido']/app-main/bodega-crear/div/form/div[12]/div/button[2]");
	protected By Cancelar1 = By.xpath("//body/app-root/div/div/div/app-main/bodega-actualizar/div/form/div[13]/div/button[2]");
	protected By Aceptar = By.xpath("//body/div[2]/div/div[3]/button[1]");
	protected By cancelar = By.xpath("//body/div[2]/div/div[3]/button[2]");
	protected By Select = By.xpath("//*[@id=\"contenido\"]/app-main/app-home/div/form/div[1]/select");
	protected By CoBodegas = By.xpath("//body/app-root/div/div/div/app-main/app-home/div/form/div[1]/select/option[2]");
	protected By Buscar = By.id("termino");// 12345
	protected By Editar = By.xpath("//*[@id='contenido']/app-main/app-home/div/div[3]/table/tbody/tr[10]/td[13]/div/a[1]");
	protected By Estado = By.id("estado");
	protected By lblEstado = By.id("estado");
	protected By Ok = By.xpath("//body/div/div/div[3]/button[1]");
	protected By Ver = By.xpath("//*[@id='contenido']/app-main/app-home/div/div[3]/table/tbody/tr[10]/td[13]/div/a[2]");
	protected By NombreB = By.xpath("//body/app-root/div/div/div/app-main/app-home/div/div[3]/table/tbody/tr[10]/td[8]");

}
