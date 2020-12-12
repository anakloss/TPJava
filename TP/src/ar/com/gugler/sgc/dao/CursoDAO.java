package ar.com.gugler.sgc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.modelo.BaseModelo;
import ar.com.gugler.sgc.modelo.Curso;
import ar.com.gugler.sgc.modelo.Profesor;

/**
 * @author Ana Kloss
 *
 */
public class CursoDAO extends BaseDAO<Curso> {

	private final String SQL_INSERT = "insert into CURSO (codigo, nombre, id_profesor) values (?,?,?)";
	private final String SQL_UPDATE = "update CURSO set codigo=?, nombre=?, id_profesor=? where id=?";
	private final String SQL_DELETE = "delete from CURSO where id=?";
	private final String SQL_SELECT = "select * from CURSO";
	
	@Override
	public void guardar(BaseModelo e) {
		Curso c = (Curso) e;
		Long id_profesor = new ProfesorDAO().buscarId(c.getProfesor());
		try {			
			conectar();
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setInt(1, c.getCodigo());
			stmt.setString(2, c.getNombre());
			stmt.setLong(3, id_profesor);
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error guardando un curso con los datos " + c);
			ex.printStackTrace();
		}
	}
	
	@Override
	public void modificar(BaseModelo e) {
		Curso c = (Curso) e;
		Long id = this.buscarId(e);
		Long id_profesor = new ProfesorDAO().buscarId(c.getProfesor());
		try {
			conectar();
			stmt = con.prepareStatement(SQL_UPDATE);
			stmt.setInt(1, c.getCodigo());
			stmt.setString(2, c.getNombre());
			stmt.setLong(3, id_profesor);
			stmt.setLong(4, id);
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error modificando un curso con los valores " + c);
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
			System.out.println("Error eliminando un curso con los valores " + (Curso) e);
			ex.printStackTrace();
		}
	}
	
	public Curso populate(ResultSet rs) {
		try {
			Long id = rs.getLong(1);
			Integer codigo = rs.getInt(2);
			String nombre = rs.getString(3);
			Long id_profesor = rs.getLong(4);
			var profesor = new Profesor();
			profesor.setId(id_profesor);
			var c = new Curso(codigo, nombre, profesor);
			c.setId(id);
			return c;
		}
		catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Busca un Curso pasando el número ID
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
	 * Busca los Cursos para settear ID
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
		List<BaseModelo> listadoCursos = new ArrayList<BaseModelo>();
		try {
			conectar();
			stmt = con.prepareStatement(SQL_SELECT);
			ResultSet rset = stmt.executeQuery();			
			while(rset.next()) {
				listadoCursos.add(this.populate(rset));
			}
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error al mostrar el listado de cursos");
			ex.printStackTrace();
		}
		return listadoCursos;
	}
	
	@Override
	public void crearTabla () {
		try {
			conectar();
			stmt = con.prepareStatement("CREATE TABLE CURSO ("
				+ "id int(11) NOT NULL AUTO_INCREMENT, "
				+ "codigo varchar(10) NOT NULL, "
				+ "nombre varchar(25) NOT NULL, "
				+ "id_profesor int(11) NOT NULL, "
				+ " PRIMARY KEY (id))");
			stmt.execute();
			cerrarConexion();
		}
		catch (SQLException ex) {
			System.out.println("Error al crear la tabla curso.");
		}
	}

}