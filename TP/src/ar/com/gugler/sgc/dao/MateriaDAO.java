package ar.com.gugler.sgc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.modelo.BaseModelo;
import ar.com.gugler.sgc.modelo.Materia;
import ar.com.gugler.sgc.modelo.Profesor;

/**
 * @author Ana Kloss
 *
 */
public class MateriaDAO extends BaseDAO<Materia> {

	private final String SQL_INSERT = "INSERT INTO MATERIA (CODIGO, NOMBRE, ID_PROFESOR, ANIO)"
			+ "VALUES (?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE MATERIA SET CODIGO=?, NOMBRE=?, ID_PROFESOR=?, ANIO=? WHERE ID=?";
	private final String SQL_DELETE = "DELETE FROM MATERIA WHERE ID=?";
	private final String SQL_SELECT = "SELECT ID, CODIGO, NOMBRE, ID_PROFESOR, ANIO FROM MATERIA";
	
	@Override
	public void guardar(BaseModelo e) {
		Materia m = (Materia) e;
		Long id_profesor = new ProfesorDAO().buscarId(m.getProfesor());
		try {
			conectar();
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setInt(1, m.getCodigo());
			stmt.setString(2, m.getNombre());
			stmt.setLong(3, id_profesor);
			stmt.setInt(4, m.getAnio());
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error guardando una materia con los datos " + m);
			ex.printStackTrace();
		}
	}
	
	@Override
	public void modificar(BaseModelo e) {
		Materia m = (Materia) e;
		Long id = this.buscarId(e);
		Long id_profesor = new ProfesorDAO().buscarId(m.getProfesor());
		try {
			conectar();
			stmt = con.prepareStatement(SQL_UPDATE);
			stmt.setInt(1, m.getCodigo());
			stmt.setString(2, m.getNombre());
			stmt.setLong(3, id_profesor);
			stmt.setInt(4, m.getAnio());
			stmt.setLong(5, id);
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error modificando una materia con los valores" + m);
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
			System.out.println("Error eliminando una materia con los valores" + (Materia) e);
			ex.printStackTrace();
		}
	}
	
	public Materia populate(ResultSet rs) {
		try {
			Long id = rs.getLong(1);
			Integer codigo = rs.getInt(2);
			String nombre = rs.getString(3);
			Long id_profesor = rs.getLong(4);
			Integer anio = rs.getInt(5);
			var profesor = new Profesor();
			profesor.setId(id_profesor);
			var m = new Materia(codigo, nombre, profesor, anio);
			m.setId(id);
			return m;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Busca una Materia pasando el número ID
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
			System.out.println("Error al mostrar el curso");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Busca las Materias para settear ID
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
		List<BaseModelo> listadoMaterias = new ArrayList<BaseModelo>();
		try {
			conectar();
			stmt = con.prepareStatement(SQL_SELECT);
			ResultSet rset = stmt.getResultSet();			
			while(rset.next()) {
				Materia m = new Materia();
				
				stmt.setInt(1, m.getCodigo());
				stmt.setString(2, m.getNombre());
				stmt.setLong(3, m.getProfesor().getId());
				stmt.setInt(4, m.getAnio());
				listadoMaterias.add(m);
			}
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error al mostrar el listado de materias");
			ex.printStackTrace();
		}
		return listadoMaterias;
	}
	
	@Override
	public void crearTabla () {
		try {
			conectar();
			stmt = con.prepareStatement("CREATE TABLE MATERIA ("
				+ "id int(11) NOT NULL AUTO_INCREMENT, "
				+ "codigo varchar(10) NOT NULL, "
				+ "nombre varchar(25) NOT NULL, "
				+ "id_profesor int(11) NOT NULL, "
				+ "anio int(5) , "
				+ " PRIMARY KEY (id))");
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error al crear la tabla materia.");
		}
	}

}
