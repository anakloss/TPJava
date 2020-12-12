package ar.com.gugler.sgc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.List;

import ar.com.gugler.sgc.modelo.BaseModelo;

/**
 * @author Ana Kloss
 *
 */
public abstract class BaseDAO<T extends BaseModelo> {
	
	protected Connection con;
	protected PreparedStatement stmt;
		
	public void conectar() {
		
		try {
//			Class.forName("com.mysql.jbdc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/TP?"
					+ "user=admin&password=admin123");
		}
		catch (Exception e) {
			System.out.println("Error al intentar iniciar la conexión a la base de datos.");
			e.printStackTrace();
		}
		
	}
	
	public void cerrarConexion() {
		
		try {
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			System.out.println("Error al intentar cerrar la conexión a la base de datos.");
			e.printStackTrace();
		}
		
	}
	
	public abstract void guardar(BaseModelo e);
	public abstract void modificar(BaseModelo e);
	public abstract void eliminar(BaseModelo e);
	public abstract Long buscarId(BaseModelo e);
	public abstract BaseModelo buscar(Long id);
	public abstract List<BaseModelo> buscarTodos();
	public abstract void crearTabla();
	
}
