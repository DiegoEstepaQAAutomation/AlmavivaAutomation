package utilities;

import java.sql.*;

public class OracleBD2 
{
	
private Connection conexion;
	
	public Connection getConexion() {
        return conexion;
    }    
	
	public void setConexion(Connection conexion) {
        this.conexion = conexion;
	}
	
	
	
	public OracleBD2 conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@172.168.10.106:1521/almaviva";
            //BD JDA	DEVELOP@//192.168.75.141:1440/wmsalmtmp
            //BD core	ssfin_core@//172.168.10.106:1521/almaviva
            
            conexion = DriverManager.getConnection(BaseDeDatos, "ssfin_core","alma2022");
            
            conexion.setAutoCommit(false);
            
            if (conexion != null) {
                System.out.println("Conexion exitosa!");
                
            } else {
                System.out.println("Conexion fallida!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }        return this;
    }
    
    
	
	public ResultSet consultar(String sql){
        ResultSet resultado = null;
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            getConexion().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
        return resultado;
        
    }
	
	public void cerrarConexion() throws SQLException{
	
		conexion.close();
	}
	
	

}
