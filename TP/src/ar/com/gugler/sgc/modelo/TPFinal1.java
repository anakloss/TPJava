package ar.com.gugler.sgc.modelo;

import java.time.LocalDate;

/**
 * Clase principal
 * @author Ana Kloss
 *
 */
public class TPFinal1 {
	
	public static void main(String[] args) {

		/**
		 * Declaración de Alumnos utilizando el constructor para crear Persona + Alumno
		 * Declaración de fecha de nacimiento
		 */
		LocalDate fechaNacA1 = LocalDate.of(1991, 3, 10);
		Alumno a1 = new Alumno("35123123", "Rodriguez", "Martin", fechaNacA1, "San Martin 123", "(0343)498-1122",
			"mrodriguez@gmail.com", "123");
		
		LocalDate fechaNacA2 = LocalDate.of(1995, 7, 23);
		Alumno a2 = new Alumno("39012678", "Perez", "Juan", fechaNacA2, "San Martin 123", "(0343)498-1122",
			"jperez@gmail.com", "078");
		
		/**
		 * Declaración de Profesor utilizando el constructor para crear Persona + Profesor
		 * Declaración de fecha de nacimiento y fecha de ingreso
		 */
		LocalDate fechaNacP1 = LocalDate.of(1985, 4, 15);
		LocalDate fechaIng = LocalDate.of(2010, 10, 28);
		Profesor p1 = new Profesor("34156932", "Gomez", "Juan Pablo", fechaNacP1, "Sarmiento 980", "(0343)4981212",
			"jpgomez@gmail.com", "27-34156932-1", fechaIng);

		/**
		 * Mostrar datos utilizando el metodo estatico de la clase Universidad
		 */
		Universidad.mostrarDatos(a1);
		Universidad.mostrarDatos(a2);
		Universidad.mostrarDatos(p1);
		
		/**
		 * Declaración de Curso utilizando el constructor
		 */
		Curso prog = new Curso(1, "Programación en Java", p1);
		prog.agregarAlumno(a1);
		prog.agregarAlumno(a2);
//		prog.mostrarAlumnos();  // Funcion para listar alumnos 

	}

}
