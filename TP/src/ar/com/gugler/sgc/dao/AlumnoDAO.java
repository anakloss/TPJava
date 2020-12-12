package ar.com.gugler.sgc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.modelo.BaseModelo;
import ar.com.gugler.sgc.modelo.Alumno;

/**
 * @author Ana Kloss
 *
 */
public class AlumnoDAO extends BaseDAO<Alumno> {
	
	private final String SQL_INSERT = "insert into ALUMNO (numeroDocumento, apellido, nombre, fechaNacimiento," 
			+ "domicilio, telefono, email, legajo) values (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_UPDATE = "update ALUMNO set numeroDocumento=?, apellido=?, nombre=?, fechaNacimiento=?," 
			+ "domicilio=?, telefono=?, email=?, legajo=? where id=?";
	private final String SQL_DELETE = "delete from ALUMNO where id=?";
	private final String SQL_SELECT = "select * from ALUMNO";
		
	@Override
	public void guardar(BaseModelo e) {
		Alumno a = (Alumno) e;
		try {
			conectar();
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setString(1, a.getNumeroDocumento());
			stmt.setString(2, a.getApellido());
			stmt.setString(3, a.getNombre());
			stmt.setDate(4, java.sql.Date.valueOf(a.getFechaNacimiento()));
			stmt.setString(5, a.getDomicilio());
			stmt.setString(6, a.getTelefono());
			stmt.setString(7, a.getEmail());
			stmt.setString(8, a.getLegajo());
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error guardando un alumno con los datos " + a);
			ex.printStackTrace();
		}
	}
	
	@Override
	public void modificar(BaseModelo e) {
		Alumno a = (Alumno) e;
		Long id = this.buscarId(e);
		try {
			conectar();
			stmt = con.prepareStatement(SQL_UPDATE);
			stmt.setString(1, a.getNumeroDocumento());
			stmt.setString(2, a.getApellido());
			stmt.setString(3, a.getNombre());
			stmt.setDate(4, java.sql.Date.valueOf(a.getFechaNacimiento()));
			stmt.setString(5, a.getDomicilio());
			stmt.setString(6, a.getTelefono());
			stmt.setString(7, a.getEmail());
			stmt.setString(8, a.getLegajo());
			stmt.setLong(9, id);
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error modificando un alumno con los valores " + a);
			ex.printStackTrace();
		}
	}
	
	@Override
	public void eliminar(BaseModelo e) {
		Long id = this.buscarId(e);
		try {
			conectar();
			stmt = con.prepareStatement(SQL_DELETE);
			stmt.setLong(1, id);
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error eliminando un alumno con los valores" + (Alumno) e);
			ex.printStackTrace();
		}
	}
	
	public Alumno populate(ResultSet rs) {
		try {
			Long id = rs.getLong(1);
			String numeroDocumento = rs.getString(2);
			String apellido = rs.getString(3);
			String nombre = rs.getString(4);
			LocalDate fechaNacimiento = rs.getDate(5).toLocalDate();
			String domicilio = rs.getString(6);
			String telefono = rs.getString(7);
			String email = rs.getString(8);
			String legajo = rs.getString(9);
			Alumno a = new Alumno(numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, email, legajo);
			a.setId(id);
			return a;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Busca un Alumno pasando el número ID
	 * Devuelve un objeto BaseModelo
	 */
	@Override
	public BaseModelo buscar(Long id) {
		try {			
			conectar();
			stmt = con.prepareStatement(SQL_SELECT + " where id=?");	
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return this.populate(rs);
			}
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error al mostrar el alumno");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Busca los Alumnos para settear ID
	 * Devuelve ID
	 */
	@Override
	public Long buscarId(BaseModelo e) {
		Long id = null;
		for (var m: this.buscarTodos()) {
			if (m.equals(e))
				id = m.getId();
		}
		return id;
	}
	
	@Override
	public List<BaseModelo> buscarTodos() {
		List<BaseModelo> listadoAlumnos = new ArrayList<BaseModelo>();
		try {
			conectar();
			stmt = con.prepareStatement(SQL_SELECT);
			ResultSet rset = stmt.executeQuery();			
			while(rset.next()) {
				listadoAlumnos.add(this.populate(rset));
			}
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error al mostrar el listado de alumnos");
			ex.printStackTrace();
		}
		return listadoAlumnos;
	}

	@Override
	public void crearTabla() {
		try {
			conectar();
			stmt = con.prepareStatement("CREATE TABLE ALUMNO ("
				+ "id int(11) NOT NULL AUTO_INCREMENT, "
				+ "numeroDocumento varchar(10) NOT NULL, "
				+ "apellido varchar(25) NOT NULL, "
				+ "nombre varchar(25) NOT NULL, "
				+ "fechaNacimiento date , "
				+ "domicilio varchar(35) , "
				+ "telefono varchar(20) , "
				+ "email varchar(50) , "
				+ "legajo varchar(15) NOT NULL, "
				+ " PRIMARY KEY (id))");
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error al crear la tabla alumno.");
		}
	}

}