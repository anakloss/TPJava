package ar.com.gugler.sgc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.modelo.BaseModelo;
import ar.com.gugler.sgc.modelo.Profesor;

/**
 * @author Ana Kloss
 *
 */
public class ProfesorDAO extends BaseDAO<Profesor> {

	private final String SQL_INSERT = "insert into PROFESOR (numeroDocumento, apellido, nombre, fechaNacimiento," 
			+ "domicilio, telefono, email, cuil, fechaIngreso) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_UPDATE = "update PROFESOR set numeroDocumento=?, apellido=?, nombre=?, fechaNacimiento=?," 
			+ "domicilio=?, telefono=?, email=?, cuil=?, fechaIngreso=? where id=?";
	private final String SQL_DELETE = "delete from PROFESOR where id=?";
	private final String SQL_SELECT = "select * from PROFESOR";
	
	@Override
	public void guardar(BaseModelo e) {
		Profesor p = (Profesor) e;
		try {
			conectar();
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setString(1, p.getNumeroDocumento());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getNombre());
			stmt.setDate(4, java.sql.Date.valueOf(p.getFechaNacimiento()));
			stmt.setString(5, p.getDomicilio());
			stmt.setString(6, p.getTelefono());
			stmt.setString(7, p.getEmail());
			stmt.setString(8, p.getCuil());
			stmt.setDate(9, java.sql.Date.valueOf(p.getFechaIngreso()));
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error guardando un profesor con los datos " + p);
			ex.printStackTrace();
		}
	}
	
	@Override
	public void modificar(BaseModelo e) {
		Profesor p = (Profesor) e;
		Long id = this.buscarId(e);
		try {
			conectar();
			stmt = con.prepareStatement(SQL_UPDATE);
			stmt.setString(1, p.getNumeroDocumento());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getNombre());
			stmt.setDate(4, java.sql.Date.valueOf(p.getFechaNacimiento()));
			stmt.setString(5, p.getDomicilio());
			stmt.setString(6, p.getTelefono());
			stmt.setString(7, p.getEmail());
			stmt.setString(8, p.getCuil());
			stmt.setDate(9, java.sql.Date.valueOf(p.getFechaIngreso()));
			stmt.setLong(10, id);
			stmt.executeUpdate();
			cerrarConexion();
			
		}
		catch (SQLException ex) {
			System.out.println("Error modificando un profesor con los valores " + p);
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
			System.out.println("Error eliminando un profesor con los valores " + (Profesor) e);
			ex.printStackTrace();
		}
	}
	
	public Profesor populate(ResultSet rs) {
		try {
			Long id = rs.getLong(1);
			String numeroDocumento = rs.getString(2);
			String apellido = rs.getString(3);
			String nombre = rs.getString(4);
			LocalDate fechaNacimiento = rs.getDate(5).toLocalDate();
			String domicilio = rs.getString(6);
			String telefono = rs.getString(7);
			String email = rs.getString(8);
			String cuil = rs.getString(9);
			LocalDate fechaIngreso = rs.getDate(10).toLocalDate();
			Profesor p = new Profesor(numeroDocumento, apellido, nombre, fechaNacimiento, domicilio, telefono, email, cuil, fechaIngreso);
			p.setId(id);
			return p;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Busca un Profesor pasando el número ID
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
			System.out.println("Error al mostrar el profesor");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Busca los Profesores para settear ID
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
		List<BaseModelo> listadoProfesores = new ArrayList<BaseModelo>();
		try {
			conectar();
			stmt = con.prepareStatement(SQL_SELECT);	
			ResultSet rset = stmt.executeQuery();
			while(rset.next()) {				
				listadoProfesores.add(this.populate(rset));
			}
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error al mostrar el listado de profesores");
			ex.printStackTrace();
		}
		return listadoProfesores;
	}
	
	@Override
	public void crearTabla () {
		try {
			conectar();
			stmt = con.prepareStatement("CREATE TABLE PROFESOR ("
				+ "id int(11) NOT NULL AUTO_INCREMENT, "
				+ "numeroDocumento varchar(10) NOT NULL, "
				+ "apellido varchar(25) NOT NULL, "
				+ "nombre varchar(25) NOT NULL, "
				+ "fechaNacimiento date , "
				+ "domicilio varchar(35) , "
				+ "telefono varchar(20) , "
				+ "email varchar(50) , "
				+ "cuil varchar(15) NOT NULL, "
				+ "fechaIngreso date ,"
				+ " PRIMARY KEY (id))");
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error al crear la tabla profesor");
		}
	}

}
