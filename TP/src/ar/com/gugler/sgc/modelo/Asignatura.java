package ar.com.gugler.sgc.modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase Asignatura
 * @author Ana Kloss
 *
 */
public class Asignatura extends BaseModelo {
	public Integer codigo;
	public String nombre;
	public ArrayList<Alumno> alumnos;
	public Profesor profesor;
	
	/**
	 * Métodos utilizados como Constructores de la clase
	 */
	public Asignatura() {
		super();
		this.alumnos = new ArrayList<Alumno>();
	}
	public Asignatura(Integer codigo, String nombre, Profesor profesor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = profesor;
	}
	
	/**
	 * Métodos setters y getters
	 */
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	/**
	 * Redefinición del método equals para determinar
	 * que dos asignaturas son iguales si tienen igual codigo 
	 * 
	 * @param obj
	 *              Objeto a comparar
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Asignatura))
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(codigo, other.codigo);
	}

	/**
	 * Redefinición del método toString para mostrar información de la Asignatura
	 */
	@Override
	public String toString() {
		if (codigo != null && nombre != null) 
			return "[" + codigo + "] " + nombre;
		else if (nombre != null)
			return nombre;
		return null;
	}
		
}
