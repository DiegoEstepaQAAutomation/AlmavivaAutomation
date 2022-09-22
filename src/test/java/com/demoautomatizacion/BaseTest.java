package com.demoautomatizacion;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.MyScreenRecorder;
import utilities.OracleBD;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.Impresion.Pages.ImpresionPage;
import com.Notificaciones.Pages.NotificacionesPage;
import com.Parametrizacion.pages.BodegasPage;
import com.Parametrizacion.pages.TiposMercanciasPage;
import com.Parametrizacion.pages.UmedidasPage;
import com.ProgramarVisita.Pages.ProgramarVisitasPage;
import com.Reportes.Pages.GenerarReportePage;
import com.Seguridad.Pages.LogAuditoriaPage;
import com.Seguridad.Pages.PerfilesPage;
import com.Seguridad.Pages.RolesPage;
import com.Seguridad.Pages.UsuariosPage;
import com.Titulo.Pages.AnularTituloPage;
import com.Titulo.Pages.CreacionTitulos;
import com.Titulo.Pages.ExpedirPage;
import com.Titulo.Pages.LiberacionPage;
import com.Titulo.Pages.ProrrogarPage;
import com.Visitas.Pages.ConsultarRegistroVisitaPage;
import com.demoautomatizacion.Pages.BasePage;
import com.demoautomatizacion.Pages.HomePage;
import com.demoautomatizacion.Pages.LoginPage;
import com.demoautomatizacion.test.Convenios;
import com.Cliente.Pages.CupoPage;
import com.Cliente.Pages.GestionPage;
import com.ConsultaRegistroVisita.Pages.CRVisitasPage;
import com.Convenio.Pages.ConvenioPage;

//ESTA ES UNA CLASE QUE GUARDA TODAS LAS INSTANCIAS DE TODOS LOS OBJETOS EXISTENTES
public class BaseTest {

	//INSTANCIA DE WEBDRIVER
	public WebDriver driver;

	public HomePage home;
	public LoginPage login;
	public BasePage base;

	public ConvenioPage convenios;
	
	// M�dulo Seguridad
	public UsuariosPage usuarios;
	public RolesPage roles;
	public PerfilesPage perfiles;
	public LogAuditoriaPage logAuditoria;
	public NotificacionesPage notificacionespage;
	
	
	// M�dulo Parametrizaci�n
	public BodegasPage bodega;
	public UmedidasPage medidas;
	public TiposMercanciasPage tiposMercancia;

	// M�dulo Cliente
	public GestionPage gestion;
	public CupoPage cupo;

	// M�dulo T�tulo
	public ExpedirPage expedir;
	public AnularTituloPage anularTitulo;
	public ProrrogarPage prorroga;
	public ImpresionPage Impresion;
	public NotificacionesPage Notificaciones;
	public CRVisitasPage CRVisitas;
	public ProgramarVisitasPage ProgramarVisitas;
	public GenerarReportePage generarReporte;
	public LiberacionPage liberacion;
	public CreacionTitulos creaciontitulos;

	// M�dulo Visitas
	public ConsultarRegistroVisitaPage consultarRegistro;

	public WebDriver getDriver() {
		return driver;
	}

	//INICIALIZA LOS OBJETOS CON UN DRIVER RESPECTIVO
	@BeforeMethod
	public void inicializar() {

		//CONFIGURA EL COMO SE VA A ABRIR EL NAVEGADOR
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-notifications");
		// options.addArguments("--headless");
		//MAXIMIZA LA PAGINA DEL NAVEGADOR
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		home = new HomePage(driver);
		login = new LoginPage(driver);
		base = new BasePage(driver);
		


		convenios = new ConvenioPage(driver);
		// M�dulo Seguridad
		usuarios = new UsuariosPage(driver);
		roles = new RolesPage(driver);
		perfiles = new PerfilesPage(driver);
		logAuditoria = new LogAuditoriaPage(driver);


		//notificaciones
		notificacionespage= new NotificacionesPage(driver);
		
		
		// M�dulo Parametrización
		medidas = new UmedidasPage(driver);
		tiposMercancia = new TiposMercanciasPage(driver);
		bodega = new BodegasPage(driver);

		// M�dulo Cliente
		gestion = new GestionPage(driver);
		cupo = new CupoPage(driver);

		// M�dulo T�tulo
		expedir = new ExpedirPage(driver);
		anularTitulo = new AnularTituloPage(driver);
		prorroga = new ProrrogarPage(driver);
		Impresion = new ImpresionPage(driver);
		Notificaciones = new NotificacionesPage(driver);
		CRVisitas = new CRVisitasPage(driver);
		ProgramarVisitas = new ProgramarVisitasPage(driver);
		generarReporte = new GenerarReportePage(driver);
		liberacion = new LiberacionPage(driver);
		creaciontitulos = new CreacionTitulos(driver);
		

		// M�dulo Visitas
		consultarRegistro = new ConsultarRegistroVisitaPage(driver);
	}
	
	//INSTANCIA DE CONEXION DE BASE DE DATOS
	public ArrayList<Object> consultaBD(String sql) {

		ArrayList<Object> datos = new ArrayList<Object>();
		//CREA UNA INSTANCIA DE LA CLASE ORACLEBD QUE CONTIENE LA CONEXION A BASE DE DATOS
		try {
			OracleBD conexion = new OracleBD().conectar();
			//SI LA CONEXION ES DIFERENTE A NULO REALIZARA LA CONSULTA QUE ESTA LLAMADA EN EL METODO CONSULTAR CON EL STRING QUE ES LA CONSULTA QUE SE LE ENVIA
			if (conexion != null) {

				ResultSet resultado = conexion.consultar(sql);
				ResultSetMetaData metadata = resultado.getMetaData();
				int columnas = metadata.getColumnCount();
				//MEDIANTE UN CICLO SE AÑADE EL RESULTADO DE CADA COLUMNA 
				while (resultado.next()) {
					Object dato = new Object[columnas];
					for (int i = 1; i <= columnas; i++) {
						dato = resultado.getObject(i);
						//System.out.println(resultado.getString(i));
						datos.add(dato);
					}
				}
			}
			
			conexion.cerrarConexion();
		//SE RETORNA DATOS QUE ES LA METADATA DEL RESULTADO DE LA CONSULTA 	
		} catch (Exception e) {
			System.out.println("error de conexion");
			throw new RuntimeException(e.getMessage());
		}
		return datos;
	}

	

	
	//CIERRE DE INSTANCIA UNIVERSAL
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
