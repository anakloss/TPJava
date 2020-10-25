package ar.com.gugler.sgc.modelo;

/**
 *  Clase Curso que hereda de la clase Asignatura e implementa la interface
 *  Administrable para verificar si admite inscripciones
 * @author Ana Kloss
 *
 */
public class Curso extends Asignatura implements Administrable {
	public final Integer cupo = 24;

	/**
	 * Métodos utilizados como Constructores de la clase
	 */
	public Curso() {
		super();
	}
	public Curso(Integer codigo, String nombre, Profesor profesor) {
		super(codigo, nombre, profesor);
	}

	/**
	 * Métodos setters y getters
	 */
	public Integer getCupo() {
		return cupo;
	}

	/**
	 * Redefinición del método toString para mostrar información del Curso
	 */
	@Override
	public String toString() {
		return super.toString() + "[Cupo:  " + getCupo() + "]"; 
	}
	
	/**
	 * Metodo que debemos escribir por implementar la interface Administrable
	 * Verifica si el curso admite inscripciones si tiene menos participantes que el cupo
	 */
	@Override
	public boolean admiteInscripciones() {
		return (alumnos.size() < cupo);
	}
	
	/**
	 * Método para agregar un Alumno a la lista alumnos heredado de Asignatura
	 * utilizando el método para implementar la interface Administrable.
	 * Si se permite agregar, se agrega el alumno a la lista, sino devuelve un mensaje.
	 * 
	 * @param alumno
	 * 				alumno a agregar
	 */
	public void agregarAlumno(Alumno alumno) {
		if (admiteInscripciones() && (!alumnos.contains(alumno)))
			alumnos.add(alumno);
	}
	/**
	 * Método para eliminar un Alumno a la lista alumnos heredado de Asignatura
	 * 
	 * @param alumno
	 * 				alumno a eliminar
	 */
	public void eliminarAlumno(Alumno alumno) {
		if (alumnos.contains(alumno)) {
			alumnos.remove(alumno);
		}
	}
	/**
	 * Método para mostrar listado de alumnos heredado de Asignatura
	 * 
	 */
	public void mostrarAlumnos() {
		System.out.println("*** Listado de alumnos ***");
		System.out.println("Cantidad de personas: " + alumnos.size());
		for (Alumno a: alumnos)
			System.out.println(a);
	}

}
