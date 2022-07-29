package com.demoautomatizacion.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoautomatizacion.Pages.BasePage;

public class LoginMap extends BasePage
{

	public LoginMap(WebDriver driver) {
		super(driver);
	}

	// PRIVACIDAD
	protected By btnAvanzado = By.id("details-button");
	protected By lblContinuarNoSeguro = By.id("proceed-link");
	
	protected By txtusuario=By.xpath("//*[@id='contenido']/app-main/app-login-in/div/div[2]/div[4]/form/div/div[1]/div/input");
	protected By txtpassword =By.xpath("//*[@id='contenido']/app-main/app-login-in/div/div[2]/div[4]/form/div/div[2]/div/input");
	protected By btnLogin = By.xpath("//*[@id='contenido']/app-main/app-login-in/div/div[2]/div[4]/form/div/button");
	protected By Alert = By.xpath("//div[@id='toast-container']/div/div");
	protected By Home = By.id("sidebarCollapse");
	protected By btnContinuar = By.xpath("//body/div/div/div[3]/button[1]");
	protected By Titulo = By.xpath("//*[@id='sidebar']/div/h3/a");
	protected By Label = By.id("dropdown04");
	protected By btncerrarSesion = By.xpath("//*[@class='nav-item mr-5 show dropdown']/div/a[contains(text(),'Cerrar sesión')]");
}
