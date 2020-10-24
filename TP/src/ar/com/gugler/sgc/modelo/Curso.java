package ar.com.gugler.sgc.modelo;

/**
 *  Clase Curso que hereda de la clase Asignatura e implementa la interface
 *  Administrable para verificar si admite inscripciones
 * @author Ana Kloss
 *
 */
public class Curso extends Asignatura implements Administrable {
	public Integer cupo;

	/**
	 * Métodos utilizados como Constructores de la clase
	 */
	public Curso() {
		super();
	}
	public Curso(Integer cupo) {
		super();
		this.cupo = cupo;
	}
	public Curso(Integer codigo, String nombre, Profesor profesor, Integer cupo) {
		super(codigo, nombre, profesor);
		this.cupo = cupo;
	}

	/**
	 * Métodos setters y getters
	 */
	public Integer getCupo() {
		return cupo;
	}
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
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
	 * Verifica si el curso admite inscripciones si tiene menos de 24 participantes
	 */
	@Override
	public boolean admiteInscripciones() {
		if (alumnos.size() < 24)
			return true;
		else
			return false;
	}
	
	/**
	 * Método para agregar un Alumno a la lista alumnos heredado de Asignatura
	 * 
	 * @param alumno
	 * 				alumno a agregar
	 */
	public void agregarAlumno(Alumno alumno) {
		if (!alumnos.contains(alumno)) {
			alumnos.add(alumno);
		}
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
		for (Alumno a: alumnos) {
			System.out.println(a);
		}
	}
}
