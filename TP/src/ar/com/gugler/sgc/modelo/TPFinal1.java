package ar.com.gugler.sgc.modelo;

import java.util.Date;

public class TPFinal1 {

	public static void main(String[] args) {

		// Objeto Alumnos
		Date fechaNac = new Date();
		Alumno a1 = new Alumno("35123123", "Rodriguez", "Martin", fechaNac, "San Martin 123", "(0343)498-1122",
			"mrodriguez@gmail.com", "123");
		
		Alumno a2 = new Alumno("39012678", "Perez", "Juan", fechaNac, "San Martin 123", "(0343)498-1122",
			"jperez@gmail.com", "078");
		
		// Objeto Profesor
		@SuppressWarnings("deprecation")
		Date fechaNac2 = new Date(1990, 3, 10);
		@SuppressWarnings("deprecation")
		Date fechaIng = new Date(2010, 10, 28);	
		Profesor p1 = new Profesor("34156932", "Gomez", "Juan Pablo", fechaNac2, "Sarmiento 980", "(0343)4981212",
			"jpgomez@gmail.com", "27-35123125-1", fechaIng);

		// Mostrar Datos
		Universidad.mostrarDatos(a1);
		Universidad.mostrarDatos(a2);
		Universidad.mostrarDatos(p1);
		
		// Curso
		Curso prog = new Curso(1, "Programación en Java", p1, 24);
		prog.agregarAlumno(a1);
		prog.agregarAlumno(a2);
		// prog.mostrarAlumnos();  // Funcion para listar alumnos 
			
	}

}
