package com.demoautomatizacion.test;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demoautomatizacion.BaseTest;
import com.demoautomatizacion.test.utils.Listeners.TestListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Listeners({ TestListener.class })
@Epic("Home")
@Feature("Home Test")

public class HomeTest extends BaseTest {

    //OBTENER EL NOMBRE DE LA CLASE
    String nomClass = Thread.currentThread().getStackTrace()[1].getFileName();

	private static final Logger log = LogManager.getLogger(HomeTest.class.getName());
	public Properties fileprops = new Properties();

	public Properties getProperties() throws Exception {
		fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
		return fileprops;
	}

	@Test(priority = 0, description = "Validar Opciones Almaviva")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validar Opciones")
	@Story("Home")
	public void ingresarPortalAlmaviva() throws Exception {

		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
        String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();		
		log.info("SE INICIA LA EJECUCION DEL TEST "+nomTest);
		home.irPortal(getProperties().getProperty("url"));
		log.info("FINALIZA LA EJECUCION DEL TEST");
	}
}
