package ar.com.gugler.sgc.modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import ar.com.gugler.sgc.dao.ProfesorDAO;
import ar.com.gugler.sgc.dao.AlumnoDAO;
import ar.com.gugler.sgc.dao.CursoDAO;


/**
 * Clase principal
 * @author Ana Kloss
 *
 */
public class TPFinal1 {
	
	public static void main(String[] args) throws SQLException {
	
		/**
		 * Declaración de Alumnos utilizando el constructor para crear Persona + Alumno
		 * Declaración de fecha de nacimiento
		 */
		LocalDate fechaNacA1 = LocalDate.of(1991, 3, 10);
		var a1 = new Alumno("35123123", "Rodriguez", "Martin", fechaNacA1, "San Martin 123", "(0343)498-1122",
			"mrodriguez@gmail.com", "123");
		LocalDate fechaNacA2 = LocalDate.of(1995, 7, 23);
		var a2 = new Alumno("39012678", "Perez", "Juan", fechaNacA2, "San Martin 123", "(0343)498-1122",
			"jperez@gmail.com", "078");
		
		var aDAO = new AlumnoDAO();
		aDAO.crearTabla();
		aDAO.guardar(a1);
		aDAO.guardar(a2);
		a2.setApellido("Sanchez");
		aDAO.modificar(a2);
		aDAO.eliminar(a1);
		for (var alum: aDAO.buscarTodos()) {
			System.out.println(alum);
		}
		aDAO.cerrarConexion();
		
		

		/**
		 * Declaración de Profesor utilizando el constructor para crear Persona + Profesor
		 * Declaración de fecha de nacimiento y fecha de ingreso
		 */
		LocalDate fechaNacP1 = LocalDate.of(1985, 4, 15);
		LocalDate fechaIng = LocalDate.of(2010, 10, 28);
		var p1 = new Profesor("34156932", "Gomez", "Juan Pablo", fechaNacP1, "Sarmiento 980", "(0343)4981212",
			"jpgomez@gmail.com", "27-34156932-1", fechaIng);
		
		var p2 = new Profesor("34095382", "Martinez", "Carlos", fechaNacP1, "San Martin 80", "(0343)4982243",
			"cmartinez@gmail.com", "27-34095382-1", fechaIng);
		
		var pDAO = new ProfesorDAO();
		pDAO.crearTabla();
		pDAO.guardar(p1);
		pDAO.guardar(p2);
		System.out.println(p2.mostrarInformacion());
		p2.setApellido("Perez");
		pDAO.modificar(p2);

		pDAO.eliminar(p1);
		for (var profe: pDAO.buscarTodos()) {
			System.out.println(profe);
		}
		pDAO.cerrarConexion();
		

		
		/**
		 * Mostrar datos utilizando el metodo estatico de la clase Universidad
		 */
		Universidad.mostrarDatos(a1);
		Universidad.mostrarDatos(a2);
		Universidad.mostrarDatos(p1);
		
		
		/**
		 * Declaración de Curso utilizando el constructor
		 */
		
		Curso prog = new Curso(1, "Programación en Java", p2);
		prog.agregarAlumno(a1);
		prog.agregarAlumno(a2);
//		prog.mostrarAlumnos();  // Funcion para listar alumnos 
		
		
		
		var cDAO = new CursoDAO();
		cDAO.crearTabla();
		cDAO.guardar(prog);
		prog.setNombre("Prog en Python");
		cDAO.modificar(prog);
		for (var curso: cDAO.buscarTodos()) {
			System.out.println(curso);
		}
//		cDAO.eliminar(prog);
		cDAO.cerrarConexion();
		 
	}

}
