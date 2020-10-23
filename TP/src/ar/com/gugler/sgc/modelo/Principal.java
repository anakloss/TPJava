package ar.com.gugler.sgc.modelo;

import java.util.Date;

public class Principal {

	public static void main(String[] args) {

		Persona p1 = new Alumno("125");
		p1.setNumeroDocumento("35123123");
		p1.setNombre("Juan Pablo");
		p1.setApellido("Martinez");
		
		Alumno a1 = new Alumno("125");
		a1.setNumeroDocumento("35123123");
		a1.setNombre("Juan Pablo");
		a1.setApellido("Martinez");
		
		Date fecha = new Date();
		Persona p2 = new Profesor("123", fecha);
		p2.setNumeroDocumento("35123125");
		p2.setNombre("Juan");
		
		Persona p3 = new Profesor("125", fecha);
		p3.setNumeroDocumento("35123125");
		p3.setNombre("Juan");
						
//		System.out.println("Alumno 1 y Profesor 2 son iguales? " + p1.equals(p2));
//		System.out.println("Profesor 2 y Profesor 3 son iguales? " + p2.equals(p3));
		
		Curso curso = new Curso(30);
		curso.agregarAlumno(p1);
		
		curso.mostrarAlumnos();

			
	}

}
